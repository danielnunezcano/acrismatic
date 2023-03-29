package com.acrismatic.acrismatic.service;

import com.acrismatic.acrismatic.domain.model.*;
import com.acrismatic.acrismatic.repository.AutomaticCounterHistoryJpaRepository;
import com.acrismatic.acrismatic.repository.CollectionHistoryJpaRepository;
import com.acrismatic.acrismatic.repository.MachineJpaRepository;
import com.acrismatic.acrismatic.repository.entity.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class IrregularCollectionsServiceImplTest {

    @InjectMocks
    private IrregularCollectionsServiceImpl service;

    @Mock
    private MachineJpaRepository machineJpaRepository;

    @Mock
    private CollectionHistoryJpaRepository collectionHistoryJpaRepository;

    @Mock
    private AutomaticCounterHistoryJpaRepository automaticCounterHistoryJpaRepository;

    @Test
    public void shouldReturnOneIrregularCollectionsByExits() {
        final Automatic automatic = Automatic.builder()
                .automaticEntries(100)
                .automaticExists(98)
                .date(toLocalDateTime("2023-01-21 09:56:00"))
                .build();

        final Manual manual = Manual.builder()
                .manualEntries(100)
                .manualExits(99)
                .date(toLocalDateTime("2023-01-21 10:00:00"))
                .build();

        final IrregularCollection irregularCollection = IrregularCollection.builder()
                .collectionId(1)
                .manualId(1)
                .automaticId(3)
                .manuals(manual)
                .automatics(automatic)
                .build();

        final Machine expectMachine = Machine.builder()
                .machine("supermáquina")
                .client("Bar Pepe")
                .irregularCollections(Arrays.asList(irregularCollection))
                .build();

        ClientJpa clientJpa = ClientJpa.builder()
                .id(1l).name("Bar Pepe")
                .build();
        MachineJpa machineJpa = MachineJpa.builder()
                .id(1l)
                .client(clientJpa)
                .name("supermáquina")
                .build();
        ManualCounterJpa manualCounterJpa = ManualCounterJpa.builder()
                .id(1l)
                .machine(machineJpa)
                .entries(100)
                .exits(99)
                .date(toLocalDateTime("2023-01-21 10:00:00"))
                .build();
        CollectionHistoryJpa collectionHistoryJpa =
                CollectionHistoryJpa.builder()
                        .id(1l).machine(machineJpa).date(LocalDate.parse("2023-01-21"))
                        .amount(5).manualCounter(manualCounterJpa).client(clientJpa).build();
        List<AutomaticCounterHistoryJpa> automaticCounterHistoryJpaList =
                Arrays.asList(
                        AutomaticCounterHistoryJpa.builder().id(3l).machine(machineJpa).entries(100).exits(98).date(toLocalDateTime("2023-01-21 09:56:00")).build(),
                        AutomaticCounterHistoryJpa.builder().id(2l).machine(machineJpa).entries(85).exits(91).date(toLocalDateTime("2023-01-21 09:51:00")).build(),
                        AutomaticCounterHistoryJpa.builder().id(1l).machine(machineJpa).entries(80).exits(90).date(toLocalDateTime("2023-01-21 09:46:00")).build());
        Mockito.when(machineJpaRepository.findAll()).thenReturn(Arrays.asList(machineJpa));
        Mockito.when(collectionHistoryJpaRepository.findByMachineId(machineJpa.getId())).thenReturn(Arrays.asList(collectionHistoryJpa));
        Mockito.when(automaticCounterHistoryJpaRepository.findByMachineIdAndDateBeforeOrderByDateDesc(
                        collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate()))
                .thenReturn(automaticCounterHistoryJpaList);
        final List<Machine> response = service.getIrregularCollections();
        assertEquals(Arrays.asList(expectMachine), response);
        verify(machineJpaRepository, times(1)).findAll();
        verify(collectionHistoryJpaRepository, times(1)).findByMachineId(machineJpa.getId());
        verify(automaticCounterHistoryJpaRepository, times(1))
                .findByMachineIdAndDateBeforeOrderByDateDesc(collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate());
    }

    @Test
    public void shouldReturnOneIrregularCollectionsByEntries() {
        final Automatic automatic = Automatic.builder()
                .automaticEntries(101)
                .automaticExists(99)
                .date(toLocalDateTime("2023-01-21 09:56:00"))
                .build();

        final Manual manual = Manual.builder()
                .manualEntries(100)
                .manualExits(99)
                .date(toLocalDateTime("2023-01-21 10:00:00"))
                .build();

        final IrregularCollection irregularCollection = IrregularCollection.builder()
                .collectionId(1)
                .manualId(1)
                .automaticId(3)
                .manuals(manual)
                .automatics(automatic)
                .build();

        final Machine expectMachine = Machine.builder()
                .machine("supermáquina")
                .client("Bar Pepe")
                .irregularCollections(Arrays.asList(irregularCollection))
                .build();

        ClientJpa clientJpa = ClientJpa.builder()
                .id(1l).name("Bar Pepe")
                .build();
        MachineJpa machineJpa = MachineJpa.builder()
                .id(1l)
                .client(clientJpa)
                .name("supermáquina")
                .build();
        ManualCounterJpa manualCounterJpa = ManualCounterJpa.builder()
                .id(1l)
                .machine(machineJpa)
                .entries(100)
                .exits(99)
                .date(toLocalDateTime("2023-01-21 10:00:00"))
                .build();
        CollectionHistoryJpa collectionHistoryJpa =
                CollectionHistoryJpa.builder()
                        .id(1l).machine(machineJpa).date(LocalDate.parse("2023-01-21"))
                        .amount(5).manualCounter(manualCounterJpa).client(clientJpa).build();
        List<AutomaticCounterHistoryJpa> automaticCounterHistoryJpaList =
                Arrays.asList(
                        AutomaticCounterHistoryJpa.builder().id(3l).machine(machineJpa).entries(101).exits(99).date(toLocalDateTime("2023-01-21 09:56:00")).build(),
                        AutomaticCounterHistoryJpa.builder().id(2l).machine(machineJpa).entries(85).exits(91).date(toLocalDateTime("2023-01-21 09:51:00")).build(),
                        AutomaticCounterHistoryJpa.builder().id(1l).machine(machineJpa).entries(80).exits(90).date(toLocalDateTime("2023-01-21 09:46:00")).build());
        Mockito.when(machineJpaRepository.findAll()).thenReturn(Arrays.asList(machineJpa));
        Mockito.when(collectionHistoryJpaRepository.findByMachineId(machineJpa.getId())).thenReturn(Arrays.asList(collectionHistoryJpa));
        Mockito.when(automaticCounterHistoryJpaRepository.findByMachineIdAndDateBeforeOrderByDateDesc(
                        collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate()))
                .thenReturn(automaticCounterHistoryJpaList);
        final List<Machine> response = service.getIrregularCollections();
        assertEquals(Arrays.asList(expectMachine), response);
        verify(machineJpaRepository, times(1)).findAll();
        verify(collectionHistoryJpaRepository, times(1)).findByMachineId(machineJpa.getId());
        verify(automaticCounterHistoryJpaRepository, times(1))
                .findByMachineIdAndDateBeforeOrderByDateDesc(collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate());
    }

    @Test
    public void shouldReturnEmpyIrregularCollections() {
        final Machine expectMachine = Machine.builder()
                .machine("supermáquina")
                .client("Bar Pepe")
                .irregularCollections(Arrays.asList())
                .build();
        ClientJpa clientJpa = ClientJpa.builder()
                .id(1l).name("Bar Pepe")
                .build();
        MachineJpa machineJpa = MachineJpa.builder()
                .id(1l)
                .client(clientJpa)
                .name("supermáquina")
                .build();
        ManualCounterJpa manualCounterJpa = ManualCounterJpa.builder()
                .id(1l)
                .machine(machineJpa)
                .entries(100)
                .exits(99)
                .date(toLocalDateTime("2023-01-21 10:00:00"))
                .build();
        CollectionHistoryJpa collectionHistoryJpa =
                CollectionHistoryJpa.builder()
                        .id(1l).machine(machineJpa).date(LocalDate.parse("2023-01-21"))
                        .amount(5).manualCounter(manualCounterJpa).client(clientJpa).build();
        List<AutomaticCounterHistoryJpa> automaticCounterHistoryJpaList =
                Arrays.asList(
                        AutomaticCounterHistoryJpa.builder().id(3l).machine(machineJpa).entries(100).exits(99).date(toLocalDateTime("2023-01-21 09:56:00")).build(),
                        AutomaticCounterHistoryJpa.builder().id(2l).machine(machineJpa).entries(85).exits(91).date(toLocalDateTime("2023-01-21 09:51:00")).build(),
                        AutomaticCounterHistoryJpa.builder().id(1l).machine(machineJpa).entries(80).exits(90).date(toLocalDateTime("2023-01-21 09:46:00")).build());
        Mockito.when(machineJpaRepository.findAll()).thenReturn(Arrays.asList(machineJpa));
        Mockito.when(collectionHistoryJpaRepository.findByMachineId(machineJpa.getId())).thenReturn(Arrays.asList(collectionHistoryJpa));
        Mockito.when(automaticCounterHistoryJpaRepository.findByMachineIdAndDateBeforeOrderByDateDesc(
                        collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate()))
                .thenReturn(automaticCounterHistoryJpaList);
        final List<Machine> response = service.getIrregularCollections();
        assertEquals(Arrays.asList(expectMachine), response);
        verify(machineJpaRepository, times(1)).findAll();
        verify(collectionHistoryJpaRepository, times(1)).findByMachineId(machineJpa.getId());
        verify(automaticCounterHistoryJpaRepository, times(1))
                .findByMachineIdAndDateBeforeOrderByDateDesc(collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate());
    }

    @Test
    public void shouldReturnEmpyIrregularCollectionsByAutomaticsSearchEmpty() {
        final Machine expectMachine = Machine.builder()
                .machine("supermáquina")
                .client("Bar Pepe")
                .irregularCollections(Arrays.asList())
                .build();

        ClientJpa clientJpa = ClientJpa.builder()
                .id(1l).name("Bar Pepe")
                .build();
        MachineJpa machineJpa = MachineJpa.builder()
                .id(1l)
                .client(clientJpa)
                .name("supermáquina")
                .build();
        ManualCounterJpa manualCounterJpa = ManualCounterJpa.builder()
                .id(1l)
                .machine(machineJpa)
                .entries(100)
                .exits(99)
                .date(toLocalDateTime("2023-01-21 10:00:00"))
                .build();
        CollectionHistoryJpa collectionHistoryJpa =
                CollectionHistoryJpa.builder()
                        .id(1l).machine(machineJpa).date(LocalDate.parse("2023-01-21"))
                        .amount(5).manualCounter(manualCounterJpa).client(clientJpa).build();
        List<AutomaticCounterHistoryJpa> automaticCounterHistoryJpaList = new ArrayList();
        Mockito.when(machineJpaRepository.findAll()).thenReturn(Arrays.asList(machineJpa));
        Mockito.when(collectionHistoryJpaRepository.findByMachineId(machineJpa.getId())).thenReturn(Arrays.asList(collectionHistoryJpa));
        Mockito.when(automaticCounterHistoryJpaRepository.findByMachineIdAndDateBeforeOrderByDateDesc(
                        collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate()))
                .thenReturn(automaticCounterHistoryJpaList);
        final List<Machine> response = service.getIrregularCollections();
        assertEquals(Arrays.asList(expectMachine), response);
        verify(machineJpaRepository, times(1)).findAll();
        verify(collectionHistoryJpaRepository, times(1)).findByMachineId(machineJpa.getId());
        verify(automaticCounterHistoryJpaRepository, times(1))
                .findByMachineIdAndDateBeforeOrderByDateDesc(collectionHistoryJpa.getMachine().getId(),collectionHistoryJpa.getManualCounter().getDate());
    }

    private LocalDateTime toLocalDateTime(final String dateTimeString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

}