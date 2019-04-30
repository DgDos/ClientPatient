/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.clientpatient;


 
public class Patient {
    private String patNo;
    private String name;
    private String address;
    private String telephone;
    private String date_of_birth;
    private String emergency_contact;
    private boolean type_of_patient;
    private int medicare;
    private String ins_company;
    private String ins_number;

    public Patient() {
    }

    public Patient(String patNo, String name, String address, String telephone, String date_of_birth, String emergency_contact, boolean type_of_patient, int medicare, String ins_company, String ins_number) {
        this.patNo = patNo;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.date_of_birth = date_of_birth;
        this.emergency_contact = emergency_contact;
        this.type_of_patient = type_of_patient;
        this.medicare = medicare;
        this.ins_company = ins_company;
        this.ins_number = ins_number;
    }

    public String getPatNo() {
        return patNo;
    }

    public void setPatNo(String patNo) {
        this.patNo = patNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmergency_contact() {
        return emergency_contact;
    }

    public void setEmergency_contact(String emergency_contact) {
        this.emergency_contact = emergency_contact;
    }

    public boolean isType_of_patient() {
        return type_of_patient;
    }

    public void setType_of_patient(boolean type_of_patient) {
        this.type_of_patient = type_of_patient;
    }

    public int getMedicare() {
        return medicare;
    }

    public void setMedicare(int medicare) {
        this.medicare = medicare;
    }

    public String getIns_company() {
        return ins_company;
    }

    public void setIns_company(String ins_company) {
        this.ins_company = ins_company;
    }

    public String getIns_number() {
        return ins_number;
    }

    public void setIns_number(String ins_number) {
        this.ins_number = ins_number;
    }
    
    
}