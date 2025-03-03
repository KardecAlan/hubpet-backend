package com.facomp.pethub.tutelado.service;

import com.facomp.pethub.configuration.exception.RegisterNotFoundException;
import com.facomp.pethub.tutelado.domain.model.*;
import com.facomp.pethub.tutelado.repository.EspecieRepository;
import com.facomp.pethub.tutelado.repository.PelagemRepository;
import com.facomp.pethub.tutelado.repository.RacaRepository;
import com.facomp.pethub.tutelado.repository.TemperamentoRepository;
import com.facomp.pethub.tutor.repository.TutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TuteladoValidator {

    private final TutorRepository tutorRepository;
    private final EspecieRepository especieRepository;
    private final PelagemRepository pelagemRepository;
    private final RacaRepository racaRepository;
    private final TemperamentoRepository temperamentoRepository;

    public void validarTutelado(Tutelado tutelado) {
        tutelado.setEspecie(buscarOuCriarEspecie(tutelado));
        tutelado.setPelagem(buscarOuCriarPelagem(tutelado));
        tutelado.setRaca(buscarOuCriarRaca(tutelado));
        tutelado.setTemperamento(buscarOuCriarTemperamento(tutelado));
        validarTutor(tutelado);
    }

    private void validarTutor(Tutelado tutelado) {
        var tutorId = tutelado.getTutor().getId();
        if (!tutorRepository.existsById(tutorId)) {
            throw new RegisterNotFoundException("Tutor não encontrado!");
        }
        tutelado.setTutor(tutorRepository.getReferenceById(tutorId));
    }

    private Especie buscarOuCriarEspecie(Tutelado tutelado) {
        return especieRepository.findByDescricaoIgnoreCase(tutelado.getEspecie().getDescricao())
                .orElseGet(() -> especieRepository.save(new Especie(tutelado.getEspecie().getDescricao())));
    }

    private Pelagem buscarOuCriarPelagem(Tutelado tutelado) {
        return pelagemRepository.findByDescricaoIgnoreCase(tutelado.getPelagem().getDescricao())
                .orElseGet(() -> pelagemRepository.save(new Pelagem(tutelado.getPelagem().getDescricao())));
    }

    private Raca buscarOuCriarRaca(Tutelado tutelado) {
        return racaRepository.findByDescricaoIgnoreCase(tutelado.getRaca().getDescricao())
                .orElseGet(() -> racaRepository.save(new Raca(tutelado.getRaca().getDescricao())));
    }

    private Temperamento buscarOuCriarTemperamento(Tutelado tutelado) {
        return temperamentoRepository.findByDescricaoIgnoreCase(tutelado.getTemperamento().getDescricao())
                .orElseGet(() -> temperamentoRepository.save(new Temperamento(tutelado.getTemperamento().getDescricao())));
    }

}
