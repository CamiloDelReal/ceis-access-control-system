package ceis.control.scheme;

import java.util.Calendar;

import visual.util.GraphicSupport;

import ceis.control.Control;
import ceis.control.entities.KeyRequest;
import ceis.control.entities.LocalAccess;
import ceis.person.Person;
import ceis.rules.entities.RulesEntities;

public class Scheme extends Control{
	private Calendar end;
	private RulesEntities entity;
	
//--Constructor--
	public Scheme(Person who, Calendar init, Calendar end, RulesEntities entity){
		super(who, init);
		this.end = end;
		this.entity = entity;
	}
	public Scheme(LocalAccess localAccess, Calendar end){
		super(localAccess.getWho(), localAccess.getInit());
		this.end = end;
		entity = localAccess.getLocal();
	}
	public Scheme(KeyRequest keyRequest, Calendar end){
		super(keyRequest.getWho(), keyRequest.getInit());
		this.end = end;
		entity = keyRequest.getKey();
	}
	
//--Interface--
	public void setEnd(Calendar end){
		this.end = end;
	}
	public Calendar getEnd(){
		return end;
	}
	
	public void setRulesEntities(RulesEntities entity){
		this.entity = entity;
	}
	public RulesEntities getRulesEntities(){
		return entity;
	}
	
	public String[] getStringData(){
		String[] data = new String[4];
		data[0] = who.toString();
		data[1] = entity.toString();
		data[2] = GraphicSupport.getStringEntryDate(init, true);
		data[3] = GraphicSupport.getStringEntryDate(end, true);
		return data;
	}
}