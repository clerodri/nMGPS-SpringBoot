package com.clerodri.app.repository;

import com.clerodri.app.model.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaqueteRepository extends MongoRepository<Paquete,Integer> {
}
