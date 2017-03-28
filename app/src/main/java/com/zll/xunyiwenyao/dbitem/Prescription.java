package com.zll.xunyiwenyao.dbitem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rxz on 2017/3/21.
 */

public class Prescription {
    private int id;
    private String name;
    private int department;
    private Doctor doctor;
    private Patient patient;
    private Map<Drug, Integer> drugmap;
    private int status;


    public Prescription(){
        setDrugmap(new HashMap<Drug, Integer>());
    }



    public Prescription(int id, String name, int department, Doctor doctor, Patient patient,
                        Map<Drug, Integer> drugmap) {
        super();
        this.id = id;
        this.name = name;
        this.department = department;
        this.doctor = doctor;
        this.patient = patient;
        this.drugmap = drugmap;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Map<Drug, Integer> getDrugmap() {
        return drugmap;
    }

    public void setDrugmap(Map<Drug, Integer> drugmap) {
        this.drugmap = drugmap;
    }



    public int getStatus() {
        return status;
    }



    public void setStatus(int status) {
        this.status = status;
    }


}
