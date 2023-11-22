package visual.dialog.util;

import java.util.ArrayList;

import ceis.rules.util.enumeration.TypeRule;

public class TypeRuleToCombo{
	private TypeRule type;
	private static ArrayList<TypeRuleToCombo> typeInCombo;
	
	private TypeRuleToCombo(TypeRule type){
		this.type = type;
	}
	
	public static ArrayList<TypeRuleToCombo> getInstance(){
		typeInCombo = new ArrayList<TypeRuleToCombo>();
		typeInCombo.add(new TypeRuleToCombo(TypeRule.TO_ALL));
		typeInCombo.add(new TypeRuleToCombo(TypeRule.TO_WORKER_OF_LOCAL));
		typeInCombo.add(new TypeRuleToCombo(TypeRule.TO_STUDENTASSISTANT));
		typeInCombo.add(new TypeRuleToCombo(TypeRule.TO_DOCENT));
		typeInCombo.add(new TypeRuleToCombo(TypeRule.TO_TECNICADMIN));
		typeInCombo.add(new TypeRuleToCombo(TypeRule.TO_VISITOR));
		typeInCombo.add(new TypeRuleToCombo(TypeRule.TO_SELECTED_PEOPLE));
		
		return typeInCombo;
	}
	
	public TypeRuleToCombo get(int index){
		return typeInCombo.get(index);
	}
	
	public String toString(){
		String text = null;
		
		if(type == TypeRule.TO_ALL)
			text = "Todo el personal";
		else if(type == TypeRule.TO_DOCENT)
			text = "Docentes";
		else if(type == TypeRule.TO_STUDENTASSISTANT)
			text = "Alumnos ayudantes";
		else if(type == TypeRule.TO_TECNICADMIN)
			text = "Técnicos/Administrativos";
		else if(type == TypeRule.TO_VISITOR)
			text = "Visitantes";
		else if(type == TypeRule.TO_SELECTED_PEOPLE)
			text = "Personal seleccionado";
		else if(type == TypeRule.TO_WORKER_OF_LOCAL)
			text = "Trabajadores del local";
		
		return text;
	}
	
	public TypeRule getType(){
		return type;
	}
}