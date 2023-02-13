package com.br.simulacao.repository;

import com.br.simulacao.domain.entidade.simulacao.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntidade, Integer> {
}
