package programas.controller;

import programas.DAO.*;
import java.sql.Connection;
import java.util.List;

public class BemDireitoController {

    private BemDireitoController bem_direito;

    public BemDireitoController(Connection connection) {
        this.bem_direito = new BemDireitoController(connection);
    }

    public void listarPatrimonio(String cpf) {
        List<BemDireitoDAO> bens = bem_direito.buscarPatrimonio(cpf);

        if (bens.isEmpty()) {
            System.out.println("Nenhum bem ou direito encontrado para o CPF: " + cpf);
            return;
        }

        System.out.println("--- Evolução de Bens e Direitos ---");
        for (BemDireitoDAO bem : bens) {
            System.out.println("Bem: " + bem.getDiscriminacao());
            System.out.println("Valor em 2024: R$ " + (bem.getSituacao2024() != null ? bem.getSituacao2024() : "0.00"));
            System.out.println("Valor em 2024: R$ " + (bem.getSituacao2025() != null ? bem.getSituacao2025() : "0.00"));
            System.out.println("-----------------------------------");
        }
    }
}