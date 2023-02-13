package com.br.simulacao.utils.cliente;

import com.br.simulacao.domain.model.cliente.Cliente;
import com.br.simulacao.domain.model.identificacao.Identificacao;
import com.br.simulacao.utils.identificacao.IdentificacaoFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ClienteFactoryTest {

    String numeroFicticioCNPJ = "12345678901234";
    String numeroFicticioCPF = "12345678901";
    Identificacao identificacaoCPF = IdentificacaoFactory.getIdentificacao(numeroFicticioCPF);
    Identificacao identificacaoCNPJ = IdentificacaoFactory.getIdentificacao(numeroFicticioCNPJ);

    @Test
    void gerarPorIdentificacao() {
        Cliente cliente = ClienteFactory.gerarPorIdentificacao(identificacaoCPF);

        assertNotNull(cliente);
    }

    @Test
    void gerarPessoaFisica() {
        Cliente cliente = ClienteFactory.gerarPessoaFisica(identificacaoCPF);

        assertNotNull(cliente);
    }

    @Test
    void gerarPessoaJuridica() {
        Cliente cliente = ClienteFactory.gerarPessoaJuridica(identificacaoCNPJ);

        assertNotNull(cliente);
    }
}