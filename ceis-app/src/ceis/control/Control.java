package ceis.control;

import java.util.Calendar;

import ceis.person.Person;

public abstract class Control{
	protected Calendar init;
	protected Person who;
	
//--Constructors--
	public Control(Person who, Calendar init){
		this.who = who;
		this.init = init;
	}
	
//--Interface--
	public void setWho(Person who){
		this.who = who;
	}
	public Person getWho(){
		return who;
	}
	
	public void setInit(Calendar init){
		this.init = init;
	}
	public Calendar getInit(){
		return init;
	}
		
}