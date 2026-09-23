package app.main.model.generic;

public class Cidade {
    private String cidade;
    private int idCidade;
    private UF uf;

    public Cidade() {
        this.uf = new UF();
    }

    public void setidCidade (int idCidade) {
        this.idCidade = idCidade;
    }

    public int getidCidade() {
        return idCidade;
    }


    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }
    
    public void setUF(UF uf) {
        this.uf = uf;
    }

    public UF getUF() {
        return uf;
    }

    @Override
    public String toString() {
        return String.valueOf(cidade);
    }
}
