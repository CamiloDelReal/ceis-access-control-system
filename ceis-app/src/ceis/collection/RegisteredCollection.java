package ceis.collection;

import java.util.ArrayList;

import ceis.person.Registered;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import exception.DuplicityException;


public class RegisteredCollection extends ArrayList<Registered> {
	private static final long serialVersionUID = 0L;

	public RegisteredCollection(){
		super();
	}
	public RegisteredCollection(int capacity){
		super(capacity);
	}
	
	public int find(String ci){
		int i = 0;
		
		while(i < size() && !ci.equalsIgnoreCase(get(i).getCI()))
			i++;
		
		return i < size() ? i : -1;
	}
	
	public int find(int id){
		int i = 0;
		
		while(i < size() && id != get(i).getID())
			i++;
		
		return i < size() ? i : -1;
	}
	
	public Registered removeReg(int id){
		int index = 0;
		
		while(index < size() && id != get(index).getID())
			index++;

		return index < size() ? remove(index) : null;
	}
	
	public StudentAssistant findStudent(int id){
		ArrayList<StudentAssistant> list = getStudents();
		
		int i = 0;
		while(i < list.size() && id != list.get(i).getID())
			i++;
		
		return i < list.size() ? list.get(i) : null;
	}
	
	public Docent findDocent(int id){
		ArrayList<Docent> list = getDocents();
		
		int i = 0;
		while(i < list.size() && id != list.get(i).getID())
			i++;
		
		return i < list.size() ? list.get(i) : null;
	}
	
	public TecnicAdmin findTecAd(int id){
		ArrayList<TecnicAdmin> list = getTecnicAdmins();
		
		int i = 0;
		while(i < list.size() && id != list.get(i).getID())
			i++;
		
		return i < list.size() ? list.get(i) : null;
	}
	
	public int addByInsertion(Registered reg) throws DuplicityException{
		int index = 0;
		if(find(reg.getCI()) != -1)
			throw new DuplicityException("Existe duplicidad en los datos\nCI: " + reg.getCI() +" ya existe en los registros");
		if(find(reg.getID()) != -1)
			throw new DuplicityException("Existe duplicidad en los datos\nID: " + reg.getID() +" ya existe en los registros");
		
		if(size() == 0)
			add(reg);
		else{
			while(index < size() && reg.getCI().compareTo(get(index).getCI()) > 0)
				index++;
			add(index, reg);
		}
		
		return index;
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
	
	
}
