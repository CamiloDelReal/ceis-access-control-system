package ceis.rules.entities;

import ceis.rules.Rule;
import ceis.rules.RulesCollection;

public abstract class RulesEntities {
	protected RulesCollection accessRules;
	
	public RulesEntities(RulesCollection accessRules){
		if(accessRules != null)
			this.accessRules = accessRules;
		else
			this.accessRules = new RulesCollection();
	}
	
//--Interface to RulesCollection--
	public RulesCollection getRules(){
		return accessRules;
	}
	
	public void setRules(RulesCollection rules){
		accessRules = rules;
	}
	
	public boolean addRule(Rule rule){
		return accessRules.add(rule);
	}
	
	public Rule getRule(int index){
		return accessRules.get(index);
	}
	
	public int exist(String name){
		return accessRules.exist(name);
	}
	
	public Rule find(String name){
		return accessRules.find(name);
	}
	
	public Rule remove(String name){
		return accessRules.remove(name);
	}
	public Rule remove(int index){
		return accessRules.remove(index);
	}
	
	public RulesCollection findRulesByPerson(String ci){
		return accessRules.findRulesByPerson(ci);
	}
}
