package app.main.model.casestudy;

public class FontePagadora {
    private int idFontePagadora;
    private String nomeFontePagadora;
    private String cnpjFontePagadora;

    public FontePagadora() {}

    // Getters e Setters
    public int getIdFontePagadora() { return idFontePagadora; }
    public void setIdFontePagadora(int idFontePagadora) { this.idFontePagadora = idFontePagadora; }

    public String getNomeFontePagadora() { return nomeFontePagadora; }
    public void setNomeFontePagadora(String nomeFontePagadora) { this.nomeFontePagadora = nomeFontePagadora; }

    public String getCnpjFontePagadora() { return cnpjFontePagadora; }
    public void setCnpjFontePagadora(String cnpjFontePagadora) { this.cnpjFontePagadora = cnpjFontePagadora; }
}
