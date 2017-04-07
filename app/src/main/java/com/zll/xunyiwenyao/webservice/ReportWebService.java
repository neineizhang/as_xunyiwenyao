package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Report;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kejund on 17/4/7.
 */

public class ReportWebService {
    private static List<Report> reportList;

    static{
        reportList=new ArrayList<Report>();
    }

    public static void addReport(Report item){reportList.add(item);}

    public static List<Report> getAllReport(){
        return reportList;
    }



    }
