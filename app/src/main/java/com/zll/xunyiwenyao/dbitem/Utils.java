package com.zll.xunyiwenyao.dbitem;

/**
 * Created by rxz on 2017/3/21.
 */

public class Utils {

    public static enum SEX {
        MAN, WOMAN
    };

    public static enum DOCTOR_TYPE{
        ACCESSOR, DOCTOR
    };

    public static enum DEPARTMENT {
        NEIKE, WAIKE, ERKE, FUCHANKE, WUGUANKE, PIFUKE
    };

    public static String[] DEPARTMENT_ARRAY = new String[]{"NEI KE", "WAI KE", "ER KE", "FU CHAN KE", "WU GUANKE", "PI FU KE"};

    public static enum STATUS{
        COMMITED,SAVED,APPROVED,REFUSED
    };

    public static enum INSPECTION_STATUS{
        UNCOMMITED, COMMITED
    };

    public static Doctor LOGIN_DOCTOR;

    public static enum REPORT_LEVEL{
        NEW, SEVERE, GENERAL
    };

}
