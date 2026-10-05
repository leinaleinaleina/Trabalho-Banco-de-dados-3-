package app.main.repository;

import app.main.dto.ContribuinteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ContribuinteRepository {
    private Connection connection;

    public ContribuinteRepository(Connection connection) {
        this.connection = connection;
    }

    public ContribuinteDTO buscarPorCpf(String cpf) {
        // SQL baseado nas ligações do seu MER
        String sql = "SELECT c.Nome, c.CPF, c.Data_nascimento, " +
                "e.Email, " +
                "t.fone " +
                // NOTA: Para incluir o endereço, você precisará adicionar os JOINs
                // para IdentificacaoContribuinte, Endereco, Bairro, Cidade e UF
                // de acordo com as chaves estrangeiras exatas criadas pelo seu colega.
                "FROM Contribuinte c " +
                "LEFT JOIN Email_Contribuinte e ON c.idContribuinte = e.Contribuinte_idContribuinte " +
                "LEFT JOIN TelefoneContribuinte t ON c.idContribuinte = t.Contribuinte_idContribuinte " +
                "WHERE c.CPF = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ContribuinteDTO(
                            rs.getString("Nome"),
                            rs.getString("CPF"),
                            rs.getString("Data_nascimento"),
                            rs.getString("Email"),
                            rs.getString("fone"),
                            "A Implementar (Requer JOIN com Endereco, Bairro e Cidade)"
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar contribuinte: " + e.getMessage());
        }
        return null; // Retorna null se não encontrar o CPF
    }
}