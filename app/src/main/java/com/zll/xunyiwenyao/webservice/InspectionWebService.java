package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Inspection;
import com.zll.xunyiwenyao.dbitem.Utils;

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

        inspection1 = new Inspection("基本检查单","张三", Utils.SEX.MAN.ordinal(),"23","骨折","X光检查","2017-3-12","无",Utils.INSPECTION_STATUS.UNCOMMITED.ordinal(),Utils.LOGIN_DOCTOR);
        inspection2 = new Inspection("B超检查单","李思",Utils.SEX.WOMAN.ordinal(),"36","肠胃炎","B超检查","2017-1-15","无",Utils.INSPECTION_STATUS.COMMITED.ordinal(), Utils.LOGIN_DOCTOR);
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
    public static void deleteInspectionByPosition(int position){
        inspectionList.remove(position);
    }

    public static List<String> getAllPatientName(){
        List<String> pnamelist = new ArrayList<String>();
        for(Inspection item:inspectionList){
            if (!pnamelist.contains(item.getPatientName().toString()))
                pnamelist.add(item.getPatientName().toString());
        }
        return pnamelist;
    }

    public static List<Inspection> getInspectionByPatientName(String name){
        List<Inspection> resultList = new ArrayList<Inspection>();
        for(Inspection item:inspectionList){
            if(name.equals(item.getPatientName().toString())){
                resultList.add(item);
            }
        }
        return resultList;
    }


}
