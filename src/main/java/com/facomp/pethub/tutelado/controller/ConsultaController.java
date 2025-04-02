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
@RequestMapping("/consulta")
public class ConsultaController {

    private final ConsultaService consultaService;

    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @Operation(summary = "Listas todas as consultas")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<ConsultaResponse> findAll(ConsultaRequest consultaRequest, Pageable paginacao) {
        return consultaService.findAll(consultaRequest, paginacao);
    }

    @Operation(summary = "Consultar consulta por ID")
    @GetMapping("/{idConsulta}")
    @ResponseStatus(HttpStatus.OK)
    public ConsultaResponse findById(@PathVariable("idConsulta") Long idConsulta) {
        return consultaService.findById(idConsulta);
    }

    @Operation(summary = "Cadastrar consulta")
    @PostMapping
    public ConsultaResponse create(@RequestBody @Valid ConsultaRequest consultaRequest) {
        return consultaService.create(consultaRequest);
    }

    @Operation(summary = "Atualizar consulta")
    @PutMapping("/{idConsulta}")
    public ConsultaResponse update(@PathVariable("idConsulta") Long idConsulta,
                                   @RequestBody @Valid ConsultaRequest consultaRequest) {
        return consultaService.update(idConsulta, consultaRequest);
    }

    @Operation(summary = "Deletar consulta")
    @DeleteMapping("/{idConsulta}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idConsulta") Long idConsulta) {
        consultaService.delete(idConsulta);
    }


}
