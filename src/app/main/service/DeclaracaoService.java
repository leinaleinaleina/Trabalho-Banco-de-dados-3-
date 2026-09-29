package app.main.service;

import app.main.dto.DeclaracaoResumoDTO;
import app.main.repository.DeclaracaoRepository;
import java.sql.Connection;
import java.util.List;

public class DeclaracaoService {

    private DeclaracaoRepository repository;

    public DeclaracaoService(Connection connection) {
        this.repository = new DeclaracaoRepository(connection);
    }

    public List<DeclaracaoResumoDTO> gerarRelatorioDeclaracoes() {
        return repository.buscarSimulacoesCompletas();
    }
}