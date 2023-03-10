package com.br.simulacao.dataprovider.service.gateway;

import com.br.simulacao.application.domain.model.simulacao.Simulacao;
import com.br.simulacao.application.gateway.SimulacaoGateway;
import com.br.simulacao.dataprovider.mapper.SimulacaoMapper;
import com.br.simulacao.dataprovider.service.SimulacaoDataProviderService;
import com.br.simulacao.infraestructure.configuration.mapper.MapperConfig;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SimulacaoDataProviderGatewayService implements SimulacaoGateway {
    @NonNull
    SimulacaoDataProviderService simulacaoDataProviderService;

    SimulacaoMapper simulacaoMapper = MapperConfig.getSimulacaoMapper();

    @Override
    public Simulacao criarSimulacao(Simulacao simulacao) {
        com.br.simulacao.dataprovider.model.simulacao.Simulacao simulacaoDataProvider = simulacaoMapper.converterSimulacaoNegocioEmSimulacaoProvider(simulacao);
        return simulacaoMapper.converterSimulacaoProviderEmSimulacaoNegocio(simulacaoDataProviderService.criarSimulacao(simulacaoDataProvider));
    }

    @Override
    public List<Simulacao> obterTodasSimulacoes() {
        return simulacaoDataProviderService.obterTodasSimulacoes().stream()
                .map(
                        simulacaoDataProvider -> simulacaoMapper.converterSimulacaoProviderEmSimulacaoNegocio(simulacaoDataProvider)
                ).collect(Collectors.toList());
    }

    @Override
    public List<Simulacao> obterSimulacoesPorPessoa(String idPessoa) {
        return simulacaoDataProviderService.obterSimulacoesPorPessoa(idPessoa).stream()
                .map(simulacaoDataProvider -> simulacaoMapper.converterSimulacaoProviderEmSimulacaoNegocio(simulacaoDataProvider))
                .collect(Collectors.toList());
    }
}
