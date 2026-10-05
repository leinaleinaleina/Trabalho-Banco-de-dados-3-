package programas.DAO;

import programas.classes.casodeuso.*;
import programas.classes.generico.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BemDireitoDAO {
    private Connection connection;

    public BemDireitoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<BemDireitoDAO> buscarPatrimonio(String cpf) {
        List<BemDireitoDAO> bens = new ArrayList<>();

        // O JOIN exato dependerá de como o seu colega conectou Bens_direitos ao Contribuinte no MER
        String sql = "SELECT b.Discriminacao, b.Situacao2023, b.Situacao2024 " +
                    "FROM Bens_direitos b " +
               // "INNER JOIN Contribuinte c ON b.A_DEFINIR = c.idContribuinte " +
                "WHERE c.CPF = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    bens.add(new BemDireitoDAO(
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