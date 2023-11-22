package ceis.person.registered.worker;

import ceis.person.registered.Worker;

public class TecnicAdmin extends Worker{
	private String department;
	
//--Constructor--
	public TecnicAdmin(String ci, String name, String lastName, int id, 
			  	  String address, String phone, String pictureString,
			  	  String charge, String department){
		super(ci, name, lastName, id, address, phone, pictureString, charge);
		this.department = department;
	}
	
//--Interface--
	public void setDepartment(String department){
		this.department = department;
	}
	public String getDepartment(){
		return department;
	}
}