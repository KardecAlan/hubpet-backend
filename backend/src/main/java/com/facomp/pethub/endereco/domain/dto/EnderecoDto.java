package com.facomp.pethub.endereco.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDto {

    private Long id;

    private Long versao;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String estado;

    private String cidade;

    private String bairro;

}
