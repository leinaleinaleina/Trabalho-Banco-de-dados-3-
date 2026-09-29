package app.main.dto;

public class BemDireitoDTO {
    private String discriminacao;
    private String situacao2023;
    private String situacao2024;

    public BemDireitoDTO(String discriminacao, String situacao2023, String situacao2024) {
        this.discriminacao = discriminacao;
        this.situacao2023 = situacao2023;
        this.situacao2024 = situacao2024;
    }

    public String getDiscriminacao() { return discriminacao; }
    public String getSituacao2023() { return situacao2023; }
    public String getSituacao2024() { return situacao2024; }
}