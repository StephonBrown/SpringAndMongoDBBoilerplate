/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stephonb.mongoboilerplatecode.repositories;

import com.stephonb.mongoboilerplatecode.model.Patient;
import java.util.List;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 *
 * @author sbrown6
 */
public interface PatientRepository extends MongoRepository<Patient, String>{
    
    Patient findBy_id(ObjectId _id);
    
    @Query(value="{ 'firstName' : {$regex: ?0, $options: 'i' }}")
    List<Patient> findByfirstName(String firstName);
    
    @Query(value="{ 'lastName' : {$regex: ?0, $options: 'i' }}")
    List<Patient> findByLastName(String lastName);
}
