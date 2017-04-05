package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Inspection;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kejund on 17/3/29.
 */

public class InspectionWebService {
    public static List<Inspection> inspectionList = new ArrayList<Inspection>();

    static{
        Doctor doctor = null;

        Inspection inspection1 = null;
        Inspection inspection2 = null;

        inspection1 = new Inspection("基本检查单","张三","男","23","骨折","X光检查","2017-3-12","无","未提交");
        inspection2 = new Inspection("B超检查单","李思","女","36","肠胃炎","B超检查","2017-1-15","无","已提交");
        inspectionList.add(inspection1);
        inspectionList.add(inspection2);
    }

    public static List<Inspection> getAllInspection() {return inspectionList;};

    public static void addInspection(Inspection item){
        inspectionList.add(item);
    }
    public static void updateInspectionByPosition(int position,Inspection item){
        inspectionList.set(position,item);
    }



}
