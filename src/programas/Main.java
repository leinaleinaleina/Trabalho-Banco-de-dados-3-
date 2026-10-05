package app.main;

import app.main.controller.SimulacaoController;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Declaramos a conexão aqui em cima para ela ser visível dentro do 'finally'
        Connection connection = null;

        try {
            System.out.println("Conectando ao banco de dados...");


            connection = DriverManager.getConnection("jdbc:postgresql://localhost:6666/irpf2026", "postgres", "123456");

            // Instancia o controller passando a conexão para ele usar nos serviços
            SimulacaoController controller = new SimulacaoController(connection);

            // inicia a interface
            controller.iniciar(scanner);

        } catch (Exception e) {
            System.out.println("Erro crítico: " + e.getMessage());
        } finally {
            scanner.close();

            // Fecha a conexão com o banco ao finalizar
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexão fechada.");
                } catch (SQLException e) {
                    System.out.println("Erro ao fechar a conexão: " + e.getMessage());
                }
            }
        }
    }
}