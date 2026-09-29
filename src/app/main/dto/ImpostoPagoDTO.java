package app.main.dto;

public class ImpostoPagoDTO {
    private String valor;
    private String parcela;
    private String cnpjBeneficiario;

    public ImpostoPagoDTO(String valor, String parcela, String cnpjBeneficiario) {
        this.valor = valor;
        this.parcela = parcela;
        this.cnpjBeneficiario = cnpjBeneficiario;
    }

    public String getValor() { return valor; }
    public String getParcela() { return parcela; }
    public String getCnpjBeneficiario() { return cnpjBeneficiario; }
}