package app.main.model.generic;

import app.main.model.casestudy.Dependente;

public class EmailDependente {
    private String email;
    private int idEmail;
    public Dependente dependente;
    
    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }

    public void setidEmail (int idEmail) {
        this.idEmail = idEmail;
    }

    public int getidEmail() {
        return idEmail;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.valueOf(email);
    }
}
