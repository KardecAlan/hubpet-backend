package com.facomp.pethub.tutor.domain.dto.request;

import com.facomp.pethub.endereco.domain.dto.EnderecoDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Getter
@Setter
public class TutorRequest {

    private Long versao;

    @NotNull(message = "O nome do tutor é obrigatório")
    private String nome;

    @NotNull(message = "O CPF do tutor é obrigatório")
    @CPF(message = "O CPF informado é inválido")
    private String cpf;

    @NotNull(message = "A data de nascimento do tutor é obrigatória")
    private Date dataNascimento;

    private String telefone;

    private String celular;

    @NotNull(message = "O e-mail do tutor é obrigatório")
    @Email(message = "O e-mail informado é inválido")
    private String email;

    private EnderecoDto endereco;

}
