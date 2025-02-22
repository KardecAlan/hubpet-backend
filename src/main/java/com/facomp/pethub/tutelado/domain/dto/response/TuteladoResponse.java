package com.facomp.pethub.tutelado.domain.dto.response;

import com.facomp.pethub.tutelado.domain.emums.*;
import com.facomp.pethub.tutor.domain.dto.response.TutorResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TuteladoResponse {

    private Long id;

    private Long versao;

    private String nome;

    private boolean vivo;

    private Sexo sexo;

    private Especie especie;

    private String raca;

    private Date dataNascimento;

    private Temperamento temperamento;

    private Pelagem pelagem;

    private Porte porte;

    private Castrado castrado;

    private TutorResponse tutor;

    private String observacoes;
}
