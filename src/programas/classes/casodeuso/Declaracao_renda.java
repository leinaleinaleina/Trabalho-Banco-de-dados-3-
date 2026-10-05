package programas.classes.casodeuso;


public class Declaracao_renda {

    public int idDeclaração_renda;
    public String Base_calculo;
    public String Imposto_devido;
    public String Deducao_incentivo;
    public Identificacao identificacao;
    public String Imposto_devido_RRA;
    public String Imposto_devido_I;
    public String Aliquota;
    public String Numero_recibo;
    public Imposto_pago imposto_pago;

    public Declaracao_renda () {
        this.identificacao = new Identificacao();
        this.imposto_pago = new Imposto_pago();
    }

    public int getIdDeclaração_renda() {
        return idDeclaração_renda;
    }

    public void setIdDeclaração_renda(int idDeclaração_renda) {
        this.idDeclaração_renda = idDeclaração_renda;
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

    public Identificacao getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(Identificacao identificacao) {
        this.identificacao = identificacao;
    }

    public String getImposto_devido_RRA() {
        return Imposto_devido_RRA;
    }

    public void setImposto_devido_RRA(String Imposto_devido_RRA) {
        this.Imposto_devido_RRA = Imposto_devido_RRA;
    }

    public String getImposto_devido_I() {
        return Imposto_devido_I;
    }

    public void setImposto_devido_I(String Imposto_devido_I) {
        this.Imposto_devido_I = Imposto_devido_I;
    }

    public String getAliquota() {
        return Aliquota;
    }

    public void setAliquota(String Aliquota) {
        this.Aliquota = Aliquota;
    }

    public String getNumero_recibo() {
        return Numero_recibo;
    }

    public void setNumero_recibo(String Numero_recibo) {
        this.Numero_recibo = Numero_recibo;
    }

    public Imposto_pago getImposto_pago() {
        return imposto_pago;
    }

    public void setImposto_pago(Imposto_pago imposto_pago) {
        this.imposto_pago = imposto_pago;
    }


}