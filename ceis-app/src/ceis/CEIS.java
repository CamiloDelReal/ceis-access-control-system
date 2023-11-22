package ceis;

import java.util.ArrayList;
import java.util.Calendar;

import ceis.collection.ControlCollection;
import ceis.collection.PersonCollection;
import ceis.collection.RegisteredCollection;
import ceis.collection.RulesEntitiesCollection;
import ceis.control.Control;
import ceis.control.entities.KeyRequest;
import ceis.control.entities.LocalAccess;
import ceis.control.scheme.Scheme;
import ceis.person.Person;
import ceis.person.Registered;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import ceis.rules.entities.Key;
import ceis.rules.entities.Local;
import ceis.rules.entities.RulesEntities;
import exception.DontExistException;
import exception.DuplicityException;

public class CEIS {
	//Patron Singleton
	private static CEIS ceis = null;
	
	private PersonCollection persons;
	private ControlCollection controls;
	private RulesEntitiesCollection rulesEntities;
	
	public static CEIS getInstance(){
		if(ceis == null)
			ceis = new CEIS();
		
		return ceis;
	}
	
	private CEIS(){
		persons = new PersonCollection();
		controls = new ControlCollection();
		rulesEntities = new RulesEntitiesCollection();
	}
	
	
//--Interface to PersonCollection--
	public int exist(String ci){
		return persons.exist(ci);
	}	
	public int exist(int id){
		return persons.exist(id);
	}
	public Person find(String ci){
		return persons.find(ci);
	}
	public Person find(int id){
		return persons.find(id);
	}
	public int addPerson(Person person) throws DuplicityException{
		return persons.addByInsertion(person);
	}
	public int addVisitor(String ci, String name, String lastName, Calendar entryDate) throws DuplicityException{
		Visitor person = new Visitor(ci, name, lastName, entryDate);
		return persons.addByInsertion(person);
	}
	public int addStudent(String ci, String name, String lastName, int id, String address, 
	  		String phone, String pictureString, String project,
	  		Docent tutor) throws DuplicityException{
		StudentAssistant person = new StudentAssistant(ci, name, lastName, id, address, phone, pictureString, project, tutor);
		return persons.addByInsertion(person);
	}
	public int addDocent(String ci, String name, String lastName, int id, 
			  	  String address, String phone, String pictureString,
			  	  String charge, String category) throws DuplicityException{
		Docent person = new Docent(ci, name, lastName, id, address, phone, pictureString, charge, category);
		return persons.addByInsertion(person);
	}
	public int addTecnicAdmin(String ci, String name, String lastName, int id, 
			  	  String address, String phone, String pictureString,
			  	  String charge, String department) throws DuplicityException{
		TecnicAdmin person = new TecnicAdmin(ci, name, lastName, id, address, phone, pictureString, charge, department);
		return persons.addByInsertion(person);
	}
	public Person removePerson(String ci) throws DontExistException{
		return persons.removeByCI(ci);
	}
	public Person removePerson(int id) throws DontExistException{
		return persons.removeByID(id);
	}
	public Person removePersonByIndex(int index){
		return inRange(index, 0, persons.size()) ? persons.remove(index) : null;
	}
	public Person getPerson(int index){
		return inRange(index, 0, persons.size()) ? persons.get(index) : null;
	}
	public PersonCollection getPersons(){
		return persons;
	}
	public ArrayList<StudentAssistant> getStudents(){
		return persons.getStudents();
	}
	public ArrayList<Docent> getDocents(){
		return persons.getDocents();
	}
	public ArrayList<TecnicAdmin> getTecnicAdmins(){
		return persons.getTecnicAdmins();
	}
	public RegisteredCollection getRegistered(){
		return persons.getRegistered();
	}
	public ArrayList<Visitor> getVisitors(){
		return persons.getVisitors();
	}
	public String[][] getDocentArrayData(){
		return persons.getDocentArrayData();
	}
	public String[][] getStudentArrayData(){
		return persons.getStudentArrayData();
	}
	public String[][] getTecnicAdminArrayData(){
		return persons.getTecnicAdminArrayData();
	}
	public String[][] getVisitorDataArray(){
		return persons.getVisitorDataArray();
	}
	public StudentAssistant findStudent(int id){
		return persons.findStudent(id);
	}
	public Docent findDocent(int id){
		return persons.findDocent(id);
	}
	public TecnicAdmin findTecAd(int id){
		return persons.findTecAd(id);
	}
	public Visitor findVisitor(String ci){
		return persons.findVisitor(ci);
	}
	
//--Interface to ControlCollection--
	public boolean addControl(Control control){
		return controls.add(control);
	}
	public Control getControl(int index){
		return controls.get(index);
	}
	public ControlCollection getControls(){
		return controls;
	}
	public Control removeControl(int index){
		return controls.remove(index);
	}
	
	public ArrayList<Scheme> getSchemes(){
		return controls.getSchemes();
	}

	public ArrayList<Scheme> getSchemesByDocent(){
		return controls.getSchemesByDocent();
	}
	public ArrayList<Scheme> getSchemesByStudent(){
		return controls.getSchemesByStudent();
	}
	public ArrayList<Scheme> getSchemesByTecnicAdmin(){
		return controls.getSchemesByTecnicAdmin();
	}
	public ArrayList<Scheme> getSchemesByVisitor(){
		return controls.getSchemesByVisitor();
	}
	public ArrayList<Scheme> getSchemeByAccess(){
		return controls.getSchemeByAccess();
	}
	public ArrayList<Scheme> getSchemeByKeyRequest(){
		return controls.getSchemeByKeyRequest();
	}
	
	public ArrayList<LocalAccess> getLocalsAccess(){
		return controls.getLocalsAccess();
	}
	public ArrayList<LocalAccess> getLocalsAccessDocent(){
		return controls.getLocalsAccessDocent();
	}
	public ArrayList<LocalAccess> getLocalsAccessStudent(){
		return controls.getLocalsAccessStudent();
	}
	public ArrayList<LocalAccess> getLocalsAccessTecnisAdmin(){
		return controls.getLocalsAccessTecnisAdmin();
	}
	public ArrayList<LocalAccess> getLocalsAccessVisitor(){
		return controls.getLocalsAccessVisitor();
	}
	
	public ArrayList<KeyRequest> getKeyRequested(){
		return controls.getKeyRequested();
	}
	public ArrayList<KeyRequest> getKeyRequestedDocent(){
		return controls.getKeyRequestedDocent();
	}
	public ArrayList<KeyRequest> getKeyRequestedStudent(){
		return controls.getKeyRequestedStudent();
	}
	public ArrayList<KeyRequest> getKeyRequestedTecnicAdmin(){
		return controls.getKeyRequestedTecnicAdmin();
	}
	public ArrayList<KeyRequest> getKeyRequestedVisitor(){
		return controls.getKeyRequestedVisitor();
	}
	
	public ArrayList<Control> getControlByPerson(String name){
		return controls.getControlByPerson(name);
	}
	
	public boolean isInsideInSomeLocal(String ci){
		return controls.isInsideInSomeLocal(ci);
	}
	
	public boolean haveKey(String ci){
		return controls.haveKey(ci);
	}
//--Interface to RulesEntitiesCollection--
	public boolean addRuleEntity(RulesEntities ruleEntity){
		return rulesEntities.add(ruleEntity);
	}
	public RulesEntities getRuleEntity(int index){
		return rulesEntities.get(index);
	}
	public RulesEntities removeRuleEntity(int index){
		return rulesEntities.remove(index);
	}
	
	public ArrayList<Local> getLocals(){
		return rulesEntities.getLocals();
	}
	
	public ArrayList<Key> getKeys(){
		return rulesEntities.getKeys();
	}
	
	public Local findLocal(String name){
		return rulesEntities.findLocal(name);
	}
	
	public Key findKey(String localName){
		return rulesEntities.findKey(localName);
	}
	
	public int existLocal(String name){
		return rulesEntities.existLocal(name);
	}
	
	public int existKey(String localName){
		return rulesEntities.existKey(localName);
	}
	
	public RulesEntitiesCollection getRulesEntities(){
		return rulesEntities;
	}
	
//--Reports--
	public ControlCollection findAccessWorker(Calendar init, Calendar end){
		return controls.findAccessWorker(init, end);
	}
	public ControlCollection findVisit(Calendar init, Calendar end){
		return controls.findVisit(init, end);
	}
	public ControlCollection findRequest(Calendar init, Calendar end){
		return controls.findRequest(init, end);
	}
	public ControlCollection findDelivery(Calendar init, Calendar end){
		return controls.findDelivery(init, end);
	}
	public Registered findPossessionOfKey(Key key){
		return controls.findPossessionOfKey(key);
	}
	public Docent docentWithMoreRequestKey(Calendar init, Calendar end, Key key){
		return controls.docentWithMoreRequestKey(init, end, key);
	}
	
	public PersonCollection findPersonalByName(String name){
		return persons.findPersonalByName(name);
	}
//--Auxiliary methods--
	public static boolean inRange(int index, int init, int max){
		return (index >= init && index < max) ? true : false;
	}
		
}
