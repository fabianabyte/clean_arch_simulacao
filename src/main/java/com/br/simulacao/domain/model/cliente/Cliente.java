package com.br.simulacao.domain.model.cliente;

import com.br.simulacao.domain.model.identificacao.Identificacao;

public interface Cliente {
    public void validar() throws Exception;

    public Identificacao getIdentificacao();
}
