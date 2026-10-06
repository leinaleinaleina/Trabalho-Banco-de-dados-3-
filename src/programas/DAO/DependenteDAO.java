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
                "td.idTipo_dependente, td.Tipo_dependente, " +
                "em.idEmail, em.Email, " +
                "t.idTelefone, t.fone, " +
                "ddd.idDDD, ddd.DDD, " +
                "ddi.idDDDI, ddi.DDDI " +
                "FROM Dependente d " +
                "INNER JOIN Tipo_dependente td ON d.Tipo_dependente_idTipo_dependente = td.idTipo_dependente " +
                "INNER JOIN Email em ON d.Email_idEmail = em.idEmail " +
                "INNER JOIN Telefone t ON d.Telefone_idTelefone = t.idTelefone " +
                "INNER JOIN DDD ddd ON t.DDD_idDDD = ddd.idDDD " +
                "INNER JOIN DDDI ddi ON ddd.DDDI_idDDDI = ddi.idDDDI " +
                "INNER JOIN Declaracao_Renda dr ON dr.Identificacao_Contribuinte_idContribuinte = ?";

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

                // Tipo de Dependente
                Tipo_dependente tipoDep = new Tipo_dependente();
                tipoDep.setTipo_dependente(String.valueOf(rs.getInt("idTipo_dependente")));
                tipoDep.setTipo_dependente(rs.getString("Tipo_dependente"));
                dep.setTipo_dependente(tipoDep);

                buscarTelefones(idContribuinte);
                buscarEmails(idContribuinte);

                dep.setTelefone(dep.getTelefone());

                dependentes.add(dep);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar dependentes: " + e.getMessage());
            e.printStackTrace();
        }
        return dependentes;
    }

        public List<TelefoneDependente> buscarTelefones(int idDependente) throws SQLException {
        String sql = "SELECT * FROM TelefoneDependente WHERE Dependente_idDependente = ?";
        List<TelefoneDependente> telefones = new ArrayList<>();
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idDependente);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                TelefoneDependente tel = new TelefoneDependente();
                
                tel.setTelefone(rs.getString("fone"));
                tel.getDDD().setidDDD(rs.getInt("DDD_idDDD"));
                tel.getDDI().setidDDDI(rs.getInt("DDD_DDDI_idDDDI"));
                
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
        
        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
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