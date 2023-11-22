package visual.show;

import javax.swing.ImageIcon;

import visual.util.GraphicSupport;


import ceis.CEIS;
import ceis.person.Person;
import ceis.person.registered.worker.Docent;
import exception.EmptyDataShowException;


public class PanelTabDocent extends PanelTabRegistered {
	private static final long serialVersionUID = 9209719920212376053L;
	
	
	public PanelTabDocent() throws EmptyDataShowException {
		super();
		labelHeader.setText("Personal Docente registrado en el centro");
		other1Label.setText("Cargo");
		other2Label.setText("Categoría");
	}


	@Override
	public void fillTable() throws EmptyDataShowException {
		super.clear();
		String [][]dataDocent = CEIS.getInstance().getDocentArrayData();
		
		if(dataDocent == null)
			throw new EmptyDataShowException("No hay personal docente\nregistrado en el centro");
		
		for(int i = 0; i < dataDocent.length; i++)
			tableModel.addRow(dataDocent[i]);
		
		table.changeSelection(0, 0, false, false);
		showData(Integer.parseInt(String.valueOf(tableModel.getValueAt(0, 0))));
	}

	@Override
	protected void showData(int id) {
		Docent aux = CEIS.getInstance().findDocent(id);
		if(aux != null){
				ciField.setText(aux.getCI());
				phoneField.setText(aux.getPhone());
				addressField.setText(aux.getAddress());
				other2Field.setText(aux.getCategory());
				other1Field.setText(aux.getCharge());
				ImageIcon icon = GraphicSupport.scaleImageIcon(new ImageIcon(aux.getPicture()), 80, 100);
				picture.setIcon(icon);
				picture.repaint();
		}
	}


	public Object getSelected() {
		Person person = null;
		int id = Integer.parseInt(String.valueOf(tableModel.getValueAt(oldRow, 0)));
		person = CEIS.getInstance().findDocent(id);
			
		return person;
	}
		
}
