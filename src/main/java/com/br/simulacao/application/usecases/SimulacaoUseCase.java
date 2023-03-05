package com.br.simulacao.application.usecases;

import com.br.simulacao.application.domain.model.pessoa.TipoPessoa;
import com.br.simulacao.application.domain.model.simulacao.Simulacao;
import com.br.simulacao.application.gateway.SimulacaoGateway;
import com.br.simulacao.application.usecases.exception.SimulacaoRejeitadaException;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Component
public class SimulacaoUseCase {
    @NonNull
    SimulacaoGateway simulacaoGateway;

    private static final Integer VALIDADE_EM_MESES_SIMULACAO = 3;
    private static final Integer MAIOR_IDADE = 18;

    public Simulacao gravarSimulacao(Simulacao simulacao) throws SimulacaoRejeitadaException{
        Simulacao retorno;

        if(simulacao.getPessoa().getTipoPessoa().equals(TipoPessoa.CPF)
        && possuiMaiorIdade(simulacao.getPessoa().getDataNascimento())){
            retorno = simulacaoGateway.criarSimulacao(simulacao);
        }else{
            throw new SimulacaoRejeitadaException("A pessoa informada não possui maior idade legal no Brasil.");
        }

        return retorno;
    }

    public boolean possuiMaiorIdade(LocalDate dataNascimento){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.YEARS.between(dataNascimento, agora) > MAIOR_IDADE;
    }

    public List<Simulacao> obterTodasSimulacoes(){
        LocalDate agora = LocalDate.now();
        List<Simulacao> retorno = simulacaoGateway.obterTodasSimulacoes();

        Predicate<Simulacao> simulacoesValidas = simulacao -> ChronoUnit.MONTHS.between(simulacao.getDataSimulacao(), agora) < VALIDADE_EM_MESES_SIMULACAO;

        return retorno.stream().filter(simulacoesValidas).collect(Collectors.toList());
    }

    public List<Simulacao> obterSimulacoesPorPessoa(String idPessoa){
        return simulacaoGateway.obterSimulacoesPorPessoa(idPessoa).stream()
                .filter(simulacao -> ChronoUnit.MONTHS.between(simulacao.getDataSimulacao(), LocalDate.now()) < VALIDADE_EM_MESES_SIMULACAO)
                .collect(Collectors.toList());
    }


}
