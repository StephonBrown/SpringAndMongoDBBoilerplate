/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stephonb.mongoboilerplatecode.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 *
 * @author sbrown6
 */
public class Patient {
    @Id
    private ObjectId _id;
    private String firstName;
    private String lastName;
    private String gender;
    private long age;

    public Patient(ObjectId _id, String firstName, String lastName, String gender, long age) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public String getId() {
        return _id.toHexString();
    }

    public void setId(ObjectId _id) {
        this._id = _id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }
    
    
}
