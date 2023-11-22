package visual.show;

import javax.swing.ImageIcon;

import visual.util.GraphicSupport;


import ceis.CEIS;
import ceis.person.Person;
import ceis.person.registered.worker.TecnicAdmin;
import exception.EmptyDataShowException;

public class PanelTabTecAd extends PanelTabRegistered {
	private static final long serialVersionUID = 7750616239316597184L;

	public PanelTabTecAd() throws EmptyDataShowException {
		super();
		labelHeader.setText("Personal Técnico/Administrativo registrado en el centro");
		other1Label.setText("Cargo");
		other2Label.setText("Departamento");
	}

	@Override
	public void fillTable() throws EmptyDataShowException {
		super.clear();
		String [][]dataDocent = CEIS.getInstance().getTecnicAdminArrayData();
		
		if(dataDocent == null)
			throw new EmptyDataShowException("No hay personal técnico/administrativo\nregistrado en el centro");
		
		for(int i = 0; i < dataDocent.length; i++)
			tableModel.addRow(dataDocent[i]);
		
		table.changeSelection(0, 0, false, false);
		showData(Integer.parseInt(String.valueOf(tableModel.getValueAt(0, 0))));
	}

	@Override
	protected void showData(int id) {
		TecnicAdmin aux = CEIS.getInstance().findTecAd(id);
		if(aux != null){
				ciField.setText(aux.getCI());
				phoneField.setText(aux.getPhone());
				addressField.setText(aux.getAddress());
				other2Field.setText(aux.getDepartment());
				other1Field.setText(aux.getCharge());
				ImageIcon icon = GraphicSupport.scaleImageIcon(new ImageIcon(aux.getPicture()), 80, 100);
				picture.setIcon(icon);
				picture.repaint();
		}
	}

	public Object getSelected() {
		Person person = null;
		int id = Integer.parseInt(String.valueOf(tableModel.getValueAt(oldRow, 0)));
		person = CEIS.getInstance().findTecAd(id);
			
		return person;
	}

}
