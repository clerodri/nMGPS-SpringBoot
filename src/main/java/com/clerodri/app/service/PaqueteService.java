package com.clerodri.app.service;

import com.clerodri.app.dto.PaqueteDto;
import com.clerodri.app.model.Paquete;
import com.clerodri.app.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;
    @Autowired
    private PaqueteDTOMapper paqueteDTOMapper;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public List<PaqueteDto> getAll(){
        return paqueteRepository.findAll()
                .stream().map(paqueteDTOMapper)
                .collect(Collectors.toList());
    }

    public ResponseEntity<PaqueteDto> getOne(int id){
        Optional<Paquete> optionalPaquete = paqueteRepository.findById(id);
        return optionalPaquete
                .map(paquete -> new ResponseEntity<>(paqueteDTOMapper.apply(paquete), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }

    public PaqueteDto save(PaqueteDto dto){
        Paquete paquete = new Paquete(dto.nameClient(),dto.nameDevice());
        paquete.setId(sequenceGeneratorService.getSequenceNumber(Paquete.SEQUENCE_NAME));
        return paqueteDTOMapper.apply(paqueteRepository
                .save(paquete));
    }
}
