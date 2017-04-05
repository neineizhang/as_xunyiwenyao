package com.zll.xunyiwenyao.dbitem;

/**
 * Created by rxz on 2017/3/21.
 */

public class Doctor {
    private int id;//系统自增
    private String user_name;//用户名，注册时填的唯一名称
    private String real_name;//真实姓名
    private int sex;//性别
    private int type;//0-执业医生，1-审核医生
    private String passwd;//密码

    private String photo;//医生照片路径
    private String license;//执业证书路径

    private String title;//职位
    private String hospital;//医院
    private String department;//科室
    private String goodat;//删除
    private String profile;//个人资料
    private String register_time;//注册时间


    public Doctor() {
    }

    public Doctor(int id, String name, int type, String hospital, String username, String passwd) {
        super();
        this.id = id;
        this.real_name = name;
        this.type = type;
        this.hospital = hospital;
        this.user_name = username;
        this.passwd = passwd;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String username) {
        this.user_name = username;
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
        return real_name;
    }

    public void setName(String name) {
        this.real_name = name;
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
