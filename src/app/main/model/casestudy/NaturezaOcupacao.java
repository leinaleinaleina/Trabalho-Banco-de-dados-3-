package app.main.model.casestudy;

public class NaturezaOcupacao {
    private int idNaturezaOcupacao;
    private String descricao;
    private int idOcupacao; //Chave Estrangeira

    public NaturezaOcupacao() {}

    // Getters and Setters
    public int getIdNaturezaOcupacao() {
        return idNaturezaOcupacao;
    }

    public void setIdNaturezaOcupacao(int idNaturezaOcupacao) {
        this.idNaturezaOcupacao = idNaturezaOcupacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getIdOcupacao() {
        return idOcupacao;
    }

    public void setIdOcupacao(int idOcupacao) {
        this.idOcupacao = idOcupacao;
    }
}
