package com.facomp.pethub.tutor.domain.model;


import com.facomp.pethub.endereco.domain.model.Endereco;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
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
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private LocalDateTime dataHoraExclusao;

}
