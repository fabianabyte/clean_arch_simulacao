package com.br.simulacao.dataprovider.repository;

import com.br.simulacao.dataprovider.model.entidade.simulacao.ProdutoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<ProdutoEntidade, Integer> {
}
