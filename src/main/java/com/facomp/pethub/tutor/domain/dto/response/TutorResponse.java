package com.facomp.pethub.tutor.domain.dto.response;

import com.facomp.pethub.endereco.domain.dto.EnderecoDto;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class TutorResponse {

    private Long id;

    private Long versao;

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private String telefone;

    private String celular;

    private String email;

    private EnderecoDto endereco;

    private LocalDateTime dataHoraExclusao;

}
