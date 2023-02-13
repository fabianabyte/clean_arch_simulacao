package com.br.simulacao.domain.entidade.pessoa;

import com.br.simulacao.domain.entidade.EntidadeIdAb;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "contato")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContatoEntidade extends EntidadeIdAb {
    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "logradouro")
    private String logradouro;
}
