package app.main.repository;

import app.main.dto.DeclaracaoResumoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeclaracaoRepository {

    private Connection connection;

    public DeclaracaoRepository(Connection connection) {
        this.connection = connection;
    }

    public List<DeclaracaoResumoDTO> buscarSimulacoesCompletas() {
        List<DeclaracaoResumoDTO> declaracoes = new ArrayList<>();



        // Ajuste os nomes das tabelas e colunas conforme você criou no seu PGAdmin
        // Note o uso do STRING_AGG que é específico do PostgreSQL
        String sql = "SELECT c.nome, c.cpf, " +
                "COALESCE(r.total_rendimentos, 0) AS total_rendimentos, " +
                "COALESCE(i.total_imposto, 0) AS total_imposto, " +
                "b.bens " +
                "FROM Contribuinte c " +
                // Subconsulta para isolar e somar apenas os rendimentos
                "LEFT JOIN (" +
                "    SELECT id_contribuinte, SUM(valor_tributavel) AS total_rendimentos " +
                "    FROM RendimentoTribPJ " +
                "    GROUP BY id_contribuinte" +
                ") r ON c.id = r.id_contribuinte " +
                // Subconsulta para isolar e somar apenas os impostos
                "LEFT JOIN (" +
                "    SELECT id_contribuinte, SUM(valor_pago) AS total_imposto " +
                "    FROM ImpostoPago " +
                "    GROUP BY id_contribuinte" +
                ") i ON c.id = i.id_contribuinte " +
                // Subconsulta para isolar e concatenar apenas os bens
                "LEFT JOIN (" +
                "    SELECT id_contribuinte, STRING_AGG(descricao || ' (R$ ' || valor_bem || ')', ', ') AS bens " +
                "    FROM BemDireito " +
                "    GROUP BY id_contribuinte" +
                ") b ON c.id = b.id_contribuinte";

        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                DeclaracaoResumoDTO dto = new DeclaracaoResumoDTO();
                dto.setNome(rs.getString("nome"));
                dto.setCpf(rs.getString("cpf"));
                dto.setTotalRendimentos(rs.getDouble("total_rendimentos"));
                dto.setTotalImpostoPago(rs.getDouble("total_imposto"));
                dto.setDescricaoBens(rs.getString("bens"));
                declaracoes.add(dto);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao executar a consulta no banco: " + e.getMessage());
            e.printStackTrace();
        }
        return declaracoes;
    }
}