package com.zll.xunyiwenyao.dbitem;

/**
 * Created by rxz on 2017/3/21.
 */

public class Doctor {
    private int id;//系统自增
    private String user_name;//用户名，注册时填的唯一名称
    private String real_name;//真实姓名
    private int sex;//性别，Enum写在utils文件中
    private int type;//类型，Enum写在utils文件中
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
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return user_name;
    }

    public void setUsername(String username) {
        this.user_name = username;
    }

    public String getRealName() {
        return real_name;
    }

    public void setRealName(String name) {
        this.real_name = name;
    }

    public int getSex() {return sex;}

    public void setSex(int s) {this.sex=s;}

    public int getType() {return type;}

    public void setType(int t) {this.type=t;}

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getTitle() {return title;}

    public void setTitle(String t){this.title=t;}

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getDepartment(){return department;}

    public void setDepartment(String d){this.department=d;}

    public String getGoodat(){return goodat;}

    public void setGoodat(String g){this.goodat=g;}

    public String getProfile(){return profile;}

    public void setProfile (String p) {this.profile=p;}
}
