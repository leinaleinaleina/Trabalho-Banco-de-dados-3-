package programas;

import programas.controller.DeclaracaoController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        // Configurações de conexão com o banco de dados MySQL
        // Substitua "sua_senha" pela senha real do seu usuário root
        String url = "jdbc:mysql://localhost:3306/mydb?useTimezone=true&serverTimezone=UTC";
        String usuario = "root";
        String senha = "sua_senha";

        System.out.println("Iniciando o Sistema de Gestão de IRPF...");
        System.out.println("Conectando ao banco de dados...");

        // O bloco try-with-resources garante que a conexão será fechada automaticamente no final
        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            System.out.println("Conexão estabelecida com sucesso!\n");

            // Instancia o "Garçom" (Controlador Principal) passando a conexão ativa
            DeclaracaoController garcom = new DeclaracaoController(conexao);

            // Chama o método que vai ler o CPF e exibir as opções no terminal
            garcom.iniciarMenu();

        } catch (SQLException e) {
            System.out.println("Erro crítico: Não foi possível conectar ao banco de dados.");
            System.out.println("Detalhes do erro: " + e.getMessage());
            e.printStackTrace();
        }
    }
}