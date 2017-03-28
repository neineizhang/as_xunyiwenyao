package com.zll.xunyiwenyao.webservice;

import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rxz on 2017/3/21.
 */

public class DoctorWebService {

    private static int MAX_ID = 1;
    private static List<Doctor> dctorlist;

    static {
        Doctor doctor = null;
        dctorlist = new ArrayList<Doctor>();
        doctor = new Doctor(1, "doctor A", Utils.DOCTOR_TYPE.DOCTOR.ordinal(), "Hospital 1", "root", "2222");
        dctorlist.add(doctor);
        doctor = new Doctor(2, "doctor B", Utils.DOCTOR_TYPE.DOCTOR.ordinal(), "Hospital 2", "admin", "admin");
        dctorlist.add(doctor);
        doctor = new Doctor(3, "doctor C", Utils.DOCTOR_TYPE.ACCESSOR.ordinal(), "Hospital 3", "doctor", "doctor");
        dctorlist.add(doctor);
        MAX_ID = 4;
    }

    public static List<Doctor> getAllDoctor(){
        return dctorlist;
    }

    public static List<Doctor> getDoctorByType(int type){
        List<Doctor> resultlist = new ArrayList<Doctor>();
        for(Doctor doctor : dctorlist){
            if(doctor.getType() == type){
                resultlist.add(doctor);
            }
        }
        return resultlist;
    }

    public static void addDoctor(Doctor item){
        item.setId(MAX_ID);
        MAX_ID++;
    }

    public static Doctor isSuccessLogin(String username, String passwd, int type){
        List<Doctor> resultlist = getDoctorByType(type);
        for(Doctor item : resultlist){
            if(item.getUsername().equals(username) &&
                    item.getPasswd().equals(passwd)){
                return item;
            }
        }
        return null;
    }


}
