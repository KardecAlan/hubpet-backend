package com.facomp.pethub.usuario.controller;

import com.facomp.pethub.usuario.domain.request.CreateUserRequest;
import com.facomp.pethub.usuario.domain.request.LoginRequest;
import com.facomp.pethub.usuario.domain.request.RefreshTokenRequest;
import com.facomp.pethub.usuario.domain.response.CreateUserResponse;
import com.facomp.pethub.usuario.domain.response.LoginResponse;
import com.facomp.pethub.usuario.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(AutenticacaoController.BASE_PATH)
@Tag(name = "Autenticação")
public class AutenticacaoController {

    public static final String BASE_PATH = "/autenticacao";

    private final UsuarioService usuarioService;

    public AutenticacaoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping("/login")
    @Operation(description = "Realizar login na aplicação")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody @Valid LoginRequest loginUserDto) {
        LoginResponse token = usuarioService.authenticateUser(loginUserDto);

        return ResponseEntity.ok(token);
    }

    @PostMapping("/registrar")
    @Operation(description = "Registrar novo usuário")
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest, UriComponentsBuilder uriBuilder) {

        CreateUserResponse response = usuarioService.createUser(createUserRequest);

        URI uri = uriBuilder.path(BASE_PATH + "/login").build().toUri();

        return ResponseEntity.created(uri).body(response);
    }

    @PostMapping("/atualizar")
    @Operation(description = "Atualizar token de autenticação")
    public ResponseEntity<LoginResponse> refresh(@RequestBody @Valid RefreshTokenRequest refreshToken) {
        LoginResponse token = usuarioService.refreshJwtToken(refreshToken.refreshToken());

        return ResponseEntity.ok(token);
    }
}
