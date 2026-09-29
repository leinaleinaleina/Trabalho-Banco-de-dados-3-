package app.main.controller;

import app.main.dto.DeclaracaoResumoDTO;
import app.main.service.DeclaracaoService;
import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class SimulacaoController {

    private DeclaracaoService declaracaoService;

    // Construtor que recebe a conexão do Main e repassa para o serviço principal
    public SimulacaoController(Connection connection) {
        this.declaracaoService = new DeclaracaoService(connection);
    }

    public void iniciar(Scanner scanner) {
        int opcao = 0;

        do {
            System.out.println("\n===================== Sistema IRPF 2026 =====================");
            System.out.println("1. Consultar Simulação Completa da Declaração");
            System.out.println("0. Sair");
            System.out.println("=============================================================\n");

            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpar o buffer

                if (opcao == 1) {
                    processarConsulta(scanner);
                } else if (opcao == 0) {
                    System.out.println("Encerrando o sistema...");
                } else {
                    System.out.println("Opção inválida. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite uma opção numérica.");
                scanner.nextLine();
            }

        } while (opcao != 0);
    }

    private void processarConsulta(Scanner scanner) {
        System.out.print("Informe os dígitos do CPF do contribuinte (ou aperte ENTER para listar todos): ");
        String cpf = scanner.nextLine();

        System.out.println("\n#############################################################");
        System.out.print("Buscando dados...");
        animarCarregamento();

        System.out.println("\n");

        System.out.println("--- Simulação Completa da Declaração ---");
        // Busca os dados reais consolidados no banco
        List<DeclaracaoResumoDTO> relatorio = declaracaoService.gerarRelatorioDeclaracoes();

        boolean encontrou = false;
        for (DeclaracaoResumoDTO dto : relatorio) {
            // Filtra pelo CPF ou mostra todos se o usuário não digitou nada
            if (cpf.trim().isEmpty() || dto.getCpf().equals(cpf)) {
                System.out.println("Nome: " + dto.getNome());
                System.out.println("CPF: " + dto.getCpf());
                System.out.println("Rendimentos Tributáveis: R$ " + dto.getTotalRendimentos());
                System.out.println("Imposto Pago Anteriormente: R$ " + dto.getTotalImpostoPago());
                System.out.println("Bens e Direitos: " + dto.getDescricaoBens());
                System.out.println("-------------------------------------------------------------");
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum registro encontrado para o CPF informado.");
        }

        System.out.println("#############################################################\n");
    }

    private void animarCarregamento() {
        try {
            for (int i = 0; i < 3; i++) {
                Thread.sleep(400);
                System.out.print(".");
            }
            System.out.println();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}