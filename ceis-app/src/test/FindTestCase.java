package test;

import ceis.CEIS;
import ceis.person.registered.worker.Docent;
import exception.DuplicityException;
import junit.framework.TestCase;

public class FindTestCase extends TestCase {	
	private Docent doc;
	public void setUp(){
		try {
			super.setUp();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CEIS ceis = CEIS.getInstance();
		try{
			doc = new Docent(
					"82457896325", "Alejandro", "Murcielago de la China", 45789,
					"Palacios #53 % Fernendina y Caucaso, Cerro", "1548795", "para_ejemplo/img13.png",
					"Jefe de Catedra", "Profesor Titular"
					);
			ceis.addPerson(doc);
			doc = new Docent(
					"36598547812", "Ignacio", "Freu Hernandez", 11245,
					"Palatino #209 % Via Blanca y Pocitos, Alta Habana", "8734098", "para_ejemplo/img26.png",
					"Jefe GRIAL", "Doctor en Ciencias Informaticcas"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"45879865544", "Aleida", "Perez Diaz", 78965,
					"Lawton #5674 % Concepcion y San Francisco, Diez de Octubre", "3455647", "para_ejemplo/img24.png",
					"Jefe COREMAI", "Master en Ciencias Informaticcas"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"52020754879", "Jose Ricardo", "del Real Hernandez", 14586,
					"Toore #2 % Route y Techo, Marianao", "3456217", "para_ejemplo/img9.png",
					"Rector", "Profesor Titular"
			);
			ceis.addPerson(doc);
		}
		catch(DuplicityException e){
			e.printStackTrace();
		}
	}
	
	public void testFind(){
		assertEquals(CEIS.getInstance().find("52020754879"), doc);
	}
	
	
	public void tearDown(){
		try {
			super.tearDown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i < CEIS.getInstance().getDocents().size(); i++)
			CEIS.getInstance().getDocents().remove(i);
	}
}
