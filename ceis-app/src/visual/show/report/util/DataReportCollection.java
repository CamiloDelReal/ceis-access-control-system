package visual.show.report.util;

import java.util.ArrayList;

import ceis.control.entities.KeyRequest;
import ceis.control.scheme.Scheme;
import ceis.person.Registered;
import ceis.person.registered.worker.Docent;

public class DataReportCollection extends ArrayList<DataReport> {
	private static final long serialVersionUID = 1868819226472085855L;

	public int find(int id){
		int index = 0;
		
		while(index < size() && id != get(index).getDocent().getID())
			index++;
		
		return index < size() ? index : -1;
	}
	
	public void addDataReport(KeyRequest request){
		int index = 0;
		if((index = find(((Registered)request.getWho()).getID())) != -1){
			get(index).updateCount();
		}
		else
			add(new DataReport((Docent)request.getWho(), 1));
	}
	
	public void addDataReport(Scheme scheme){
		int index = 0;
		if((index = find(((Registered)scheme.getWho()).getID())) != -1){
			get(index).updateCount();
		}
		else
			add(new DataReport((Docent)scheme.getWho(), 1));
	}
	
	public Docent getWithMoreExtraction(){
		int index = 0;
		
		for(int i = 1; i < size(); i++)
			if(get(index).getCount() < get(i).getCount())
				index = i;
		
		return get(index).getDocent();
	}
}
