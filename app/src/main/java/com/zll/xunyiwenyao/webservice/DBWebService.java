package com.zll.xunyiwenyao.webservice;

import java.util.ArrayList;
import java.util.List;

public class DBWebService {
	private static List<List<String>> druglist= new ArrayList<List<String>>();
	
	static{
		// id, name, size, price
		List<String> drug = new ArrayList<String>();
		drug.add("001");
		drug.add("罗红霉素");
		drug.add("5g X 12");
		drug.add("12.50");
		druglist.add(drug);
		drug = new ArrayList<String>();
		drug.add("002");
		drug.add("阿莫西林");
		drug.add("10g X 15");
		drug.add("22.50");
		druglist.add(drug);
		
	}
	
	public static List<List<String>> getAllDrugList(){
		return druglist;
	}
	
	public static List<String> getDetailDrugByName(String name){
		for(List<String> item : druglist){
			if(item.get(1).equals(name)){
				return item;
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println("hello");
		System.out.println(DBWebService.getAllDrugList().size());
		DBWebService.getDetailDrugByName("阿莫西林");
	}

}
