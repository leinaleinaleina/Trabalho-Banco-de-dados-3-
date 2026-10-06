package programas.DAO;

import programas.classes.casodeuso.Declaracao_renda;
import programas.classes.casodeuso.Identificacao;
import programas.classes.casodeuso.Contribuinte;
import programas.classes.casodeuso.Imposto_pago;
import programas.classes.casodeuso.Tipo_declaracao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DeclaracaoDAO {

    private Connection conexao;

    public DeclaracaoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Declaracao_renda> buscarRelatorioCompleto() {
        List<Declaracao_renda> relatorio = new ArrayList<>();

        // Consulta unindo as tabelas de Declaração, Identificação, Contribuinte e Impostos
        String sql = "SELECT dr.idDeclaracao_Renda, " +
                "i.idIdentificacao, td.idTipo_Declaracao, td.NumeroDeclaracao, " +
                "c.idContribuinte, c.Nome, " +
                "idev.Base_calculo, idev.Imposto_devido, idev.Deducao_incentivo, " +
                "idev.Imporsto_devido_I, idev.Imposto_devido_RRA, idev.Aliquota, " +
                "ip.idImposto_pago, ip.Imposto_retido_titular, ip.Imposto_retido_dependente, " +
                "ip.Carne_titular, ip.Carne_dependente, ip.Imposto_complementar, " +
                "ip.Imposto_no_exterior, ip.Imposto_retido, ip.Imposto_RRA " +
                "FROM Declaracao_Renda dr " +
                "INNER JOIN Identificacao i ON dr.Identificacao_idIdentificacao = i.idIdentificacao " +
                "INNER JOIN Contribuinte c ON i.Contribuinte_idContribuinte = c.idContribuinte " +
                "INNER JOIN Tipo_Declaracao td ON i.Tipo_Declaracao_idTipo_Declaracao = td.idTipo_Declaracao " +
                "LEFT JOIN Imposto imp ON dr.Imposto_idimposto = imp.idimposto " +
                "LEFT JOIN Imposto_devido idev ON imp.Imposto_devido_idImposto_devido = idev.idImposto_devido " +
                "LEFT JOIN Imposto_pago ip ON imp.Imposto_pago_idImposto_pago = ip.idImposto_pago";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Declaracao_renda declaracao = new Declaracao_renda();

                // Mapeamento dos atributos diretos de Declaracao_Renda e Imposto_Devido
                declaracao.setIdDeclaração_renda(rs.getInt("idDeclaracao_Renda"));
                declaracao.setBase_calculo(rs.getString("Base_calculo"));
                declaracao.setImposto_devido(rs.getString("Imposto_devido"));
                declaracao.setDeducao_incentivo(rs.getString("Deducao_incentivo"));
                declaracao.setImposto_devido_I(rs.getString("Imporsto_devido_I")); // Nome com erro de digitação no SQL
                declaracao.setImposto_devido_RRA(rs.getString("Imposto_devido_RRA"));
                declaracao.setAliquota(rs.getString("Aliquota"));
                declaracao.setNumero_recibo(rs.getString("NumeroDeclaracao"));

                // Estrutura de Identificação
                Identificacao identificacao = new Identificacao();
                identificacao.setIdIdentificacao(rs.getInt("idIdentificacao"));

                Contribuinte contribuinte = new Contribuinte();
                contribuinte.setIdContribuinte(rs.getInt("idContribuinte"));
                contribuinte.setNome(rs.getString("Nome"));
                identificacao.setContribuinte(contribuinte);

                Tipo_declaracao tipoDeclaracao = new Tipo_declaracao();
                tipoDeclaracao.setIdTipo_declaracao(rs.getInt("idTipo_Declaracao"));
                tipoDeclaracao.setNumero_declaracao(rs.getString("NumeroDeclaracao"));
                identificacao.setTipo_declaracao(tipoDeclaracao);

                declaracao.setIdentificacao(identificacao);

                // Estrutura de Imposto Pago
                Imposto_pago impostoPago = new Imposto_pago();
                impostoPago.setIdImposto_pago(rs.getInt("idImposto_pago"));
                impostoPago.setImposto_retido_titular(rs.getString("Imposto_retido_titular"));
                impostoPago.setImposto_retido_dependente(rs.getString("Imposto_retido_dependente"));
                impostoPago.setCarne_titular(rs.getString("Carne_titular"));
                impostoPago.setCarne_dependente(rs.getString("Carne_dependente"));
                impostoPago.setImposto_complementar(rs.getString("Imposto_complementar"));
                // Ligando a coluna Imposto_no_exterior do banco ao atributo Imposto_exterior da classe
                impostoPago.setImposto_exterior(rs.getString("Imposto_no_exterior"));
                impostoPago.setImposto_retido(rs.getString("Imposto_retido"));
                impostoPago.setImposto_RRA(rs.getString("Imposto_RRA"));

                declaracao.setImposto_pago(impostoPago);

                relatorio.add(declaracao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar declarações: " + e.getMessage());
            e.printStackTrace();
        }
        return relatorio;
    }
}