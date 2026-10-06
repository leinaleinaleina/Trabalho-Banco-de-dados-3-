package programas.DAO;

import programas.classes.casodeuso.Dependente;
import programas.classes.casodeuso.Tipo_dependente;
import programas.classes.generico.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO {
    private Connection conexao;

    public DependenteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public List<Dependente> buscarDependentesPorCpfContribuinte(int idContribuinte) {
        List<Dependente> dependentes = new ArrayList<>();

        // Consulta SQL unindo Dependente com suas tabelas auxiliares (Tipo, Email e Telefone)
        // Ajustada para filtrar através da relação com a Declaração de Renda / Contribuinte
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
        // Nota: Caso no seu banco a relação com dependente passe por outra tabela intermediária,
        // o WHERE pode ser adaptado, mas este padrão via Contribuinte mantém a consistência do sistema.

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

                // E-mail do Dependente
                EmailDependente email = new EmailDependente();
                email.setidEmail(rs.getInt("idEmail"));
                email.setEmail(rs.getString("Email"));
                dep.setEmail(dep.getEmail());

                // Telefone do Dependente
                TelefoneDependente telefone = new TelefoneDependente();
                telefone.setidTelefone(rs.getInt("idTelefone"));
                telefone.setTelefone(rs.getString("fone"));

                DDD dddObj = new DDD();
                dddObj.setidDDD(rs.getInt("idDDD"));
                dddObj.setDDD(rs.getInt("DDD"));
                telefone.setDDD(dddObj);

                DDI ddiObj = new DDI();
                ddiObj.setidDDDI(rs.getInt("idDDDI"));
                ddiObj.setDDDI(rs.getInt("DDDI"));
                telefone.setDDI(ddiObj);

                dep.setTelefone(dep.getTelefone());

                dependentes.add(dep);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar dependentes: " + e.getMessage());
            e.printStackTrace();
        }
        return dependentes;
    }
}