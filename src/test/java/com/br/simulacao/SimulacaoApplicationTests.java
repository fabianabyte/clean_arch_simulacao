package com.br.simulacao;

import com.br.simulacao.entrypoint.controller.SimulacaoController;
import com.br.simulacao.dataprovider.service.SimulacaoDataProviderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class SimulacaoApplicationTests {
	@Autowired
	private SimulacaoController simulacaoController;

	@Autowired
	private SimulacaoDataProviderService simulacaoDataProviderService;

	@Test
	void contextLoads() {
		assertThat(simulacaoController).isNotNull();
		assertThat(simulacaoDataProviderService).isNotNull();
	}

}
