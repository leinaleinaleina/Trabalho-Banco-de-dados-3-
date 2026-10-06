package programas.controller;

import programas.DAO.ImpostoPagoDAO;
import programas.classes.casodeuso.Imposto_pago; // Importando a classe de domínio correta
import java.sql.Connection;
import java.util.List;

public class ImpostoPagoController {

    private ImpostoPagoDAO dao;

    public ImpostoPagoController(Connection connection) {
        this.dao = new ImpostoPagoDAO(connection);
    }

    public void consultarHistorico(String cpf) {
        // O DAO fará a busca na base de dados e retornará a lista de objetos do domínio
        List<Imposto_pago> pagamentos = dao.buscarHistorico(cpf);

        if (pagamentos == null || pagamentos.isEmpty()) {
            System.out.println("Nenhum histórico de pagamento encontrado para o CPF: " + cpf);
            return;
        }

        for (Imposto_pago pgto : pagamentos) {
            // Utilizando exatamente os getters declarados na classe Imposto_pago.java
            System.out.println("Imposto Retido Titular: " + (pgto.getImposto_retido_titular() != null ? pgto.getImposto_retido_titular() : "0.00"));
            System.out.println("Imposto Retido Dependente: " + (pgto.getImposto_retido_dependente() != null ? pgto.getImposto_retido_dependente() : "0.00"));
            System.out.println("Carnê Leão Titular: " + (pgto.getCarne_titular() != null ? pgto.getCarne_titular() : "0.00"));
            System.out.println("Carnê Leão Dependente: " + (pgto.getCarne_dependente() != null ? pgto.getCarne_dependente() : "0.00"));
            System.out.println("Imposto Complementar: " + (pgto.getImposto_complementar() != null ? pgto.getImposto_complementar() : "0.00"));
            System.out.println("Imposto no Exterior: " + (pgto.getImposto_exterior() != null ? pgto.getImposto_exterior() : "0.00"));
            System.out.println("Imposto Retido na Fonte: " + (pgto.getImposto_retido() != null ? pgto.getImposto_retido() : "0.00"));
            System.out.println("Imposto RRA: " + (pgto.getImposto_RRA() != null ? pgto.getImposto_RRA() : "0.00"));
            System.out.println("-----------------------------------");
        }
    }
}