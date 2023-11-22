package test;

import java.util.Calendar;

import ceis.rules.RulesCollection;

import junit.framework.TestCase;

public class CompareTestCase extends TestCase {
	private Calendar init;
	private Calendar end;
	private Calendar check;

	public void setUp(){
		try {
			super.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init = Calendar.getInstance();
		init.add(Calendar.DAY_OF_WEEK, -2);
		
		end = Calendar.getInstance();
		end.add(Calendar.DAY_OF_WEEK, 2);
		
		check = Calendar.getInstance();
		check.add(Calendar.DAY_OF_WEEK, -3);
	}
	
	public void testCompareDateByDayOfWeekAndTime(){
		assertFalse(RulesCollection.compareDateByDayOfWeekAndTime(check, init, end, false));
	}
	
	public void tearDown(){
		try {
			super.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init = null;
		check = null;
		end = null;
	}
}
