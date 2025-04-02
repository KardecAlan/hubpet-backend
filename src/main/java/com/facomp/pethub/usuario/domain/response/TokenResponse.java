package com.facomp.pethub.usuario.domain.response;

public record TokenResponse(
        String token,
        String refreshToken
) {
}