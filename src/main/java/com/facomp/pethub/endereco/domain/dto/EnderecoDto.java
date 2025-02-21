package com.facomp.pethub.endereco.domain.dto;


import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "O CEP é obrigatório")
    private String cep;

    @NotBlank(message = "O logradouro é obrigatório")
    private String logradouro;

    @NotBlank(message = "O número é obrigatório")
    private String numero;

    private String complemento;

    @NotBlank(message = "O Estado é obrigatório")
    private String estado;

    @NotBlank(message = "A cidade é obrigatória")
    private String cidade;

    private String bairro;

}
