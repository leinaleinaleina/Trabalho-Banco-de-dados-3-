package app.main.model.casestudy;

public class TipoPagamento {
    private int idTipoPagamento;
    private String descricao;

    public TipoPagamento() {}
    
    //Getters and Setters

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
