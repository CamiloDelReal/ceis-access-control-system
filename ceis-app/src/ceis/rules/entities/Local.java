package ceis.rules.entities;

import java.util.ArrayList;

import ceis.collection.RegisteredCollection;
import ceis.person.Registered;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import ceis.rules.RulesCollection;
import exception.DuplicityException;


public class Local extends RulesEntities{
	private String name;
	private RegisteredCollection workers;
	private Key key;
	
	public Local(RulesCollection accessRules, String name, RegisteredCollection workers, Key key){
		super(accessRules);
		this.name = name;
		if(workers != null)
			this.workers = workers;
		else
			this.workers = new RegisteredCollection();
		this.key = key;
	}
	
//--Interface--
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	
	public void setKey(Key key){
		this.key = key;
	}
	public Key getKey(){
		return key;
	}
	
//--Interface to RegisteredCollection--
	public int findRegistered(String ci){
		int k = workers.find(ci);
		return k;
	}
	
	public void addWorker(Registered reg){
		workers.add(reg);
	}
	
	public void setWorkers(RegisteredCollection workers){
		this.workers = workers;
	}
	
	public RegisteredCollection getRegistereds(){
		return workers;
	}
	public Registered getRegistered(int index){
		return workers.get(index);
	}
	
	public int findRegistered(int id){
		return workers.find(id);
	}
	
	public Registered removeRegistered(int id){
		return workers.removeReg(id);
	}
	
	public Registered removeRegisteredByIndex(int index){
		return workers.remove(index);
	}
	
	public StudentAssistant findStudent(int id){
		return workers.findStudent(id);
	}
	
	public Docent findDocent(int id){
		return workers.findDocent(id);
	}
	
	public TecnicAdmin findTecAd(int id){
		return workers.findTecAd(id);
	}
	
	public int addByInsertion(Registered reg) throws DuplicityException{
		return workers.addByInsertion(reg);
	}
	
	public ArrayList<StudentAssistant> getStudents(){
		return workers.getStudents();
	}
	
	public ArrayList<Docent> getDocents(){
		return workers.getDocents();
	}
	
	public ArrayList<TecnicAdmin> getTecnicAdmins(){
		return workers.getTecnicAdmins();
	}
	
	public String[][] getDocentArrayData(){
		return workers.getDocentArrayData();
	}
	
	public String[][] getStudentArrayData(){
		return workers.getStudentArrayData();
	}
	
	public String[][] getTecnicAdminArrayData(){
		return workers.getTecnicAdminArrayData();
	}
	
//--Auxiliary methods--
	
	public String toString(){
		return name;
	}
}