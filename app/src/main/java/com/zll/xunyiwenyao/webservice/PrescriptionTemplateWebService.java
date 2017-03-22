package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Drug;
import com.zll.xunyiwenyao.dbitem.PrescriptionTemplate;
import com.zll.xunyiwenyao.dbitem.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rxz on 2017/3/22.
 */

public class PrescriptionTemplateWebService {

    public static List<PrescriptionTemplate> templatelt = new ArrayList<PrescriptionTemplate>();

    static{

        List<Drug> resultDruglt = DrugWebService.getAllDrug();
        PrescriptionTemplate template = null;


        template = new PrescriptionTemplate( 1, "template 1", Utils.DEPARTMENT.NEIKE.ordinal(), new HashMap<Drug, Integer>());
        template.getDrugmap().put(resultDruglt.get(0), 10);
        template.getDrugmap().put(resultDruglt.get(1), 2);
        templatelt.add(template);

        template = new PrescriptionTemplate( 2, "template 2", Utils.DEPARTMENT.NEIKE.ordinal(), new HashMap<Drug, Integer>());
        template.getDrugmap().put(resultDruglt.get(0), 10);
        template.getDrugmap().put(resultDruglt.get(1), 20);
        templatelt.add(template);

        template = new PrescriptionTemplate( 3, "template 3", Utils.DEPARTMENT.WAIKE.ordinal(), new HashMap<Drug, Integer>());
        template.getDrugmap().put(resultDruglt.get(2), 10);
        template.getDrugmap().put(resultDruglt.get(1), 2);
        templatelt.add(template);

    }

    public static List<PrescriptionTemplate> getAllTemplate(){
        return templatelt;
    }
}
