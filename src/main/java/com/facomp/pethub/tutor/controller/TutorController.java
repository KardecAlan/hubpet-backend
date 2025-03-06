package com.facomp.pethub.tutor.controller;

import com.facomp.pethub.tutelado.domain.dto.Combo;
import com.facomp.pethub.tutor.domain.dto.request.TutorRequest;
import com.facomp.pethub.tutor.domain.dto.response.TutorResponse;
import com.facomp.pethub.tutor.service.TutorService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController("tutorController")
@RequestMapping("/tutor")
public class TutorController {

    private final TutorService tutorService;

    public TutorController(TutorService tutorService) {
        this.tutorService = tutorService;
    }

    @Operation(summary = "Lista todos os tutores.")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<TutorResponse> findAll(TutorRequest tutorDto, Pageable paginacao) {
        return tutorService.buscarTodos(tutorDto, paginacao);
    }

    @GetMapping("/combo")
    @ResponseStatus(HttpStatus.OK)
    public List<Combo> findAllCombo() {
        return tutorService.buscarTodosCombo();
    }

    @Operation(summary = "Consulta um tutor por ID.")
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TutorResponse findById(@PathVariable Long id) {
        return tutorService.buscarPorId(id);
    }

    @Operation(summary = "Cria um tutor.")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TutorResponse create(@RequestBody @Valid TutorRequest tutorDto) {
        return tutorService.criar(tutorDto);
    }

    @Operation(summary = "Atualiza um tutor.")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TutorResponse update(@PathVariable Long id, @RequestBody TutorResponse tutorDto) {
        return tutorService.atualizar(id, tutorDto);
    }

    @Operation
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tutorService.deletar(id);
    }
}
