package com.facomp.pethub.tutelado.domain.emums.model;

import com.kardec.pethub.tutelado.domain.emums.*;
import com.kardec.pethub.tutor.domain.model.Tutor;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tutelado {

    @Id
    @SequenceGenerator(name = "tutelado_generator", sequenceName = "tutor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tudelado_generator")
    private Long id;

    @Version
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

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    private String observacoes;
}
