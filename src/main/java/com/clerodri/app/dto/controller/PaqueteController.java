package com.clerodri.app.dto.controller;

import com.clerodri.app.dto.PaqueteDto;
import com.clerodri.app.model.Paquete;
import com.clerodri.app.service.PaqueteService;
import com.clerodri.app.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PaqueteController {
    @Autowired
    private PaqueteService paqueteService;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    //obtener todos los paquetes
    @GetMapping("/paquete")
    public ResponseEntity<List<PaqueteDto>> getAll(){
        return new ResponseEntity<>(paqueteService.getAll(),HttpStatus.OK);
    }


    @PostMapping("/paquete")
    public ResponseEntity<?> savePaquete(@RequestBody PaqueteDto dto){
        PaqueteDto paqueteDto = paqueteService.save(dto);
        return new ResponseEntity<>(paqueteDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaqueteDto> paqueteById(@PathVariable int id){
       return paqueteService.getOne(id);
    }

}
