package com.zll.xunyiwenyao.dbitem;

/**
 * Created by kejund on 17/3/23.
 */



public class Inspection {
    private int id;     //系统自增的唯一id
    private String name;//检查单名称，必填项
    private String pname;//患者名称，必填项
    private String psex;
    private String page;
    private String diagnose;
    private String content;//检查单内容，必填项
    private String date;
    private String comment;
    private String state;
    private boolean checked;

    public Inspection(){

    };
    public Inspection(String ins_name, String pat_name, String pat_sex, String pat_age,
                      String pat_diag, String ins_text, String ins_date, String ins_comment,
                      String ins_state){
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

    public String getPatientSex() {
        return psex;
    }
    public void setPatientSex(String sex) {
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

    public String getInspectionState() {
        return state;
    }
    public void setInspectionState(String state) {
        this.state = state;
    }
}
