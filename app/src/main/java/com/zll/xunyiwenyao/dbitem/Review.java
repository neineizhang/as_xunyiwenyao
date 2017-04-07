package com.zll.xunyiwenyao.dbitem;

/**
 * Created by kejund on 17/3/30.
 */

public class Review {
    private int id;     //系统自增的唯一id
    private String name;//名称，必填项
    private int drug_id;//评价的药品id
    private String drug_name;// 评价的药品name，必填项
    private String content;//评价的内容，必填项
    private String date;//提交的时间
    private Doctor doctor;//提交的医生，必填项
    private String comment;//备注

    public Review(){}
    public Review(String name, String content){
        this.name=name;
        this.content=content;
    }

    public String getName(){
        return this.name;
    }
    public void setName(String name){this.name=name;}

    public String getContent(){return this.content;}
    public void setContent(String content){this.content=content;}

    public int getDrugID(){return drug_id;}
    public void setDrugID(int id){this.drug_id=id;}

    public String getDrugName(){return  drug_name;}
    public void setDrugName(String dname){this.drug_name=dname;}

    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}

    public Doctor getDoctor(){return doctor;}
    public void setDoctor(Doctor d){this.doctor=d;}

    public String getComment(){return comment;}
    public void setComment(String c){this.comment=c;}
}
