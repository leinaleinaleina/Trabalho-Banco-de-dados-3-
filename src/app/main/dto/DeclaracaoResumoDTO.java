package app.main.dto;

public class DeclaracaoResumoDTO {
    private String nome;
    private String cpf;
    private double totalRendimentos;
    private double totalImpostoPago;
    private String descricaoBens;

    // Construtor vazio
    public DeclaracaoResumoDTO() {}

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public double getTotalRendimentos() { return totalRendimentos; }
    public void setTotalRendimentos(double totalRendimentos) { this.totalRendimentos = totalRendimentos; }

    public double getTotalImpostoPago() { return totalImpostoPago; }
    public void setTotalImpostoPago(double totalImpostoPago) { this.totalImpostoPago = totalImpostoPago; }

    public String getDescricaoBens() { return descricaoBens; }
    public void setDescricaoBens(String descricaoBens) { this.descricaoBens = descricaoBens; }
}