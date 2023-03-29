package com.acrismatic.acrismatic.controller.mapper;

import com.acrismatic.acrismatic.controller.dto.IrregularCollectionDTO;
import com.acrismatic.acrismatic.controller.dto.MachineDTO;
import com.acrismatic.acrismatic.domain.model.IrregularCollection;
import com.acrismatic.acrismatic.domain.model.Machine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface MachineMapper {
    MachineMapper INSTANCE = Mappers.getMapper(MachineMapper.class);

    @Mapping(source = "collectionId", target = "idRecaudacion")
    @Mapping(source = "manualId", target = "idManual")
    @Mapping(source = "automaticId", target = "idAutomatico")
    @Mapping(source = "manuals.manualEntries", target = "manuales.entradasManuales")
    @Mapping(source = "manuals.manualExits", target = "manuales.salidasManuales")
    @Mapping(source = "manuals.date", target = "manuales.fecha")
    @Mapping(source = "automatics.automaticEntries", target = "automaticos.entradasAutomaticas")
    @Mapping(source = "automatics.automaticExists", target = "automaticos.salidasAutomaticas")
    @Mapping(source = "automatics.date", target = "automaticos.fecha")
    IrregularCollectionDTO toIrregularCollectionDTO(IrregularCollection model);

    @Mapping(source = "machine", target = "maquina")
    @Mapping(source = "client", target = "cliente")
    @Mapping(source = "irregularCollections", target = "recaudacionesIrregulares")
    MachineDTO toMachineDTO(Machine model);

    List<MachineDTO> toMachineDTOList(List<Machine> models);

}
