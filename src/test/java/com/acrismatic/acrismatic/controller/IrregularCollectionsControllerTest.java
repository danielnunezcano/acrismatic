package com.acrismatic.acrismatic.controller;

import com.acrismatic.acrismatic.controller.dto.*;
import com.acrismatic.acrismatic.domain.model.*;
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
import java.util.List;

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


    private final Machine machine = Machine.builder()
            .machine("supermáquina")
            .client("Bar Pepe")
            .irregularCollections(Arrays.asList(irregularCollection))
            .build();

    private final List<MachineDTO> expectedCustomResponseDTO =
            Arrays.asList(MachineDTO.builder().maquina("supermáquina")
                    .cliente("Bar Pepe")
                    .recaudacionesIrregulares(Arrays.asList(
                            IrregularCollectionDTO.builder()
                                    .idRecaudacion(1)
                                    .idManual(1)
                                    .idAutomatico(3)
                                    .manuales(ManualDTO.builder()
                                            .entradasManuales(100)
                                            .salidasManuales(99)
                                            .fecha(date)
                                            .build())
                                    .automaticos(AutomaticDTO.builder()
                                            .entradasAutomaticas(100)
                                            .salidasAutomaticas(98)
                                            .fecha(date)
                                            .build())
                                    .build()
                    ))
                    .build());

    @BeforeEach
    public void setUp() {
        when(service.getIrregularCollections()).thenReturn(Arrays.asList(machine));
    }

    @Test
    public void testGetIrregularCollections() {
        ResponseEntity<List<MachineDTO>> response = controller.getIrregularCollections();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(expectedCustomResponseDTO, response.getBody());
        verify(service, times(1)).getIrregularCollections();
    }
}
