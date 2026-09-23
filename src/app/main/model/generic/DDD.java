package app.main.model.generic;

public class DDD {
    public int DDD;
    private int idDDD;
    private DDI DDI;

    public void setidDDD (int idDDD) {
        this.idDDD = idDDD;
    }

    public int getidDDD() {
        return idDDD;
    }


    public void setDDD (int DDD) {
        this.DDD = DDD;
    }

    public int getDDD () {
        return DDD;
    }

    @Override
    public String toString() {
        return String.valueOf(DDD);
    }

    public DDI getDDI() {
        return DDI;
    }

    public void setDDI(DDI DDI) {
        this.DDI = DDI;
    }
}
