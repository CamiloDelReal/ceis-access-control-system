package ceis.rules.util;

import java.util.Calendar;

public class Schedule{
	private Calendar initWeek;
	private Calendar endWeek;
	private Calendar initWeekend;
	private Calendar endWeekend;
	
//--Constructor--
	public Schedule(Calendar initWeek, Calendar endWeek, Calendar initWeekend, Calendar endWeekend){
		this.initWeek = initWeek;
		this.endWeek = endWeek;
		this.initWeekend = initWeekend;
		this.endWeekend = endWeekend;
	}
	
//--Interface--
	public void setInitWeek(Calendar initWeek){
		this.initWeek = initWeek;
	}
	public Calendar getInitWeek(){
		return initWeek;
	}
	
	public void setEndWeek(Calendar endWeek){
		this.endWeek = endWeek;
	}
	public Calendar getEndWeek(){
		return endWeek;
	}
	
	public void setInitWeekend(Calendar initWeekend){
		this.initWeekend = initWeekend;
	}
	public Calendar getInitWeekend(){
		return initWeekend;
	}
	
	public void setEndWeekend(Calendar endWeekend){
		this.endWeekend = endWeekend;
	}
	public Calendar getEndWeekend(){
		return endWeekend;
	}
}