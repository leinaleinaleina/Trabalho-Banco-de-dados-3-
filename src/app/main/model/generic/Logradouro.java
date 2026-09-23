package app.main.model.generic;

public class Logradouro {
    public String logradouro;
    private TipoLogradouro tipoLogradouro;
    private int idLogradouro;

    public Logradouro () {
        this.tipoLogradouro = new TipoLogradouro();
    }

    public void setidLogradouro (int idLogradouro) {
        this.idLogradouro = idLogradouro;
    }

    public int getidLogradouro() {
        return idLogradouro;
    }

    public void setLogradouro (String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setTipoLogradouro (TipoLogradouro tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public TipoLogradouro getTipoLogradouro() {
        return tipoLogradouro ;
    }

    @Override
    public String toString() {
        return String.valueOf(logradouro);
    }
}
