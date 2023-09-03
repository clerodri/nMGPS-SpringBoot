package com.clerodri.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "paquetes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Paquete {

    @Transient
    public static final  String SEQUENCE_NAME ="paquete_sequence";

    @Id
    private int id;
    private String nameDevice;
    private String nameClient;
    public Paquete (String nameDevice,String nameClient){
        this.nameClient=nameClient;
        this.nameDevice=nameDevice;
    }

}
