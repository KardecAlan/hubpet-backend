package com.facomp.pethub.tutelado.mapper;


import com.facomp.pethub.tutelado.domain.dto.request.ConsultaRequest;
import com.facomp.pethub.tutelado.domain.dto.response.ConsultaResponse;
import com.facomp.pethub.tutelado.domain.model.Consulta;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    ConsultaResponse mapToDto(Consulta consulta);

    Consulta mapToEntity(ConsultaRequest consultaRequest);

    @Mapping(target = "id", ignore = true)
    void updateToEntity(ConsultaRequest request, @MappingTarget Consulta consulta);
}
