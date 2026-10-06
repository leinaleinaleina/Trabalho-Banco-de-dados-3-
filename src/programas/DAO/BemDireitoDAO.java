package programas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import programas.classes.casodeuso.Bens_direitos;
import programas.classes.generico.Endereco;

public class BemDireitoDAO {
    private Connection conexao;

    public BemDireitoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Bens_direitos> buscarPatrimonio(int cpfContribuinte) {
        List<Bens_direitos> bens = new ArrayList<>();

        // O JOIN correto passa pela Declaracao_Renda para chegar ao ID do Contribuinte (CPF)
        String sql = "SELECT bd.idBens_direitos, bd.Pais, bd.IPTU, bd.Data_aquisicao, " +
                "bd.Discriminacao, bd.Área_total, bd.Cadastro_imoveis, " +
                "bd.Situacao2023, bd.Situacao2024, " +
                "e.idEndereco, e.CEP " +
                "FROM Bens_direitos bd " +
                "INNER JOIN Declaracao_Renda dr ON bd.Declaracao_Renda_idDeclaracao_Renda = dr.idDeclaracao_Renda " +
                "LEFT JOIN Endereco e ON bd.Endereco_idEndereco = e.idEndereco " +
                "WHERE dr.Identificacao_Contribuinte_idContribuinte = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, cpfContribuinte);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Bens_direitos bem = new Bens_direitos();

                bem.setIdBens(rs.getInt("idBens_direitos"));
                bem.setPais(rs.getString("Pais"));
                bem.setIPTU(rs.getString("IPTU"));
                bem.setData_aquisicao(rs.getString("Data_aquisicao"));
                bem.setDiscriminacao(rs.getString("Discriminacao"));

                bem.setArea_total(rs.getString("Área_total"));

  
                String cadastroImoveisStr = rs.getString("Cadastro_imoveis");
                if(cadastroImoveisStr != null && !cadastroImoveisStr.isEmpty()) {
                    bem.setCadastro_imoveis(cadastroImoveisStr.charAt(0));
                }


                bem.setSituacao_2024(rs.getString("Situacao2023"));
                bem.setSituacao_2025(rs.getString("Situacao2024"));


                Endereco endereco = new Endereco();
                endereco.setidEndereco(rs.getInt("idEndereco"));
                endereco.setCEP(rs.getString("CEP"));
                bem.setEndereco(endereco);

                bens.add(bem);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar bens e direitos: " + e.getMessage());
        }
        return bens;
    }
}