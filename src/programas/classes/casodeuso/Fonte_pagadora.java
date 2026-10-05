package programas.classes.casodeuso;


public class Fonte_pagadora {

    public int idFontePagadora;
    public String Nome;
    public String CNPJ;

    public int getIdFontePagadora() {
        return idFontePagadora;
    }

    public void setIdFontePagadora(int idFontePagadora) {
        this.idFontePagadora = idFontePagadora;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
}