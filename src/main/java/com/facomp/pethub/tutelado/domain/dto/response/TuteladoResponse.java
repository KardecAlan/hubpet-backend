package com.facomp.pethub.tutelado.domain.dto.response;

import com.facomp.pethub.tutelado.domain.emums.Castrado;
import com.facomp.pethub.tutelado.domain.emums.Porte;
import com.facomp.pethub.tutelado.domain.emums.Sexo;
import com.facomp.pethub.tutelado.domain.model.Especie;
import com.facomp.pethub.tutelado.domain.model.Pelagem;
import com.facomp.pethub.tutelado.domain.model.Raca;
import com.facomp.pethub.tutelado.domain.model.Temperamento;
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

    private Raca raca;

    private Date dataNascimento;

    private Temperamento temperamento;

    private Pelagem pelagem;

    private Porte porte;

    private Castrado castrado;

    private TutorResponse tutor;

    private String observacoes;
}
