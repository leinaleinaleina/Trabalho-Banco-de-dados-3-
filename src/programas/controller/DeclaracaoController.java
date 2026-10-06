package programas.controller;

import java.sql.Connection;
import java.util.Scanner;

public class DeclaracaoController {

    private Connection connection;

    // Instâncias dos outros controladores do pacote
    private ContribuinteController contribuinteController;
    private ImpostoPagoController impostoPagoController;
    private RendimentoController rendimentoController;
    private BemDireitoController bemDireitoController;

    public DeclaracaoController(Connection connection) {
        this.connection = connection;
        this.contribuinteController = new ContribuinteController(connection);
        this.impostoPagoController = new ImpostoPagoController(connection);
        this.rendimentoController = new RendimentoController(connection);
        this.bemDireitoController = new BemDireitoController(connection);
    }

    public void iniciar(Scanner scanner) {
        System.out.println("===================== Sistema IRPF 2026 =====================");
        System.out.print("Inserir CPF: ");
        String cpf = scanner.nextLine().trim();

        if (cpf.isEmpty()) {
            System.out.println("CPF inválido. Encerrando o sistema...");
            return;
        }

        System.out.println("CPF Validado.\n");
        int opcao = 0;

        do {
            System.out.println("1. Contribuinte (dados pessoa e endereço)");
            System.out.println("2. IRPF (Pagamento - 2026 pra trás)");
            System.out.println("3. Tributaveis recebidos");
            System.out.println("5. Relatório Completo");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");

            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do teclado

                switch (opcao) {
                    // Supõe-se que seu colega criará métodos de busca nesses controladores
                    case 1 -> contribuinteController.consultarDados(cpf);
                    case 2 -> impostoPagoController.consultarHistorico(cpf);
                    case 3 -> rendimentoController.consultarRendimentos(cpf);
                    case 5 -> gerarRelatorioCompleto(cpf);
                    case 0 -> System.out.println("Encerrando o sistema...");
                    default -> System.out.println("Opção inválida.");
                }
            } else {
                System.out.println("Entrada inválida. Digite um número.");
                scanner.nextLine();
            }
            System.out.println();
        } while (opcao != 0);
    }

    private void gerarRelatorioCompleto(String cpf) {
        System.out.println("\n=============================================================");
        System.out.println("            RELATÓRIO COMPLETO - IRPF 2026");
        System.out.println("=============================================================");

        System.out.println("\n[1] DADOS DO CONTRIBUINTE");
        contribuinteController.consultarDados(cpf);

        System.out.println("\n[2] RENDIMENTOS TRIBUTÁVEIS RECEBIDOS");
        rendimentoController.consultarRendimentos(cpf);

        System.out.println("\n[3] IRPF PAGO ANTERIORMENTE");
        impostoPagoController.consultarHistorico(cpf);

        System.out.println("\n[4] EVOLUÇÃO DE BENS E DIREITOS");
        bemDireitoController.consultarPatrimonio(cpf);

        System.out.println("=============================================================\n");
    }
}