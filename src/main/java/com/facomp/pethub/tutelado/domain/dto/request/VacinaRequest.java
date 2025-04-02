package com.facomp.pethub.tutelado.domain.dto.request;

import com.facomp.pethub.tutelado.domain.model.Produto;
import com.facomp.pethub.tutelado.domain.model.TipoVacina;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class VacinaRequest {

    private Date dataDaVacina;

    private boolean programada;

    private TipoVacina tipoVacina;

    private Produto protudo;

    private String doseAtual;

    private String doseTotal;

    private String observacoes;

    private String nomeFabricante;

    private String numeroPartida;

    private Date dataFabricacao;

    private Date dataValidade;

    private boolean doseReforco;
}
