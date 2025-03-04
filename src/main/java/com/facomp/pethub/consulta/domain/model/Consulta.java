package com.facomp.pethub.consulta.domain.model;

import com.facomp.pethub.consulta.domain.enums.TipoConsulta;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
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

    @ManyToOne
    @JoinColumn(name = "tutelado_id", nullable = false)
    private Tutelado tutelado;
}
