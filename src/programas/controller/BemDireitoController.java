package programas.controller;

import programas.DAO.BemDireitoDAO;
import programas.classes.casodeuso.Bens_direitos;

import java.sql.Connection;
import java.util.List;

public class BemDireitoController {

    private Connection conexao;

    public BemDireitoController(Connection conexao) {
        this.conexao = conexao;
    }

    public void exibirBensDireitos(int cpf) {
        // Instancia o DAO e busca a lista de bens no banco de dados
        BemDireitoDAO dao = new BemDireitoDAO(conexao);
        List<Bens_direitos> bens = dao.buscarPatrimonio(cpf);

        System.out.println("\n=== BENS E DIREITOS ===");

        // Verifica se a lista não está vazia
        if (bens != null && !bens.isEmpty()) {
            // Percorre a lista e imprime os dados de cada bem
            for (int i = 0; i < bens.size(); i++) {
                Bens_direitos bem = bens.get(i);

                System.out.println("Item #" + (i + 1));
                System.out.println("Discriminação: " + bem.getDiscriminacao());
                System.out.println("País: " + bem.getPais());
                System.out.println("IPTU: " + bem.getIPTU());
                System.out.println("Data de Aquisição: " + bem.getData_aquisicao());
                System.out.println("Área Total: " + bem.getArea_total());
                System.out.println("Cadastro de Imóveis: " + bem.getCadastro_imoveis());
                System.out.println("Situação em 2024: R$ " + bem.getSituacao_2024());
                System.out.println("Situação em 2025: R$ " + bem.getSituacao_2025());
                System.out.println("CEP do Imóvel: " + bem.getEndereco().getCEP());
                System.out.println("---------------------------------------------");
            }
        } else {
            System.out.println("Nenhum bem ou direito encontrado para o CPF: " + cpf);
        }
    }
}