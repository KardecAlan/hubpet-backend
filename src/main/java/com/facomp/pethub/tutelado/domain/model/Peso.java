package com.facomp.pethub.tutelado.domain.model;

import com.facomp.pethub.tutelado.domain.emums.CondicaoCorporal;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Peso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long versao;

    private LocalDateTime dataCadastro;

    private Float pesoEmKg;

    private CondicaoCorporal condicaoCorporal;

    private String observacao;

    @ManyToOne
    @JoinColumn(name = "tutelado_id", nullable = false)
    private Tutelado tutelado;
}
