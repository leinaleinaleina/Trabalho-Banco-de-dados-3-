package app.main.service;

import app.main.dto.*;
import app.main.repository.*;
import java.sql.Connection;
import java.util.List;

public class DeclaracaoService {

    // Instanciamos todos os repositórios que você já criou
    private ContribuinteRepository contribuinteRepo;
    private RendimentoRepository rendimentoRepo;
    private ImpostoPagoRepository impostoPagoRepo;
    private BemDireitoRepository bemDireitoRepo;

    public DeclaracaoService(Connection connection) {
        this.contribuinteRepo = new ContribuinteRepository(connection);
        this.rendimentoRepo = new RendimentoRepository(connection);
        this.impostoPagoRepo = new ImpostoPagoRepository(connection);
        this.bemDireitoRepo = new BemDireitoRepository(connection);
    }

    public void gerarRelatorio(String cpf) {
        System.out.println("\n=============================================================");
        System.out.println("            RELATÓRIO COMPLETO - IRPF 2026");
        System.out.println("=============================================================");

        // 1. Busca e imprime os dados do Contribuinte
        ContribuinteDTO contribuinte = contribuinteRepo.buscarPorCpf(cpf);
        if (contribuinte == null) {
            System.out.println("Erro: Contribuinte não encontrado para o CPF " + cpf);
            return; // Se não achar a pessoa, cancela o resto do relatório
        }

        System.out.println("\n[1] DADOS DO CONTRIBUINTE");
        System.out.println("Nome: " + contribuinte.getNome());
        System.out.println("CPF: " + contribuinte.getCpf());
        System.out.println("E-mail: " + (contribuinte.getEmail() != null ? contribuinte.getEmail() : "N/A"));
        System.out.println("Telefone: " + (contribuinte.getTelefone() != null ? contribuinte.getTelefone() : "N/A"));
        System.out.println("Endereço: " + contribuinte.getEnderecoCompleto());

        // 2. Busca e imprime os Rendimentos Tributáveis
        System.out.println("\n[2] RENDIMENTOS TRIBUTÁVEIS RECEBIDOS");
        List<RendimentoDTO> rendimentos = rendimentoRepo.buscarTributaveis(cpf);
        if (rendimentos.isEmpty()) {
            System.out.println("Nenhum rendimento registrado.");
        } else {
            for (RendimentoDTO r : rendimentos) {
                System.out.println("- " + r.getFontePagadora() + " | Valor: R$ " + r.getValorRecebido());
            }
        }

        // 3. Busca e imprime os Impostos Pagos Anteriormente
        System.out.println("\n[3] IRPF PAGO ANTERIORMENTE (Até 2025)");
        List<ImpostoPagoDTO> pagamentos = impostoPagoRepo.buscarHistorico(cpf);
        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum imposto pago anteriormente registrado.");
        } else {
            for (ImpostoPagoDTO p : pagamentos) {
                System.out.println("- Valor: R$ " + p.getValor() + " | CNPJ: " + p.getCnpjBeneficiario());
            }
        }

        // 4. Busca e imprime os Bens e Direitos
        System.out.println("\n[4] EVOLUÇÃO DE BENS E DIREITOS");
        List<BemDireitoDTO> bens = bemDireitoRepo.buscarPatrimonio(cpf);
        if (bens.isEmpty()) {
            System.out.println("Nenhum bem ou direito registrado.");
        } else {
            for (BemDireitoDTO b : bens) {
                System.out.println("- " + b.getDiscriminacao() + " | 2023: R$ " + b.getSituacao2023() + " -> 2024: R$ " + b.getSituacao2024());
            }
        }

        System.out.println("=============================================================\n");
    }
}