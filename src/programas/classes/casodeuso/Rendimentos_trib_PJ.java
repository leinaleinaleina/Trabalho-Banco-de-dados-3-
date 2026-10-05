package programas.classes.casodeuso;


public class Rendimentos_trib_PJ {

    public int idRendimentos;
    public String CPF_pagadora;
    public String CNPJ_pagadora;
    public String Nome_pagadora;
    public String Rendimentos_recebidos;
    public String Contribuicao;
    public String Imposto;
    public String decimo_terceiro;
    public String IRPF_salario;
    private Fonte_pagadora fonte_pagadora;
    private Declaracao_renda declaracao_renda;

    public Rendimentos_trib_PJ () {
        this.fonte_pagadora = Fonte_pagadora ();
        this.declaracao_renda = declaracao_renda ();
    }

    public int getIdRendimentos() {
        return idRendimentos;
    }

    public void setIdRendimentos(int idRendimentos) {
        this.idRendimentos = idRendimentos;
    }

    public String getCPF_pagadora() {
        return CPF_pagadora;
    }

    public void setCPF_pagadora(String CPF_pagadora) {
        this.CPF_pagadora = CPF_pagadora;
    }

    public String getCNPJ_pagadora() {
        return CNPJ_pagadora;
    }

    public void setCNPJ_pagadora(String CNPJ_pagadora) {
        this.CNPJ_pagadora = CNPJ_pagadora;
    }

    public String getNome_pagadora() {
        return Nome_pagadora;
    }

    public void setNome_pagadora(String Nome_pagadora) {
        this.Nome_pagadora = Nome_pagadora;
    }

    public String getRendimentos_recebidos() {
        return Rendimentos_recebidos;
    }

    public void setRendimentos_recebidos(String Rendimentos_recebidos) {
        this.Rendimentos_recebidos = Rendimentos_recebidos;
    }

    public String getContribuicao() {
        return Contribuicao;
    }

    public void setContribuicao(String Contribuicao) {
        this.Contribuicao = Contribuicao;
    }

    public String getImposto() {
        return Imposto;
    }

    public void setImposto(String Imposto) {
        this.Imposto = Imposto;
    }

    public String getDecimo_terceiro() {
        return decimo_terceiro;
    }

    public void setDecimo_terceiro(String decimo_terceiro) {
        this.decimo_terceiro = decimo_terceiro;
    }

    public String getIRPF_salario() {
        return IRPF_salario;
    }

    public void setIRPF_salario(String IRPF_salario) {
        this.IRPF_salario = IRPF_salario;
    }

    public Fonte_pagadora getFonte_pagadora() {
        return fonte_pagadora;
    }

    public void setFonte_pagadora(Fonte_pagadora fonte_pagadora) {
        this.fonte_pagadora = fonte_pagadora;
    }

    public Declaracao_renda getDeclaracao_renda() {
        return declaracao_renda;
    }

    public void setDeclaracao_renda(Declaracao_renda declaracao_renda) {
        this.declaracao_renda = declaracao_renda;
    }
    

}