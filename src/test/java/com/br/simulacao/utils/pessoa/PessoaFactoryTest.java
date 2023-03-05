package com.br.simulacao.utils.pessoa;

import com.br.simulacao.application.utils.pessoa.PessoaFactory;
import com.br.simulacao.application.domain.model.identificacao.TipoIdentificacao;
import com.br.simulacao.dataprovider.model.entidade.pessoa.PessoaEntidade;
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