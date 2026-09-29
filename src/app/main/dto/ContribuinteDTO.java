package app.main.dto;

public class ContribuinteDTO {
    private String nome;
    private String cpf;
    private String dataNascimento;
    private String email;
    private String telefone;
    // O endereço completo pode ser concatenado numa única string no SQL
    private String enderecoCompleto;

    // Construtor
    public ContribuinteDTO(String nome, String cpf, String dataNascimento, String email, String telefone, String enderecoCompleto) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
        this.enderecoCompleto = enderecoCompleto;
    }

    // Getters
    public String getNome() { return nome; }
    public String getCpf() { return cpf; }
    public String getDataNascimento() { return dataNascimento; }
    public String getEmail() { return email; }
    public String getTelefone() { return telefone; }
    public String getEnderecoCompleto() { return enderecoCompleto; }
}