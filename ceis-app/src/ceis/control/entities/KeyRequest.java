package ceis.control.entities;

import java.util.Calendar;

import visual.util.GraphicSupport;

import ceis.control.Control;
import ceis.person.Person;
import ceis.rules.entities.Key;

public class KeyRequest extends Control{
	private Key key;
	
//--Constructor--
	public KeyRequest(Person person, Calendar init, Key key){
		super(person, init);
		this.key = key;
	}
	
//--Interface--
	public void setKey(Key key){
		this.key = key;
	}
	public Key getKey(){
		return key;
	}
	
	public String[] getDataKeyRequest(){
		String[] result = new String[3];
		result[0] = who.toString();
		result[1] = key.toString();
		result[2] = GraphicSupport.getStringEntryDate(init, true);
		return result;
	}
}