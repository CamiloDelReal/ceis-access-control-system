package visual.show;

import javax.swing.ImageIcon;

import visual.util.GraphicSupport;
import ceis.CEIS;
import ceis.person.Person;
import ceis.person.registered.StudentAssistant;
import exception.EmptyDataShowException;

public class PanelTabStudent extends PanelTabRegistered {
	private static final long serialVersionUID = -6371997284902217705L;

	public PanelTabStudent() throws EmptyDataShowException {
		super();
		labelHeader.setText("Alumnos Ayudantes relacionados con el centro");
		other1Label.setText("Proyecto");
		other2Label.setText("Tutor");
	}

	@Override
	public void fillTable() throws EmptyDataShowException {
		super.clear();
		String [][]dataDocent = CEIS.getInstance().getStudentArrayData();
		
		if(dataDocent == null)
			throw new EmptyDataShowException("No hay estudiantes ayudantes\nregistrado en el centro");
		
		for(int i = 0; i < dataDocent.length; i++)
			tableModel.addRow(dataDocent[i]);
		
		table.changeSelection(0, 0, false, false);
		showData(Integer.parseInt(String.valueOf(tableModel.getValueAt(0, 0))));
	}

	@Override
	protected void showData(int id) {
		StudentAssistant aux = CEIS.getInstance().findStudent(id);
		if(aux != null){
				ciField.setText(aux.getCI());
				phoneField.setText(aux.getPhone());
				addressField.setText(aux.getAddress());
				other1Field.setText(aux.getProject());
				other2Field.setText(aux.getTutor().toString());
				ImageIcon icon = GraphicSupport.scaleImageIcon(new ImageIcon(aux.getPicture()), 80, 100);
				picture.setIcon(icon);
				picture.repaint();
		}
	}
	
	public Object getSelected(){
		Person person = null;
		int id = Integer.parseInt(String.valueOf(tableModel.getValueAt(oldRow, 0)));
		person = CEIS.getInstance().findStudent(id);
			
		return person;
	}

}
