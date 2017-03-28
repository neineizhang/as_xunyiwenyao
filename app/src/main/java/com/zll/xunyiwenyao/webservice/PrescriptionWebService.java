package com.zll.xunyiwenyao.webservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zll.xunyiwenyao.dbitem.Doctor;
import com.zll.xunyiwenyao.dbitem.Drug;
import com.zll.xunyiwenyao.dbitem.Patient;
import com.zll.xunyiwenyao.dbitem.Prescription;
import com.zll.xunyiwenyao.dbitem.Utils;

public class PrescriptionWebService {

	private static List<Prescription> prescriptionlist;

	static {
		prescriptionlist = new ArrayList<Prescription>();

		Doctor doctor = null;
		Patient patient = null;
		Prescription  prescription = null;

		//doctor = new Doctor(1, "doctor A", Utils.DOCTOR_TYPE.DOCTOR.ordinal(), "Hospital 1");
		doctor = DoctorWebService.getAllDoctor().get(0);
		patient = PatientWebService.getAllDoctor().get(1);

		Map<Drug, Integer> drugmap = new HashMap<Drug, Integer>();
		drugmap.put(DrugWebService.getAllDrug().get(0), 1);
		drugmap.put(DrugWebService.getAllDrug().get(1), 3);
		drugmap.put(DrugWebService.getAllDrug().get(2), 4);
		drugmap.put(DrugWebService.getAllDrug().get(4), 2);
		drugmap.put(DrugWebService.getAllDrug().get(3), 1);

		prescription= new Prescription(1,"coach", Utils.DEPARTMENT.NEIKE.ordinal(), doctor,patient, drugmap);
		prescriptionlist.add(prescription);
	}

	public static void AddPrescription(Prescription item){
		Prescription prescription_inDB = getPrescriptionByName(item.getName());
		if(prescription_inDB == null){
			prescriptionlist.add(item);
		}else{
			prescriptionlist.set(prescriptionlist.indexOf(prescription_inDB), item);
		}
	}

	public static List<Prescription> getAllPrescription()
	{
		return prescriptionlist;
	}

	public static List<Prescription> getPrescriptionbyStatus(int status)
	{
		//List<Prescription> prescriptionsaved,prescriptioncommited,prescriptionapproved,prescriptionrefused;
		List<Prescription> prescription_result_lt = new ArrayList<Prescription>();
		List<Prescription> prescriptionlist = getAllPrescription();
		for(Prescription item :prescriptionlist){

			if(item.getStatus() == status){
				prescription_result_lt.add(item);
			}

		}

		return prescription_result_lt;

	}

	public static Prescription getPrescriptionByName(String name){
		for(Prescription item :prescriptionlist){
			if(item.getName().equals(name)){
				return item;
			}
		}
		return null;
	}

//	public static Prescription getPrescriptionbyid(int id)
//	{
//		for Prescription item :prescriptionlist:
//		return prescription;
//	}


}
