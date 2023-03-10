package com.br.simulacao.application.domain.model.pessoa;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
    private String logradouro;
    private String email;
    private String telefone;

}
