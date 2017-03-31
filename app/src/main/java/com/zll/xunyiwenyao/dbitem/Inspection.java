package com.zll.xunyiwenyao.dbitem;

/**
 * Created by kejund on 17/3/23.
 */



public class Inspection {
    private String inspection_name;
    private String patient_name;
    private String patient_sex;
    private String patient_age;
    private String patient_diag;
    private String inspection_text;
    private String inspection_date;
    private String inspection_comment;
    private String inspection_state;
    private boolean checked;

    public Inspection(){

    };
    public Inspection(String ins_name, String pat_name, String pat_sex, String pat_age,
                      String pat_diag, String ins_text, String ins_date, String ins_comment,
                      String ins_state){
        super();
        this.inspection_name = ins_name;
        this.patient_name = pat_name;
        this.patient_sex = pat_sex;
        this.patient_age = pat_age;
        this.patient_diag = pat_diag;
        this.inspection_text = ins_text;
        this.inspection_date = ins_date;
        this.inspection_comment = ins_comment;
        this.inspection_state = ins_state;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }
    public String getInspectionName() {
        return inspection_name;
    }
    public void setInspectionName(String ins_name) {
        this.inspection_name = ins_name;
    }

    public String getPatientName() {
        return patient_name;
    }
    public void setPatientName(String pat_name) {
        this.patient_name = pat_name;
    }

    public String getPatientSex() {
        return patient_sex;
    }
    public void setPatientSex(String sex) {
        this.patient_sex = sex;
    }

    public String getPatientAge() {
        return patient_age;
    }
    public void setPatientAge(String age) {
        this.patient_age = age;
    }

    public String getPatientDiag() {
        return patient_diag;
    }
    public void setPatientDiag(String diag) {
        this.patient_diag = diag;
    }

    public String getInspectionText() {
        return inspection_text;
    }
    public void setInspectionText(String text) {
        this.inspection_text = text;
    }

    public String getInspectionDate() {
        return inspection_date;
    }
    public void setInspectionDate(String ins_date) {
        this.inspection_date = ins_date;
    }

    public String getInspectionComment() {
        return inspection_comment;
    }
    public void setInspectionComment(String comment) {
        this.inspection_comment = comment;
    }

    public String getInspectionState() {
        return inspection_state;
    }
    public void setInspectionState(String state) {
        this.inspection_state = state;
    }
}
