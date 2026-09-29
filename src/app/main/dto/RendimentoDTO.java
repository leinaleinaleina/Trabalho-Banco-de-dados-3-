package app.main.dto;

public class RendimentoDTO {
    private String fontePagadora;
    private String cnpjFonte;
    private String valorRecebido;
    private String decimoTerceiro;

    public RendimentoDTO(String fontePagadora, String cnpjFonte, String valorRecebido, String decimoTerceiro) {
        this.fontePagadora = fontePagadora;
        this.cnpjFonte = cnpjFonte;
        this.valorRecebido = valorRecebido;
        this.decimoTerceiro = decimoTerceiro;
    }

    public String getFontePagadora() { return fontePagadora; }
    public String getCnpjFonte() { return cnpjFonte; }
    public String getValorRecebido() { return valorRecebido; }
    public String getDecimoTerceiro() { return decimoTerceiro; }
}