package app.main.model.casestudy;

public class DeclaracaoRendaContribuinte {
    private int idDeclaracaoRenda;
    private String baseCalculo;
    private String impostoDevido;
    private String deducaoIncentivo;
    private String aliquota;
    private String numeroRecibo;
    private int identificacaoId; // FK para IdentificacaoContribuinte
    
    public DeclaracaoRendaContribuinte() {}

    // Getters e Setters
    public int getIdDeclaracaoRenda() { return idDeclaracaoRenda; }
    public void setIdDeclaracaoRenda(int idDeclaracaoRenda) { this.idDeclaracaoRenda = idDeclaracaoRenda; }

    public String getNumeroRecibo() { return numeroRecibo; }
    public void setNumeroRecibo(String numeroRecibo) { this.numeroRecibo = numeroRecibo; }
    
    public String getBaseCalculo() { return baseCalculo; }
    public void setBaseCalculo(String baseCalculo) { this.baseCalculo = baseCalculo; }

    public String getImpostoDevido() { return impostoDevido; }
    public void setImpostoDevido(String impostoDevido) { this.impostoDevido = impostoDevido; }

    public String getDeducaoIncentivo() { return deducaoIncentivo; }
    public void setDeducaoIncentivo(String deducaoIncentivo) { this.deducaoIncentivo = deducaoIncentivo; }

    public String getAliquota() { return aliquota; }
    public void setAliquota(String aliquota) { this.aliquota = aliquota; }

    public int getIdentificacaoId() { return identificacaoId; }
    public void setIdentificacaoId(int identificacaoId) { this.identificacaoId = identificacaoId; }

}