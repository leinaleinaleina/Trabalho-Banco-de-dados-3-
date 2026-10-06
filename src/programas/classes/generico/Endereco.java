package programas.classes.generico;

public class Endereco {
    private String CEP;
    private Bairro bairro;
    private Cidade cidade;
    private Logradouro logradouro;
    private int idEndereco;
    public String tipo_endereco;

    public Endereco () {
        this.bairro = new Bairro();
        this.cidade = new Cidade();
        this.logradouro = new Logradouro();
    }

    public void setidEndereco (int idEndereco) {
        this.idEndereco = idEndereco;
    } 

    public int getidEndereco () {
        return idEndereco;
    }

    public void setCEP (String CEP) {
        this.CEP = CEP;
    } 

    public String getCEP () {
        return CEP;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public void setCidade (Cidade cidade) {
        this.cidade = cidade;
    }

    public Bairro getBairro() {
        return bairro;
    }
    public Logradouro getLogradouro() {
        return logradouro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    @Override
    public String toString() {
        return String.valueOf(CEP);
    }

    public String getTipo_endereco() {
        return tipo_endereco;
    }

    public void setTipo_endereco(String tipo_endereco) {
        this.tipo_endereco = tipo_endereco;
    }
}
