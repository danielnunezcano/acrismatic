package com.acrismatic.acrismatic.controller;

import com.acrismatic.acrismatic.controller.dto.IrregularCollectionsDTO;
import com.acrismatic.acrismatic.controller.mapper.IrregularCollectionsMapper;
import com.acrismatic.acrismatic.service.IrregularCollectionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class IrregularCollectionsController {

    private final IrregularCollectionsService service;

    @GetMapping("/recaudaciones-irregulares")
    public ResponseEntity<IrregularCollectionsDTO> getIrregularCollections() {
        IrregularCollectionsDTO result =
                IrregularCollectionsMapper.INSTANCE.toDTO(service.getRecaudacionesIrregulares());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}