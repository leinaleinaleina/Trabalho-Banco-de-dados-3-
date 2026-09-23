package app.main.model.generic;

public class Bairro {
    private String bairro;
    private int idBairro;

    public void setidBairro (int idBairro) {
        this.idBairro = idBairro;
    }

    public int getidBairro() {
        return idBairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    
    @Override
    public String toString() {
        return String.valueOf(bairro);
    }
}
