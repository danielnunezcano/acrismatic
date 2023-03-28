package com.acrismatic.acrismatic.controller.mapper;

import com.acrismatic.acrismatic.controller.dto.IrregularCollectionsDTO;
import com.acrismatic.acrismatic.domain.model.IrregularCollections;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IrregularCollectionsMapper {
    IrregularCollectionsMapper INSTANCE = Mappers.getMapper(IrregularCollectionsMapper.class);

    IrregularCollectionsDTO toDTO(IrregularCollections irregularCollections);
}