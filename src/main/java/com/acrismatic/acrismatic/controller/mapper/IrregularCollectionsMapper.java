package com.acrismatic.acrismatic.controller.mapper;

import com.acrismatic.acrismatic.controller.dto.CustomResponseDTO;
import com.acrismatic.acrismatic.domain.model.CustomResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IrregularCollectionsMapper {
    IrregularCollectionsMapper INSTANCE = Mappers.getMapper(IrregularCollectionsMapper.class);

    CustomResponseDTO toDTO(CustomResponse response);
}