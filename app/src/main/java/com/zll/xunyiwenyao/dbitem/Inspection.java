package com.zll.xunyiwenyao.dbitem;

/**
 * Created by kejund on 17/3/23.
 */



public class Inspection {
    private int id;     //系统自增的唯一id
    private String name;//检查单名称，必填项
    private String pname;//患者名称，必填项
    private int psex;//患者性别
    private String page;//患者年龄
    private String diagnose;//临床诊断
    private String content;//检查单内容，必填项
    private String date;//开具日期
    private String comment;//备注信息
    private int state;//状态，未提交，已提交
    private Doctor doctor;//开具检查单的医师，必填项
    private boolean checked;

    public Inspection(){

    };
    public Inspection(String ins_name, String pat_name, int pat_sex, String pat_age,
                      String pat_diag, String ins_text, String ins_date, String ins_comment,
                      int ins_state, Doctor doctor){
        super();
        this.name = ins_name;
        this.pname = pat_name;
        this.psex = pat_sex;
        this.page = pat_age;
        this.diagnose = pat_diag;
        this.content = ins_text;
        this.date = ins_date;
        this.comment = ins_comment;
        this.state = ins_state;
        this.doctor = doctor;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public String getInspectionName() {
        return name;
    }
    public void setInspectionName(String ins_name) {
        this.name = ins_name;
    }

    public String getPatientName() {
        return pname;
    }
    public void setPatientName(String pat_name) {
        this.pname = pat_name;
    }

    public int getPatientSex() {
        return psex;
    }
    public void setPatientSex(int sex) {
        this.psex = sex;
    }

    public String getPatientAge() {
        return page;
    }
    public void setPatientAge(String age) {
        this.page = age;
    }

    public String getPatientDiag() {
        return diagnose;
    }
    public void setPatientDiag(String diag) {
        this.diagnose = diag;
    }

    public String getInspectionText() {
        return content;
    }
    public void setInspectionText(String text) {
        this.content = text;
    }

    public String getInspectionDate() {
        return date;
    }
    public void setInspectionDate(String ins_date) {
        this.date = ins_date;
    }

    public String getInspectionComment() {
        return comment;
    }
    public void setInspectionComment(String comment) {
        this.comment = comment;
    }

    public int getInspectionState() {
        return state;
    }
    public void setInspectionState(int state) {
        this.state = state;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public boolean isChecked() {
        return checked;
    }
}
