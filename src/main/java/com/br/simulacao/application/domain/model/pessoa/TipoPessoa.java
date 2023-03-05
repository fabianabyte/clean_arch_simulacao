package com.br.simulacao.application.domain.model.pessoa;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public enum TipoPessoa {
    CPF("CPF"),
    CNPJ("CNPJ");

    private String descricao;
    private TipoPessoa(String descricao){
        this.descricao = descricao;
    }
}
