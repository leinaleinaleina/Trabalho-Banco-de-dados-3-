package app.main.model;

public class UF {
    private String uf;
    private int idUF;
    private String siglaUF;


    public void setidUF (int idUF) {
        this.idUF = idUF;
    }

    public int getidUF() {
        return idUF;
    }

    public void setUF(String uf) {
        this.uf = uf;
    }

    public String getUF() {
        return uf;
    }

    @Override
    public String toString() {
        return String.valueOf(uf);
    }

    public String getSiglaUF() {
        return siglaUF;
    }

    public void setSiglaUF(String siglaUF) {
        this.siglaUF = siglaUF;
    }
}
