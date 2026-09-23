package app.main.model.casestudy;

public class BemDireito {
    private int idBensDireitos;
    private String pais;
    private String iptu;
    private String dataAquisicao;
    private String discriminacao;
    private String areaTotal;
    private int cadastroImoveis;
    private String situacao2023;
    private String situacao2024;
    private int idDeclaracaoRenda; // Chave Estrangeira

    public BemDireito() {}

    // Getters e Setters
    public int getIdBensDireitos() { return idBensDireitos; }
    public void setIdBensDireitos(int idBensDireitos) { this.idBensDireitos = idBensDireitos; }

    public String getDiscriminacao() { return discriminacao; }
    public void setDiscriminacao(String discriminacao) { this.discriminacao = discriminacao; }

    public String getAreaTotal() { return areaTotal; }
    public void setAreaTotal(String areaTotal) { this.areaTotal = areaTotal; }

    public String getPais() { return pais; }
    public void setPais(String pais) { this.pais = pais; }

    public String getIptu() { return iptu; }
    public void setIptu(String iptu) { this.iptu = iptu; }

    public String getDataAquisicao() { return dataAquisicao; }
    public void setDataAquisicao(String dataAquisicao) { this.dataAquisicao = dataAquisicao; }

    public int getCadastroImoveis() { return cadastroImoveis; }
    public void setCadastroImoveis(int cadastroImoveis) { this.cadastroImoveis = cadastroImoveis; }

    public String getSituacao2023() { return situacao2023; }
    public void setSituacao2023(String situacao2023) { this.situacao2023 = situacao2023; }

    public String getSituacao2024() { return situacao2024; }
    public void setSituacao2024(String situacao2024) { this.situacao2024 = situacao2024; }

    public int getIdDeclaracaoRenda() { return idDeclaracaoRenda; }
    public void setIdDeclaracaoRenda(int idDeclaracaoRenda) { this.idDeclaracaoRenda = idDeclaracaoRenda; }

}