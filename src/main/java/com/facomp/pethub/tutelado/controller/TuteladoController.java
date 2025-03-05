package com.facomp.pethub.tutelado.controller;

import com.facomp.pethub.tutelado.domain.dto.request.TuteladoRequest;
import com.facomp.pethub.tutelado.domain.dto.response.TuteladoResponse;
import com.facomp.pethub.tutelado.domain.model.Especie;
import com.facomp.pethub.tutelado.domain.model.Pelagem;
import com.facomp.pethub.tutelado.domain.model.Raca;
import com.facomp.pethub.tutelado.domain.model.Temperamento;
import com.facomp.pethub.tutelado.service.TuteladoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("tuteladoController")
@RequestMapping("/tutelado")
public class TuteladoController {

    private final TuteladoService tuteladoService;

    public TuteladoController(TuteladoService tuteladoService) {
        this.tuteladoService = tuteladoService;
    }

    @Operation(summary = "Lista todos os tutelados.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TuteladoResponse> findAll(TuteladoRequest tuteladoRequest, Pageable paginacao) {
        return tuteladoService.buscarTodos(tuteladoRequest, paginacao);
    }

    @Operation(summary = "Consulta um tutelado por ID.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TuteladoResponse findById(@PathVariable Long id) {
        return tuteladoService.buscarPorId(id);
    }

    @Operation(summary = "Cria um tutelado.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TuteladoResponse create(@RequestBody @Valid TuteladoRequest tuteladoRequest) {
        return tuteladoService.criar(tuteladoRequest);
    }

    @Operation(summary = "Atualiza um tutelado.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TuteladoResponse update(@PathVariable Long id, @RequestBody TuteladoResponse tuteladoRequest) {
        return tuteladoService.atualizar(id, tuteladoRequest);
    }

    @Operation
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tuteladoService.deletar(id);
    }

    @Operation(summary = "Lista todas as espécies.")
    @GetMapping("/especie")
    @ResponseStatus(HttpStatus.OK)
    public List<Especie> findAllEspecies() {
        return tuteladoService.buscarEspecies();
    }

    @Operation(summary = "Lista todas as pelagens.")
    @GetMapping("/pelagem")
    @ResponseStatus(HttpStatus.OK)
    public List<Pelagem> findAllPelagens() {
        return tuteladoService.buscarPelagens();
    }

    @Operation(summary = "Lista todas as raças.")
    @GetMapping("/raca")
    @ResponseStatus(HttpStatus.OK)
    public List<Raca> findAllRacas() {
        return tuteladoService.buscarRacas();
    }

    @Operation(summary = "Lista todos os temperamentos.")
    @GetMapping("/temperamento")
    @ResponseStatus(HttpStatus.OK)
    public List<Temperamento> findAllTemperamentos() {
        return tuteladoService.buscarTemperamentos();
    }
}
