package visual.dialog.newPersonal;

import java.awt.Frame;
import java.awt.Image;

import javax.swing.ImageIcon;

import visual.util.Data;
import ceis.person.registered.worker.Docent;
import exception.DontExistException;

public class DialogDocent extends DialogRegister {
	private static final long serialVersionUID = -3349041647117715152L;
	private Docent docent;
	
	public DialogDocent(Frame owner) throws DontExistException {
		super(owner, null);		
	}
	public DialogDocent(Frame owner, Docent docent) throws DontExistException {
		super(owner, docent);		
		this.docent = docent;
		
		setTitle("Registro de modificación - Docente");
		labelHeader1.setText("Registro de modificación");
		applyButton.setEnabled(false);
		nameField.setText(docent.getName());
		lastNameField.setText(docent.getLastName());
		ciField.setText(docent.getCI());
		phoneField.setText(docent.getPhone());
		addressField.setText(docent.getAddress());
		idField.setText(String.valueOf(docent.getID()));
		ImageIcon icon = new ImageIcon(docent.getPicture());
		icon = new ImageIcon(icon.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT));
		picture.setIcon(icon);
		comboOther1Model.setSelectedItem(docent.getCharge());
		comboOther2Model.setSelectedItem(docent.getCategory());
		pack();
	}

	@Override
	protected void collectData(String image) {
		if(docent == null)
			entryList.add(new Docent(ciField.getText(), nameField.getText(), lastNameField.getText(), Integer.parseInt(idField.getText()), 
				addressField.getText(), phoneField.getText(), image, (String)comboOther1Model.getSelectedItem(), (String)comboOther2Model.getSelectedItem()));
		else{
			docent.setName(nameField.getText());
			docent.setLastName(lastNameField.getText());
			docent.setCI(ciField.getText());
			docent.setID(Integer.parseInt(idField.getText()));
			docent.setAddress(addressField.getText());
			docent.setPhone(phoneField.getText());
			if(this.image != null)
				docent.setPicture(image);
			docent.setCategory((String)comboOther2Model.getSelectedItem());
			docent.setCharge((String)comboOther1Model.getSelectedItem());
		}
		}	

	@Override
	protected void ownInitialization() {
		setTitle("Registro de ingreso - Docente");
		setIconImage((new ImageIcon("src/icons/user_green.png")).getImage());
		labelHeader2.setText("Docente");
		labelOther1.setText("Cargo");
		labelOther1.setDisplayedMnemonic('g');
		labelOther2.setText("Categoría");
		labelOther2.setDisplayedMnemonic('o');
		
		for(int i = 0; i < Data.charge.length; i++)
			comboOther1Model.addElement(Data.charge[i]);
		comboOther1Model.setSelectedItem(null);
		
		for(int i = 0; i < Data.category.length; i++)
			comboOther2Model.addElement(Data.category[i]);
		comboOther2Model.setSelectedItem(null);
		
		repaint();
		pack();
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
