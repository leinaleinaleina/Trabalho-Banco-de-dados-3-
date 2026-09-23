package app.main.model.generic;

import app.main.model.casestudy.Contribuinte;

public class TelefoneContribuinte {
    public String telefone;
    private DDD ddd;
    private final DDI ddi;
    private int idTelefone;
    private Contribuinte contribuinte;

    public void setidTelefone (int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getidTelefone() {
        return idTelefone;
    }

    public TelefoneContribuinte () {
        this.ddd = new DDD();
        this.ddi = new DDI();
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone () {
        return telefone;
    }

    public void setDDD(DDD ddd) {
        this.ddd = ddd;
    }
    public DDD getDDD() {
        return ddd;
    }

    public DDI getDDI() {
        return ddi;
    }

    @Override
    public String toString() {
        return String.valueOf(telefone);
    }

    public void setContribuinte (Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }
}
