package com.br.simulacao.domain.entidade.pessoa;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "pessoa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PessoaEntidade {

    @Id
    @Column(name = "identificacao")
    @Setter(AccessLevel.NONE)
    private String identificacao;

    @ManyToOne(cascade={CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "contato_id")
    private ContatoEntidade contato;

    @Column(name = "tipo_pessoa")
    private String tipoPessoa;

    @Column(name = "nome")
    private String nome;
}
