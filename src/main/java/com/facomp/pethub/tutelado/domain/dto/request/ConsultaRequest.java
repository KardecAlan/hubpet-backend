package com.facomp.pethub.tutelado.domain.dto.request;

import com.facomp.pethub.configuration.annotation.ValidEnum;
import com.facomp.pethub.tutelado.domain.emums.TipoConsulta;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaRequest {

    private Long versao;

    @NotBlank
    @ValidEnum(enumClass = TipoConsulta.class, message = "O tipo da consulta é inválido")
    private String tipoConsulta;

    @NotNull(message = "O campo retorno é obrigatório")
    private boolean retorno;

    @NotNull(message = "A data da consulta é obrigatória")
    private LocalDateTime dataConsulta;

    private Integer duracaoConsulta;

    private boolean consultaCancelada;

    private String anamnese;

    private String exameFisico;

    private String diagnostico;

    private String tratamento;

    private String proximosPassos;

    private String observacoes;

    private Long tuteladoId;

}
