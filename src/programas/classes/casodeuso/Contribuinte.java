package programas.classes.casodeuso;

import programas.classes.generico.*;

public class Contribuinte {
    
    public int idContribuinte;
    public String nome;
    public String data_nascimento;
    public char defciciencia;
    public char alteracao;
    public char companheiro;
    public char residente;
    private Endereco endereco;
    private Email email;
    private Telefone telefone;
    private Nat_ocupacao natureza_ocupacao;

    public Contribuinte () {
        this.endereco = new Endereco();
        this.email = new Email();
        this.telefone = new Telefone();
        this.natureza_ocupacao = new Nat_ocupacao();
    }

    public int getIdContribuinte() {
        return idContribuinte;
    }

    public void setIdContribuinte(int idContribuinte) {
        this.idContribuinte = idContribuinte;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public char getDefciciencia() {
        return defciciencia;
    }

    public void setDefciciencia(char defciciencia) {
        this.defciciencia = defciciencia;
    }

    public char getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(char alteracao) {
        this.alteracao = alteracao;
    }

    public char getCompanheiro() {
        return companheiro;
    }

    public void setCompanheiro(char companheiro) {
        this.companheiro = companheiro;
    }

    public char getResidente() {
        return residente;
    }

    public void setResidente(char residente) {
        this.residente = residente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Nat_ocupacao getNatureza_ocupacao() {
        return natureza_ocupacao;
    }

    public void setNatureza_ocupacao(Nat_ocupacao natureza_ocupacao) {
        this.natureza_ocupacao = natureza_ocupacao;
    }

}