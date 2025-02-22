package com.facomp.pethub.tutelado.domain.dto.request;

import com.facomp.pethub.tutelado.domain.emums.*;
import com.facomp.pethub.tutor.domain.dto.request.TutorRequest;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TuteladoRequest {

    private Long versao;

    @NotBlank(message = "O nome do tutelado é obrigatório")
    private String nome;

    private boolean vivo;

    @NotNull(message = "O sexo do tutelado é obrigatório")
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @NotNull(message = "A espécie do tutelado é obrigatória")
    @Enumerated(EnumType.STRING)
    private Especie especie;

    private String raca;

    @NotNull(message = "A data de nascimento do tutelado é obrigatória")
    private Date dataNascimento;

    @Enumerated(EnumType.STRING)
    private Temperamento temperamento;

    @Enumerated(EnumType.STRING)
    private Pelagem pelagem;

    @Enumerated(EnumType.STRING)
    private Porte porte;

    @Enumerated(EnumType.STRING)
    private Castrado castrado;

    @NotNull(message = "O tutor do tutelado é obrigatório")
    private TutorRequest tutor;

    private String observacoes;
}
