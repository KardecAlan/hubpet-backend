package com.facomp.pethub.usuario.service;

import com.facomp.pethub.configuration.exception.BusinessException;
import com.facomp.pethub.usuario.domain.enums.TipoCargo;
import com.facomp.pethub.usuario.domain.model.Cargo;
import com.facomp.pethub.usuario.domain.model.Usuario;
import com.facomp.pethub.usuario.domain.request.CreateUserRequest;
import com.facomp.pethub.usuario.domain.request.LoginRequest;
import com.facomp.pethub.usuario.domain.response.CreateUserResponse;
import com.facomp.pethub.usuario.domain.response.LoginResponse;
import com.facomp.pethub.usuario.domain.response.TokenResponse;
import com.facomp.pethub.usuario.mapper.CargoMapper;
import com.facomp.pethub.usuario.repository.CargoRepository;
import com.facomp.pethub.usuario.repository.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioService {

    private final AuthenticationManager authenticationManager;

    private final TokenService jwtTokenService;

    private final UsuarioRepository userRepository;

    private final CargoRepository cargoRepository;

    private final PasswordEncoder passwordEncoder;

    private final CargoMapper cargoMapper;

    public UsuarioService(AuthenticationManager authenticationManager, TokenService jwtTokenService, UsuarioRepository userRepository, CargoRepository cargoRepository, PasswordEncoder passwordEncoder, CargoMapper cargoMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenService = jwtTokenService;
        this.userRepository = userRepository;
        this.cargoRepository = cargoRepository;
        this.passwordEncoder = passwordEncoder;
        this.cargoMapper = cargoMapper;
    }

    public LoginResponse authenticateUser(LoginRequest loginUserDto) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(loginUserDto.email(), loginUserDto.senha());


        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);


        Usuario usuario = (Usuario) authentication.getPrincipal();
        String subject = usuario.getEmail();
        List<Cargo> cargos = usuario.getCargos();


        return new LoginResponse(usuario.getNome(), cargoMapper.mapTipoCargoList(cargos), jwtTokenService.generateAccessToken(subject), jwtTokenService.generateRefreshToken(subject));
    }

    public TokenResponse refreshJwtToken(String refreshToken) {
        String email = jwtTokenService.getSubjectFromRefreshToken(refreshToken);

        return new TokenResponse(
                jwtTokenService.generateAccessToken(email),
                jwtTokenService.generateRefreshToken(email)
        );
    }


    public CreateUserResponse createUser(CreateUserRequest createUserRequest) {

        if (userRepository.existsByEmail(createUserRequest.email())) {
            throw new BusinessException("Email já cadastrado");
        }

        Cargo cargo = cargoRepository.findByCargo(TipoCargo.ROLE_USUARIO).orElseThrow();

        Usuario newUser = Usuario.builder()
                .nome(createUserRequest.nome())
                .email(createUserRequest.email())
                .senha(passwordEncoder.encode(createUserRequest.senha()))
                .cargos(
                        Collections.singletonList(
                                cargo
                        )
                )
                .build();

        Usuario persistedUser = userRepository.save(newUser);

        return new CreateUserResponse(
                persistedUser.getEmail(), persistedUser.getCargos()
        );
    }
}