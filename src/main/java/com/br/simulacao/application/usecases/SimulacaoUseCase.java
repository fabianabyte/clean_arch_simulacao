package com.br.simulacao.application.usecases;

import com.br.simulacao.application.domain.model.identificacao.TipoIdentificacao;
import com.br.simulacao.application.domain.model.simulacao.Simulacao;
import com.br.simulacao.application.gateway.SimulacaoGateway;
import com.br.simulacao.application.usecases.exception.SimulacaoNaoEncontradaException;
import com.br.simulacao.application.usecases.exception.SimulacaoRejeitadaException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class SimulacaoUseCase {
    final SimulacaoGateway simulacaoGateway;

    public SimulacaoUseCase(SimulacaoGateway simulacaoGateway){
        this.simulacaoGateway = simulacaoGateway;
    }

    private static final Integer VALIDADE_EM_MESES_SIMULACAO = 3;
    private static final Integer MAIOR_IDADE = 18;

    Predicate<Simulacao> simulacoesValidas = simulacao -> ChronoUnit.MONTHS.between(simulacao.getDataSimulacao(), LocalDate.now()) < VALIDADE_EM_MESES_SIMULACAO;

    public Simulacao gravarSimulacao(Simulacao simulacao) throws SimulacaoRejeitadaException{
        Simulacao retorno;

        if(simulacao.getPessoa().getTipoIdentificacao().equals(TipoIdentificacao.CPF)
                && !possuiMaiorIdade(simulacao.getPessoa().getDataNascimento())){
                throw new SimulacaoRejeitadaException("A pessoa informada não possui maior idade legal no Brasil.");
        }

        retorno = simulacaoGateway.criarSimulacao(simulacao);

        return retorno;
    }

    public boolean possuiMaiorIdade(LocalDate dataNascimento){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.YEARS.between(dataNascimento, agora) > MAIOR_IDADE;
    }

    public List<Simulacao> obterTodasSimulacoes() throws SimulacaoNaoEncontradaException {
        List<Simulacao> retorno = simulacaoGateway.obterTodasSimulacoes();

        if(retorno.isEmpty()){
            throw new SimulacaoNaoEncontradaException("Não foram encontradas simulações");
        }

        return retorno
                .stream()
                .filter(simulacoesValidas)
                .collect(Collectors.toList());
    }

    public List<Simulacao> obterSimulacoesPorPessoa(String idPessoa)  throws SimulacaoNaoEncontradaException {
        List<Simulacao> retorno = simulacaoGateway.obterSimulacoesPorPessoa(idPessoa)
                .stream()
                .filter(simulacoesValidas)
                .collect(Collectors.toList());

        if(retorno.isEmpty()){
            throw new SimulacaoNaoEncontradaException("Não foram encontradas simulações");
        }

        return retorno;
    }

}
