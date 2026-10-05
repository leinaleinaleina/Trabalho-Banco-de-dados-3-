package programas.classes.casodeuso;


public class Nat_ocupacao {

    public int idNatureza;
    public String Natureza_ocupacao;
    private Ocupacao ocupacao;

    public Nat_ocupacao () {
        this.ocupacao = new Ocupacao();
    }

    public int getIdNatureza() {
        return idNatureza;
    }

    public void setIdNatureza(int idNatureza) {
        this.idNatureza = idNatureza;
    }

    public String getNatureza_ocupacao() {
        return Natureza_ocupacao;
    }

    public void setNatureza_ocupacao(String Natureza_ocupacao) {
        this.Natureza_ocupacao = Natureza_ocupacao;
    }

    public Ocupacao getOcupacao() {
        return ocupacao;
    }

    public void setOcupacao(Ocupacao ocupacao) {
        this.ocupacao = ocupacao;
    }
}