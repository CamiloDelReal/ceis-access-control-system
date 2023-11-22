package visual.show.report.util;

import ceis.person.registered.worker.Docent;

public class DataReport {
	private Docent docent;
	private int count;
	
	public DataReport(Docent docent, int count){
		this.docent = docent;
		this.count = count;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void updateCount(){
		count++;
	}
	
	
	public Docent getDocent() {
		return docent;
	}
	public void setDocent(Docent docent) {
		this.docent = docent;
	}
}
