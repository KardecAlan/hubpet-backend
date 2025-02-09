package com.facomp.pethub.tutor.mapper;


import com.facomp.pethub.tutor.domain.dto.request.TutorRequest;
import com.facomp.pethub.tutor.domain.dto.response.TutorResponse;
import com.facomp.pethub.tutor.domain.model.Tutor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TutorMapper {

    Tutor mapToEntity(TutorResponse tutorDto);

    TutorResponse mapToDto(Tutor tutor);

    Tutor mapToEntity(TutorRequest tutorDto);
}
