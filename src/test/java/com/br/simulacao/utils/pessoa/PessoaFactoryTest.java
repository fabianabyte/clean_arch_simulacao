package com.br.simulacao.utils.pessoa;

import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import com.br.simulacao.domain.model.identificacao.TipoIdentificacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PessoaFactoryTest {

    private final String identificacao = "12345678901234";

    @Test
    void gerarPessoaEntity() {
        PessoaEntidade pessoaGerada = PessoaFactory.gerarPessoaPorIdentificacao(identificacao);

        assertEquals(identificacao, pessoaGerada.getIdentificacao());
        assertNotNull(pessoaGerada.getIdentificacao());
    }

    @Test
    void gerarPessoaFisicaEntity() {
        PessoaEntidade pessoaGerada = PessoaFactory.gerarPessoaFisica(identificacao);

        assertEquals(identificacao, pessoaGerada.getIdentificacao());
        assertNotNull(pessoaGerada.getIdentificacao());
    }

    @Test
    void gerarPessoaJuridicaEntity() {
        PessoaEntidade pessoaGerada = PessoaFactory.gerarPessoaJuridica(identificacao);

        assertEquals(identificacao, pessoaGerada.getIdentificacao());
        assertNotNull(pessoaGerada.getIdentificacao());
    }

    @Test
    void testGerarPessoaEntity() {
        PessoaEntidade pessoaGerada = PessoaFactory.gerarPessoa(identificacao, TipoIdentificacao.CNPJ);

        assertEquals(identificacao, pessoaGerada.getIdentificacao());
        assertNotNull(pessoaGerada.getIdentificacao());
    }

}