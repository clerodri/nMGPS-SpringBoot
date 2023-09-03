package com.clerodri.app.service;

import com.clerodri.app.dto.PaqueteDto;
import com.clerodri.app.model.Paquete;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class PaqueteDTOMapper implements Function<Paquete, PaqueteDto> {

    @Override
    public PaqueteDto apply(Paquete paquete) {
        return new PaqueteDto(
                paquete.getNameDevice(),
                paquete.getNameClient()
        );
    }

}
