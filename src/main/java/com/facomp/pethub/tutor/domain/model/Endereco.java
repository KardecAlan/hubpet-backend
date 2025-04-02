package com.facomp.pethub.tutor.domain.model;


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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long versao;

    private String cep;

    private String logradouro;

    private String numero;

    private String complemento;

    private String estado;

    private String cidade;

    private String bairro;

}
