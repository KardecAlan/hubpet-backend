package com.facomp.pethub.usuario.domain.response;

import java.util.List;

public record LoginResponse(
        String nome,
        List<String> cargos,
        String token,
        String refreshToken
) {
}