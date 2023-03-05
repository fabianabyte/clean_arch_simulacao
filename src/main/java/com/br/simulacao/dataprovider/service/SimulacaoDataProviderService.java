package com.br.simulacao.dataprovider.service;

import com.br.simulacao.infraestructure.configuration.mapper.MapperConfig;
import com.br.simulacao.dataprovider.model.simulacao.Simulacao;
import com.br.simulacao.dataprovider.repository.SimulacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SimulacaoDataProviderService {
    @Autowired
    SimulacaoRepository simulacaoRepository;

    public Simulacao criarSimulacao(Simulacao simulacao){
        return MapperConfig
                .getSimulacaoMapper()
                .converterSimulacaoEntityEmSimulacao(
                        simulacaoRepository.save(
                                MapperConfig
                                        .getSimulacaoMapper()
                                        .converterSimulacaoEmSimulacaoEntity(simulacao)
                        )
                );
    }

    public List<Simulacao> obterTodasSimulacoes() {
        return simulacaoRepository.findAll().stream().map(simulacaoEntity -> MapperConfig.getSimulacaoMapper().converterSimulacaoEntityEmSimulacao(simulacaoEntity)).collect(Collectors.toList());
    }

    public List<Simulacao> obterSimulacoesPorPessoa(String idPessoa) {
        return simulacaoRepository.findByPessoaIdentificacao(idPessoa).stream()
                .map(simulacaoEntity -> MapperConfig.getSimulacaoMapper().converterSimulacaoEntityEmSimulacao(simulacaoEntity))
                .collect(Collectors.toList());
    }

}
