package visual.util.forDBAction;

import javax.swing.JPanel;

import visual.util.forDBAction.enumeration.TypeInfo;



public class TabInfo {
	private TypeInfo type;
	private JPanel tab;
	
	public TabInfo(TypeInfo type, JPanel tab){
		this.tab = tab;
		this.type = type;
	}
	
	public TypeInfo getTypeInfo(){
		return type;
	}
	
	public JPanel getTab(){
		return tab;
	}
}
