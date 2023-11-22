package ceis.person.registered;

import ceis.person.Registered;
import ceis.person.registered.worker.Docent;

public class StudentAssistant extends Registered{
	private String project;
	private Docent tutor;
	
//--Constructor--
	public StudentAssistant(String ci, String name, String lastName, int id, String address, 
					  		String phone, String pictureString, String project,
					  		Docent tutor){
		super(ci, name, lastName, id, address, phone, pictureString);
		this.project = project;
		this.tutor = tutor;
	}
	
//--Interface--
	public void setProject(String project){
		this.project = project;
	}
	public String getProject(){
		return project;
	}
	
	public void setTutor(Docent tutor){
		this.tutor = tutor;
	}
	public Docent getTutor(){
		return tutor;
	}
}