package programas.classes.casodeuso;


public class Identificacao {

    public int idIdentificacao;
    private Tipo_declaracao tipo_declaracao;
    private Contribuinte contribuinte;

    public int getIdIdentificacao() {
        return idIdentificacao;
    }

    public void setIdIdentificacao(int idIdentificacao) {
        this.idIdentificacao = idIdentificacao;
    }

    public Tipo_declaracao getTipo_declaracao() {
        return tipo_declaracao;
    }

    public void setTipo_declaracao(Tipo_declaracao tipo_declaracao) {
        this.tipo_declaracao = tipo_declaracao;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }
    
}