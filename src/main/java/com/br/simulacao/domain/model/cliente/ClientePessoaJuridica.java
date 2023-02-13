package com.br.simulacao.domain.model.cliente;

import com.br.simulacao.domain.model.identificacao.Identificacao;
import lombok.Builder;

@Builder
public class ClientePessoaJuridica implements Cliente{
    private Identificacao identificacao;
    @Override
    public void validar() throws Exception {
        identificacao.validar();
    }

    @Override
    public Identificacao getIdentificacao() {
        return identificacao;
    }
}
