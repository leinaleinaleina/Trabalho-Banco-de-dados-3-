package app.main.model.casestudy;

public class PagamentoEfetuado {
    private int idPagamentoEfetuado;
    private String cpfBeneficiario;
    private String cnpjBeneficiario;
    private String valor;
    private String dataPagamento;
    private String parcelaNDedutivel;
    private int idTipoPagamento; //Chave Estrangeira
    private int idDeclaracaoRenda; //Chave Estrangeira

    public PagamentoEfetuado() {}

    // Getters and Setters
    public int getIdPagamentoEfetuado() {
        return idPagamentoEfetuado; }

    public void setIdPagamentoEfetuado(int idPagamentoEfetuado) {
        this.idPagamentoEfetuado = idPagamentoEfetuado; }

    public String getCpfBeneficiario() {
        return cpfBeneficiario; }

    public void setCpfBeneficiario(String cpfBeneficiario) {
        this.cpfBeneficiario = cpfBeneficiario; }

    public String getCnpjBeneficiario() {
        return cnpjBeneficiario; }

    public void setCnpjBeneficiario(String cnpjBeneficiario) {
        this.cnpjBeneficiario = cnpjBeneficiario; }

    public String getValor() {
        return valor; }

    public void setValor(String valor) {
        this.valor = valor; }

    public String getDataPagamento() {
        return dataPagamento; }

    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento; }

    public String getParcelaNDedutivel() {
        return parcelaNDedutivel; }

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(int tipoPagamento) {
        this.idTipoPagamento = tipoPagamento;
    }

    public int getIdDeclaracaoRenda() {
        return idDeclaracaoRenda;
    }

    public void setIdDeclaracaoRenda(int declaracaoRenda) {
        this.idDeclaracaoRenda = declaracaoRenda;
    }
}
