package com.br.simulacao.application.utils.identificacao;

import com.br.simulacao.application.domain.model.identificacao.Identificacao;
import com.br.simulacao.application.domain.model.identificacao.IdentificacaoCNPJ;
import com.br.simulacao.application.domain.model.identificacao.IdentificacaoCPF;
import com.br.simulacao.application.domain.model.identificacao.TipoIdentificacao;
import org.slf4j.helpers.MessageFormatter;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class IdentificacaoFactory {

    private IdentificacaoFactory(){}

    public static Identificacao gerarIdentificacaoCPF(String numeroCPF) throws IllegalArgumentException{
        return gerarIdentificacao(numeroCPF, TipoIdentificacao.CPF);
    }

    public static Identificacao gerarIdentificacaoCNPJ(String numeroCNPJ) throws IllegalArgumentException{
        return gerarIdentificacao(numeroCNPJ, TipoIdentificacao.CNPJ);
    }

    private static Identificacao gerarIdentificacao(String identificacao, TipoIdentificacao tipoIdentificacao) throws IllegalArgumentException{
        Identificacao retorno = getIdentificacao(identificacao);

        if(retorno == null){
            throw new IllegalArgumentException(MessageFormatter.format("Número de {} Inválido!", tipoIdentificacao.getDescricao()).getMessage());
        }

        return retorno;
    }

    public static Identificacao getIdentificacao(final String identificacao) {
        final Map<TipoIdentificacao, Identificacao> mapa = new EnumMap<>(TipoIdentificacao.class);
        mapa.put(TipoIdentificacao.CPF, new IdentificacaoCPF(identificacao));
        mapa.put(TipoIdentificacao.CNPJ, new IdentificacaoCNPJ(identificacao));
        return mapa.get(getTipoIdentificacao(identificacao.length()));
    }
    public static TipoIdentificacao getTipoIdentificacao(final Integer tamanho) {
        final HashMap<Integer, TipoIdentificacao> mapa = new HashMap<>();
        mapa.put(TipoIdentificacao.CNPJ.getTamanho(), TipoIdentificacao.CNPJ);
        mapa.put(TipoIdentificacao.CPF.getTamanho(), TipoIdentificacao.CPF);
        return mapa.get(tamanho);
    }

}
