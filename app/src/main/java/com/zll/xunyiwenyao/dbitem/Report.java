package com.zll.xunyiwenyao.dbitem;

import java.util.List;

/**
 * Created by kejund on 17/4/6.
 */

public class Report {
    private int id;     //系统自增的唯一id
    private  String name;//报告名称，必填项
    private String feature;//临床表现，必填项
    private List<Drug> drugList;//涉及的药品，必填项
    private int lever;//严重程度
    private String event_date;//事件发生的时间
    private String report_date;//提交的时间
    private Doctor doctor;//提交的医生，必填项
    private String comment;//备注

    public String getName(){
        return this.name;
    }
    public void setName(String name){this.name=name;}

    public String getFeature(){return this.feature;}
    public void setFeature(String feature){this.feature=feature;}


    public int getLever(){return this.lever;}
    public void setLever(int lever){this.lever=lever;}

    public String getEvent_Date(){return event_date;}
    public void setEventDate(String date){this.event_date=date;}

    public String getReportDate(){return report_date;}
    public void setReportDate(String date){this.report_date=date;}

    public Doctor getDoctor(){return doctor;}
    public void setDoctor(Doctor d){this.doctor=d;}

    public String getComment(){return comment;}
    public void setComment(String c){this.comment=c;}
}
