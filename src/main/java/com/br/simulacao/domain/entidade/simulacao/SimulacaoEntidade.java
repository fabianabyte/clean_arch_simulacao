package com.br.simulacao.domain.entidade.simulacao;

import com.br.simulacao.domain.entidade.EntidadeIdAb;
import com.br.simulacao.domain.entidade.pessoa.PessoaEntidade;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "simulacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SimulacaoEntidade extends EntidadeIdAb {
    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "pessoaIdentificacao")
    private PessoaEntidade pessoa;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "produtoId")
    private ProdutoEntidade produto;

    @Column(name = "valor_entrada")
    private Double valorEntrada;

    @Column(name = "valor_prestacao")
    private Double valorPrestacao;

    @Column(name = "quantidade_prestacoes")
    private Integer quantidadePrestacoes;

    @Column(name = "valor_total_contrato")
    private Double valorTotalContrato;

    @Column(name = "taxa_mensal")
    private Double taxaMensal;

    @Column(name = "taxa_anual")
    private Double taxaAnual;
}
