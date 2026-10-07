package programas.controller;

import java.sql.Connection;
import java.util.*;
import programas.DAO.*;
import programas.classes.casodeuso.*;
import programas.classes.generico.*;

public class DependenteController {

    private Connection conexao;

    public DependenteController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirDependentes(int idContribuinte) {
        DependenteDAO dao = new DependenteDAO(conexao);

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

                listarContatosDependente(dep.getIdDependente());
            }
        } else {
            System.out.println("Nenhum dependente cadastrado para este contribuinte.");
        }
    }

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

    public void listarContatosDependente(int idDependente) {
        DependenteDAO dao = new DependenteDAO(conexao); 
        
        try {
            List<TelefoneDependente> telefones = dao.buscarTelefones(idDependente);
            List<EmailDependente> emails = dao.buscarEmails(idDependente);
            
            System.out.println("\n--- Contatos do Dependente ID: " + idDependente + " ---");
            
            System.out.println("Telefones encontrados:");
            if (telefones.isEmpty()) {
                System.out.println("Nenhum telefone registrado.");
            } else {
                for (TelefoneDependente tel : telefones) {
                    System.out.println("- [" + tel.getDDI().getidDDI() + " " + tel.getDDD().getidDDD() + "] " + tel.getTelefone());
                }
            }
            
            System.out.println("\nE-mails encontrados:");
            if (emails.isEmpty()) {
                System.out.println("Nenhum e-mail registrado.");
            } else {
                for (EmailDependente email : emails) {
                    System.out.println("- " + email.getEmail());
                }
            }
            
        } catch (Exception e) {
            System.err.println("Falha ao recuperar os contatos: " + e.getMessage());
        }
    }
}