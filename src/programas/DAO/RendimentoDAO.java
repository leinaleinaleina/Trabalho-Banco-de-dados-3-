package programas.DAO;

import programas.classes.casodeuso.Rendimentos_trib_PJ;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RendimentoDAO {
    private Connection conexao;

    public RendimentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Rendimentos_trib_PJ> buscarTributaveisPorCpf(int cpfContribuinte) {
        List<Rendimentos_trib_PJ> rendimentos = new ArrayList<>();

        // A query passa pela Declaracao_Renda para encontrar os rendimentos vinculados ao Contribuinte titular
        String sql = "SELECT r.idRendimentos, r.CPF_pagadora, r.CNPJ_pagadora, r.Nome_pagadoea, " +
                "r.Rendimentos_recebidos, r.Contribuicao, r.Imposto, r.13salario, r.IRRF13salario " +
                "FROM Rendimentos_trib_PJ r " +
                "INNER JOIN Declaracao_Renda dr ON r.Declaracao_Renda_idDeclaracao_Renda = dr.idDeclaracao_Renda " +
                "WHERE dr.Identificacao_Contribuinte_idContribuinte = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cpfContribuinte);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Rendimentos_trib_PJ rendimento = new Rendimentos_trib_PJ();

                rendimento.setIdRendimentos(rs.getInt("idRendimentos"));
                rendimento.setCPF_pagadora(rs.getString("CPF_pagadora"));
                rendimento.setCNPJ_pagadora(rs.getString("CNPJ_pagadora"));

                // Lidando com o erro de digitação da coluna no script SQL
                rendimento.setNome_pagadora(rs.getString("Nome_pagadoea"));

                rendimento.setRendimentos_recebidos(rs.getString("Rendimentos_recebidos"));
                rendimento.setContribuicao(rs.getString("Contribuicao"));
                rendimento.setImposto(rs.getString("Imposto"));

                // Lidando com os nomes diferentes entre BD e a classe Java
                rendimento.setDecimo_terceiro(rs.getString("13salario"));
                rendimento.setIRPF_salario(rs.getString("IRRF13salario"));

                // Se necessitar preencher Fonte_pagadora e Declaracao_renda na classe,
                // pode instanciar os objetos aqui usando rendimento.setFonte_pagadora(...)

                rendimentos.add(rendimento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar rendimentos tributáveis: " + e.getMessage());
            e.printStackTrace();
        }
        return rendimentos;
    }
}