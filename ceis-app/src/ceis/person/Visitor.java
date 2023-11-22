package ceis.person;

import java.util.Calendar;

public class Visitor extends Person{
	private Calendar dateReg;
	
//--Constructor--
	public Visitor(String ci, String name, String lastName, Calendar dateReg){
		super(ci, name, lastName);
		this.dateReg = dateReg;
	}
	
//--Interface--
	
	public void setEntryDate(Calendar dateReg){
		this.dateReg = dateReg;
	}
	public Calendar getEntryDate(){
		return dateReg;
	}
}