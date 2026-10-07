package programas.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import programas.classes.casodeuso.Dependente;
import programas.classes.casodeuso.Tipo_dependente;
import programas.classes.generico.*;

public class DependenteDAO {
    private Connection conexao;

    public DependenteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Dependente> buscarDependentesPorCpfContribuinte(int idContribuinte) {
        List<Dependente> dependentes = new ArrayList<>();

        String sql = "SELECT d.idDependente, d.Nome, d.CPF, d.Data_nascimento, d.Moradia_com_titular, d.Deducao, " +
                     "td.idTipo_dependente, td.Tipo_dependente " +
                     "FROM Dependente d " +
                     "INNER JOIN Tipo_dependente td ON d.Tipo_dependente_idTipo_dependente = td.idTipo_dependente " +
                     "WHERE d.Contribuinte_idContribuinte = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idContribuinte);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Dependente dep = new Dependente();

                dep.setIdDependente(rs.getInt("idDependente"));
                dep.setNome(rs.getString("Nome"));
                dep.setCPF(rs.getString("CPF"));
                dep.setData_nascimento(rs.getString("Data_nascimento"));
                dep.setMoradia_titular(rs.getString("Moradia_com_titular"));
                dep.setDeducao(rs.getString("Deducao"));

                Tipo_dependente tipoDep = new Tipo_dependente();
                tipoDep.setTipo_dependente(String.valueOf(rs.getInt("idTipo_dependente")));
                tipoDep.setTipo_dependente(rs.getString("Tipo_dependente"));
                dep.setTipo_dependente(tipoDep);

                dependentes.add(dep);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar dependentes: " + e.getMessage());
        }
        return dependentes;
    }

    public List<TelefoneDependente> buscarTelefones(int idDependente) throws SQLException {
        String sql = "SELECT * FROM TelefoneDependente WHERE Dependente_idDependente = ?";
        List<TelefoneDependente> telefones = new ArrayList<>();
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idDependente);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                TelefoneDependente tel = new TelefoneDependente();
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
            System.err.println("Erro ao buscar telefones do Dependente: " + e.getMessage());
            throw e;
        }
        
        return telefones;
    }
    
    public List<EmailDependente> buscarEmails(int idDependente) throws SQLException {
        String sql = "SELECT * FROM Email_Dependente WHERE Dependente_idDependente = ?";
        List<EmailDependente> emails = new ArrayList<>();
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idDependente);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                EmailDependente email = new EmailDependente();
                email.setEmail(rs.getString("Email"));
                emails.add(email);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao buscar emails do dependente: " + e.getMessage());
            throw e;
        }
        
        return emails;
    }
}