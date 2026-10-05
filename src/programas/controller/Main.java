package programas.controller;

import programas.DAO.*;
import java.sql.Connection;
import java.util.Scanner;

public class SimulacaoController {

    private DeclaracaoService declaracaoService;
    private ContribuinteService contribuinteService;
    private ImpostoPagoService impostoPagoService;
    private RendimentoService rendimentoService;
    private BemDireitoService bemdireitoService;
    // private BemDireitoService bemDireitoService; // Para uso futuro se necessário

    public SimulacaoController(Connection connection) {
        this.declaracaoService = new DeclaracaoService(connection);
        this.contribuinteService = new ContribuinteService(connection);
        this.impostoPagoService = new ImpostoPagoService(connection);
        this.rendimentoService = new RendimentoService(connection);
        this.bemdireitoService = new BemDireitoService(connection);
    }

    public void iniciar(Scanner scanner) {
        System.out.println("===================== Sistema IRPF 2026 =====================");
        System.out.print("Inserir CPF: ");
        String cpf = scanner.nextLine().trim();

        // Validação básica (pode ser aprimorada depois)
        if (cpf.isEmpty()) {
            System.out.println("CPF inválido. A encerrar...");
            return;
        }

        System.out.println("Validado.\n");
        int opcao = 0;

        do {
            System.out.println("1. Contribuinte (dados pessoa)");
            System.out.println("2. IRPF (Pagamento - 2026 pra trás)");
            System.out.println("3. Tributaveis recebidos");
            System.out.println("5. Relatório Completo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // limpar o buffer

                switch (opcao) {
                    case 1 -> consultarContribuinte(cpf);
                    case 2 -> consultarPagamentos(cpf);
                    case 3 -> consultarTributaveis(cpf);
                    case 5 -> declaracaoService.gerarRelatorio(cpf);
                    case 0 -> System.out.println("A encerrar o sistema...");
                    default -> System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Entrada inválida.");
                scanner.nextLine();
            }
            System.out.println();
        } while (opcao != 0);
    }

    private void consultarContribuinte(String cpf) {
        System.out.println("--- Dados do Contribuinte ---");
        // A IMPLEMENTAR: contribuinteService.buscarDadosCompletos(cpf);
    }

    private void consultarPagamentos(String cpf) {
        System.out.println("--- Pagamentos Anteriores a 2026 ---");
        // A IMPLEMENTAR: impostoPagoService.buscarHistorico(cpf);
    }

    private void consultarTributaveis(String cpf) {
        System.out.println("--- Rendimentos Tributáveis ---");
        // A IMPLEMENTAR: rendimentoService.buscarTributaveis(cpf);
    }

    private void consultarRelatorioCompleto(String cpf) {
        System.out.println("--- Relatório Completo da Declaração ---");
        // A IMPLEMENTAR: declaracaoService.gerarRelatorio(cpf);
    }
}