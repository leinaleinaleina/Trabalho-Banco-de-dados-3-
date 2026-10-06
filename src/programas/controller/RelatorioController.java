package programas.controller;

import programas.DAO.RelatorioDAO;
import programas.classes.casodeuso.Declaracao_renda;

import java.sql.Connection;
import java.util.List;

public class RelatorioController {

    private Connection conexao;

    public RelatorioController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirRelatorioCompleto() {
        RelatorioDAO dao = new RelatorioDAO(conexao);
        List<Declaracao_renda> lista = dao.buscarRelatorioGeral();

        System.out.println("\n=================================================");
        System.out.println("          RELATÓRIO GERAL DE DECLARAÇÕES         ");
        System.out.println("=================================================");

        if (lista != null && !lista.isEmpty()) {
            for (int i = 0; i < lista.size(); i++) {
                Declaracao_renda dec = lista.get(i);

                System.out.println("Registo #" + (i + 1));
                System.out.println("ID Declaração: " + dec.getIdDeclaração_renda());

                // Exibe o nome do contribuinte puxando pela Identificação
                if (dec.getIdentificacao() != null && dec.getIdentificacao().getContribuinte() != null) {
                    System.out.println("Contribuinte: " + dec.getIdentificacao().getContribuinte().getNome());
                }

                String impDevido = (dec.getImposto_devido() != null) ? dec.getImposto_devido() : "0,00";
                System.out.println("Imposto Devido: R$ " + impDevido);
                System.out.println("-------------------------------------------------");
            }
            System.out.println("Total de declarações encontradas: " + lista.size());
        } else {
            System.out.println("Nenhuma declaração registada no sistema.");
        }
        System.out.println("=================================================\n");
    }
}