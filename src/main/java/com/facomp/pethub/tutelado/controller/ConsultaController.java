package com.facomp.pethub.tutelado.controller;

import com.facomp.pethub.tutelado.domain.dto.request.ConsultaRequest;
import com.facomp.pethub.tutelado.domain.dto.response.ConsultaResponse;
import com.facomp.pethub.tutelado.service.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutelado/{idTutelado}/consulta")
public class ConsultaController {

    private ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @Operation(summary = "Listar consultas por tutelado")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ConsultaResponse> findPesoPorTutelado(@PathVariable("idTutelado") Long id, Pageable paginacao) {
        return consultaService.findPesoPorTutelado(id, paginacao);
    }

    @Operation(summary = "Cadastrar consulta")
    @PostMapping
    public ConsultaResponse create(@PathVariable("idTutelado") Long id, @RequestBody @Valid ConsultaRequest consultaRequest) {
        return consultaService.create(id, consultaRequest);
    }

    @Operation(summary = "Atualizar consulta")
    @PutMapping("/{idConsulta}")
    public ConsultaResponse update(@PathVariable("idTutelado") Long idTutelado,
                                   @PathVariable("idConsulta") Long idConsulta,
                                   @RequestBody @Valid ConsultaRequest consultaRequest) {
        return consultaService.update(idTutelado, idConsulta, consultaRequest);
    }


}
