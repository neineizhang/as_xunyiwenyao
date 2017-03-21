package com.zll.xunyiwenyao.test;

import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Drug;
import com.zll.xunyiwenyao.webservice.DoctorWebService;
import com.zll.xunyiwenyao.webservice.DrugWebService;

import java.util.List;

/**
 * Created by rxz on 2017/3/21.
 */

public class WebServiceTest {
    public static void main(String[] args){
        List<Doctor> resultDoctorlt = DoctorWebService.getAllDoctor();
        System.out.println(resultDoctorlt.size());
        List<Drug> resultDruglt = DrugWebService.getAllDrug();
        System.out.println(resultDruglt.size());
    }
}
