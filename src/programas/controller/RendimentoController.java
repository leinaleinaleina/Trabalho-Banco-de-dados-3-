package programas.controller;

import java.sql.Connection;
import java.util.List;
import programas.DAO.RendimentoDAO;
import programas.classes.casodeuso.Rendimentos_trib_PJ;

public class RendimentoController {

    private Connection conexao;

    public RendimentoController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirRendimentos(int idContribuinte) {
        RendimentoDAO dao = new RendimentoDAO(conexao);


        List<Rendimentos_trib_PJ> rendimentos = dao.buscarTributaveisPorCpf(idContribuinte);

        System.out.println("\n=================================================");
        System.out.println("           RENDIMENTOS TRIBUTÁVEIS (PJ)          ");
        System.out.println("=================================================");

        if (rendimentos != null && !rendimentos.isEmpty()) {
            for (int i = 0; i < rendimentos.size(); i++) {
                Rendimentos_trib_PJ r = rendimentos.get(i);

                System.out.println("Registro #" + (i + 1));
                System.out.println("Fonte Pagadora: " + r.getNome_pagadora());
                System.out.println("CNPJ da Pagadora: " + formatarTexto(r.getCNPJ_pagadora()));
                System.out.println("CPF da Pagadora: " + formatarTexto(r.getCPF_pagadora()));
                System.out.println("Rendimentos Recebidos: R$ " + formatarValor(r.getRendimentos_recebidos()));
                System.out.println("Contribuição Previdenciária: R$ " + formatarValor(r.getContribuicao()));
                System.out.println("Imposto Retido: R$ " + formatarValor(r.getImposto()));
                System.out.println("13º Salário: R$ " + formatarValor(r.getDecimo_terceiro()));
                System.out.println("IRRF sobre 13º Salário: R$ " + formatarValor(r.getIRPF_salario()));
                System.out.println("-------------------------------------------------");
            }
        } else {
            System.out.println("Nenhum rendimento tributável encontrado para este contribuinte.");
        }
    }


    private String formatarValor(String valor) {
        return (valor != null && !valor.isEmpty()) ? valor : "0,00";
    }

    private String formatarTexto(String texto) {
        return (texto != null && !texto.isEmpty()) ? texto : "Não informado";
    }
}