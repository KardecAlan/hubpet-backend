package com.facomp.pethub.endereco.domain.model;


import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @SequenceGenerator(name = "endereco_generator", sequenceName = "endereco_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_generator")
    private Long id;

    @Version
    private Long versao;

    private String cep;

    private String endereco;

    private String numero;

    private String complemento;

    private String estado;

    private String cidade;

    private String bairro;

}
