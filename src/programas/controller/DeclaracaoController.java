package programas.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeclaracaoController {

    private Connection conexao;
    private Scanner scanner;

    public DeclaracaoController(Connection conexao) {
        this.conexao = conexao;
        this.scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {

        System.out.println("SISTEMA DE GESTÃO IRPF 2026");

        int idContribuinteLogado = -1;
        String cpfDigitado = "";

        while (idContribuinteLogado == -1) {
            System.out.print("Digite o CPF do Contribuinte: ");
            cpfDigitado = scanner.nextLine().trim();


            if (cpfDigitado.isEmpty()) {
                System.out.println("Erro: Você precisa digitar um CPF. Tente novamente.\n");
                continue;
            }

            idContribuinteLogado = buscarIdPorCpf(cpfDigitado);

            if (idContribuinteLogado == -1) {
                System.out.println("Erro: CPF não encontrado na base de dados.\n");
            } else {
                System.out.println("CPF validado com sucesso! Acesso liberado.");
            }
        }

        int opcao = -1;


        while (opcao != 0) {
            System.out.println("\n--- MENU PRINCIPAL (CPF: " + cpfDigitado + ") ---");
            System.out.println("1 - Consultar Dados do Contribuinte");
            System.out.println("2 - Consultar IRPF Anteriores");
            System.out.println("3 - Consultar Dependentes");
            System.out.println("4 - Consultar Bens e Direitos");
            System.out.println("5 - Consultar Rendimentos");
            System.out.println("6 - Relatório Completo de Declarações (Geral)");
            System.out.println("0 - Sair do Sistema");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                continue;
            }

            System.out.println("\nProcessando...");

            switch (opcao) {
                case 1:
                    ContribuinteController contribuinteCtrl = new ContribuinteController(conexao);
                    contribuinteCtrl.exibirDadosContribuinte(idContribuinteLogado);
                    break;
                case 2:
                    ImpostoPagoController impostoCtrl = new ImpostoPagoController(conexao);
                    impostoCtrl.exibirIRPFAnteriores(idContribuinteLogado);
                    break;
                case 3:
                    DependenteController dependenteCtrl = new DependenteController(conexao);
                    dependenteCtrl.exibirDependentes(idContribuinteLogado);
                    break;
                case 4:
                    BemDireitoController bemDireitoCtrl = new BemDireitoController(conexao);
                    bemDireitoCtrl.exibirBensDireitos(idContribuinteLogado);
                    break;
                case 5:
                    RendimentoController rendimentoCtrl = new RendimentoController(conexao);
                    rendimentoCtrl.exibirRendimentos(idContribuinteLogado);
                    break;
                case 6:
                    RelatorioController relatorioCtrl = new RelatorioController(conexao);
                    relatorioCtrl.exibirRelatorioCompleto();
                    break;
                case 0:
                    System.out.println("Encerrando o sistema");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

 
    private int buscarIdPorCpf(String cpf) {
        String sql = "SELECT idContribuinte FROM Contribuinte WHERE CPF = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("idContribuinte");
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar o banco de dados: " + e.getMessage());
        }
        return -1;
    }
}