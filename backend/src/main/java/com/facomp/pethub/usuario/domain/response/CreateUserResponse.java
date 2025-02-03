package com.facomp.pethub.usuario.domain.response;


import com.facomp.pethub.usuario.domain.model.Cargo;

import java.util.List;

public record CreateUserResponse(
        String email,
        List<Cargo> cargos
) {
}