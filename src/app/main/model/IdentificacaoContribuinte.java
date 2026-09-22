package app.main.model;

public class IdentificacaoContribuinte {
    private int idIdentificacao;
    public TipoDeclaracao tipoDeclaracao;
    public Contribuinte contribuinte;

    public IdentificacaoContribuinte () {
        this.tipoDeclaracao = new TipoDeclaracao();
    }

    public int getIdIdentificacao() {
        return idIdentificacao;
    }

    public void setIdIdentificacao(int idIdentificacao) {
        this.idIdentificacao = idIdentificacao;
    }
}
