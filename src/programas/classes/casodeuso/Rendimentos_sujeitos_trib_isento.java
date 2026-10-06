package programas.classes.casodeuso;

public class Rendimentos_sujeitos_trib_isento {
    public int idRendimento_trib_isento;
    public String valor;
    public String Beneficiario;
    public String trib_ou_isento;
    private Fonte_pagadora fonte_pagadora;
    private Tipo_rendimento tipo_rendimento;
    private Declaracao_renda declaracao_renda;

    public Rendimentos_sujeitos_trib_isento () {
        this.fonte_pagadora = new Fonte_pagadora();
        this.tipo_rendimento = new Tipo_rendimento();
        this.declaracao_renda = new Declaracao_renda();
    }

    public int getIdRendimento_trib_isento() {
        return idRendimento_trib_isento;
    }

    public void setIdRendimento_trib_isento(int idRendimento_trib_isento) {
        this.idRendimento_trib_isento = idRendimento_trib_isento;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getBeneficiario() {
        return Beneficiario;
    }

    public void setBeneficiario(String Beneficiario) {
        this.Beneficiario = Beneficiario;
    }

    public String getTrib_ou_isento() {
        return trib_ou_isento;
    }

    public void setTrib_ou_isento(String trib_ou_isento) {
        this.trib_ou_isento = trib_ou_isento;
    }

    public Fonte_pagadora getFonte_pagadora() {
        return fonte_pagadora;
    }

    public void setFonte_pagadora(Fonte_pagadora fonte_pagadora) {
        this.fonte_pagadora = fonte_pagadora;
    }

    public Tipo_rendimento getTipo_rendimento() {
        return tipo_rendimento;
    }

    public void setTipo_rendimento(Tipo_rendimento tipo_rendimento) {
        this.tipo_rendimento = tipo_rendimento;
    }

    public Declaracao_renda getDeclaracao_renda() {
        return declaracao_renda;
    }

    public void setDeclaracao_renda(Declaracao_renda declaracao_renda) {
        this.declaracao_renda = declaracao_renda;
    }

}