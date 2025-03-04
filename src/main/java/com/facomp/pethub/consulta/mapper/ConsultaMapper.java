package com.facomp.pethub.consulta.mapper;


import com.facomp.pethub.consulta.domain.dto.request.ConsultaRequest;
import com.facomp.pethub.consulta.domain.dto.response.ConsultaResponse;
import com.facomp.pethub.consulta.domain.model.Consulta;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ConsultaMapper {

    ConsultaResponse mapToDto(Consulta consulta);

    Consulta mapToEntity(ConsultaRequest consultaRequest);

    @Mapping(target = "id", ignore = true) // Garante que o ID da consulta não seja alterado
    void updateToEntitu(ConsultaRequest request, @MappingTarget Consulta consulta);
}
