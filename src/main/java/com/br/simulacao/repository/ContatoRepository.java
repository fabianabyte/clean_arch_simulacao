package com.br.simulacao.repository;

import com.br.simulacao.domain.entidade.pessoa.ContatoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntidade, Integer> {
}
