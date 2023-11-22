package ceis.collection;

import java.util.ArrayList;
import java.util.Calendar;

import visual.show.report.util.DataReportCollection;
import ceis.control.Control;
import ceis.control.entities.KeyRequest;
import ceis.control.entities.LocalAccess;
import ceis.control.scheme.Scheme;
import ceis.person.Registered;
import ceis.person.Visitor;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.Worker;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;
import ceis.rules.entities.Key;
import ceis.rules.entities.Local;

public class ControlCollection extends ArrayList<Control> {
	private static final long serialVersionUID = 0L;
	
	public ControlCollection(){
		super();
	}
	public ControlCollection(int capacity){
		super(capacity);
	}
	
	public ArrayList<Scheme> getSchemes(){
		ArrayList<Scheme> schemes = new ArrayList<Scheme>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Scheme)
				schemes.add((Scheme)get(i));
		
		return schemes.isEmpty() ? null : schemes;
	}

	public ArrayList<Scheme> getSchemesByDocent(){
		ArrayList<Scheme> schemes = new ArrayList<Scheme>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Scheme && get(i).getWho() instanceof Docent)
				schemes.add((Scheme)get(i));
		
		return schemes.isEmpty() ? null : schemes;
	}
	public ArrayList<Scheme> getSchemesByStudent(){
		ArrayList<Scheme> schemes = new ArrayList<Scheme>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Scheme && get(i).getWho() instanceof StudentAssistant)
				schemes.add((Scheme)get(i));
		
		return schemes.isEmpty() ? null : schemes;
	}
	public ArrayList<Scheme> getSchemesByTecnicAdmin(){
		ArrayList<Scheme> schemes = new ArrayList<Scheme>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Scheme && get(i).getWho() instanceof TecnicAdmin)
				schemes.add((Scheme)get(i));
		
		return schemes.isEmpty() ? null : schemes;
	}
	public ArrayList<Scheme> getSchemesByVisitor(){
		ArrayList<Scheme> schemes = new ArrayList<Scheme>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Scheme && get(i).getWho() instanceof Visitor)
				schemes.add((Scheme)get(i));
		
		return schemes.isEmpty() ? null : schemes;
	}
	public ArrayList<Scheme> getSchemeByAccess(){
		ArrayList<Scheme> schemes = new ArrayList<Scheme>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Scheme && ((Scheme)get(i)).getRulesEntities() instanceof Local)
				schemes.add((Scheme)get(i));
		
		return schemes.isEmpty() ? null : schemes;
	}
	public ArrayList<Scheme> getSchemeByKeyRequest(){
		ArrayList<Scheme> schemes = new ArrayList<Scheme>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Scheme && ((Scheme)get(i)).getRulesEntities() instanceof Key)
				schemes.add((Scheme)get(i));
		
		return schemes.isEmpty() ? null : schemes;
	}
	
	public ArrayList<LocalAccess> getLocalsAccess(){
		ArrayList<LocalAccess> access = new ArrayList<LocalAccess>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof LocalAccess)
				access.add((LocalAccess)get(i));
		
		return access.isEmpty() ? null : access;
	}
	public ArrayList<LocalAccess> getLocalsAccessDocent(){
		ArrayList<LocalAccess> access = new ArrayList<LocalAccess>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof LocalAccess && get(i).getWho() instanceof Docent)
				access.add((LocalAccess)get(i));
		
		return access.isEmpty() ? null : access;
	}
	public ArrayList<LocalAccess> getLocalsAccessStudent(){
		ArrayList<LocalAccess> access = new ArrayList<LocalAccess>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof LocalAccess && get(i).getWho() instanceof StudentAssistant)
				access.add((LocalAccess)get(i));
		
		return access.isEmpty() ? null : access;
	}
	public ArrayList<LocalAccess> getLocalsAccessTecnisAdmin(){
		ArrayList<LocalAccess> access = new ArrayList<LocalAccess>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof LocalAccess && get(i).getWho() instanceof TecnicAdmin)
				access.add((LocalAccess)get(i));
		
		return access.isEmpty() ? null : access;
	}
	public ArrayList<LocalAccess> getLocalsAccessVisitor(){
		ArrayList<LocalAccess> access = new ArrayList<LocalAccess>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof LocalAccess && get(i).getWho() instanceof Visitor)
				access.add((LocalAccess)get(i));
		
		return access.isEmpty() ? null : access;
	}
	
	public ArrayList<KeyRequest> getKeyRequested(){
		ArrayList<KeyRequest> keys = new ArrayList<KeyRequest>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof KeyRequest)
				keys.add((KeyRequest)get(i));
		
		return keys.isEmpty() ? null : keys;
	}
	public ArrayList<KeyRequest> getKeyRequestedDocent(){
		ArrayList<KeyRequest> keys = new ArrayList<KeyRequest>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof KeyRequest && get(i).getWho() instanceof Docent)
				keys.add((KeyRequest)get(i));
		
		return keys.isEmpty() ? null : keys;
	}
	public ArrayList<KeyRequest> getKeyRequestedStudent(){
		ArrayList<KeyRequest> keys = new ArrayList<KeyRequest>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof KeyRequest && get(i).getWho() instanceof StudentAssistant)
				keys.add((KeyRequest)get(i));
		
		return keys.isEmpty() ? null : keys;
	}
	public ArrayList<KeyRequest> getKeyRequestedTecnicAdmin(){
		ArrayList<KeyRequest> keys = new ArrayList<KeyRequest>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof KeyRequest && get(i).getWho() instanceof TecnicAdmin)
				keys.add((KeyRequest)get(i));
		
		return keys.isEmpty() ? null : keys;
	}
	public ArrayList<KeyRequest> getKeyRequestedVisitor(){
		ArrayList<KeyRequest> keys = new ArrayList<KeyRequest>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof KeyRequest && get(i).getWho() instanceof Visitor)
				keys.add((KeyRequest)get(i));
		
		return keys.isEmpty() ? null : keys;
	}
	
	public ArrayList<Control> getControlByPerson(String name){
		ArrayList<Control> result = new ArrayList<Control>();
		
		for(int i = 0; i < size(); i++)
			if(name.equalsIgnoreCase(get(i).getWho().getName()))
				result.add(get(i));
		
		return result.isEmpty() ? null : result;
	}
	public boolean isInsideInSomeLocal(String ci){
		int i = 0;
		ArrayList<LocalAccess> result = getLocalsAccess();
		
		if(result != null)
			while(i < result.size() && !ci.equalsIgnoreCase(result.get(i).getWho().getCI()))
				i++;
		
		return result != null && i < result.size() ? true : false;
	}
	public boolean haveKey(String ci){
		int i = 0;
		ArrayList<KeyRequest> result = getKeyRequested();
		
		if(result != null && !result.isEmpty())
			while(i < result.size() && !ci.equalsIgnoreCase(result.get(i).getWho().getCI()))
				i++;
		
		return (result != null && i < result.size()) ? true : false;
	}
	
	/**Report*/
	public ControlCollection findAccessWorker(Calendar init, Calendar end){
		ControlCollection result = new ControlCollection();
		
		for(int i = 0; i < size(); i++){
			if(get(i) instanceof LocalAccess && get(i).getWho() instanceof Worker){
				if( init.compareTo(((LocalAccess)get(i)).getInit()) <= 0 && end.compareTo(((LocalAccess)get(i)).getInit()) >= 0 ){
					result.add(get(i));
				}
			}
			else if(get(i) instanceof Scheme && get(i).getWho() instanceof Worker && ((Scheme)get(i)).getRulesEntities() instanceof Local){
				if( init.compareTo(((Scheme)get(i)).getInit()) <= 0 && end.compareTo(((Scheme)get(i)).getInit()) >= 0 ){
					result.add(get(i));
				}
			}
		}
		
		return result.isEmpty() ? null : result;
	}
	
	public ControlCollection findVisit(Calendar init, Calendar end){
		ControlCollection result = new ControlCollection();
		
		for(int i = 0; i < size(); i++){
			if(get(i) instanceof LocalAccess && get(i).getWho() instanceof Visitor){
				if( init.compareTo(((LocalAccess)get(i)).getInit()) <= 0 && end.compareTo(((LocalAccess)get(i)).getInit()) >= 0 ){
					result.add(get(i));
				}
			}
			else if(get(i) instanceof Scheme && get(i).getWho() instanceof Visitor && ((Scheme)get(i)).getRulesEntities() instanceof Local){
				if( init.compareTo(((Scheme)get(i)).getInit()) <= 0 && end.compareTo(((Scheme)get(i)).getInit()) >= 0 ){
					result.add(get(i));
				}
			}
		}
		
		return result.isEmpty() ? null : result;
	}
	
	public ControlCollection findRequest(Calendar init, Calendar end){
		ControlCollection result = new ControlCollection();
		
		for(int i = 0; i < size(); i++){
			if(get(i) instanceof KeyRequest){
				if( init.compareTo(((KeyRequest)get(i)).getInit()) <= 0 && end.compareTo(((KeyRequest)get(i)).getInit()) >= 0 ){
					result.add(get(i));
				}
			}
			else if(get(i) instanceof Scheme && ((Scheme)get(i)).getRulesEntities() instanceof Key){
				if( init.compareTo(((Scheme)get(i)).getInit()) <= 0 && end.compareTo(((Scheme)get(i)).getInit()) >= 0 ){
					result.add(get(i));
				}
			}
		}
		
		return result.isEmpty() ? null : result;
	}
	
	public ControlCollection findDelivery(Calendar init, Calendar end){
		ControlCollection result = new ControlCollection();
		
		for(int i = 0; i < size(); i++){
			if(get(i) instanceof Scheme && ((Scheme)get(i)).getRulesEntities() instanceof Key){
				if( init.compareTo(((Scheme)get(i)).getInit()) <= 0 && end.compareTo(((Scheme)get(i)).getInit()) >= 0 ){
					result.add(get(i));
				}
			}
		}
		
		return result.isEmpty() ? null : result;
	}
	
	public Registered findPossessionOfKey(Key key){
		ArrayList<KeyRequest> req = getKeyRequested();
		int i = 0;
		
		if(req != null && !req.isEmpty()){
			while(i < req.size() && key != req.get(i).getKey())
				i++;
		}
		
		return req != null && i < req.size() ? (Registered)req.get(i).getWho() : null;
	}
	
	public Docent docentWithMoreRequestKey(Calendar init, Calendar end, Key key){
		DataReportCollection data = new DataReportCollection();
		
		{
			ArrayList<KeyRequest> request = getKeyRequestedDocent();
			if(request != null)
				for(int i = 0; i < request.size(); i++)
					if(key == request.get(i).getKey())
						if(init.compareTo(request.get(i).getInit()) <= 0 && end.compareTo(request.get(i).getInit()) >= 0 )
							data.addDataReport(request.get(i));
		}
		
		{
			ArrayList<Scheme> scheme = getSchemeByKeyRequest();
			if(scheme != null)
				for(int i = 0; i < scheme.size(); i++)
					if(scheme.get(i).getRulesEntities() instanceof Key && scheme.get(i).getWho() instanceof Docent && init.compareTo(scheme.get(i).getInit()) <= 0 && end.compareTo(scheme.get(i).getInit()) >= 0 )
						if(key == (Key)scheme.get(i).getRulesEntities())
							data.addDataReport(scheme.get(i));
		}
		
		
		return data.isEmpty() ? null : data.getWithMoreExtraction();
	}
	
}
