package programas.controller;

import java.sql.Connection;
import java.util.List;
import programas.DAO.ImpostoPagoDAO;
import programas.classes.casodeuso.Declaracao_renda;
import programas.classes.casodeuso.Imposto_pago;

public class ImpostoPagoController {

    private Connection conexao;

    public ImpostoPagoController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirIRPFAnteriores(int idContribuinte) {
        ImpostoPagoDAO dao = new ImpostoPagoDAO(conexao);


        List<Declaracao_renda> declaracoes = dao.buscarIrpfAnterioresPorCpf(idContribuinte);

        System.out.println("\n=================================================");
        System.out.println("               IRPF ANTERIORES                   ");
        System.out.println("=================================================");

        if (declaracoes != null && !declaracoes.isEmpty()) {
            for (int i = 0; i < declaracoes.size(); i++) {
                Declaracao_renda dec = declaracoes.get(i);
                Imposto_pago ip = dec.getImposto_pago();

                System.out.println("Declaração #" + dec.getIdDeclaração_renda());

                String valorDevido = dec.getImposto_devido() != null ? dec.getImposto_devido() : "0,00";
                System.out.println("IRPF - Declarado no valor de R$ " + valorDevido);

                if (ip != null) {
                    System.out.println("\n--- Detalhes do Imposto Pago ---");

                    System.out.println("Imposto Retido Titular: R$ " + formatarValor(ip.getImposto_retido_titular()));
                    System.out.println("Imposto Retido Dependente: R$ " + formatarValor(ip.getImposto_retido_dependente()));
                    System.out.println("Carnê Leão Titular: R$ " + formatarValor(ip.getCarne_titular()));
                    System.out.println("Carnê Leão Dependente: R$ " + formatarValor(ip.getCarne_dependente()));
                    System.out.println("Imposto Complementar: R$ " + formatarValor(ip.getImposto_complementar()));
                    System.out.println("Imposto no Exterior: R$ " + formatarValor(ip.getImposto_exterior()));
                    System.out.println("Imposto Retido: R$ " + formatarValor(ip.getImposto_retido()));
                    System.out.println("Imposto RRA: R$ " + formatarValor(ip.getImposto_RRA()));
                }
                System.out.println("-------------------------------------------------");
            }
        } else {
            System.out.println("Nenhum registro de IRPF anterior encontrado para este contribuinte.");
        }
    }


    private String formatarValor(String valor) {
        return (valor != null && !valor.isEmpty()) ? valor : "0,00";
    }
}