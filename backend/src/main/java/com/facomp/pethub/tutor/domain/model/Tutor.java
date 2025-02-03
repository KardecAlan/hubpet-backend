package com.facomp.pethub.tutor.domain.model;


import com.facomp.pethub.endereco.domain.model.Endereco;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Tutor {

    @Id
    @SequenceGenerator(name = "tutor_generator", sequenceName = "tutor_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tutor_generator")
    private Long id;

    @Version
    private Long versao;

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private String telefone;

    private String celular;

    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    private String observacoes;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tutor")
    private List<Tutelado> tutelados;

}
