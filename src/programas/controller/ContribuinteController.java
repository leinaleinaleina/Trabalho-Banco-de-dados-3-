package app.main.service;

import app.main.dto.ContribuinteDTO;
import app.main.repository.ContribuinteRepository;
import java.sql.Connection;

public class ContribuinteService {

    private ContribuinteRepository repository;

    public ContribuinteService(Connection connection) {
        this.repository = new ContribuinteRepository(connection);
    }

    public void buscarDadosCompletos(String cpf) {
        ContribuinteDTO dados = repository.buscarPorCpf(cpf);

        if (dados != null) {
            System.out.println("Nome: " + dados.getNome());
            System.out.println("CPF: " + dados.getCpf());
            System.out.println("Nascimento: " + dados.getDataNascimento());
            System.out.println("E-mail: " + (dados.getEmail() != null ? dados.getEmail() : "Nenhum registado"));
            System.out.println("Telefone: " + (dados.getTelefone() != null ? dados.getTelefone() : "Nenhum registado"));
            System.out.println("Endereço: " + dados.getEnderecoCompleto());
        } else {
            System.out.println("Nenhum contribuinte encontrado com o CPF: " + cpf);
        }
    }
}