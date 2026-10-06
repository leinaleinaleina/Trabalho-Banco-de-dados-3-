package programas.classes.casodeuso;
import programas.classes.generico.*;

public class Dependente {
    
    public int idDependente;
    public String Nome;
    public String CPF;
    public String Data_nascimento;
    public String Moradia_titular;
    public String Deducao;
    private TelefoneDependente telefone;
    private EmailDependente email;
    private Tipo_dependente tipo_dependente;

    public int getIdDependente() {
        return idDependente;
    }

    public void setIdDependente(int idDependente) {
        this.idDependente = idDependente;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getData_nascimento() {
        return Data_nascimento;
    }

    public void setData_nascimento(String Data_nascimento) {
        this.Data_nascimento = Data_nascimento;
    }

    public String getMoradia_titular() {
        return Moradia_titular;
    }

    public void setMoradia_titular(String Moradia_titular) {
        this.Moradia_titular = Moradia_titular;
    }

    public String getDeducao() {
        return Deducao;
    }

    public void setDeducao(String Deducao) {
        this.Deducao = Deducao;
    }

    public TelefoneDependente getTelefone() {
        return telefone;
    }

    public void setTelefone(TelefoneDependente telefone) {
        this.telefone = telefone;
    }

    public EmailDependente getEmail() {
        return email;
    }

    public void setEmail(EmailDependente email) {
        this.email = email;
    }

    public Tipo_dependente getTipo_dependente() {
        return tipo_dependente;
    }

    public void setTipo_dependente(Tipo_dependente tipo_dependente) {
        this.tipo_dependente = tipo_dependente;
    }

}
    