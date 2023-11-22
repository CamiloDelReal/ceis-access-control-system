package ceis.person.registered.worker;

import ceis.person.registered.Worker;

public class Docent extends Worker{
	private String category;
	
//--Constructor--
	public Docent(String ci, String name, String lastName, int id, 
			  	  String address, String phone, String pictureString,
			  	  String charge, String category){
		super(ci, name, lastName, id, address, phone, pictureString, charge);
		this.category = category;
	}
	
//--Interface--
	public void setCategory(String category){
		this.category = category;
	}
	public String getCategory(){
		return category;
	}
}