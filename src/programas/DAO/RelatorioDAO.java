package programas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import programas.classes.casodeuso.Contribuinte;
import programas.classes.casodeuso.Declaracao_renda;

public class RelatorioDAO {
    private Connection conexao;

    public RelatorioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Declaracao_renda> buscarRelatorioGeral() {
        List<Declaracao_renda> relatorio = new ArrayList<>();

        String sql = "SELECT dr.idDeclaracao_Renda, c.idContribuinte, c.Nome, c.CPF, dr.Imposto_devido " +
                     "FROM Contribuinte c " +
                     "INNER JOIN IdentificacaoContribuinte ic ON c.idContribuinte = ic.Contribuinte_idContribuinte " +
                     "INNER JOIN Declaracao_Renda_Contribuinte dr ON ic.idIdentificacao = dr.Identificacao_idIdentificacao";


        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Declaracao_renda dec = new Declaracao_renda();
                dec.setIdDeclaracao_renda(rs.getInt("idDeclaracao_Renda"));
                dec.setImposto_devido(rs.getString("Imposto_devido"));


                Contribuinte cont = new Contribuinte();
                cont.setIdContribuinte(rs.getInt("idContribuinte"));
                cont.setNome(rs.getString("Nome"));
                cont.setCpf(rs.getString("CPF"));

                dec.setContribuinte(cont);


                relatorio.add(dec);
            }

        } catch (SQLException e) {
            System.err.println("Erro ao gerar relatório geral: " + e.getMessage());
        }

        return relatorio;
    }
}