package app.main.service;

import app.main.dto.RendimentoDTO;
import app.main.repository.RendimentoRepository;
import java.sql.Connection;
import java.util.List;

public class RendimentoService {

    private RendimentoRepository repository;

    public RendimentoService(Connection connection) {
        this.repository = new RendimentoRepository(connection);
    }

    public void buscarTributaveis(String cpf) {
        List<RendimentoDTO> rendimentos = repository.buscarTributaveis(cpf);

        if (rendimentos.isEmpty()) {
            System.out.println("Nenhum rendimento tributável encontrado para o CPF: " + cpf);
            return;
        }

        for (RendimentoDTO rend : rendimentos) {
            System.out.println("Fonte Pagadora: " + rend.getFontePagadora() + " (CNPJ: " + rend.getCnpjFonte() + ")");
            System.out.println("Valor Recebido: R$ " + rend.getValorRecebido());
            System.out.println("13º Salário: R$ " + rend.getDecimoTerceiro());
            System.out.println("-----------------------------------");
        }
    }
}