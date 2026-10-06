package programas.controller;

import programas.DAO.ContribuinteDAO;
import programas.classes.casodeuso.Contribuinte;
import java.sql.Connection;

public class ContribuinteController {

    private ContribuinteDAO dao;

    public ContribuinteController(Connection connection) {
        this.dao = new ContribuinteDAO(connection);
    }

    public void consultarDados(String cpf) {
        Contribuinte dados = dao.buscarPorCpf(cpf);

        if (dados != null) {
            System.out.println("Nome: " + dados.getNome());
            // System.out.println("CPF: " + dados.getCpf()); // Veja o aviso abaixo sobre o CPF
            System.out.println("Nascimento: " + dados.getData_nascimento());

            // Acessando os objetos aninhados que seu colega criou
            System.out.println("E-mail: " + dados.getEmail()); // O ideal é ter um dados.getEmail().getEmail()
            System.out.println("Telefone: " + dados.getTelefone());
            System.out.println("CEP do Endereço: " + dados.getEndereco().getCEP());
            System.out.println("Número: " + dados.getNumero());
        } else {
            System.out.println("Nenhum contribuinte encontrado com o CPF: " + cpf);
        }
    }
}