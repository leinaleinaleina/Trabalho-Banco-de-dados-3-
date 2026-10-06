package programas.controller;

import programas.DAO.BemDireitoDAO;
import programas.classes.casodeuso.Bens_direitos;
import java.sql.Connection;
import java.util.List;

public class BemDireitoController {

    private BemDireitoDAO dao;

    public BemDireitoController(Connection connection) {
        // Conecta o Controller diretamente ao DAO
        this.dao = new BemDireitoDAO(connection);
    }

    public void consultarPatrimonio(String cpf) {
        // O DAO busca no banco e retorna a lista de objetos de domínio
        List<Bens_direitos> bens = dao.buscarPatrimonio(cpf);

        if (bens == null || bens.isEmpty()) {
            System.out.println("Nenhum bem ou direito encontrado para o CPF: " + cpf);
            return;
        }

        System.out.println("--- Evolução de Bens e Direitos ---");
        for (Bens_direitos bem : bens) {
            // Utiliza a classe de domínio Bens_direitos e as colunas corretas de anos
            System.out.println("Bem: " + bem.getDiscriminacao());
            System.out.println("Valor em 2023: R$ " + (bem.getSituacao2023() != null ? bem.getSituacao2023() : "0.00"));
            System.out.println("Valor em 2024: R$ " + (bem.getSituacao2024() != null ? bem.getSituacao2024() : "0.00"));
            System.out.println("-----------------------------------");
        }
    }
}