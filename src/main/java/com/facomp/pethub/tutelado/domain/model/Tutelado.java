package com.facomp.pethub.tutelado.domain.model;

import com.facomp.pethub.tutelado.domain.emums.*;
import com.facomp.pethub.tutor.domain.model.Tutor;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

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
    @JoinColumn(name = "especie_descricao", referencedColumnName = "descricao")
    private Especie especie;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "raca_descricao", referencedColumnName = "descricao")
    private Raca raca;

    private Date dataNascimento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "temperamento_descricao", referencedColumnName = "descricao")
    private Temperamento temperamento;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "pelagem_descricao", referencedColumnName = "descricao")
    private Pelagem pelagem;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn
    private List<Peso> peso;

    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn
    private List<Consulta> consultas;

    private Porte porte;

    private Castrado castrado;

    @ManyToOne
    @JoinColumn(name = "tutor_id")
    private Tutor tutor;

    private String observacoes;

    private LocalDateTime dataHoraExclusao;
}
