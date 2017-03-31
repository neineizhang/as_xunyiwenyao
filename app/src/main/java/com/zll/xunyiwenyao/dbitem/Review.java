package com.zll.xunyiwenyao.dbitem;

/**
 * Created by kejund on 17/3/30.
 */

public class Review {
    private String name;
    private String content;

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
}
