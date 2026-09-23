package app.main.model.generic;

public class Endereco {
    private String CEP;
    private Bairro bairro;
    private Cidade cidade;
    private Logradouro logradouro;
    private int idEndereco;

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
}
