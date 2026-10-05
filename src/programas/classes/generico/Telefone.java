package programas.classes.generico;

public class Telefone {
    public String telefone;
    private DDD ddd;
    private final DDI ddi;
    private int idTelefone;

    public void setidTelefone (int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getidTelefone() {
        return idTelefone;
    }

    public Telefone() {
        this.ddd = new DDD();
        this.ddi = new DDI();
    }

    public void setTelefone (String telefone) {
        this.telefone = telefone;
    }

    public String getTelefone () {
        return telefone;
    }

    public void setDDD(DDD ddd) {
        this.ddd = ddd;
    }
    public DDD getDDD() {
        return ddd;
    }

    public DDI getDDI() {
        return ddi;
    }

    @Override
    public String toString() {
        return String.valueOf(telefone);
    }
}