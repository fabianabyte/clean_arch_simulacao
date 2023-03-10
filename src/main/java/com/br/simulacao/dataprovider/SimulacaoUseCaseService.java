package com.br.simulacao.dataprovider;

import com.br.simulacao.application.usecases.SimulacaoUseCase;
import com.br.simulacao.application.usecases.exception.SimulacaoNaoEncontradaException;
import com.br.simulacao.application.usecases.exception.SimulacaoRejeitadaException;
import com.br.simulacao.dataprovider.model.simulacao.Simulacao;
import com.br.simulacao.infraestructure.configuration.mapper.MapperConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimulacaoUseCaseService {
    final SimulacaoUseCase simulacaoUseCase;

    public Simulacao criarSimulacao(Simulacao simulacao) throws SimulacaoRejeitadaException{
        com.br.simulacao.application.domain.model.simulacao.Simulacao simulacaoNegio = MapperConfig.getSimulacaoMapper().converterSimulacaoProviderEmSimulacaoNegocio(simulacao);

        return MapperConfig
                .getSimulacaoMapper()
                .converterSimulacaoNegocioEmSimulacaoProvider(simulacaoUseCase.gravarSimulacao(simulacaoNegio));
    }

    public List<Simulacao> obterTodasSimulacoes() throws SimulacaoNaoEncontradaException {
        return simulacaoUseCase.obterTodasSimulacoes()
                .stream()
                .map(simulacao -> MapperConfig.getSimulacaoMapper().converterSimulacaoNegocioEmSimulacaoProvider(simulacao))
                .collect(Collectors.toList());

    }

    public List<Simulacao> obterSimulacoesPorPessoa(String idPessoa) throws SimulacaoNaoEncontradaException {
        return simulacaoUseCase.obterSimulacoesPorPessoa(idPessoa)
                .stream()
                .map(simulacao -> MapperConfig.getSimulacaoMapper().converterSimulacaoNegocioEmSimulacaoProvider(simulacao))
                .collect(Collectors.toList());
    }
}
