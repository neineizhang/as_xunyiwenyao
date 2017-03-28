package com.zll.xunyiwenyao.dbitem;

/**
 * Created by rxz on 2017/3/21.
 */

public class Patient {
    private int id;
    private String name;
    private int sex;
    private int age;

    public Patient() {
        super();
    }

    public Patient(int id, String name, int sex, int age) {
        super();
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
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

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
