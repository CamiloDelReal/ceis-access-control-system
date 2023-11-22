package main;

import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.jdesktop.swingx.plaf.nimbus.NimbusLookAndFeel;

import visual.MainFrame;
import ceis.CEIS;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import exception.DuplicityException;

public class Main{
	public static void main(String []args){
		Runnable runner = new Runnable(){
			public void run(){
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
				}catch(Exception e1){
					try{
						UIManager.setLookAndFeel(new NimbusLookAndFeel());
					}catch(Exception e2){
						JOptionPane.showMessageDialog(null, "No se ha podido encontrar el Look'n Feel Nimbus.\n" +
								"La aplicaci�n se ejecutar� con el Look'n Feel por defecto");
					}
				}
				fillData();
				MainFrame frame = new MainFrame();
				frame.setVisible(true);
			}
		};
		
		SwingUtilities.invokeLater(runner);
	}
	
	private static void fillData(){
		CEIS ceis = CEIS.getInstance();
		
		
		//Insertanto Docentes
		try{
			Docent doc = new Docent(
					"82457896325", "Alejandro", "Murcielago de la China", 45789,
					"Palacios #53 % Fernendina y Caucaso, Cerro", "1548795", "avatars/img13.png",
					"Jefe de Catedra", "Profesor Titular"
					);
			ceis.addPerson(doc);
			doc = new Docent(
					"52020754879", "Jose Ricardo", "del Real Hernandez", 14586,
					"Toore #2 % Route y Techo, Marianao", "3456217", "avatars/img9.png",
					"Rector", "Profesor Titular"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"32548759865", "Juana", "Martell Rosales", 58256,
					"Calle 32 #21 % 45 y 47, Vedado", "4567324", "avatars/img22.png",
					"Vicedecano docente", "Master en Ciencias Informaticcas"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"45789561254", "Maria", "Garcia Garcia", 25489,
					"Santa Juane #1 % Primalles y Mayia, Cerro", "7643562", "avatars/img23.png",
					"Vicedecano segundo", "Doctora en Ciencias Informaticcas"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"36598547812", "Ignacio", "Freu Hernandez", 11245,
					"Palatino #209 % Via Blanca y Pocitos, Alta Habana", "8734098", "avatars/img26.png",
					"Jefe GRIAL", "Doctor en Ciencias Informaticcas"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"45879865544", "Aleida", "Perez Diaz", 78965,
					"Lawton #5674 % Concepcion y San Francisco, Diez de Octubre", "3455647", "avatars/img24.png",
					"Jefe COREMAI", "Master en Ciencias Informaticcas"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"68548751245", "Osvaldo", "de la Rosa Amarilla", 35681,
					"Cuadrado #4 % Rectangulo y Circunferencia, Geometria", "5687324", "avatars/img21.png",
					"Jefe SIGENU", "Master en Ciencias Informaticcas"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"79548751245", "Federica", "Ceruto Valdes", 52014,
					"Arbol #289 % Planta y Pinito, Bosque", "8754326", "avatars/img15.png",
					"Jefe de Catedra", "Profesor Titular"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"75487589652", "Pedro", "Mendez Garcia", 78901,
					"Jeringuilla #123 % Estetoscopio y Bandeja, Hospital", "9854763", "avatars/img19.png",
					"Jefe de Docentes", "Licenciado"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"82457895615", "Mariela", "Martell Vivez", 24056,
					"Bocinas #908 % Monitor y Ventilador, Mesa", "7845620", "avatars/img23.png",
					"Vicerrector", "Profesor Titular"
			);
			ceis.addPerson(doc);
			doc = new Docent(
					"74584587625", "Juana de Arco", "de la Villa Europea", 10245,
					"Churre #9999 % Dedos y Teclado, Mesa", "6675839", "avatars/img22.png",
					"Jefe de Catedra", "Master en Ciencias Informaticcas"
			);	
			
			
			//Insertando Estudiantes Ayudantes
			ArrayList<Docent> aux = ceis.getDocents();
			
			StudentAssistant stu = new StudentAssistant(
					"91100228189", "Camilo Jos�", "del Real Martell", 45782,
					"Armas 976 apto #20 % Santa Catalina y San Mariano, Diez de Octubre", "6993800",
					"avatars/img10.png", "COREMAI", aux.get(0)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"91112763457", "Oscar", "Vildosola Valdez", 45126,
					"Concepcion #234 % Octava y Novena, Diez de Octubre", "6984590",
					"avatars/img4.png", "COREMAI", aux.get(6)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"91100254871", "Amauri", "Montoya Carbo", 25486,
					"Armas #45 % Concepcion y Dolores, Diez de Octubre", "6995210",
					"avatars/img1.png", "SIGENU", aux.get(2)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"92548612543", "Adrian", "Gonzalez Pedrera", 98542,
					"Oxford #890 % Palo seco & Maya, Vedado", "",
					"avatars/img8.png", "GREU", aux.get(0)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"98542153687", "Gustavo", "de la Caridad Sotolongo", 78451,
					"Valle #23 % 34 y 36, Songo la Maya", "5987421",
					"avatars/img3.png", "GRIAL", aux.get(5)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"84562154879", "Alfonso Maria", "Fernandez Rosales", 78459,
					"Porvenir #89 % Lawton y San Lazaro, Cerro", "",
					"avatars/img12.png", "SIGENU", aux.get(2)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"98744512633", "Yam", "Sordo Martell", 45872,
					"San indalecio #130 % Agua Dulce y Serafines, Cerro", "2045271",
					"avatars/img5.png", "COREMAI", aux.get(1)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"96854879212", "Mercedes", "Martell Diaz", 15489,
					"Cuadra #78 apto 1 % Poza y Circulo, Geometria", "",
					"avatars/img7.png", "SIGENU", aux.get(0)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"94581623598", "Argelia", "Diaz Navarro", 25479,
					"Circulo #4 % Rectangulo y Circunferencia, Geometria", "4578956",
					"avatars/img11.png", "GREU", aux.get(8)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"86524536598", "Maria", "Alvarez Padron", 98597,
					"Calle 23 #90 % M y L, Vedado", "",
					"avatars/img15.png", "GRIAL", aux.get(2)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"89542158694", "Liza Maria", "Cardenas Tolomeda", 78495,
					"Infanta #45 % Flores y Maraca, Alta Habana", "4578956",
					"avatars/img16.png", "COREMAI", aux.get(8)
					);
			ceis.addPerson(stu);
			stu = new StudentAssistant(
					"88541253658", "Carla", "Rosales Perez", 10245,
					"Infanta #4 % Perico y Cotorra, Vedado", "2154896",
					"avatars/img17.png", "SIGENU", aux.get(2)
					);
			ceis.addPerson(stu);
			
			//Insertando Tecnicos Administrativos
			TecnicAdmin tad = new TecnicAdmin(
					"54879653258", "Juana", "de la Caridad", 40789,
					"Mayia #34a % Santa Catalina y San Mariano", "5487596", "avatars/img31.png",
					"Jefe Administrativo", "Administracion"
					);
			ceis.addPerson(tad);
			
			tad = new TecnicAdmin(
					"15487895625", "Mario", "Alfonso Marquez", 25874,
					"Balsa #90 apto 1 % Rosal y Palomilla", "2045896", "src/icons/unknown_user.png",
					"Jefe de Tecnicos", "Lab 5"
					);
			ceis.addPerson(tad);
			
			tad = new TecnicAdmin(
					"32659878451", "Wilford", "Rosette Valdez", 10489,
					"Calle 34 #6 % San Anastasio y Perla", "2548956", "src/icons/unknown_user.png",
					"Vicedecano", "Decanato"
					);
			ceis.addPerson(tad);
			
			tad = new TecnicAdmin(
					"15485926359", "Elaine", "Parez Casta�a", 48596,
					"Porvenir #190 % Concepcion y San Francisco", "2514578", "avatars/img32.png",
					"Decana", "Decanato"
					);
			ceis.addPerson(tad);
			
			tad = new TecnicAdmin(
					"26594878551", "Tania", "Concepcion Valdes", 36958,
					"Vega #3 % Hoja Verde y Hoja Roja", "2356897", "avatars/img33.png",
					"Encargada de secretarias", "Secretaria"
					);
			ceis.addPerson(tad);
			
			tad = new TecnicAdmin(
					"36958425187", "Maria", "Diaz Gonzalez", 36598,
					"Terciopelo #97 apto 4 % Algodon y Poliester", "1245796", "avatars/img34.png",
					"Encargada de limpieza", "Secretaria"
					);
			ceis.addPerson(tad);
			
			tad = new TecnicAdmin(
					"15487956892", "Alain", "Galan Lopez", 70495,
					"Fuente #34 % Chasis y Upperfan", "3698520", "src/icons/unknown_user.png",
					"Vicedecano docente", "Decanato"
					);
			ceis.addPerson(tad);
			
			tad = new TecnicAdmin(
					"26195487325", "Coralina", "del Azul Mar", 59480,
					"Perla #901 % Concha1 y Concha2", "2154876", "avatars/img35.png",
					"Vicedecana", "Secretaria"
					);
			ceis.addPerson(tad);
			
			
			
			
			//Insertando visitantes
			Calendar cal = Calendar.getInstance();
			Visitor vit = new Visitor(
					"15487589653", "Federico", "Garcia Navarro", cal
					);
			ceis.addPerson(vit);
			
			cal = Calendar.getInstance();
			vit = new Visitor(
					"85458965215", "Elpidio", "Valdez", cal
					);
			ceis.addPerson(vit);
			
		}
		catch(DuplicityException ex){
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	
}