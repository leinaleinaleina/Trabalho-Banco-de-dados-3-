package programas.classes.casodeuso;

public class Imposto_devido {

    public int idImposto_devido;
    public String Base_calculo;
    public String Deducao_incentivo;
    public String Imposto_devido_I;
    public String Imposto_devido_RRA;
    public String Aliquota;

    public int getIdImposto_devido() {
        return idImposto_devido;
    }

    public void setIdImposto_devido(int idImposto_devido) {
        this.idImposto_devido = idImposto_devido;
    }

    public String getBase_calculo() {
        return Base_calculo;
    }

    public void setBase_calculo(String Base_calculo) {
        this.Base_calculo = Base_calculo;
    }

    public String getDeducao_incentivo() {
        return Deducao_incentivo;
    }

    public void setDeducao_incentivo(String Deducao_incentivo) {
        this.Deducao_incentivo = Deducao_incentivo;
    }

    public String getImposto_devido_I() {
        return Imposto_devido_I;
    }

    public void setImposto_devido_I(String Imposto_devido_I) {
        this.Imposto_devido_I = Imposto_devido_I;
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