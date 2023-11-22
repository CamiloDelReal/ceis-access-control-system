package visual.dialog.newPersonal;

import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import visual.util.Data;
import ceis.CEIS;
import ceis.person.registered.worker.TecnicAdmin;
import ceis.rules.entities.Local;
import exception.DontExistException;

public class DialogTecAd extends DialogRegister {
	private static final long serialVersionUID = -308502628881039567L;
	private TecnicAdmin tecad;

	public DialogTecAd(Frame owner) throws DontExistException {
		super(owner, null);
	}
	public DialogTecAd(Frame owner, TecnicAdmin tecad) throws DontExistException {
		super(owner, tecad);
		this.tecad = tecad;
		
		setTitle("Registro de modificación - Alumno Ayudante");
		labelHeader1.setText("Registro de modificación");
		applyButton.setEnabled(false);
		nameField.setText(tecad.getName());
		lastNameField.setText(tecad.getLastName());
		ciField.setText(tecad.getCI());
		phoneField.setText(tecad.getPhone());
		addressField.setText(tecad.getAddress());
		idField.setText(String.valueOf(tecad.getID()));
		ImageIcon icon = new ImageIcon(tecad.getPicture());
		icon = new ImageIcon(icon.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT));
		picture.setIcon(icon);
		comboOther1Model.setSelectedItem(tecad.getCharge());
		comboOther2Model.setSelectedItem(tecad.getDepartment());
		pack();
	}

	@Override
	protected void collectData(String image) {
		if(tecad == null){
			String department = ((Local)comboOther2Model.getSelectedItem()).getName();
			String charge = (String)comboOther1Model.getSelectedItem();
			entryList.add(new TecnicAdmin(ciField.getText(), nameField.getText(), lastNameField.getText(), Integer.parseInt(idField.getText()), 
				addressField.getText(), phoneField.getText(), image, charge, department));
		}
		else{
			String department = ((Local)comboOther2Model.getSelectedItem()).getName();
			String charge = (String)comboOther1Model.getSelectedItem();
			
			tecad.setName(nameField.getText());
			tecad.setLastName(lastNameField.getText());
			tecad.setCI(ciField.getText());
			tecad.setID(Integer.parseInt(idField.getText()));
			tecad.setAddress(addressField.getText());
			tecad.setPhone(phoneField.getText());
			if(this.image != null)
				tecad.setPicture(image);
			tecad.setDepartment(department);
			tecad.setCharge(charge);
		}
	}

	@Override
	protected void ownInitialization() throws DontExistException{
		setTitle("Registro de ingreso - Técnico/Administrativo");
		setIconImage((new ImageIcon("src/icons/user_red.png")).getImage());
		labelHeader2.setText("Técnico/Administrativo");
		labelOther1.setText("Cargo");
		labelOther1.setDisplayedMnemonic('g');
		labelOther2.setText("Departamento");
		labelOther2.setDisplayedMnemonic('m');
		
		for(int i = 0; i < Data.charge.length; i++)
			comboOther1Model.addElement(Data.charge[i]);
		comboOther1Model.setSelectedItem(null);
		
		ArrayList<Local> locals = CEIS.getInstance().getLocals();
		if(locals == null)
			throw new DontExistException("No hay locales a los que puedan ser asignados nuevos trabajadores");
		
		for(int i = 0; i < locals.size();i++)
			comboOther2Model.addElement(locals.get(i));
		comboOther2Model.setSelectedItem(null);
		
		repaint();
		pack();
	}

}
