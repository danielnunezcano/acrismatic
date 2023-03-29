package com.acrismatic.acrismatic.service;

import com.acrismatic.acrismatic.domain.model.*;
import com.acrismatic.acrismatic.repository.AutomaticCounterHistoryJpaRepository;
import com.acrismatic.acrismatic.repository.MachineJpaRepository;
import com.acrismatic.acrismatic.repository.CollectionHistoryJpaRepository;
import com.acrismatic.acrismatic.repository.entity.AutomaticCounterHistoryJpa;
import com.acrismatic.acrismatic.repository.entity.CollectionHistoryJpa;
import com.acrismatic.acrismatic.repository.entity.MachineJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IrregularCollectionsServiceImpl implements IrregularCollectionsService {

    private final MachineJpaRepository machineJpaRepository;
    private final CollectionHistoryJpaRepository collectionHistoryJpaRepository;

    private final AutomaticCounterHistoryJpaRepository automaticCounterHistoryJpaRepository;

    @Override
    public List<Machine> getIrregularCollections() {
        return toMachines(machineJpaRepository.findAll());
    }


    private List<Machine> toMachines(final List<MachineJpa> machineJpas){
        return machineJpas.stream().map(machineJpa -> {
            List<CollectionHistoryJpa> collectionHistoryJpas = collectionHistoryJpaRepository.findByMachineId(machineJpa.getId());
            List<IrregularCollection> irregularCollections = getIrregularCollectionsList(collectionHistoryJpas);
            return Machine.builder()
                    .machine(machineJpa.getName())
                    .client(machineJpa.getClient().getName())
                    .irregularCollections(irregularCollections)
                    .build();
        }).collect(Collectors.toList());
    }

    private List<IrregularCollection> getIrregularCollectionsList(final List<CollectionHistoryJpa> collectionHistoryJpas){
        return collectionHistoryJpas.stream().map(collectionHistoryJpa -> {
                    List<AutomaticCounterHistoryJpa> auxAutomaticCounterHistoryJpas =
                            automaticCounterHistoryJpaRepository
                                    .findByMachineIdAndDateBeforeOrderByDateDesc(collectionHistoryJpa.getMachine().getId(),
                                            collectionHistoryJpa.getManualCounter().getDate());
                    if(!auxAutomaticCounterHistoryJpas.isEmpty()
                            && (!auxAutomaticCounterHistoryJpas.get(0).getEntries().equals(collectionHistoryJpa.getManualCounter().getEntries())
                            || !auxAutomaticCounterHistoryJpas.get(0).getExits().equals(collectionHistoryJpa.getManualCounter().getExits()))){
                        return toIrregularCollection(collectionHistoryJpa, auxAutomaticCounterHistoryJpas.get(0));
                    }
                    return null;
                }).filter(Objects::nonNull).collect(Collectors.toList());
    }
    
    private IrregularCollection toIrregularCollection(final CollectionHistoryJpa collectionHistoryJpa,
                                                      AutomaticCounterHistoryJpa auxAutomaticCounterHistoryJpa){
        return IrregularCollection.builder()
                .collectionId(collectionHistoryJpa.getId())
                .manualId(collectionHistoryJpa.getManualCounter().getId())
                .automaticId(auxAutomaticCounterHistoryJpa.getId())
                .manuals(Manual.builder()
                        .manualEntries(collectionHistoryJpa.getManualCounter().getEntries())
                        .manualExits(collectionHistoryJpa.getManualCounter().getExits())
                        .date(collectionHistoryJpa.getManualCounter().getDate())
                        .build())
                .automatics(Automatic.builder()
                        .automaticEntries(auxAutomaticCounterHistoryJpa.getEntries())
                        .automaticExists(auxAutomaticCounterHistoryJpa.getExits())
                        .date(auxAutomaticCounterHistoryJpa.getDate())
                        .build())
                .build();
    }
}
