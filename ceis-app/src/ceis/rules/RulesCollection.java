package ceis.rules;

import java.util.ArrayList;
import java.util.Calendar;

import ceis.person.Person;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import ceis.rules.entities.Local;
import ceis.rules.util.enumeration.TypeRule;

public class RulesCollection extends ArrayList<Rule> {
	private static final long serialVersionUID = -1979433503462633194L;

	public RulesCollection(){
		super();
	}
	
	public int exist(String name){
		int index = 0;
		
		while(index < size() && !name.equalsIgnoreCase(get(index).getName()))
			index++;
		
		return index < size() ? index : -1;
	}
	
	public Rule find(String name){
		int index = exist(name);
		return index != -1 ? get(index) : null;
	}
	
	public Rule remove(String name){
		int index = exist(name);
		return index != -1 ? remove(index) : null;
	}
	
	public RulesCollection findRulesByPerson(String ci){
		RulesCollection result = new RulesCollection();
		
		for(int i = 0; i < size(); i++)
			if(get(i).existPerson(ci))
				result.add(get(i));
		
		return result.isEmpty() ? null : result;
	}
	
	public boolean isPosibleEntry(Person person, Local local, Calendar date){
		boolean done = false;
		int i = 0;
		
		while(i < size() && !done){			
			if(     get(i).getType() == TypeRule.TO_ALL
				|| (get(i).getType() == TypeRule.TO_WORKER_OF_LOCAL && local.findRegistered(person.getCI()) != -1)
				|| (get(i).getType() == TypeRule.TO_SELECTED_PEOPLE && get(i).existPerson(person.getCI()))
				|| (get(i).getType() == TypeRule.TO_DOCENT && person instanceof Docent)
				|| (get(i).getType() == TypeRule.TO_TECNICADMIN && person instanceof TecnicAdmin)
				|| (get(i).getType() == TypeRule.TO_STUDENTASSISTANT && person instanceof StudentAssistant)
				|| (get(i).getType() == TypeRule.TO_VISITOR && person instanceof Visitor)
				)
				done = true;
			
			if(done){
				if(compareDateByDayOfWeekAndTime(date, get(i).getScheduleInitWeek(), get(i).getScheduleEndWeek(), false)
					|| compareDateByDayOfWeekAndTime(date, get(i).getScheduleInitWeekend(), get(i).getScheduleEndWeekend(), true))
					done = true;
				else
					done = false;
			}
			i++;
		}
		
		return done;
	}
	
	public static boolean compareDateByDayOfWeekAndTime(Calendar check, Calendar init, Calendar end, boolean weekend){
		boolean done = true;
		
		if(init == null || end == null)
			done = false;
		
		if(done && !weekend && init.get(Calendar.DAY_OF_WEEK) <= check.get(Calendar.DAY_OF_WEEK) && check.get(Calendar.DAY_OF_WEEK) <= end.get(Calendar.DAY_OF_WEEK))
			done = true;
		else if(done && weekend && (init.get(Calendar.DAY_OF_WEEK) == check.get(Calendar.DAY_OF_WEEK) || check.get(Calendar.DAY_OF_WEEK) == end.get(Calendar.DAY_OF_WEEK)))
			done = true;
		else
			done = false;
		
		if(done && (
						(init.get(Calendar.HOUR_OF_DAY) < check.get(Calendar.HOUR_OF_DAY) && check.get(Calendar.HOUR_OF_DAY) < end.get(Calendar.HOUR_OF_DAY))
					 || ( (init.get(Calendar.HOUR_OF_DAY) == check.get(Calendar.HOUR_OF_DAY) && init.get(Calendar.MINUTE) <= check.get(Calendar.MINUTE))
						 || (check.get(Calendar.HOUR_OF_DAY) == end.get(Calendar.HOUR_OF_DAY) && check.get(Calendar.MINUTE) <= end.get(Calendar.MINUTE))
					 	 )
				    )				
			)
			done = true;
		else
			done = false;
		
		return done;
	}
}
