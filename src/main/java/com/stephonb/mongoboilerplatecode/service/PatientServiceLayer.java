/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stephonb.mongoboilerplatecode.service;

import com.stephonb.mongoboilerplatecode.model.Patient;
import java.util.List;
import org.bson.types.ObjectId;

/**
 *
 * @author sbrown6
 */
public interface PatientServiceLayer {
    
    public Patient getPatient(ObjectId _id);
    
    public Patient createPatient(Patient patient);
    
    public Patient updatePatient(Patient patient);
    
    public Patient deletePatient(ObjectId _id);
    
    public List<Patient> getAllPatients();
    
}
