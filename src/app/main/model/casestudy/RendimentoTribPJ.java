package app.main.model.casestudy;

public class RendimentoTribPJ {
    private int idRendimento;
    private String cpfPagadora;
    private String cnpjPagadora;
    private String nomePagadora;
    private String rendimentoRecebido;
    private String contribuicao;
    private String imposto;
    private String salario13;
    private String IRRF13salario;
    private int idFontePagadora;
    
    public RendimentoTribPJ() {}
    
    //Getters and Setters
    
    public int getIdRendimento() {
        return idRendimento;
    }

    public String getCpfPagadora() {
        return cpfPagadora;
    }

    public String getCnpjPagadora() {
        return cnpjPagadora;
    }

    public String getNomePagadora() {
        return nomePagadora;
    }

    public String getRendimentoRecebido() {
        return rendimentoRecebido;
    }

    public String getContribuicao() {
        return contribuicao;
    }

    public String getImposto() {
        return imposto;
    }

    public String getSalario13() {
        return salario13;
    }

    public String getIRRF13salario() {
        return IRRF13salario;
    }

    public int getIdFontePagadora() {
        return idFontePagadora;
    }

    public void setIdRendimento(int idRendimento) {
        this.idRendimento = idRendimento;
    }

    public void setCpfPagadora(String cpfPagadora) {
        this.cpfPagadora = cpfPagadora;
    }

    public void setCnpjPagadora(String cnpjPagadora) {
        this.cnpjPagadora = cnpjPagadora;
    }

    public void setNomePagadora(String nomePagadora) {
        this.nomePagadora = nomePagadora;
    }

    public void setRendimentoRecebido(String rendimentoRecebido) {
        this.rendimentoRecebido = rendimentoRecebido;
    }

    public void setContribuicao(String contribuicao) {
        this.contribuicao = contribuicao;
    }

    public void setImposto(String imposto) {
        this.imposto = imposto;
    }

    public void setSalario13(String salario13) {
        this.salario13 = salario13;
    }

    public void setIRRF13salario(String iRRF13salario) {
        IRRF13salario = iRRF13salario;
    }

    public void setIdFontePagadora(int idFontePagadora) {
        this.idFontePagadora = idFontePagadora;
    }

}
