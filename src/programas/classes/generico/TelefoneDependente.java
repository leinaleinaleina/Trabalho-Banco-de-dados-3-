package programas.classes.generico;
import programas.classes.casodeuso.*;

public class TelefoneDependente {
    public String telefone;
    private DDD ddd;
    private DDI ddi;
    private int idTelefone;
    private Dependente dependente;

    public TelefoneDependente () {
        this.ddd = new DDD();
        this.ddi = new DDI();
    }

    public void setidTelefone (int idTelefone) {
        this.idTelefone = idTelefone;
    }

    public int getidTelefone() {
        return idTelefone;
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

    public Dependente getDependente() {
        return dependente;
    }

    public void setDependente(Dependente dependente) {
        this.dependente = dependente;
    }


    public void setDDI(DDI ddiObj) {
    }
}