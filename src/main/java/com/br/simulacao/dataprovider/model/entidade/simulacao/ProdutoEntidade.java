package com.br.simulacao.dataprovider.model.entidade.simulacao;

import com.br.simulacao.dataprovider.model.entidade.EntidadeIdAb;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "produto")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProdutoEntidade extends EntidadeIdAb {

    @Column(name = "nomeProduto")
    private String nomeProduto;

    @Column(name = "tipoProduto")
    private String tipoProduto;

}
