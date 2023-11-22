package ceis.person.registered;

import ceis.person.Registered;

public abstract class Worker extends Registered{
	protected String charge;
	
//--Constructor--
	public Worker(String ci, String name, String lastName, int id, 
			  	  String address, String phone,  String pictureString,
			  	  String charge){
		super(ci, name, lastName, id, address, phone, pictureString);
		this.charge = charge;
	}
	
//--Interface--
	public void setCharge(String charge){
		this.charge = charge;
	}
	public String getCharge(){
		return charge;
	}
}