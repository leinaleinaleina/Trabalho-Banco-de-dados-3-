package app.main.model;

public class Contribuinte {
    public int idContribuinte;
    public String nome;
    public String CPF;
    public String dataNascimento;
    public String deficiencia;
    public String alteracao;
    public String companheiro;
    public String residenteExterior;
    public int numero;
    public String complemento;
    private Endereco endereco;

    public Contribuinte () {}

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

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getDeficiencia() {
        return deficiencia;
    }

    public void setDeficiencia(String deficiencia) {
        this.deficiencia = deficiencia;
    }

    public String getAlteracao() {
        return alteracao;
    }

    public void setAlteracao(String alteracao) {
        this.alteracao = alteracao;
    }

    public String getCompanheiro() {
        return companheiro;
    }

    public void setCompanheiro(String companheiro) {
        this.companheiro = companheiro;
    }

    public String getResidenteExterior() {
        return residenteExterior;
    }

    public void setResidenteExterior(String residenteExterior) {
        this.residenteExterior = residenteExterior;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public void setEndereco (Endereco endereco) {
        this.endereco = endereco;
    }

    public Endereco getEndereco () {
        return endereco;
    }
}
