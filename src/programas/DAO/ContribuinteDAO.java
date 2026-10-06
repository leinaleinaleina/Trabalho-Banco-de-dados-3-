package programas.DAO;

import programas.classes.casodeuso.Contribuinte;
import programas.classes.casodeuso.Nat_ocupacao;
import programas.classes.casodeuso.Ocupacao;
import programas.classes.generico.Endereco;
import programas.classes.generico.Bairro;
import programas.classes.generico.Logradouro;
import programas.classes.generico.TipoLogradouro;
import programas.classes.generico.Cidade;
import programas.classes.generico.UF;
import programas.classes.generico.TelefoneContribuinte;
import programas.classes.generico.DDD;
import programas.classes.generico.DDI;
import programas.classes.generico.EmailContribuinte;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContribuinteDAO {
    private Connection conexao;

    public ContribuinteDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public Contribuinte buscarPorCpf(int idContribuinte) {
        Contribuinte contribuinte = null;
        String sql = "SELECT c.idContribuinte, c.Nome, c.Data_nascimento, c.Deficiencia, c.Alteracao, c.Companheiro, c.Residente, " +
                "n.idNatureza_ocupacao, n.Natureza_ocupacao, o.idOcupacao, o.Ocupacao, " +
                "e.idEndereco, e.Tipo_endereco, e.CEP, e.Numero, e.Complemento, " +
                "b.idBairro, b.Bairro, l.idLogradouro, l.Logradouro, " +
                "tl.idTipo_logradouro, tl.Tipo_logradouro, " +
                "cid.idCidade, cid.Cidade, uf.idUF, uf.UF, " +
                "t.idTelefone, t.fone, d.idDDD, d.DDD, ddi.idDDDI, ddi.DDDI, " +
                "em.idEmail, em.Email " +
                "FROM Contribuinte c " +
                "INNER JOIN Natureza_ocupacao n ON c.Natureza_ocupacao_idNatureza_ocupacao = n.idNatureza_ocupacao " +
                "INNER JOIN Ocupacao o ON c.Natureza_ocupacao_Ocupacao_idOcupacao = o.idOcupacao " +
                "INNER JOIN Endereco e ON c.Endereco_idEndereco = e.idEndereco " +
                "INNER JOIN Bairro b ON e.Bairro_idBairro = b.idBairro " +
                "INNER JOIN Logradouro l ON e.Logradouro_idLogradouro = l.idLogradouro " +
                "INNER JOIN Tipo_logradouro tl ON l.Tipo_logradouro_idTipo_logradouro = tl.idTipo_logradouro " +
                "INNER JOIN Cidade cid ON e.Cidade_idCidade = cid.idCidade " +
                "INNER JOIN UF uf ON cid.UF_idUF = uf.idUF " +
                "INNER JOIN Telefone t ON c.Telefone_idTelefone = t.idTelefone " +
                "INNER JOIN DDD d ON t.DDD_idDDD = d.idDDD " +
                "INNER JOIN DDDI ddi ON d.DDDI_idDDDI = ddi.idDDDI " +
                "INNER JOIN Email em ON c.Email_idEmail = em.idEmail " +
                "WHERE c.idContribuinte = ? AND e.Tipo_endereco = 0";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idContribuinte);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                contribuinte = new Contribuinte();

                // Dados básicos do Contribuinte
                contribuinte.setIdContribuinte(rs.getInt("idContribuinte"));
                contribuinte.setNome(rs.getString("Nome"));
                contribuinte.setData_nascimento(rs.getString("Data_nascimento"));

                // Tratamento de TINYINT (BD) para char (Java)
                if(rs.getString("Deficiencia") != null && !rs.getString("Deficiencia").isEmpty()) {
                    contribuinte.setDefciciencia(rs.getString("Deficiencia").charAt(0));
                }
                if(rs.getString("Alteracao") != null && !rs.getString("Alteracao").isEmpty()) {
                    contribuinte.setAlteracao(rs.getString("Alteracao").charAt(0));
                }
                if(rs.getString("Companheiro") != null && !rs.getString("Companheiro").isEmpty()) {
                    contribuinte.setCompanheiro(rs.getString("Companheiro").charAt(0));
                }
                if(rs.getString("Residente") != null && !rs.getString("Residente").isEmpty()) {
                    contribuinte.setResidente(rs.getString("Residente").charAt(0));
                }

                // Numero e Complemento do Endereco salvos no Contribuinte
                if (rs.getString("Numero") != null && !rs.getString("Numero").isEmpty()) {
                    try {
                        contribuinte.setNumero(Integer.parseInt(rs.getString("Numero")));
                    } catch (NumberFormatException ex) {
                        contribuinte.setNumero(0);
                    }
                }
                contribuinte.setComplemento(rs.getString("Complemento"));

                // Natureza da Ocupação e Ocupação
                Nat_ocupacao natOcupacao = new Nat_ocupacao();
                natOcupacao.setIdNatureza(rs.getInt("idNatureza_ocupacao"));
                natOcupacao.setNatureza_ocupacao(rs.getString("Natureza_ocupacao"));

                Ocupacao ocupacao = new Ocupacao();
                ocupacao.setIdOcupacao(rs.getInt("idOcupacao"));
                ocupacao.setOcupacao(rs.getString("Ocupacao"));

                natOcupacao.setOcupacao(ocupacao);
                contribuinte.setNatureza_ocupacao(natOcupacao);

                // Endereço
                Endereco endereco = new Endereco();
                endereco.setidEndereco(rs.getInt("idEndereco"));
                endereco.setTipo_endereco(rs.getString("Tipo_endereco"));
                endereco.setCEP(rs.getString("CEP"));

                // Bairro
                Bairro bairro = new Bairro();
                bairro.setidBairro(rs.getInt("idBairro"));
                bairro.setBairro(rs.getString("Bairro"));
                endereco.setBairro(bairro);

                // Tipo Logradouro -> Inserido dentro de Logradouro
                TipoLogradouro tipoLogradouro = new TipoLogradouro();
                tipoLogradouro.setidTipoLogradouro(rs.getInt("idTipo_logradouro"));
                tipoLogradouro.setTipoLogradouro(rs.getString("Tipo_logradouro"));

                Logradouro logradouro = new Logradouro();
                logradouro.setidLogradouro(rs.getInt("idLogradouro"));
                logradouro.setLogradouro(rs.getString("Logradouro"));
                logradouro.setTipoLogradouro(tipoLogradouro);
                endereco.setLogradouro(logradouro);

                // UF -> Inserida dentro de Cidade
                UF ufObj = new UF();
                ufObj.setidUF(rs.getInt("idUF"));
                ufObj.setUF(rs.getString("UF"));

                Cidade cidade = new Cidade();
                cidade.setidCidade(rs.getInt("idCidade"));
                cidade.setCidade(rs.getString("Cidade"));
                cidade.setUF(ufObj);
                endereco.setCidade(cidade);

                contribuinte.setEndereco(endereco);

                // Telefone
                TelefoneContribuinte telefone = new TelefoneContribuinte();
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

                contribuinte.setTelefone(telefone);

                // Email
                EmailContribuinte email = new EmailContribuinte();
                email.setidEmail(rs.getInt("idEmail"));
                email.setEmail(rs.getString("Email"));
                contribuinte.setEmail(email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contribuinte;
    }
}