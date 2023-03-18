package com.smart_salon.repository;

import com.smart_salon.model.Salon;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRepository extends MongoRepository<Salon,String> {

}
