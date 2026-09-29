package app.main.repository;

import app.main.dto.BemDireitoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BemDireitoRepository {
    private Connection connection;

    public BemDireitoRepository(Connection connection) {
        this.connection = connection;
    }

    public List<BemDireitoDTO> buscarPatrimonio(String cpf) {
        List<BemDireitoDTO> bens = new ArrayList<>();

        // O JOIN exato dependerá de como o seu colega conectou Bens_direitos ao Contribuinte no MER
        String sql = "SELECT b.Discriminacao, b.Situacao2023, b.Situacao2024 " +
                "FROM Bens_direitos b " +
               // "INNER JOIN Contribuinte c ON b.A_DEFINIR = c.idContribuinte " +
                "WHERE c.CPF = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bens.add(new BemDireitoDTO(
                            rs.getString("Discriminacao"),
                            rs.getString("Situacao2023"),
                            rs.getString("Situacao2024")
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar bens e direitos: " + e.getMessage());
        }
        return bens;
    }
}