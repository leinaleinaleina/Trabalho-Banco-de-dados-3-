package app.main;

import app.main.controller.SimulacaoController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SimulacaoController controller = new SimulacaoController();
        
        try {
            //--------> FALTA inicializar a conexão com o SGBD (JDBC)
            System.out.println("Conectando ao banco de dados...");
            
            // inicia a interface
            controller.iniciar(scanner);
            
        } catch (Exception e) {
            System.out.println("Erro crítico na simulação: " + e.getMessage());
        } finally {
            scanner.close();

            //-------->FALTA fechar a conexão com o banco
        }
    }
}