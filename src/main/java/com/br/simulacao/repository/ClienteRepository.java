package com.br.simulacao.repository;

import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<PessoaEntidade, Integer> {
}
