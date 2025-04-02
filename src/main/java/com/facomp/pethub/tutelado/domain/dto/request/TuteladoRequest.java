package com.facomp.pethub.tutelado.domain.dto.request;

import com.facomp.pethub.tutelado.domain.emums.Castrado;
import com.facomp.pethub.tutelado.domain.emums.Porte;
import com.facomp.pethub.tutelado.domain.emums.Sexo;
import com.facomp.pethub.tutelado.domain.model.Especie;
import com.facomp.pethub.tutelado.domain.model.Pelagem;
import com.facomp.pethub.tutelado.domain.model.Raca;
import com.facomp.pethub.tutelado.domain.model.Temperamento;
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
    private Especie especie;

    private Raca raca;

    @NotNull(message = "A data de nascimento do tutelado é obrigatória")
    private Date dataNascimento;

    private Temperamento temperamento;

    private Pelagem pelagem;

    private Porte porte;

    private Castrado castrado;

    @NotNull(message = "O tutor do tutelado é obrigatório")
    private TutorRequest tutor;

    private String observacoes;

}
