package com.facomp.pethub.vacina.domain.model;

import com.facomp.pethub.vacina.domain.enums.TipoVacina;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vacina {

    @Id
    @SequenceGenerator(name = "vacina_generator", sequenceName = "vacina_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vacina_generator")
    private Long id;

    @Version
    private Long versao;

    private Date dataDaVacina;

    private boolean programada;

    private TipoVacina tipoVacina;

    private String nomeProduto;

    private String doseAtual;

    private String doseTotal;

    private String observacoes;

    private String nomeFabricante;

    private String numeroPartida;

    private Date dataFabricacao;

    private Date dataValidade;

    private boolean doseReforco;


}
