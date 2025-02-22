package com.facomp.pethub.tutelado.mapper;


import com.facomp.pethub.tutelado.domain.dto.request.TuteladoRequest;
import com.facomp.pethub.tutelado.domain.dto.response.TuteladoResponse;
import com.facomp.pethub.tutelado.domain.model.Tutelado;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TuteladoMapper {

    Tutelado mapToEntity(TuteladoResponse tuteladoDto);

    TuteladoResponse mapToDto(Tutelado tutelado);

    Tutelado mapToEntity(TuteladoRequest tuteladoDto);
}
