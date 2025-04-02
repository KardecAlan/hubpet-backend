package com.facomp.pethub.tutelado.controller;

import com.facomp.pethub.tutelado.domain.dto.request.VacinaRequest;
import com.facomp.pethub.tutelado.domain.dto.response.VacinaResponse;
import com.facomp.pethub.tutelado.service.VacinaService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tutelado/{idTutelado}/vacina")
public class VacinaController {

    private VacinaService vacinaService;

    public VacinaController(VacinaService vacinaService) {
        this.vacinaService = vacinaService;
    }

    @Operation(summary = "Listar vacinas por tutelado")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Page<VacinaResponse> findVacinaPorTutelado(@PathVariable("idTutelado") Long id, Pageable paginacao) {
        return vacinaService.findVacinaPorTutelado(id, paginacao);
    }

    @Operation(summary = "Obter vacina por id")
    @GetMapping("/{idVacina}")
    @ResponseStatus(HttpStatus.OK)
    public VacinaResponse findById(@PathVariable("idTutelado") Long idTutelado, @PathVariable("idVacina") Long idVacina) {
        return vacinaService.findById(idTutelado, idVacina);
    }


    @Operation(summary = "Cadastrar vacina")
    @PostMapping
    public VacinaResponse create(@PathVariable("idTutelado") Long id, @RequestBody @Valid VacinaRequest vacinaRequest) {
        return vacinaService.create(id, vacinaRequest);
    }

    @Operation(summary = "Atualizar vacina")
    @PutMapping("/{idVacina}")
    public VacinaResponse update(@PathVariable("idTutelado") Long idTutelado,
                               @PathVariable("idVacina") Long idVacina,
                               @RequestBody @Valid VacinaRequest vacinaRequest) {
        return vacinaService.update(idTutelado, idVacina, vacinaRequest);
    }

    @Operation(summary = "Deletar vacina")
    @DeleteMapping("/{idVacina}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("idTutelado") Long idTutelado, @PathVariable("idVacina") Long idVacina) {
        vacinaService.delete(idTutelado, idVacina);
    }
}
