package app.main.service;

import app.main.dto.ImpostoPagoDTO;
import app.main.repository.ImpostoPagoRepository;
import java.sql.Connection;
import java.util.List;

public class ImpostoPagoService {

    private ImpostoPagoRepository repository;

    public ImpostoPagoService(Connection connection) {
        this.repository = new ImpostoPagoRepository(connection);
    }

    public void buscarHistorico(String cpf) {
        List<ImpostoPagoDTO> pagamentos = repository.buscarHistorico(cpf);

        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum histórico de pagamento encontrado para o CPF: " + cpf);
            return;
        }

        for (ImpostoPagoDTO pgto : pagamentos) {
            System.out.println("Valor: R$ " + pgto.getValor());
            System.out.println("Parcela dedutível: " + pgto.getParcela());
            System.out.println("CNPJ Beneficiário: " + pgto.getCnpjBeneficiario());
            System.out.println("-----------------------------------");
        }
    }
}