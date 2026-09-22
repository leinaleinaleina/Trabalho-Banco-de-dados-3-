package app.main.model;

public class TipoLogradouro {
    private String tipoLogradouro;
    private int idTipoLogradouro;

    public void setidTipoLogradouro (int idTipoLogradouro) {
        this.idTipoLogradouro = idTipoLogradouro;
    }

    public int getidTipoLogradouro() {
        return idTipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    @Override
    public String toString() {
        return String.valueOf(tipoLogradouro);
    }
}
