package com.acrismatic.acrismatic.controller;

import com.acrismatic.acrismatic.controller.dto.MachineDTO;
import com.acrismatic.acrismatic.controller.mapper.MachineMapper;
import com.acrismatic.acrismatic.service.IrregularCollectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IrregularCollectionsController {

    private final IrregularCollectionsService service;

    @GetMapping("/irregular-collections")
    public ResponseEntity<List<MachineDTO>> getIrregularCollections() {
        List<MachineDTO> result =
                MachineMapper.INSTANCE.toMachineDTOList(service.getIrregularCollections());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
