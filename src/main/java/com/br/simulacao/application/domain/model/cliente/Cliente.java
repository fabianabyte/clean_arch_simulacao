package com.br.simulacao.application.domain.model.cliente;


import com.br.simulacao.application.domain.model.identificacao.Identificacao;
import com.br.simulacao.application.usecases.exception.IdentificacaoInvalidaException;

import java.time.LocalDate;

public interface Cliente {
    void validar() throws IdentificacaoInvalidaException;
    String getNomeOuRazaoSocial();
    LocalDate getDataNascimentoOuFundacao();
    Identificacao getIdentificacao();
}
