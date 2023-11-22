package ceis.rules.entities;

import ceis.rules.RulesCollection;


public class Key extends RulesEntities{
	private boolean available;
	private Local local;
	
	public Key(RulesCollection accessRules, Local local){
		super(accessRules);
		this.local = local;
		available = true;
	}

//--Interface--
	public void setLocal(Local local){
		this.local = local;
	}
	public Local getLocal(){
		return local;
	}
	
	public boolean isAvailable(){
		return available == true;
	}
	public void delivery(){
		available = true;
	}
	public void loan(){
		available = false;
	}
	
//--Auxiliary methods--
	
	public String toString(){
		return local.getName();
	}
}