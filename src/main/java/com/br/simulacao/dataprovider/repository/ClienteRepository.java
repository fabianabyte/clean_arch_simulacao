package com.br.simulacao.dataprovider.repository;

import com.br.simulacao.dataprovider.model.entidade.pessoa.PessoaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<PessoaEntidade, Integer> {
}
