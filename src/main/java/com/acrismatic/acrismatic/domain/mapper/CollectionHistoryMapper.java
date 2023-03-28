package com.acrismatic.acrismatic.domain.mapper;

import com.acrismatic.acrismatic.controller.mapper.IrregularCollectionsMapper;
import com.acrismatic.acrismatic.repository.entity.CollectionHistoryJpa;
import com.acrismatic.acrismatic.domain.model.IrregularCollection;
import com.acrismatic.acrismatic.domain.model.IrregularCollections;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface CollectionHistoryMapper {

    CollectionHistoryMapper INSTANCE = Mappers.getMapper(CollectionHistoryMapper.class);

    @Mappings({
            @Mapping(source = "machine.name", target = "machine"),
            @Mapping(source = "client.name", target = "client"),
            @Mapping(source = "manualCounter.entries", target = "manualEntries"),
            @Mapping(source = "manualCounter.exits", target = "manualExits"),
            @Mapping(source = "manualCounter.date", target = "manualDates"),
            @Mapping(source = "automaticCounter.entries", target = "automaticEntries"),
            @Mapping(source = "automaticCounter.exits", target = "automaticExits"),
            @Mapping(source = "automaticCounter.date", target = "automaticDates"),
            @Mapping(source = "id", target = "collectionId"),
            @Mapping(source = "manualCounter.id", target = "manualId"),
            @Mapping(source = "automaticCounter.id", target = "automaticId")
    })
    IrregularCollection collectionHistoryJpaToIrregularCollection(CollectionHistoryJpa collectionHistoryJpa);

    default IrregularCollections collectionHistoryJpaListToIrregularCollections(List<CollectionHistoryJpa> collectionHistoryJpaList) {
        List<IrregularCollection> irregularCollectionList = collectionHistoryJpaList.stream()
                .map(this::collectionHistoryJpaToIrregularCollection)
                .collect(Collectors.toList());

        // Use the first collectionHistoryJpa to get machine and client names
        CollectionHistoryJpa first = collectionHistoryJpaList.get(0);
        String machine = first.getMachine().getName();
        String client = first.getClient().getName();

        return IrregularCollections.builder()
                .machine(machine)
                .client(client)
                .irregularCollections(irregularCollectionList)
                .build();
    }
}
