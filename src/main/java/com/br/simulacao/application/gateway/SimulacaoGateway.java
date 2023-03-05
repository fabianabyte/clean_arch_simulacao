package com.br.simulacao.application.gateway;

import com.br.simulacao.application.domain.model.simulacao.Simulacao;

import java.util.List;

public interface SimulacaoGateway {
    Simulacao criarSimulacao(Simulacao simulacao);
    List<Simulacao> obterTodasSimulacoes();
    List<Simulacao> obterSimulacoesPorPessoa(String idPessoa);
}
