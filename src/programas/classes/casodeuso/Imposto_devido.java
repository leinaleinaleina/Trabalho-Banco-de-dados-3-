package programas.classes.casodeuso;

public class Imposto_devido {

    private int idImposto_devido;
    private String Base_calculo;
    private String Imposto_devido;
    private String Deducao_incentivo;
    private String Imporsto_devido_I; // Escrito com 'r' conforme o banco de dados
    private String Imposto_devido_RRA;
    private String Aliquota;

    public int getidImposto_devido() {
        return idImposto_devido;
    }

    public void setidImposto_devido(int idImposto_devido) {
        this.idImposto_devido = idImposto_devido;
    }

    public String getBase_calculo() {
        return Base_calculo;
    }

    public void setBase_calculo(String Base_calculo) {
        this.Base_calculo = Base_calculo;
    }

    public String getImposto_devido() {
        return Imposto_devido;
    }

    public void setImposto_devido(String Imposto_devido) {
        this.Imposto_devido = Imposto_devido;
    }

    public String getDeducao_incentivo() {
        return Deducao_incentivo;
    }

    public void setDeducao_incentivo(String Deducao_incentivo) {
        this.Deducao_incentivo = Deducao_incentivo;
    }

    public String getImporsto_devido_I() {
        return Imporsto_devido_I;
    }

    public void setImporsto_devido_I(String Imporsto_devido_I) {
        this.Imporsto_devido_I = Imporsto_devido_I;
    }

    public String getImposto_devido_RRA() {
        return Imposto_devido_RRA;
    }

    public void setImposto_devido_RRA(String Imposto_devido_RRA) {
        this.Imposto_devido_RRA = Imposto_devido_RRA;
    }

    public String getAliquota() {
        return Aliquota;
    }

    public void setAliquota(String Aliquota) {
        this.Aliquota = Aliquota;
    }
}