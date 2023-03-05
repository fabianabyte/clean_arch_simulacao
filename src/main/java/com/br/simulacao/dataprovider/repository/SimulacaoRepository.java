package com.br.simulacao.dataprovider.repository;

import com.br.simulacao.dataprovider.model.entidade.simulacao.SimulacaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulacaoRepository extends JpaRepository<SimulacaoEntidade, Integer> {

    List<SimulacaoEntidade> findByPessoaIdentificacao(String idPessoa);
}
