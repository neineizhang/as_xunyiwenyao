package com.zll.xunyiwenyao.dbitem;

/**
 * Created by rxz on 2017/3/21.
 */

public class Doctor {
    private int id;
    private String name;
    private int type;
    private String hospital;
    private String username;
    private String passwd;

    public Doctor() {
    }

    public Doctor(int id, String name, int type, String hospital, String username, String passwd) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.hospital = hospital;
        this.username = username;
        this.passwd = passwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }
}
