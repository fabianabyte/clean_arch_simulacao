package com.br.simulacao.application.domain.model.cliente;


import com.br.simulacao.application.domain.model.identificacao.Identificacao;
import com.br.simulacao.application.usecases.exception.IdentificacaoInvalidaException;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Builder
@Getter
@Setter
public class ClientePessoaJuridica implements Cliente {
    private Identificacao identificacao;
    private String razaoSocial;
    private LocalDate dataFundacao;
    @Override
    public void validar() throws IdentificacaoInvalidaException {
        identificacao.validar();
    }

    @Override
    public String getNomeOuRazaoSocial() {
        return getRazaoSocial();
    }

    @Override
    public Identificacao getIdentificacao() {
        return identificacao;
    }

    @Override
    public LocalDate getDataNascimentoOuFundacao() {
        return getDataFundacao();
    }
}
