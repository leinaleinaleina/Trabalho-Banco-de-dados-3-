package programas.controller;

import programas.DAO.ContribuinteDAO;
import programas.classes.casodeuso.Contribuinte;

import java.sql.Connection;

public class ContribuinteController {

    private Connection conexao;

    public ContribuinteController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirDadosContribuinte(int idContribuinte) {
        ContribuinteDAO dao = new ContribuinteDAO(conexao);

        // Assumindo que o método no seu DAO se chama buscarPorId (ajuste se necessário)
        Contribuinte c = dao.buscarPorCpf(idContribuinte);

        if (c != null) {
            System.out.println("\n=================================================");
            System.out.println("             DADOS DO CONTRIBUINTE               ");
            System.out.println("=================================================");

            System.out.println("ID no Banco: " + c.getIdContribuinte());
            System.out.println("Nome: " + c.getNome());
            System.out.println("Data de Nascimento: " + c.getData_nascimento());

            // Tratamento visual usando os getters exatos da sua classe
            System.out.println("Possui Deficiência: " + formatarSimNao(c.getDefciciencia()));
            System.out.println("Houve Alteração: " + formatarSimNao(c.getAlteracao()));
            System.out.println("Possui Companheiro(a): " + formatarSimNao(c.getCompanheiro()));
            System.out.println("Residente no Exterior: " + formatarSimNao(c.getResidente()));

            System.out.println("\n--- CONTATO E ENDEREÇO ---");

            if (c.getEmail() != null) {
                // Assumindo que a classe EmailContribuinte possui o método getEmail()
                System.out.println("E-mail: " + c.getEmail().getEmail());
            }

            if (c.getTelefone() != null && c.getTelefone().getDDD() != null) {
                // Assumindo que TelefoneContribuinte possui os métodos getDDD() e getTelefone()
                System.out.println("Telefone: (" + c.getTelefone().getDDD().getDDD() + ") " + c.getTelefone().getTelefone());
            }

            if (c.getEndereco() != null) {
                System.out.println("CEP: " + c.getEndereco().getCEP());
            }

            // Imprimindo Número e Complemento que foram definidos na entidade
            System.out.println("Número: " + c.getNumero());
            System.out.println("Complemento: " + (c.getComplemento() != null ? c.getComplemento() : "N/A"));

            System.out.println("=================================================\n");
        } else {
            System.out.println("Nenhum dado encontrado para o ID especificado.");
        }
    }

    /**
     * Método auxiliar para transformar o char da entidade em texto legível.
     */
    private String formatarSimNao(Object valor) {
        if (valor == null) return "Não informado";

        String strValor = valor.toString().toUpperCase();

        // Se no seu banco a marcação de 'Sim' for 1, 'S', 'C' ou 'T'
        if (strValor.equals("1") || strValor.equals("S") || strValor.equals("TRUE") || strValor.equals("C")) {
            return "Sim";
        }
        return "Não";
    }
}