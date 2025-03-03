package com.facomp.pethub.tutelado.domain.model;

import com.facomp.pethub.tutelado.domain.emums.*;
import com.facomp.pethub.tutor.domain.model.Tutor;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tutelado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Long versao;

    private String nome;

    private boolean vivo;

    private Sexo sexo;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "especie_id")
    private Especie especie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "raca_id")
    private Raca raca;

    private Date dataNascimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "temperamento_id")
    private Temperamento temperamento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pelagem_id")
    private Pelagem pelagem;

    private Porte porte;

    private Castrado castrado;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    private String observacoes;

    private LocalDateTime dataHoraExclusao;
}
