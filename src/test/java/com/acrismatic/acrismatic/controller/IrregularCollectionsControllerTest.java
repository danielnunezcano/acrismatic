package com.acrismatic.acrismatic.controller;

import com.acrismatic.acrismatic.controller.dto.IrregularCollectionsDTO;
import com.acrismatic.acrismatic.domain.model.IrregularCollection;
import com.acrismatic.acrismatic.domain.model.IrregularCollections;
import com.acrismatic.acrismatic.service.IrregularCollectionsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class IrregularCollectionsControllerTest {

    @InjectMocks
    private IrregularCollectionsController controller;

    @Mock
    private IrregularCollectionsService service;

    private IrregularCollections irregularCollections;

    @BeforeEach
    public void setUp() {
        IrregularCollection irregularCollection = IrregularCollection.builder()
                .collectionId(1L)
                .manualId(100L)
                .automaticId(200L)
                .manualEntries(5)
                .manualExits(3)
                .manualDates(LocalDateTime.now())
                .automaticEntries(10)
                .automaticExits(8)
                .automaticDates(LocalDateTime.now())
                .build();

        irregularCollections = IrregularCollections.builder()
                .machine("Machine1")
                .client("Client1")
                .irregularCollections(Collections.singletonList(irregularCollection))
                .build();
    }

    @Test
    public void getIrregularCollectionsTest() {
        when(service.getRecaudacionesIrregulares()).thenReturn(irregularCollections);

        ResponseEntity<IrregularCollectionsDTO> response = controller.getIrregularCollections();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        IrregularCollectionsDTO dto = response.getBody();
        assertEquals(irregularCollections.getMachine(), dto.getMachine());
        assertEquals(irregularCollections.getClient(), dto.getClient());
        assertEquals(irregularCollections.getIrregularCollections().size(), dto.getIrregularCollections().size());
    }
}
