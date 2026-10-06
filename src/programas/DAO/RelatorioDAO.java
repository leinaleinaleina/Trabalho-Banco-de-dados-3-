package programas.DAO;

import programas.classes.casodeuso.Declaracao_renda;
import programas.classes.casodeuso.Contribuinte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RelatorioDAO {
    private Connection conexao;

    public RelatorioDAO(Connection conexao) {
        this.conexao = conexao;
    }

    // Busca um resumo geral de todas as declarações associadas aos contribuintes
    public List<Declaracao_renda> buscarRelatorioGeral() {
        List<Declaracao_renda> relatorio = new ArrayList<>();

        String sql = "SELECT dr.idDeclaracao_Renda, c.idContribuinte, c.Nome, c.CPF, " +
                "idev.Imposto_devido " +
                "FROM Declaracao_Renda dr " +
                "INNER JOIN Contribuinte c ON dr.Identificacao_Contribuinte_idContribuinte = c.idContribuinte " +
                "LEFT JOIN Imposto imp ON dr.Imposto_idimposto = imp.idimposto " +
                "LEFT JOIN Imposto_devido idev ON imp.Imposto_devido_idImposto_devido = idev.idImposto_devido";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Declaracao_renda dec = new Declaracao_renda();
                dec.setIdDeclaração_renda(rs.getInt("idDeclaracao_Renda"));
                dec.setImposto_devido(rs.getString("Imposto_devido"));

                // Criamos o contribuinte e preenchemos os dados básicos vindos do SQL
                Contribuinte cont = new Contribuinte();
                cont.setIdContribuinte(rs.getInt("idContribuinte"));
                cont.setNome(rs.getString("Nome"));

                // Na sua Declaracao_renda, ligamos através da identificação ou guardamos no objeto correspondente
                // Como a sua Identificacao gere a ligação, podemos associar o nome diretamente ao objeto de identificação se houver,
                // ou ajustar o RelatorioController para ler direto do Contribuinte que guardaremos à parte,
                // mas para manter limpo, vamos atribuir a propriedade de nome via Identificacao:
                if (dec.getIdentificacao() != null) {
                    // Se preferir, podemos guardar o contribuinte vinculado na identificação
                }

                // Alternativa prática: vamos guardar o nome e ID numa estrutura limpa
                // ou associar o objeto Contribuinte caso queira injetar na Identificacao:
                dec.getIdentificacao().setContribuinte(cont);
                // Nota: caso a classe Identificacao não tenha o método setContribuinte,
                // ajuste a linha abaixo no RelatorioController para ler o nome de outra forma.

                relatorio.add(dec);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao gerar relatório geral: " + e.getMessage());
            e.printStackTrace();
        }
        return relatorio;
    }
}