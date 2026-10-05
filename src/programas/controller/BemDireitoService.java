package programas.controller;

import programas.DAO.*;
import java.sql.Connection;
import java.util.List;

public class BemDireitoService {

    private BemDireitoRepository repository;

    public BemDireitoService(Connection connection) {
        this.repository = new BemDireitoRepository(connection);
    }

    public void listarPatrimonio(String cpf) {
        List<BemDireitoDTO> bens = repository.buscarPatrimonio(cpf);

        if (bens.isEmpty()) {
            System.out.println("Nenhum bem ou direito encontrado para o CPF: " + cpf);
            return;
        }

        System.out.println("--- Evolução de Bens e Direitos ---");
        for (BemDireitoDTO bem : bens) {
            System.out.println("Bem: " + bem.getDiscriminacao());
            System.out.println("Valor em 2023: R$ " + (bem.getSituacao2023() != null ? bem.getSituacao2023() : "0.00"));
            System.out.println("Valor em 2024: R$ " + (bem.getSituacao2024() != null ? bem.getSituacao2024() : "0.00"));
            System.out.println("-----------------------------------");
        }
    }
}