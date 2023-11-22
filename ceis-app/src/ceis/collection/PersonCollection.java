package ceis.collection;

import java.util.ArrayList;

import visual.util.GraphicSupport;
import ceis.person.Person;
import ceis.person.Registered;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import exception.DontExistException;
import exception.DuplicityException;

public class PersonCollection extends ArrayList<Person> {
	private static final long serialVersionUID = 0L;

	public PersonCollection(){
		super();
	}
	public PersonCollection(int capacity){
		super(capacity);
	}
	
	public int exist(String ci){
		int index = 0;
		
		while(index < size() && !ci.equalsIgnoreCase(get(index).getCI()))
			index++;
		
		return index < size() ? index : -1;
	}
	
	public int exist(int id){
		int index = 0;
		boolean flag = false;
		
		while(index < size() && !flag)
			if(get(index) instanceof Registered && id == ((Registered)get(index)).getID())
				flag = true;
			else
				index++;
		
		return flag ? index : -1;
	}
	
	public Person find(String ci){
		int index = exist(ci);
		return index != -1 ? get(index) : null;
	}
	
	public Person find(int id){
		int index = 0;
		ArrayList<Registered> regs = getRegistered();
		
		if(regs != null)
			while(index < regs.size() && id != regs.get(index).getID())
				index++;
		
		return regs != null && index <regs.size() ? regs.get(index) : null;
	}
	
	public int addByInsertion(Person person) throws DuplicityException{
		int index = 0;
		if(exist(person.getCI()) != -1)
			throw new DuplicityException("Existe duplicidad en los datos\nCI: " + person.getCI() +" ya existe en los registros");
		if(person instanceof Registered && exist(((Registered)person).getID()) != -1)
			throw new DuplicityException("Existe duplicidad en los datos\nID: " + ((Registered)person).getID() +" ya existe en los registros");
		
		if(size() == 0)
			add(person);
		else{
			while(index < size() && person.getCI().compareTo(get(index).getCI()) > 0)
				index++;
			add(index, person);
		}
		
		return index;
	}
	
	public Person removeByCI(String ci) throws DontExistException{
		int index = exist(ci);
		
		if(index == -1)
			throw new DontExistException("En el personal registrado no existe nadie \ncon la caracteristica CI: "+ci);
		
		return remove(index);
	}
	
	public Person removeByID(int id) throws DontExistException{
		int index = exist(id);
		
		if(index == -1)
			throw new DontExistException("En el personal registrado no existe nadie \ncon la caracteristica ID: "+id);
		
		return remove(index);
	}
	
	public ArrayList<StudentAssistant> getStudents(){
		ArrayList<StudentAssistant> result = new ArrayList<StudentAssistant>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof StudentAssistant)
				result.add((StudentAssistant)get(i));
		
		if(result.size() == 0)
			result = null;
		
		return result;
	}
	
	public ArrayList<Docent> getDocents(){
		ArrayList<Docent> result = new ArrayList<Docent>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Docent)
				result.add((Docent)get(i));
		
		if(result.size() == 0)
			result = null;
		
		return result;
	}
	
	public ArrayList<TecnicAdmin> getTecnicAdmins(){
		ArrayList<TecnicAdmin> result = new ArrayList<TecnicAdmin>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof TecnicAdmin)
				result.add((TecnicAdmin)get(i));
		
		if(result.size() == 0)
			result = null;
		
		return result;
	}
	
	public RegisteredCollection getRegistered(){
		RegisteredCollection registered = new RegisteredCollection();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Registered)
				registered.add((Registered)get(i));
		
		return registered.isEmpty() ? null : registered;
	}
	
	public ArrayList<Visitor> getVisitors(){
		ArrayList<Visitor> result = new ArrayList<Visitor>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Visitor)
				result.add((Visitor)get(i));
		
		if(result.size() == 0)
			result = null;
		
		return result;
	}
	
	public String[][] getDocentArrayData(){
		String[][] matrix = null;
		ArrayList<Docent> aux = getDocents();
		
		if(aux != null){
			matrix = new String[aux.size()][];
			for(int i = 0; i < aux.size(); i++){
				matrix[i] = new String[2];
				matrix[i][0] = String.valueOf(aux.get(i).getID());
				matrix[i][1] = aux.get(i).toString();
			}				
		}
		
		return matrix;
	}
	
	public String[][] getStudentArrayData(){
		String[][] matrix = null;
		ArrayList<StudentAssistant> aux = getStudents();
		
		if(aux != null){
			matrix = new String[aux.size()][];
			for(int i = 0; i < aux.size(); i++){
				matrix[i] = new String[2];
				matrix[i][0] = String.valueOf(aux.get(i).getID());
				matrix[i][1] = aux.get(i).toString();
			}				
		}
		
		return matrix;
	}
	
	public String[][] getTecnicAdminArrayData(){
		String[][] matrix = null;
		ArrayList<TecnicAdmin> aux = getTecnicAdmins();
		
		if(aux != null){
			matrix = new String[aux.size()][];
			for(int i = 0; i < aux.size(); i++){
				matrix[i] = new String[2];
				matrix[i][0] = String.valueOf(aux.get(i).getID());
				matrix[i][1] = aux.get(i).toString();
			}				
		}
		
		return matrix;
	}
	
	public String[][] getVisitorDataArray(){
		String[][] matrix = null;
		ArrayList<Visitor> aux = getVisitors();
		
		if(aux != null && aux.size() > 0){
			matrix = new String[aux.size()][];
			for(int i = 0; i < aux.size(); i++){
				matrix[i] = new String[3];
				matrix[i][0] = aux.get(i).getCI();
				matrix[i][1] = aux.get(i).toString();
				matrix[i][2] = GraphicSupport.getStringEntryDate(aux.get(i).getEntryDate(), true);
			}
		}
		
		return  matrix;
	}
	
	public StudentAssistant findStudent(int id){
		ArrayList<StudentAssistant> list = getStudents();
		
		int i = 0;
		if(list != null)
			while(i < list.size() && id != list.get(i).getID())
				i++;
		
		return list != null && i < list.size() ? list.get(i) : null;
	}
	
	public Docent findDocent(int id){
		ArrayList<Docent> list = getDocents();
		
		int i = 0;
		if(list != null)
			while(i < list.size() && id != list.get(i).getID())
				i++;
		
		return list != null && i < list.size() ? list.get(i) : null;
	}
	
	public TecnicAdmin findTecAd(int id){
		ArrayList<TecnicAdmin> list = getTecnicAdmins();
		
		int i = 0;
		if(list != null)
			while(i < list.size() && id != list.get(i).getID())
				i++;
		
		return list != null && i < list.size() ? list.get(i) : null;
	}
	
	public Visitor findVisitor(String ci){
		ArrayList<Visitor> visitors = getVisitors();
		
		int i = 0;
		if(visitors != null)
			while(i < visitors.size() && !ci.equalsIgnoreCase(visitors.get(i).getCI()))
				i++;
		
		return visitors != null && i < visitors.size() ? visitors.get(i) : null;
	}
	
	public PersonCollection findPersonalByName(String name){
		PersonCollection result = new PersonCollection();
		String aux = null;
		name = name.toLowerCase();
		
		for(int i = 0; i < size(); i++){
			aux = get(i).toString().toLowerCase();
			if(aux.contains(name))
				result.add(get(i));
		}
		
		return result.isEmpty() ? null	: result;
	}
}
