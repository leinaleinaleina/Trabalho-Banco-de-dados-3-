package app.main.controller;

import java.util.Scanner;
//importar camada toda de servicos

public class SimulacaoController {
    
    // instanciar todos os serviços aqui
    // private DeclaracaoService declaracaoService = new DeclaracaoService();
    
    public void iniciar(Scanner scanner) {
        int opcao = 0;
        
        do {
            System.out.println("\n===================== Sistema IRPF 2026 =====================");
            System.out.println("1. Consultar Cadastro do Contribuinte");
            System.out.println("2. Consultar Simulação Completa da Declaração");
            System.out.println("3. Consultar Rendimentos Tributáveis Recebidos");
            System.out.println("4. Consultar Histórico de IRPF Pago");
            System.out.println("5. Consultar Evolução de Bens e Direitos");
            System.out.println("0. Sair");
            System.out.println("=============================================================\n");

            System.out.print("Escolha uma opção: ");
            
            if (scanner.hasNextInt()) {
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                if (opcao >= 1 && opcao <= 5) {
                    processarConsulta(opcao, scanner);
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

    private void processarConsulta(int opcao, Scanner scanner) {
        System.out.print("Informe os dígitos do CPF do contribuinte: ");
        String cpf = scanner.nextLine();
        
        System.out.println("\n#############################################################");
        System.out.print("Buscando dados para o CPF: " + cpf);
        animarCarregamento();

        System.out.println("\n");
        
        switch (opcao) {
            case 1 -> // contribuinteService.buscarPorCpf(cpf);
                System.out.println("Dados Pessoais e Contato:\n");
            case 2 -> // declaracaoService.gerarResumoDeclaracao(cpf);
                System.out.println("Imposto Devido e Base de Cálculo:\n");
            case 3 -> // rendimentoService.listarRendimentosPorCpf(cpf);
                System.out.println("Lista de Fontes Pagadoras e Valores:\n");
            case 4 -> // impostoPagoService.listarImpostosPagos(cpf);
                System.out.println("Histórico de Carnê-Leão e Retidos na Fonte:\n");
            case 5 -> // bemDireitoService.listarPatrimonio(cpf);
                System.out.println("Comparativo de Situação 2023 x 2024:\n");
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