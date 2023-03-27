package com.acrismatic.acrismatic.controller;

import com.acrismatic.acrismatic.controller.dto.RecaudacionesIrregularesDTO;
import com.acrismatic.acrismatic.controller.mapper.RecaudacionesIrregularesMapper;
import com.acrismatic.acrismatic.service.RecaudacionesIrregularesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class RecaudacionesIrregularesController {

    private final RecaudacionesIrregularesService service;

    @GetMapping("/recaudaciones-irregulares")
    public ResponseEntity<RecaudacionesIrregularesDTO> getRecaudacionesIrregulares() {
//        RecaudacionesIrregularesDTO result =
//                RecaudacionesIrregularesMapper.INSTANCE.toDTO(service.getRecaudacionesIrregulares());
//        return new ResponseEntity<>(result, HttpStatus.OK);
        return new ResponseEntity<>(new RecaudacionesIrregularesDTO(), HttpStatus.OK);
    }
}
