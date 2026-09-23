package app.main.model.casestudy;

public class IdentificacaoContribuinte {
    private int idIdentificacao;
    private TipoDeclaracao tipoDeclaracao;
    private Contribuinte contribuinte;

    public IdentificacaoContribuinte () {
        this.tipoDeclaracao = new TipoDeclaracao();
    }

    public int getIdIdentificacao() {
        return idIdentificacao;
    }

    public void setIdIdentificacao(int idIdentificacao) {
        this.idIdentificacao = idIdentificacao;
    }

    public TipoDeclaracao getTipoDeclaracao() {
        return tipoDeclaracao;
    }

    public void setTipoDeclaracao(TipoDeclaracao tipoDeclaracao) {
        this.tipoDeclaracao = tipoDeclaracao;
    }

    public Contribuinte getContribuinte() {
        return contribuinte;
    }

    public void setContribuinte(Contribuinte contribuinte) {
        this.contribuinte = contribuinte;
    }
}
