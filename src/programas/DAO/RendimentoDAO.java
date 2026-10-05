package app.main.repository;

import app.main.dto.RendimentoDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RendimentoRepository {
    private Connection connection;

    public RendimentoRepository(Connection connection) {
        this.connection = connection;
    }

    public List<RendimentoDTO> buscarTributaveis(String cpf) {
        List<RendimentoDTO> rendimentos = new ArrayList<>();

        // Fazendo JOIN entre Rendimentos e Fonte Pagadora conforme o MER
        String sql = "SELECT f.Nome_fonte, f.CNPJ, r.Rendimentos_recebidos, r.13salario " +
                "FROM Rendimentos_trib_PJ r " +
                "INNER JOIN FontePagadora f ON r.FontePagadora_idFontePagadora = f.idFontePagadora " +
                "WHERE r.CPF_pagadora = ?"; // CPF vinculado ao rendimento

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    rendimentos.add(new RendimentoDTO(
                            rs.getString("Nome_fonte"),
                            rs.getString("CNPJ"),
                            rs.getString("Rendimentos_recebidos"),
                            rs.getString("13salario")
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar rendimentos: " + e.getMessage());
        }
        return rendimentos;
    }
}