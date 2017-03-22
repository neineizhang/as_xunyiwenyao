package com.zll.xunyiwenyao.dbitem;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rxz on 2017/3/21.
 */

public class PrescriptionTemplate {
    private int id;
    private String name;
    private int department;
    private Map<Drug, Integer> drugmap;

    private PrescriptionTemplate(){
        setDrugmap(new HashMap<Drug, Integer>());
    }

    public PrescriptionTemplate(int id, String name, int department, Map<Drug, Integer> drugmap) {
        this.id = id;
        this.name = name;
        this.department = department;
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

    public Map<Drug, Integer> getDrugmap() {
        return drugmap;
    }

    public void setDrugmap(Map<Drug, Integer> drugmap) {
        this.drugmap = drugmap;
    }
}
