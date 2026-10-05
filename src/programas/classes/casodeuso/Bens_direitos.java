package programas.classes.casodeuso;
import programas.classes.generico.*;

public class Bens_direitos {

    public int idBens;
    public String Pais;
    public String IPTU;
    public String Data_aquisicao;
    public String Discriminacao;
    public String Area_total;
    public char Cadastro_imoveis;
    public String situacao_2024;
    public String situacao_2025;
    private Endereco endereco;

    public Bens_direitos() {
        this.endereco = new Endereco();
    }


    public int getIdBens() {
        return idBens;
    }

    public void setIdBens(int idBens) {
        this.idBens = idBens;
    }

    public String getPais() {
        return Pais;
    }

    public void setPais(String Pais) {
        this.Pais = Pais;
    }

    public String getIPTU() {
        return IPTU;
    }

    public void setIPTU(String IPTU) {
        this.IPTU = IPTU;
    }

    public String getData_aquisicao() {
        return Data_aquisicao;
    }

    public void setData_aquisicao(String Data_aquisicao) {
        this.Data_aquisicao = Data_aquisicao;
    }

    public String getDiscriminacao() {
        return Discriminacao;
    }

    public void setDiscriminacao(String Discriminacao) {
        this.Discriminacao = Discriminacao;
    }

    public String getArea_total() {
        return Area_total;
    }

    public void setArea_total(String Area_total) {
        this.Area_total = Area_total;
    }

    public char getCadastro_imoveis() {
        return Cadastro_imoveis;
    }

    public void setCadastro_imoveis(char Cadastro_imoveis) {
        this.Cadastro_imoveis = Cadastro_imoveis;
    }

    public String getSituacao_2024() {
        return situacao_2024;
    }

    public void setSituacao_2024(String situacao_2024) {
        this.situacao_2024 = situacao_2024;
    }

    public String getSituacao_2025() {
        return situacao_2025;
    }

    public void setSituacao_2025(String situacao_2025) {
        this.situacao_2025 = situacao_2025;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}