package programas.DAO;

import programas.classes.casodeuso.Declaracao_renda;
import programas.classes.casodeuso.Imposto_devido;
import programas.classes.casodeuso.Imposto_pago;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImpostoPagoDAO {
    private Connection conexao;

    public ImpostoPagoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Declaracao_renda> buscarIrpfAnterioresPorCpf(int cpfContribuinte) {
        List<Declaracao_renda> declaracoes = new ArrayList<>();

        // Consulta através da Declaracao_Renda para buscar os impostos pagos e devidos do Contribuinte
        String sql = "SELECT dr.idDeclaracao_Renda, " +
                "idev.idImposto_devido, idev.Imposto_devido, " +
                "ip.idImposto_pago, ip.Imposto_retido_titular, ip.Imposto_retido_dependente, " +
                "ip.Carne_titular, ip.Carne_dependente, ip.Imposto_complementar, " +
                "ip.Imposto_no_exterior, ip.Imposto_retido, ip.Imposto_RRA " +
                "FROM Declaracao_Renda dr " +
                "INNER JOIN Imposto imp ON dr.Imposto_idimposto = imp.idimposto " +
                "INNER JOIN Imposto_devido idev ON imp.Imposto_devido_idImposto_devido = idev.idImposto_devido " +
                "INNER JOIN Imposto_pago ip ON imp.Imposto_pago_idImposto_pago = ip.idImposto_pago " +
                "WHERE dr.Identificacao_Contribuinte_idContribuinte = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cpfContribuinte);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Declaracao_renda declaracao = new Declaracao_renda();
                declaracao.setIdDeclaração_renda(rs.getInt("idDeclaracao_Renda"));

                // Instancia a nova classe Imposto_devido e guarda o valor
                Imposto_devido impostoDevido = new Imposto_devido();
                impostoDevido.setidImposto_devido(rs.getInt("idImposto_devido"));
                impostoDevido.setImposto_devido(rs.getString("Imposto_devido"));

                // Como a sua classe Declaracao_renda recebe o Imposto Devido como String, passamos a string diretamente
                declaracao.setImposto_devido(impostoDevido.getImposto_devido());

                // Imposto Pago
                Imposto_pago impostoPago = new Imposto_pago();
                impostoPago.setIdImposto_pago(rs.getInt("idImposto_pago"));
                impostoPago.setImposto_retido_titular(rs.getString("Imposto_retido_titular"));
                impostoPago.setImposto_retido_dependente(rs.getString("Imposto_retido_dependente"));
                impostoPago.setCarne_titular(rs.getString("Carne_titular"));
                impostoPago.setCarne_dependente(rs.getString("Carne_dependente"));
                impostoPago.setImposto_complementar(rs.getString("Imposto_complementar"));
                impostoPago.setImposto_exterior(rs.getString("Imposto_no_exterior"));
                impostoPago.setImposto_retido(rs.getString("Imposto_retido"));
                impostoPago.setImposto_RRA(rs.getString("Imposto_RRA"));

                declaracao.setImposto_pago(impostoPago);

                declaracoes.add(declaracao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar IRPF anteriores: " + e.getMessage());
            e.printStackTrace();
        }
        return declaracoes;
    }
}