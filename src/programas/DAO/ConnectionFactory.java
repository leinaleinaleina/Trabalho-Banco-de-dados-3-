package programas.DAO; 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    
    private static final String URL = "jdbc:mysql://localhost:3306/trabalho_irpf_2026"; 
    private static final String USER = "root"; 
    private static final String PASSWORD = "root"; // Sua senha do MySQL

    /**
     * Método responsável por estabelecer e retornar a conexão com o banco.
     */
    public static Connection getConnection() throws SQLException {
        try {
            // Garante que o driver do MySQL seja carregado (importante para evitar erros)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Retorna a conexão estabelecida
            return DriverManager.getConnection(URL, USER, PASSWORD);
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Nao encontrado.", e);
        }
    }
}