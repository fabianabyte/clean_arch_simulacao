package com.br.simulacao.domain.model.cliente;

import com.br.simulacao.domain.model.identificacao.Identificacao;

import java.time.LocalDate;

public interface Cliente {
    void validar() throws Exception;
    String getNomeOuRazaoSocial();
    LocalDate getDataNascimentoOuFundacao();
    Identificacao getIdentificacao();
}
