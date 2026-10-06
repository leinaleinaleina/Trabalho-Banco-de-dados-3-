package programas.controller;

import programas.DAO.DependenteDAO;
import programas.classes.casodeuso.Dependente;

import java.sql.Connection;
import java.util.List;

public class DependenteController {

    private Connection conexao;

    public DependenteController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirDependentes(int idContribuinte) {
        DependenteDAO dao = new DependenteDAO(conexao);

        // Busca a lista de dependentes associados ao contribuinte
        List<Dependente> dependentes = dao.buscarDependentesPorCpfContribuinte(idContribuinte);

        System.out.println("\n=================================================");
        System.out.println("              DEPENDENTES CADASTRADOS            ");
        System.out.println("=================================================");

        if (dependentes != null && !dependentes.isEmpty()) {
            for (int i = 0; i < dependentes.size(); i++) {
                Dependente dep = dependentes.get(i);

                System.out.println("Dependente #" + (i + 1));
                System.out.println("Nome: " + dep.getNome());
                System.out.println("CPF: " + formatarTexto(dep.getCPF()));
                System.out.println("Data de Nascimento: " + formatarTexto(dep.getData_nascimento()));
                System.out.println("Reside com o Titular: " + formatarSimNao(dep.getMoradia_titular()));
                System.out.println("Valor da Dedução: R$ " + formatarValor(dep.getDeducao()));

                // Tipo do dependente (se a classe estiver preenchida)
                if (dep.getTipo_dependente() != null) {
                    System.out.println("Tipo de Dependente: " + dep.getTipo_dependente().getTipo_dependente());
                }

                // Contatos do dependente
                if (dep.getEmail() != null) {
                    System.out.println("E-mail: " + dep.getEmail().getEmail());
                }

                if (dep.getTelefone() != null) {
                    String ddi = (dep.getTelefone().getDDI() != null) ? "+" + dep.getTelefone().getDDI().getDDI() + " " : "";
                    String ddd = (dep.getTelefone().getDDD() != null) ? "(" + dep.getTelefone().getDDD().getDDD() + ") " : "";
                    String numero = (dep.getTelefone().getTelefone() != null) ? dep.getTelefone().getTelefone() : "";

                    System.out.println("Telefone: " + ddi + ddd + numero);
                }

                System.out.println("-------------------------------------------------");
            }
        } else {
            System.out.println("Nenhum dependente cadastrado para este contribuinte.");
        }
    }

    /**
     * Métodos auxiliares para formatação visual na consola.
     */
    private String formatarSimNao(Object valor) {
        if (valor == null) return "Não informado";
        String strValor = valor.toString().toUpperCase();
        if (strValor.equals("1") || strValor.equals("S") || strValor.equals("TRUE")) {
            return "Sim";
        }
        return "Não";
    }

    private String formatarValor(String valor) {
        return (valor != null && !valor.isEmpty()) ? valor : "0,00";
    }

    private String formatarTexto(String texto) {
        return (texto != null && !texto.isEmpty()) ? texto : "Não informado";
    }
}