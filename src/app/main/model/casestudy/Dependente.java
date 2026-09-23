package app.main.model.casestudy;

public class Dependente {
    private int idDependente;
    private String nome;
    private String CPF;
    private String dataNascimento;
    private String moradiaContribuinte;
    private double deducao;
    private Contribuinte contribuinte;

    public int getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(int idDependente) {
        this.idDependente = idDependente;
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

    public String getMoradiaContribuinte() {
        return moradiaContribuinte;
    }

    public void setMoradiaContribuinte(String moradiaContribuinte) {
        this.moradiaContribuinte = moradiaContribuinte;
    }

    public double getDeducao() {
        return deducao;
    }

    public void setDeducao(double deducao) {
        this.deducao = deducao;
    }

    public Contribuinte getContribuinte () {
        return contribuinte;
    }
}
