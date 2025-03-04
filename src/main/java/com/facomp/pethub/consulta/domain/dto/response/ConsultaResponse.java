package com.facomp.pethub.consulta.domain.dto.response;

import com.facomp.pethub.consulta.domain.enums.TipoConsulta;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ConsultaResponse {

    private Long id;

    private Long versao;

    private TipoConsulta tipoConsulta;

    private boolean retorno;

    private LocalDateTime dataConsulta;

    private String anamnese;

    private String exameFisico;

    private String diagnostico;

    private String tratamento;

    private String proximosPassos;

    private String observacoes;
}
