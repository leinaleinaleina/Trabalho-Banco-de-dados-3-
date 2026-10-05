package app.main.repository;

import app.main.dto.ImpostoPagoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ImpostoPagoRepository {
    private Connection connection;

    public ImpostoPagoRepository(Connection connection) {
        this.connection = connection;
    }

    public List<ImpostoPagoDTO> buscarHistorico(String cpf) {
        List<ImpostoPagoDTO> pagamentos = new ArrayList<>();
        // Query baseada na tabela Pagamento_efetuado do MER
        String sql = "SELECT p.Valor, p.Percela_n_dedutivel, p.CNPJ_beneficiario " +
                "FROM Pagamento_efetuado p " +
                "WHERE p.CPF_beneficiario = ?"; // Assumindo que este CPF é o do contribuinte

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    pagamentos.add(new ImpostoPagoDTO(
                            rs.getString("Valor"),
                            rs.getString("Percela_n_dedutivel"),
                            rs.getString("CNPJ_beneficiario")
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar impostos pagos: " + e.getMessage());
        }
        return pagamentos;
    }
}