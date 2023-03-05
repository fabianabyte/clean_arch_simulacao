package com.br.simulacao.dataprovider.model.pessoa;

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
