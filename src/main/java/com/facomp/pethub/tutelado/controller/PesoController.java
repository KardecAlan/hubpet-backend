package com.facomp.pethub.tutelado.controller;

import com.facomp.pethub.tutelado.domain.dto.request.PesoRequest;
import com.facomp.pethub.tutelado.domain.dto.response.PesoResponse;
import com.facomp.pethub.tutelado.service.PesoService;
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

    @Operation(summary = "Obter peso por id")
    @GetMapping("/{idPeso}")
    @ResponseStatus(HttpStatus.OK)
    public PesoResponse findById(@PathVariable("idTutelado") Long idTutelado, @PathVariable("idPeso") Long idPeso) {
        return pesoService.findById(idTutelado, idPeso);
    }


    @Operation(summary = "Cadastrar peso")
    @PostMapping
    public PesoResponse create(@PathVariable("idTutelado") Long id, @RequestBody @Valid PesoRequest pesoRequest) {
        return pesoService.create(id, pesoRequest);
    }

    @Operation(summary = "Atualizar peso")
    @PutMapping("/{idPeso}")
    public PesoResponse update(@PathVariable("idTutelado") Long idTutelado,
                               @PathVariable("idPeso") Long idPeso,
                               @RequestBody @Valid PesoRequest pesoRequest) {
        return pesoService.update(idTutelado, idPeso, pesoRequest);
    }

    @Operation(summary = "Deletar peso")
    @DeleteMapping("/{idPeso}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idTutelado") Long idTutelado, @PathVariable("idPeso") Long idPeso) {
        pesoService.delete(idTutelado, idPeso);
    }
}
