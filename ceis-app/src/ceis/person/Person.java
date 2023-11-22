package ceis.person;

public abstract class Person{
	protected String ci;
	protected String name;
	protected String lastName;
	
//--Constructor--
	public Person(String ci, String name, String lastName){
		this.ci = ci;
		this.name = name;
		this.lastName = lastName;
	}
	
//--Interface--
	public void setCI(String ci){
		this.ci = ci;
	}
	public String getCI(){
		return ci;
	}
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getLastName(){
		return lastName;
	}
	
//--Auxiliary methods--
	public String toString(){
		String result = null;
		
		if(!name.isEmpty()){
			if(result == null)
				result = name;
			else
				result += name;
		}
		if(!lastName.isEmpty()){
			if(result == null)
				result = lastName;
			else
				result += " " + lastName;
		}
		
		return result;
	}
}
