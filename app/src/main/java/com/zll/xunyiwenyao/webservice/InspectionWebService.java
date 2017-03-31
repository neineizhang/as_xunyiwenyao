package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Inspection;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by kejund on 17/3/29.
 */

public class InspectionWebService {
    public static List<Inspection> inspectionList = new ArrayList<Inspection>();

    static{
        Inspection inspection = null;

        inspection = new Inspection("基本检查单","张三","男","23","骨折","X光检查","2017-3-12","无","未提交");
    }

    public static List<Inspection> getAllInspection() {return inspectionList;};

    public static void addInspection(Inspection item){
        inspectionList.add(item);
    }



}
