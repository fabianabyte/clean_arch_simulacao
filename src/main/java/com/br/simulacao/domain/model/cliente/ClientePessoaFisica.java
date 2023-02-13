package com.br.simulacao.domain.model.cliente;

import com.br.simulacao.domain.model.identificacao.Identificacao;
import lombok.Builder;

@Builder
public class ClientePessoaFisica implements Cliente {

    private Identificacao identificacao;
    public void validar() throws Exception{
        identificacao.validar();
    }

    public Identificacao getIdentificacao(){
        return identificacao;
    }
}
