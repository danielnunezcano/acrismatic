package com.acrismatic.acrismatic.service;

import com.acrismatic.acrismatic.domain.model.Automatic;
import com.acrismatic.acrismatic.domain.model.CustomResponse;
import com.acrismatic.acrismatic.domain.model.IrregularCollection;
import com.acrismatic.acrismatic.domain.model.Manual;
import com.acrismatic.acrismatic.repository.AutomaticCounterHistoryJpaRepository;
import com.acrismatic.acrismatic.repository.CollectionHistoryJpaRepository;
import com.acrismatic.acrismatic.repository.entity.AutomaticCounterHistoryJpa;
import com.acrismatic.acrismatic.repository.entity.CollectionHistoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class IrregularCollectionsServiceImpl implements IrregularCollectionsService {

    private final CollectionHistoryJpaRepository collectionHistoryJpaRepository;

    private final AutomaticCounterHistoryJpaRepository automaticCounterHistoryJpaRepository;

    public CustomResponse getIrregularCollections() {
        List<CollectionHistoryJpa> collectionHistoryJpas = collectionHistoryJpaRepository.findAll();
        List<IrregularCollection> irregularCollections = getIrregularCollectionsList(collectionHistoryJpas);
        return getCustomResponse(collectionHistoryJpas, irregularCollections);
    }

    private CustomResponse getCustomResponse(final List<CollectionHistoryJpa> collectionHistoryJpas,
                                             final List<IrregularCollection> irregularCollections) {
        return CustomResponse.builder()
                .machine(collectionHistoryJpas.get(0).getMachine().getName())
                .client(collectionHistoryJpas.get(0).getMachine().getClient().getName())
                .irregularCollections(irregularCollections)
                .build();
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
