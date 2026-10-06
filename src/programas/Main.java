package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static Connection conectar() {
        // Ajuste a porta e o nome do banco conforme sua configuração no MySQL Workbench
        String url = "jdbc:mysql://localhost:3306/nome_do_seu_banco";
        String usuario = "root";
        String senha = "sua_senha";

        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao conectar: " + e.getMessage(), e);
        }
    }
}