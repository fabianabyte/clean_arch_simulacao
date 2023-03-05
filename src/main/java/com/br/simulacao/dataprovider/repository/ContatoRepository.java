package com.br.simulacao.dataprovider.repository;

import com.br.simulacao.dataprovider.model.entidade.pessoa.ContatoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContatoRepository extends JpaRepository<ContatoEntidade, Integer> {
}
