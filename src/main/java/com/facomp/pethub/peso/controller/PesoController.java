package com.facomp.pethub.peso.controller;

import com.facomp.pethub.peso.domain.dto.request.PesoRequest;
import com.facomp.pethub.peso.domain.dto.response.PesoResponse;
import com.facomp.pethub.peso.service.PesoService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutelado/{idTutelado}/peso")
public class PesoController {

    private PesoService pesoService;

    public PesoController(PesoService pesoService) {
        this.pesoService = pesoService;
    }

    @Operation(summary = "Listar pesos por tutelado")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<PesoResponse> findPesoPorTutelado(@PathVariable("idTutelado") Long id, Pageable paginacao) {
        return pesoService.findPesoPorTutelado(id, paginacao);
    }


    @Operation(summary = "Cadastrar peso")
    @PostMapping
    public PesoResponse create(@PathVariable("idTutelado") Long id, @RequestBody @Valid PesoRequest pesoRequest) {
        return pesoService.create(id, pesoRequest);
    }
}
