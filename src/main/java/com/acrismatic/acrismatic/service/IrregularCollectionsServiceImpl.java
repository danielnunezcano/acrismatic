package com.acrismatic.acrismatic.service;

import com.acrismatic.acrismatic.domain.mapper.CollectionHistoryMapper;
import com.acrismatic.acrismatic.domain.model.IrregularCollections;
import com.acrismatic.acrismatic.repository.CollectionHistoryJpaRepository;
import com.acrismatic.acrismatic.repository.entity.CollectionHistoryJpa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IrregularCollectionsServiceImpl implements IrregularCollectionsService {

    private final CollectionHistoryJpaRepository collectionHistoryJpaRepository;

    public IrregularCollections getRecaudacionesIrregulares() {
        List<CollectionHistoryJpa> collectionHistoryJpas =
                collectionHistoryJpaRepository.findMismatchedManualAndAutomaticCounters();
        return CollectionHistoryMapper.INSTANCE.collectionHistoryJpaListToIrregularCollections(collectionHistoryJpas);
    }
}
