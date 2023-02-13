package com.br.simulacao.repository;

import com.br.simulacao.domain.entidade.simulacao.SimulacaoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SimulacaoRepository extends JpaRepository<SimulacaoEntidade, Integer> {

    List<SimulacaoEntidade> findByPessoaIdentificacao(String idPessoa);
}
