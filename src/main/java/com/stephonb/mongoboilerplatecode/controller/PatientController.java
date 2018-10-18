/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stephonb.mongoboilerplatecode.controller;

import static com.fasterxml.jackson.databind.util.ClassUtil.defaultValue;
import com.stephonb.mongoboilerplatecode.model.Patient;
import com.stephonb.mongoboilerplatecode.repositories.PatientRepository;
import java.util.List;
import javax.validation.Valid;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author sbrown6
 */
@RestController
@RequestMapping("/patients")
public class PatientController {
    @Autowired
    private PatientRepository repo;
    
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<Patient> getPatients(){
        return repo.findAll();
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Patient getPatientById(@PathVariable("id") ObjectId id){
        return repo.findBy_id(id);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Patient> getPatientByName(@RequestParam(value="firstName", defaultValue="") String firstName, @RequestParam(value="lastName", defaultValue="") String lastName){
        if(firstName.isEmpty() || firstName.equals("") && !lastName.isEmpty()){
            return repo.findByLastName(lastName);
        }else{
            return repo.findByfirstName(firstName);
        }    
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void updatePatient(@PathVariable("id") ObjectId id, @Valid @RequestBody Patient patient){
        patient.setId(id);
        repo.save(patient);
    }
    
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Patient createPatient(@Valid @RequestBody Patient patient){
        patient.setId(ObjectId.get());
        repo.save(patient);
        return patient;
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePatient(@PathVariable("id") ObjectId id){
        repo.delete(repo.findBy_id(id));
    }
}
