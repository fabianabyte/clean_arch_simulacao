package com.br.simulacao.utils.identificacao;

import com.br.simulacao.application.utils.identificacao.IdentificacaoFactory;
import com.br.simulacao.application.domain.model.identificacao.Identificacao;
import com.br.simulacao.application.domain.model.identificacao.TipoIdentificacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdentificacaoFactoryTest {

    private String identificacaoCPF = "12345678901";
    private String identificacaoCNPJ = "12345678901234";
    @Test
    void gerarIdentificacaoCPF() {
        Identificacao identificacaoGerada = IdentificacaoFactory.gerarIdentificacaoCPF(identificacaoCPF);

        assertEquals(TipoIdentificacao.CPF, identificacaoGerada.getTipoIdentificacao());
        assertNotNull(identificacaoGerada.getIdentificacaoFormatada());
    }

    @Test
    void gerarIdentificacaoCNPJ() {
        Identificacao identificacaoGerada = IdentificacaoFactory.gerarIdentificacaoCNPJ(identificacaoCNPJ);

        assertEquals(TipoIdentificacao.CNPJ, identificacaoGerada.getTipoIdentificacao());
        assertNotNull(identificacaoGerada.getIdentificacaoFormatada());
    }

    @Test
    void getIdentificacao() {
        Identificacao identificacaoGerada = IdentificacaoFactory.getIdentificacao(identificacaoCNPJ);

        assertEquals(TipoIdentificacao.CNPJ, identificacaoGerada.getTipoIdentificacao());
        assertNotNull(identificacaoGerada.getIdentificacaoFormatada());
    }

    @Test
    void getTipoIdentificacao() {
        TipoIdentificacao tipoIdentificacao = IdentificacaoFactory.getTipoIdentificacao(identificacaoCNPJ.length());

        assertNotNull(tipoIdentificacao);
        assertEquals(TipoIdentificacao.CNPJ, tipoIdentificacao);
    }
}