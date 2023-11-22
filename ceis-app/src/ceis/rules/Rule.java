package ceis.rules;

import java.util.ArrayList;
import java.util.Calendar;

import ceis.CEIS;
import ceis.collection.PersonCollection;
import ceis.person.Person;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import ceis.rules.util.Schedule;
import ceis.rules.util.enumeration.TypeRule;
import exception.DontExistException;
import exception.DuplicityException;

public class Rule{
	private String name;
	private Schedule schedule;
	private PersonCollection authorized;
	private TypeRule type;
	
	public static String []week = {
			"Lunes",
			"Martes",
			"Miércoles",
			"Jueves",
			"Viernes",
		};
	public static String []weekend = {
			"Sábado",
			"Domingo"
		};
	
//--Constructors--
	public Rule(Calendar initWeek, Calendar endWeek, Calendar initWeekend, 
					   Calendar endWeekend, PersonCollection authorized,
					   String name, TypeRule type){
		this.name = name;
		schedule = new Schedule(initWeek, endWeek, initWeekend, endWeekend);
		this.type = type;
		if(authorized != null)
			this.authorized = authorized;
		else
			this.authorized = new PersonCollection();
	}
	
//--Interface to schedule--
	public void setSchedule(Calendar initWeek, Calendar endWeek, Calendar initWeekend, Calendar endWeekend){
		schedule.setInitWeek(initWeek);
		schedule.setEndWeek(endWeek);
		schedule.setInitWeekend(initWeekend);
		schedule.setEndWeekend(endWeekend);
	}
	public Schedule getSchedule(){
		return schedule;
	}
	
	public void setScheduleInitWeek(Calendar initWeek){
		schedule.setInitWeek(initWeek);
	}
	public Calendar getScheduleInitWeek(){
		return schedule.getInitWeek();
	}
	
	public void setScheduleEndWeek(Calendar endWeek){
		schedule.setEndWeek(endWeek);
	}
	public Calendar getScheduleEndWeek(){
		return schedule.getEndWeek();
	}
	
	public void setScheduleInitWeekend(Calendar initWeekend){
		schedule.setInitWeekend(initWeekend);
	}
	public Calendar getScheduleInitWeekend(){
		return schedule.getInitWeekend();
	}
	
	public void setScheduleEndWeekend(Calendar endWeekend){
		schedule.setEndWeekend(endWeekend);
	}
	public Calendar getScheduleEndWeekend(){
		return schedule.getEndWeekend();
	}
	
	public String getWeekScheduleLabel(){
		String text = "";
		
		if(schedule.getInitWeek() != null){
			switch(schedule.getInitWeek().get(Calendar.DAY_OF_WEEK)){
			case Calendar.MONDAY:
				text += "Lunes - ";
				break;
			case Calendar.TUESDAY:
				text += "Martes - ";
				break;
			case Calendar.WEDNESDAY:
				text += "Miercoles - ";
				break;
			case Calendar.THURSDAY:
				text += "Jueves - ";
				break;
			case Calendar.FRIDAY:
				text += "Viernes - ";			
				break;
			}
			
			switch(schedule.getEndWeek().get(Calendar.DAY_OF_WEEK)){
			case Calendar.MONDAY:
				text += "Lunes";
				break;
			case Calendar.TUESDAY:
				text += "Martes";
				break;
			case Calendar.WEDNESDAY:
				text += "Miercoles";
				break;
			case Calendar.THURSDAY:
				text += "Jueves";
				break;
			case Calendar.FRIDAY:
				text += "Viernes";			
				break;
			}
		}
		else
			text = "Entre semana";
			
		return text;
	}
	public String getWeekSchedule(){
		String text = "";
		String aux = null;
		
		if(schedule.getInitWeek() != null){
			aux = String.valueOf(schedule.getInitWeek().get(Calendar.HOUR));
			if(aux.equals("0"))
				aux = "12";
			if(aux.length() == 1)
				text += "0" + aux + ":";
			else
				text += aux + ":";
			
			aux = String.valueOf(schedule.getInitWeek().get(Calendar.MINUTE));
			if(aux.length() == 1)
				text += "0" + aux;
			else
				text += aux;
			
			if(schedule.getInitWeek().get(Calendar.AM_PM) == Calendar.AM)
				text += " AM";
			else
				text += " PM";
			
			text += " - ";
					
			aux = String.valueOf(schedule.getEndWeek().get(Calendar.HOUR));
			if(aux.equals("0"))
				aux = "12";
			if(aux.length() == 1)
				text += "0" + aux + ":";
			else
				text += aux + ":";
			
			aux = String.valueOf(schedule.getEndWeek().get(Calendar.MINUTE));
			if(aux.length() == 1)
				text += "0" + aux;
			else
				text += aux;
			
			if(schedule.getEndWeek().get(Calendar.AM_PM) == Calendar.AM)
				text += " AM";
			else
				text += " PM";
		}
		else
			text = "No disponibilidad";
		
		return text;
	}
	
	public String getWeekendScheduleLabel(){
		String text = "";
		
		if(schedule.getInitWeekend() != null){		
			switch(schedule.getInitWeekend().get(Calendar.DAY_OF_WEEK)){
			case Calendar.SATURDAY:
				text += "Sabado - ";
				break;
			case Calendar.SUNDAY:
				text += "Domingo - ";
				break;
			}
			
			switch(schedule.getEndWeekend().get(Calendar.DAY_OF_WEEK)){
			case Calendar.SATURDAY:
				text += "Sabado";
				break;
			case Calendar.SUNDAY:
				text += "Domingo";
				break;
			}
		}
		else
			text = "Fin de semana";
		
		return text;
	}
	public String getWeekendSchedule(){
		String text = "";
		String aux = null;
		
		if(schedule.getInitWeekend() != null){		
			aux = String.valueOf(schedule.getInitWeekend().get(Calendar.HOUR));
			if(aux.equals("0"))
				aux = "12";
			if(aux.length() == 1)
				text += "0" + aux + ":";
			else
				text += aux + ":";
			
			aux = String.valueOf(schedule.getInitWeekend().get(Calendar.MINUTE));
			if(aux.length() == 1)
				text += "0" + aux;
			else
				text += aux;
			
			if(schedule.getInitWeekend().get(Calendar.AM_PM) == Calendar.AM)
				text += " AM";
			else
				text += " PM";
			
			text += " - ";
			
			aux = String.valueOf(schedule.getEndWeekend().get(Calendar.HOUR));
			if(aux.equals("0"))
				aux = "12";
			if(aux.length() == 1)
				text += "0" + aux + ":";
			else
				text += aux + ":";
			
			aux = String.valueOf(schedule.getEndWeekend().get(Calendar.MINUTE));
			if(aux.length() == 1)
				text += "0" + aux;
			else
				text += aux;
			
			if(schedule.getEndWeekend().get(Calendar.AM_PM) == Calendar.AM)
				text += " AM";
			else
				text += " PM";
		}
		else
			text = "No disponibilidad";
		
		return text;
	}
	
//--Interface--
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public void setType(TypeRule type){
		this.type = type;
	}
	public TypeRule getType(){
		return type;
	}

//--Interface to authorized--
	public boolean existPerson(String ci){
		int index = 0;
		
		while(index < authorized.size() && !ci.equalsIgnoreCase(authorized.get(index).getCI()))
			index++;
		
		return index < authorized.size() ? true : false;
	}
	public int addPerson(Person person) throws DuplicityException{
		return authorized.addByInsertion(person);
	}
	public Person removePerson(String ci) throws DontExistException{
		return authorized.removeByCI(ci);
	}
	public Person removePerson(int id) throws DontExistException{
		return authorized.removeByID(id);
	}
	public Person removePersonByIndex(int index){
		return CEIS.inRange(index, 0, authorized.size()) ? authorized.remove(index) : null;
	}
	public Person getPerson(int index){
		return CEIS.inRange(index, 0, authorized.size()) ? authorized.get(index) : null;
	}
	public ArrayList<StudentAssistant> getStudents(){
		return authorized.getStudents();
	}
	public ArrayList<Docent> getDocents(){
		return authorized.getDocents();
	}
	public ArrayList<TecnicAdmin> getTecnicAdmins(){
		return authorized.getTecnicAdmins();
	}
	public ArrayList<Visitor> getVisitors(){
		return authorized.getVisitors();
	}
	public String[][] getDocentArrayData(){
		return authorized.getDocentArrayData();
	}
	public String[][] getStudentArrayData(){
		return authorized.getStudentArrayData();
	}
	public String[][] getTecnicAdminArrayData(){
		return authorized.getTecnicAdminArrayData();
	}
	public String[][] getVisitorDataArray(){
		return authorized.getVisitorDataArray();
	}
	
//--Auxiliary methods--
	
	public String toString(){
		return name;
	}

	public PersonCollection getAuthorized() {
		return authorized;
	}

	public void setAuthorized(PersonCollection authorized) {
		this.authorized = authorized;
	}
}