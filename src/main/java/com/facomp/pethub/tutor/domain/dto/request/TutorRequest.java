package com.facomp.pethub.tutor.domain.dto.request;

import com.facomp.pethub.tutor.domain.dto.EnderecoDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import java.util.Date;

@Getter
@Setter
public class TutorRequest {


    private Long id;

    private Long versao;

    @NotBlank(message = "O nome do tutor é obrigatório")
    private String nome;

    @NotBlank(message = "O CPF do tutor é obrigatório")
    @CPF(message = "O CPF informado é inválido")
    private String cpf;

    @NotNull(message = "A data de nascimento do tutor é obrigatória")
    private Date dataNascimento;

    private String telefone;

    @NotBlank(message = "O celular do tutor é obrigatório")
    private String celular;

    @NotNull(message = "O e-mail do tutor é obrigatório")
    @Email(message = "O e-mail informado é inválido")
    private String email;

    @Valid
    private EnderecoDto endereco;

    private String observacoes;

}
