package com.acrismatic.acrismatic.controller.mapper;

import com.acrismatic.acrismatic.controller.dto.RecaudacionesIrregularesDTO;
import com.acrismatic.acrismatic.domain.model.RecaudacionesIrregulares;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecaudacionesIrregularesMapper {
    RecaudacionesIrregularesMapper INSTANCE = Mappers.getMapper(RecaudacionesIrregularesMapper.class);

    RecaudacionesIrregularesDTO toDTO(RecaudacionesIrregulares recaudacionesIrregulares);
}