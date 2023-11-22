package ceis.control.entities;

import java.util.Calendar;

import visual.util.GraphicSupport;
import ceis.control.Control;
import ceis.person.Person;
import ceis.rules.entities.Local;

public class LocalAccess extends Control{
	private Local local;
	
//--Constructor--
	public LocalAccess(Person person, Calendar init, Local local){
		super(person, init);
		this.local = local;
	}
	
//--Interface--
	public void setLocal(Local local){
		this.local = local;
	}
	public Local getLocal(){
		return local;
	}
	
	public String[] getDataAccessLocal(){
		String[] result = new String[3];
		result[0] = who.toString();
		result[1] = local.toString();
		result[2] = GraphicSupport.getStringEntryDate(init, true);
		return result;
	}
}