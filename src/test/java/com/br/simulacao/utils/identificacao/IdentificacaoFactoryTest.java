package com.br.simulacao.utils.identificacao;

import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.domain.model.identificacao.Identificacao;
import com.br.simulacao.domain.model.identificacao.TipoIdentificacao;
import com.br.simulacao.utils.pessoa.PessoaFactory;
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