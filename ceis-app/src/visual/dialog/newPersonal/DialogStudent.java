package visual.dialog.newPersonal;

import java.awt.Frame;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import visual.util.Data;
import ceis.CEIS;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import exception.DontExistException;

public class DialogStudent extends DialogRegister {
	private static final long serialVersionUID = -4428914034865320747L;
	private StudentAssistant student;
	
	public DialogStudent(Frame owner) throws DontExistException {
		super(owner, null);
	}
	public DialogStudent(Frame owner, StudentAssistant student) throws DontExistException{
		super(owner, student);
		this.student = student;
		
		setTitle("Registro de modificación - Alumno Ayudante");
		labelHeader1.setText("Registro de modificación");
		applyButton.setEnabled(false);
		nameField.setText(student.getName());
		lastNameField.setText(student.getLastName());
		ciField.setText(student.getCI());
		phoneField.setText(student.getPhone());
		addressField.setText(student.getAddress());
		idField.setText(String.valueOf(student.getID()));
		ImageIcon icon = new ImageIcon(student.getPicture());
		icon = new ImageIcon(icon.getImage().getScaledInstance(80, 100, Image.SCALE_DEFAULT));
		picture.setIcon(icon);
		comboOther1Model.setSelectedItem(student.getProject());
		comboOther2Model.setSelectedItem(student.getTutor());
		pack();
	}

	@Override
	protected void collectData(String image) {
		if(student == null)
			entryList.add(new StudentAssistant(ciField.getText(), nameField.getText(), lastNameField.getText(), Integer.parseInt(idField.getText()), 
				addressField.getText(), phoneField.getText(), image, (String)comboOther1Model.getSelectedItem(), (Docent)comboOther2Model.getSelectedItem()));
		else{
			student.setName(nameField.getText());
			student.setLastName(lastNameField.getText());
			student.setCI(ciField.getText());
			student.setID(Integer.parseInt(idField.getText()));
			student.setAddress(addressField.getText());
			student.setPhone(phoneField.getText());
			if(this.image != null)
				student.setPicture(image);
			student.setTutor((Docent)comboOther2Model.getSelectedItem());
			student.setProject((String)comboOther1Model.getSelectedItem());
		}
	}

	@Override
	protected void ownInitialization() throws DontExistException {
		setTitle("Registro de ingreso - Alumno Ayudante");
		setIconImage((new ImageIcon("src/icons/user_orange.png")).getImage());
		labelHeader2.setText("Alumno Ayudante");
		labelOther1.setText("Proyecto");
		labelOther1.setDisplayedMnemonic('y');
		labelOther2.setText("Tutor");
		labelOther2.setDisplayedMnemonic('u');
		
		for(int i = 0; i < Data.project.length; i++)
			comboOther1Model.addElement(Data.project[i]);
		comboOther1Model.setSelectedItem(null);
		
		ArrayList<Docent> list = CEIS.getInstance().getDocents();
		if(list == null || list.isEmpty())
			throw new DontExistException("No hay docentes registrados para ser seleccionados" +
					"\ncomo tutores de los alumnos ayudantes");
		
		if(list != null && !list.isEmpty())
			for(int i = 0; i < list.size(); i++)
				comboOther2Model.addElement(list.get(i));
		comboOther2Model.setSelectedItem(null);
		
		repaint();
		pack();
	}
	
}
