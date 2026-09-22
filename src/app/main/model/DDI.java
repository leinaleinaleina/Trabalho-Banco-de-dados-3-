package app.main.model;

public class DDI {
    public int DDI;
    private int idDDI;

    public void setidDDDI (int idDDI) {
        this.idDDI = idDDI;
    }

    public int getidDDI() {
        return idDDI;
    }

    public void setDDI (int DDI) {
        this.DDI = DDI;
    }

    public int getDDI () {
        return DDI;
    }

    @Override
    public String toString() {
        return String.valueOf(DDI);
    }
}
