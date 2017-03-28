package com.zll.xunyiwenyao.webservice;

import java.util.ArrayList;
import java.util.List;

import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Patient;
import com.zll.xunyiwenyao.dbitem.Utils;

/**
 * Created by rxz on 2017/3/21.
 */

public class PatientWebService {

    private static List<Patient> patientlist;

    static {
        Patient patient = null;
        patientlist = new ArrayList<Patient>();
        patient = new Patient(1, "patient A", Utils.SEX.MAN.ordinal(), 18);
        patientlist.add(patient);
        patient = new Patient(2, "patient B", Utils.SEX.WOMAN.ordinal(), 22);
        patientlist.add(patient);
        patient = new Patient(3, "patient C", Utils.SEX.MAN.ordinal(), 34);
        patientlist.add(patient);
    }

    public static List<Patient> getAllDoctor(){
        return patientlist;
    }

}
