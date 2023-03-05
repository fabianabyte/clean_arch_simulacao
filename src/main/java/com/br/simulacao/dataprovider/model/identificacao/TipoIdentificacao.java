package com.br.simulacao.dataprovider.model.identificacao;

import lombok.Getter;

import java.util.HashMap;

@Getter
public enum TipoIdentificacao {
    CNPJ("CNPJ", 14),
    CPF("CPF", 11);

    private final String descricao;
    private final Integer tamanho;
    private static HashMap<String, TipoIdentificacao> lookup;

    TipoIdentificacao(final String descricao, final Integer tamanho) {
        this.descricao = descricao;
        this.tamanho = tamanho;
    }

    private static HashMap<String, TipoIdentificacao> gerarLookUp() {
        final HashMap<String, TipoIdentificacao> retorno = new HashMap<>();
        for (TipoIdentificacao tipoIdentificacao : values()) {
            retorno.put(tipoIdentificacao.getDescricao(), tipoIdentificacao);
        }
        return retorno;
    }

    public static TipoIdentificacao obterPorDescricao(final String descricao) {
        return TipoIdentificacao.lookup.get(descricao);
    }

    static {
        TipoIdentificacao.lookup = gerarLookUp();
    }
}
