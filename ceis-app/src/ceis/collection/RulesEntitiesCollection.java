package ceis.collection;

import java.util.ArrayList;

import ceis.rules.entities.Key;
import ceis.rules.entities.Local;
import ceis.rules.entities.RulesEntities;

public class RulesEntitiesCollection extends ArrayList<RulesEntities> {
	private static final long serialVersionUID = 6498508089398374323L;

	public RulesEntitiesCollection(){
		super();
	}
	public RulesEntitiesCollection(int capacity){
		super(capacity);
	}
	
	public int equals(RulesEntities rule){
		int index = 0;
		
		while(index < size() && !rule.equals(get(index)))
			index++;
		
		return index < size() ? index : -1;
	}
	
	public RulesEntities removeRule(){
		return null;
	}
	
	public ArrayList<Local> getLocals(){
		ArrayList<Local> locals = new ArrayList<Local>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Local)
				locals.add((Local)get(i));
		
		return locals.isEmpty() ? null : locals;
	}
	
	public ArrayList<Key> getKeys(){
		ArrayList<Key> keys = new ArrayList<Key>();
		
		for(int i = 0; i < size(); i++)
			if(get(i) instanceof Key)
				keys.add((Key)get(i));
		
		return keys.isEmpty() ? null : keys;
	}
	
	public Local findLocal(String name){
		int index = 0;
		ArrayList<Local> locals = getLocals();
		
		while(index < locals.size()&& !name.equalsIgnoreCase(locals.get(index).getName()))
			index++;
		
		return index < locals.size() ? locals.get(index) : null;
	}
	
	public Key findKey(String localName){
		int index = 0;
		ArrayList<Key> keys = getKeys();
		
		while(index < keys.size() && !localName.equalsIgnoreCase(keys.get(index).toString()))
			index++;
		
		return index < keys.size() ? keys.get(index) : null;
	}
	
	public int existLocal(String name){
		int index = -1;
		ArrayList<Local> locals = getLocals();
		
		if(locals != null){
			index = 0;
			while(index < locals.size()&& !name.equalsIgnoreCase(locals.get(index).getName()))
				index++;
		}
		
		return (locals == null || index == locals.size()) ? -1 : index;
	}
	
	public int existKey(String localName){
		int index = -1;
		ArrayList<Key> keys = getKeys();
		
		if(keys != null){
			index = 0;
			while(index < keys.size() && !localName.equalsIgnoreCase(keys.get(index).toString()))
				index++;
		}
		
		return (keys == null || index < keys.size()) ? -1 : index;
	}
}
