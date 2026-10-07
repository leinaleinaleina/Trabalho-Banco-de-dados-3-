package programas.controller;

import java.sql.Connection;
import java.util.*;
import programas.DAO.*;
import programas.classes.casodeuso.*;
import programas.classes.generico.*;

public class ContribuinteController {

    private Connection conexao;

    public ContribuinteController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirDadosContribuinte(int idContribuinte) {
        ContribuinteDAO dao = new ContribuinteDAO(conexao);


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

            if (c.getEndereco() != null) {
                            System.out.println("CEP: " + c.getEndereco().getCEP());
                            
                            if (c.getEndereco().getLogradouro() != null) {
                                System.out.println("Logradouro: " + c.getEndereco().getLogradouro().getLogradouro());
                            }
                            
                            System.out.println("Número: " + c.getNumero());
                            System.out.println("Complemento: " + (c.getComplemento() != null ? c.getComplemento() : "N/A"));
                            
                            if (c.getEndereco().getBairro() != null) {
                                System.out.println("Bairro: " + c.getEndereco().getBairro().getBairro());
                            }
                            
                            if (c.getEndereco().getCidade() != null) {
                                System.out.println("Cidade: " + c.getEndereco().getCidade().getCidade());
                                if (c.getEndereco().getCidade().getUF() != null) {
                                    System.out.println("UF: " + c.getEndereco().getCidade().getUF().getUF());
                                }
                            }

                            listarContatosContribuinte(idContribuinte);
                            
                        } else {
                            System.out.println("Endereço: Não carregado ou inexistente.");

            listarContatosContribuinte(idContribuinte);

            System.out.println("Número: " + c.getNumero());
            System.out.println("Complemento: " + (c.getComplemento() != null ? c.getComplemento() : "N/A"));

            System.out.println("=================================================\n");
        } 
    }
    }
  
    private String formatarSimNao(Object valor) {
        if (valor == null) return "Não informado";

        String strValor = valor.toString().toUpperCase();

        if (strValor.equals("1") || strValor.equals("S") || strValor.equals("TRUE") || strValor.equals("C")) {
            return "Sim";
        }
        return "Não";
    }

    public void listarContatosContribuinte(int idContribuinte) {
        ContribuinteDAO dao= new ContribuinteDAO(conexao);  
        
        try {
            List<TelefoneContribuinte> telefones = dao.buscarTelefones(idContribuinte);
            List<EmailContribuinte> emails = dao.buscarEmails(idContribuinte);
            
            System.out.println("\n--- Contatos do Contribuinte ID: " + idContribuinte + " ---");
            
            System.out.println("Telefones encontrados:");
            if (telefones.isEmpty()) {
                System.out.println("Nenhum telefone registrado.");
            } else {
                for (TelefoneContribuinte tel : telefones) {
                    // Iterando a partir da array list
                    System.out.println("- [" + tel.getDDI().getidDDI() + " " + tel.getDDD().getidDDD() + "] " + tel.getTelefone());
                }
            }
            
            System.out.println("\nE-mails encontrados:");
            if (emails.isEmpty()) {
                System.out.println("Nenhum e-mail registrado.");
            } else {
                for (EmailContribuinte email : emails) {
                    // Iterando a partir da array list
                    System.out.println("- " + email.getEmail());
                }
            }
            
        } catch (Exception e) {
            System.err.println("Falha ao recuperar os contatos: " + e.getMessage());
        }
    }
}