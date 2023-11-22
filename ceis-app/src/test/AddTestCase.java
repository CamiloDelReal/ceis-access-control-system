package test;

import java.util.ArrayList;
import java.util.Calendar;

import junit.framework.TestCase;
import ceis.CEIS;
import ceis.person.Person;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import exception.DuplicityException;

public class AddTestCase extends TestCase {
	private ArrayList<Person> persons;
	
	public void setUp(){
		try {
			super.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		persons = new ArrayList<Person>();
		CEIS ceis = CEIS.getInstance();
		try{
			Docent doc = new Docent(
					"82457896325", "Alejandro", "Murcielago de la China", 45789,
					"Palacios #53 % Fernendina y Caucaso, Cerro", "1548795", "para_ejemplo/img13.png",
					"Jefe de Catedra", "Profesor Titular"
					);
			ceis.addPerson(doc);
			persons.add(doc);
			
			StudentAssistant stu = new StudentAssistant(
					"91100228189", "Camilo José", "del Real Martell", 45782,
					"Armas 976 apto #20 % Santa Catalina y San Mariano, Diez de Octubre", "6993800",
					"para_ejemplo/img10.png", "COREMAI", doc
					);
			ceis.addPerson(stu);
			persons.add(stu);
			TecnicAdmin tad = new TecnicAdmin(
					"54879653258", "Juana", "de la Caridad", 40789,
					"Mayia #34a % Santa Catalina y San Mariano", "5487596", "para_ejemplo/img31.png",
					"Jefe Administrativo", "Administracion"
					);
			ceis.addPerson(tad);
			persons.add(0, tad);
			Visitor vit = new Visitor(
					"15487589653", "Federico", "Garcia Navarro", Calendar.getInstance()
					);
			ceis.addPerson(vit);
			persons.add(0, vit);

		}
		catch(DuplicityException e){
			e.printStackTrace();
		}
	}
	
	public void testAddByInsertion(){
		for(int i = 0; i < persons.size(); i++)
			assertEquals(persons.get(i), CEIS.getInstance().getPersons().get(i));
	}
	
	public void tearDown(){
		try {
			super.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < persons.size(); i++)
			persons.remove(i);
	}
}
