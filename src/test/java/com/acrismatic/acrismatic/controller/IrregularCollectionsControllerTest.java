package com.acrismatic.acrismatic.controller;

import com.acrismatic.acrismatic.controller.dto.AutomaticDTO;
import com.acrismatic.acrismatic.controller.dto.CustomResponseDTO;
import com.acrismatic.acrismatic.controller.dto.IrregularCollectionDTO;
import com.acrismatic.acrismatic.controller.dto.ManualDTO;
import com.acrismatic.acrismatic.domain.model.Automatic;
import com.acrismatic.acrismatic.domain.model.CustomResponse;
import com.acrismatic.acrismatic.domain.model.IrregularCollection;
import com.acrismatic.acrismatic.domain.model.Manual;
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
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class IrregularCollectionsControllerTest {

    @InjectMocks
    private IrregularCollectionsController controller;

    @Mock
    private IrregularCollectionsService service;

    private final LocalDateTime date = LocalDateTime.now();

    private final Automatic automatic = Automatic.builder()
            .automaticEntries(100)
            .automaticExists(98)
            .date(date)
            .build();

    private final Manual manual = Manual.builder()
            .manualEntries(100)
            .manualExits(99)
            .date(date)
            .build();

    private final IrregularCollection irregularCollection = IrregularCollection.builder()
            .collectionId(1)
            .manualId(1)
            .automaticId(3)
            .manuals(manual)
            .automatics(automatic)
            .build();

    private final CustomResponse customResponse = CustomResponse.builder()
            .machine("supermáquina")
            .client("Bar Pepe")
            .irregularCollections(Arrays.asList(irregularCollection))
            .build();

    private final CustomResponseDTO expectedCustomResponseDTO = CustomResponseDTO.builder()
            .machine("supermáquina")
            .client("Bar Pepe")
            .irregularCollections(Arrays.asList(
                    IrregularCollectionDTO.builder()
                            .collectionId(1)
                            .manualId(1)
                            .automaticId(3)
                            .manuals(ManualDTO.builder()
                                    .manualEntries(100)
                                    .manualExits(99)
                                    .date(date)
                                    .build())
                            .automatics(AutomaticDTO.builder()
                                    .automaticEntries(100)
                                    .automaticExists(98)
                                    .date(date)
                                    .build())
                            .build()
            ))
            .build();

    @BeforeEach
    public void setUp() {
        when(service.getIrregularCollections()).thenReturn(customResponse);
    }

    @Test
    public void testGetIrregularCollections() {
        ResponseEntity<CustomResponseDTO> response = controller.getIrregularCollections();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCustomResponseDTO, response.getBody());
        verify(service, times(1)).getIrregularCollections();
    }
}
