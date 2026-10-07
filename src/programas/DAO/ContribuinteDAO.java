package programas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import programas.classes.casodeuso.Contribuinte;
import programas.classes.generico.Bairro;
import programas.classes.generico.Cidade;
import programas.classes.generico.DDD;
import programas.classes.generico.DDI;
import programas.classes.generico.EmailContribuinte;
import programas.classes.generico.Endereco;
import programas.classes.generico.Logradouro;
import programas.classes.generico.TelefoneContribuinte;
import programas.classes.generico.UF;

public class ContribuinteDAO {
    private Connection conexao;

    public ContribuinteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Contribuinte buscarPorCpf(int idContribuinte) {
        Contribuinte contribuinte = null;
        String sql = "SELECT c.idContribuinte, c.Nome, c.CPF, c.Data_nascimento, c.Deficiencia, c.Alteracao, c.Companheiro, c.Residente_exterior, c.Numero, " +
             "n.idNatureza_ocupacao, n.Natureza_ocupacao, o.idOcupacao, o.Ocupacao, " +
             "e.idEndereco, e.Tipo_endereco, e.CEP, " +
             "b.idBairro, b.Bairro, l.idLogradouro, l.Logradouro, " +
             "tl.idTipo_logradouro, tl.Tipo_logradouro, " +
             "cid.idCidade, cid.Cidade, uf.idUF, uf.UF " +
             "FROM Contribuinte c " +
             "LEFT JOIN Natureza_ocupacao n ON c.Natureza_ocupacao_idNatureza_ocupacao = n.idNatureza_ocupacao " +
             "LEFT JOIN Ocupacao o ON n.Ocupacao_idOcupacao = o.idOcupacao " +
             "LEFT JOIN Endereco e ON c.Endereco_idEndereco = e.idEndereco " +
             "LEFT JOIN Bairro b ON e.Bairro_idBairro = b.idBairro " +
             "LEFT JOIN Logradouro l ON e.Logradouro_idLogradouro = l.idLogradouro " +
             "LEFT JOIN Tipo_logradouro tl ON l.Tipo_logradouro_idTipo_logradouro = tl.idTipo_logradouro " +
             "LEFT JOIN Cidade cid ON e.Cidade_idCidade = cid.idCidade " +
             "LEFT JOIN UF uf ON cid.UF_idUF = uf.idUF " +
             "WHERE c.idContribuinte = ?";

        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
             
            stmt.setInt(1, idContribuinte);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contribuinte = new Contribuinte();
                
                contribuinte.setIdContribuinte(rs.getInt("idContribuinte"));
                contribuinte.setNome(rs.getString("Nome"));
                contribuinte.setData_nascimento(rs.getString("Data_nascimento"));
                
                if(rs.getString("Deficiencia") != null && !rs.getString("Deficiencia").isEmpty()) {
                    contribuinte.setDefciciencia(rs.getString("Deficiencia").charAt(0));
                }
                if(rs.getString("Alteracao") != null && !rs.getString("Alteracao").isEmpty()) {
                    contribuinte.setAlteracao(rs.getString("Alteracao").charAt(0));
                }
                if(rs.getString("Companheiro") != null && !rs.getString("Companheiro").isEmpty()) {
                    contribuinte.setCompanheiro(rs.getString("Companheiro").charAt(0));
                }
                // Corrigido para "Residente_exterior" conforme a query SQL
                if(rs.getString("Residente_exterior") != null && !rs.getString("Residente_exterior").isEmpty()) {
                    contribuinte.setResidente(rs.getString("Residente_exterior").charAt(0));
                }
                
                contribuinte.setNumero(rs.getInt("Numero"));
                
                Endereco endereco = new Endereco();
                endereco.setidEndereco(rs.getInt("idEndereco"));
                endereco.setCEP(rs.getString("CEP"));
                
                Logradouro log = new Logradouro();
                log.setLogradouro(rs.getString("Logradouro"));
                endereco.setLogradouro(log);
                
                Bairro bairro = new Bairro();
                bairro.setBairro(rs.getString("Bairro"));
                endereco.setBairro(bairro);
                
                Cidade cidade = new Cidade();
                cidade.setCidade(rs.getString("Cidade"));
                
                UF uf = new UF();
                uf.setUF(rs.getString("UF"));
                cidade.setUF(uf);
                
                endereco.setCidade(cidade);
                contribuinte.setEndereco(endereco);

            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar contribuinte: " + e.getMessage());
        }
        return contribuinte;
    }
    
    public List<TelefoneContribuinte> buscarTelefones(int idContribuinte) throws SQLException {
        String sql = "SELECT * FROM TelefoneContribuinte WHERE Contribuinte_idContribuinte = ?";
        List<TelefoneContribuinte> telefones = new ArrayList<>();
        
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, idContribuinte);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                TelefoneContribuinte tel = new TelefoneContribuinte();
                tel.setTelefone(rs.getString("fone"));
                
                DDD ddd = new DDD();
                ddd.setidDDD(rs.getInt("DDD_idDDD"));
                tel.setDDD(ddd); 

                DDI ddi = new DDI();
                ddi.setidDDDI(rs.getInt("DDD_DDDI_idDDDI"));
                tel.setDDI(ddi); 
                
                telefones.add(tel);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar telefones do contribuinte: " + e.getMessage());
            throw e;
        }
        
        return telefones;
    }
    
    public List<EmailContribuinte> buscarEmails(int idContribuinte) throws SQLException {
        String sql = "SELECT * FROM Email_Contribuinte WHERE Contribuinte_idContribuinte = ?";
        List<EmailContribuinte> emails = new ArrayList<>();
        
        try (PreparedStatement stmt = this.conexao.prepareStatement(sql)) {
            
            stmt.setInt(1, idContribuinte);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                EmailContribuinte email = new EmailContribuinte();
                email.setEmail(rs.getString("Email"));
                emails.add(email);
            }
            
        } catch (SQLException e) {
            System.err.println("Erro ao buscar emails do contribuinte: " + e.getMessage());
            throw e;
        }
        
        return emails;
    }
}