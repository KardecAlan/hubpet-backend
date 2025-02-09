package com.facomp.pethub.usuario.domain.response;

public record LoginResponse(
        String token,
        String refreshToken
) {
}