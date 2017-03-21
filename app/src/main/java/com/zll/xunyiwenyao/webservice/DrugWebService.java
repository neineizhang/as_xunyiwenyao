package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Drug;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rxz on 2017/3/21.
 */

public class DrugWebService {

    private static List<Drug> druglist;

    static {
        Drug drug = null;
        druglist = new ArrayList<Drug>();
        drug = new Drug(1, "Drug A", "12g X 10", "12.00", "one day one time");
        druglist.add(drug);
        drug = new Drug(2, "Drug B", "12g X 30", "22.00", "one day 3 time");
        druglist.add(drug);
        drug = new Drug(3, "Drug C", "1g X 10", "72.00", "one day 2 time");
        druglist.add(drug);
        drug = new Drug(4, "Drug D", "12g X 13", "32.00", "one day one time");
        druglist.add(drug);
        drug = new Drug(5, "Drug E", "12g X 120", "22.00", "一one day one time");
        druglist.add(drug);
    }

    public static List<Drug> getAllDrug() {

        return druglist;

    }


}
