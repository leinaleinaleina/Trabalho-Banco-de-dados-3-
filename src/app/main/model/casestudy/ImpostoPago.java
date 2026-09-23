package app.main.model.casestudy;

public class ImpostoPago {
    private int idImpostoPago;
    private String impostoRetidoTitular;
    private String impostoRetidoDependente;
    private String carneTitular;
    private String carneDependente;
    private String impostoComplementar;
    private String impostoNoExterior;
    private String impostoRetido;
    private String impostoRRA;

    public ImpostoPago() {}

    // Getters e Setters
    public int getIdImpostoPago() { return idImpostoPago; }
    public void setIdImpostoPago(int idImpostoPago) { this.idImpostoPago = idImpostoPago; }

    public String getImpostoRetidoTitular() { return impostoRetidoTitular; }
    public void setImpostoRetidoTitular(String impostoRetidoTitular) { this.impostoRetidoTitular = impostoRetidoTitular; }

    public String getImpostoRetidoDependente() { return impostoRetidoDependente; }
    public void setImpostoRetidoDependente(String impostoRetidoDependente) { this.impostoRetidoDependente = impostoRetidoDependente; }  

    public String getCarneTitular() { return carneTitular; }
    public void setCarneTitular(String carneTitular) { this.carneTitular = carneTitular; }

    public String getCarneDependente() { return carneDependente; }
    public void setCarneDependente(String carneDependente) { this.carneDependente = carneDependente; }

    public String getImpostoComplementar() { return impostoComplementar; }
    public void setImpostoComplementar(String impostoComplementar) { this.impostoComplementar = impostoComplementar; }

    public String getImpostoNoExterior() { return impostoNoExterior; }
    public void setImpostoNoExterior(String impostoNoExterior) { this.impostoNoExterior = impostoNoExterior; }

    public String getImpostoRetido() { return impostoRetido; }
    public void setImpostoRetido(String impostoRetido) { this.impostoRetido = impostoRetido; }

    public String getImpostoRRA() { return impostoRRA; }
    public void setImpostoRRA(String impostoRRA) { this.impostoRRA = impostoRRA; }
}
