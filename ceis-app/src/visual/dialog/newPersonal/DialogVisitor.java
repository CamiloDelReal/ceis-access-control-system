package visual.dialog.newPersonal;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import visual.util.GraphicSupport;
import ceis.person.Person;
import ceis.person.Visitor;
import exception.DontExistException;
import exception.EmptyException;

public class DialogVisitor extends JDialog {

	private static final long serialVersionUID = 1L;
	private ArrayList<Person> visitors;
	private Visitor vis;
	private JPanel jContentPane = null;
	private JLabel labelHeader1 = null;
	private JLabel labelHeader2 = null;
	private JPanel personalInformation = null;
	private JLabel nameLabel = null;
	private JTextField nameField = null;
	private JLabel lastNameLabel = null;
	private JTextField lastNameField = null;
	private JLabel ciLabel = null;
	private JPanel entryInformation = null;
	private JLabel datelabel = null;
	private JTextField dateField = null;
	private JPanel panelButtons = null;
	private JButton acceptButton = null;
	private JButton cancelButton = null;
	private JButton applyButton = null;
	private JFormattedTextField ciField = null;
	private Calendar entryDate;
	/**
	 * @param owner
	 * @throws DontExistException 
	 */
	public DialogVisitor(Frame owner) throws DontExistException {
		super(owner, true); //true of modality
		initialize();
		getRootPane().setDefaultButton(acceptButton);
		GraphicSupport.centerWindow(this);
		visitors = new ArrayList<Person>();
	}
	
	public DialogVisitor(Frame owner, Visitor vis) throws DontExistException {
		super(owner, true); //true of modality
		initialize();
		getRootPane().setDefaultButton(acceptButton);
		GraphicSupport.centerWindow(this);
		this.vis = vis;
		
		setTitle("Registro de modificación - Alumno Ayudante");
		labelHeader1.setText("Registro de modificación");
		applyButton.setEnabled(false);
		nameField.setText(vis.getName());
		lastNameField.setText(vis.getLastName());
		ciField.setText(vis.getCI());
		entryDate = Calendar.getInstance();
		dateField.setText(GraphicSupport.getStringEntryDate(entryDate, true));
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws DontExistException 
	 */
	private void initialize() throws DontExistException {
		this.setContentPane(getJContentPane());
		this.setTitle("Registro de ingreso - Visitante");
		this.setSize(new Dimension(320, 283));
		this.setIconImage((new ImageIcon("src/icons/user_suit.png")).getImage());
		this.pack();
		this.setResizable(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws DontExistException 
	 */
	private JPanel getJContentPane() throws DontExistException {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints91 = new GridBagConstraints();
			gridBagConstraints91.gridx = 1;
			gridBagConstraints91.gridwidth = 2;
			gridBagConstraints91.insets = new Insets(4, 0, 0, 0);
			gridBagConstraints91.gridy = 5;
			GridBagConstraints gridBagConstraints71 = new GridBagConstraints();
			gridBagConstraints71.gridx = 2;
			gridBagConstraints71.insets = new Insets(104, 2, 0, 0);
			gridBagConstraints71.fill = GridBagConstraints.NONE;
			gridBagConstraints71.gridy = 2;
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.gridx = 1;
			gridBagConstraints61.ipady = 2;
			gridBagConstraints61.gridheight = 1;
			gridBagConstraints61.insets = new Insets(14, 0, 0, 0);
			gridBagConstraints61.gridy = 2;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.gridy = 1;
			labelHeader2 = new JLabel();
			labelHeader2.setText("Visitante");
			labelHeader2.setFont(new Font("Calibri", 14, 14));
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 1;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridy = 0;
			labelHeader1 = new JLabel();
			labelHeader1.setText("Registro de ingreso al centro");
			labelHeader1.setFont(new Font("Calibri", 14, 18));
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(labelHeader1, gridBagConstraints);
			jContentPane.add(labelHeader2, gridBagConstraints3);
			jContentPane.add(getPersonalInformation(), gridBagConstraints61);
			jContentPane.add(getEntryInformation(), gridBagConstraints71);
			jContentPane.add(getPanelButtons(), gridBagConstraints91);
		}
		return jContentPane;
	}

	/**
	 * This method initializes personalInformation	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPersonalInformation() {
		if (personalInformation == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints7.gridy = 6;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.gridwidth = 5;
			gridBagConstraints7.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints7.gridx = 3;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 3;
			gridBagConstraints6.anchor = GridBagConstraints.WEST;
			gridBagConstraints6.fill = GridBagConstraints.NONE;
			gridBagConstraints6.gridy = 5;
			ciLabel = new JLabel();
			ciLabel.setText("CI");
			ciLabel.setHorizontalTextPosition(SwingConstants.TRAILING);
			ciLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			ciLabel.setHorizontalAlignment(SwingConstants.LEADING);
			ciLabel.setLabelFor(getCiField());
			ciLabel.setDisplayedMnemonic(KeyEvent.VK_I);
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 4;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.gridwidth = 4;
			gridBagConstraints5.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints5.gridx = 3;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.gridwidth = 2;
			gridBagConstraints4.fill = GridBagConstraints.NONE;
			gridBagConstraints4.anchor = GridBagConstraints.WEST;
			gridBagConstraints4.insets = new Insets(2, 1, 0, 0);
			gridBagConstraints4.gridy = 3;
			lastNameLabel = new JLabel();
			lastNameLabel.setText("Apellido(s)");
			lastNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			lastNameLabel.setHorizontalTextPosition(SwingConstants.TRAILING);
			lastNameLabel.setHorizontalAlignment(SwingConstants.LEADING);
			lastNameLabel.setDisplayedMnemonic(KeyEvent.VK_E);
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 2;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridwidth = 4;
			gridBagConstraints2.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints2.gridx = 3;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 3;
			gridBagConstraints1.gridwidth = 1;
			gridBagConstraints1.fill = GridBagConstraints.NONE;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints1.gridy = 1;
			nameLabel = new JLabel();
			nameLabel.setText("Nombre(s)");
			nameLabel.setHorizontalAlignment(SwingConstants.LEADING);
			nameLabel.setHorizontalTextPosition(SwingConstants.TRAILING);
			nameLabel.setComponentOrientation(ComponentOrientation.UNKNOWN);
			nameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
			personalInformation = new JPanel();
			personalInformation.setLayout(new GridBagLayout());
			personalInformation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Datos personales", TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.PLAIN, 12), Color.black));
			personalInformation.add(nameLabel, gridBagConstraints1);
			personalInformation.add(getNameField(), gridBagConstraints2);
			personalInformation.add(lastNameLabel, gridBagConstraints4);
			personalInformation.add(getLastNameField(), gridBagConstraints5);
			personalInformation.add(ciLabel, gridBagConstraints6);
			personalInformation.add(getCiField(), gridBagConstraints7);
		}
		return personalInformation;
	}

	/**
	 * This method initializes nameField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getNameField() {
		if (nameField == null) {
			nameField = new JTextField();
			nameField.setColumns(12);
			nameField.setFont(new Font("Calibri", Font.PLAIN, 12));
			nameLabel.setLabelFor(nameField);
		}
		return nameField;
	}

	/**
	 * This method initializes lastNameField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLastNameField() {
		if (lastNameField == null) {
			lastNameField = new JTextField();
			lastNameField.setFont(new Font("Calibri", Font.PLAIN, 12));
			lastNameField.setColumns(12);
			lastNameLabel.setLabelFor(lastNameField);
		}
		return lastNameField;
	}

	/**
	 * This method initializes entryInformation	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws DontExistException 
	 */
	private JPanel getEntryInformation() throws DontExistException {
		if (entryInformation == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints12.gridy = 3;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.gridwidth = 2;
			gridBagConstraints12.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints12.gridx = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.insets = new Insets(2, 0, 0, 0);
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.gridy = 2;
			datelabel = new JLabel();
			datelabel.setText("Fecha y hora");
			datelabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			entryInformation = new JPanel();
			entryInformation.setLayout(new GridBagLayout());
			entryInformation.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Datos de entrada", TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.PLAIN, 12), Color.black));
			entryInformation.add(datelabel, gridBagConstraints11);
			entryInformation.add(getDateField(), gridBagConstraints12);
		}
		return entryInformation;
	}

	/**
	 * This method initializes dateField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getDateField() {
		if (dateField == null) {
			dateField = new JTextField();
			dateField.setColumns(12);
			dateField.setEditable(false);
			dateField.setFont(new Font("Calibri", Font.PLAIN, 12));
			entryDate = Calendar.getInstance();
			dateField.setText(GraphicSupport.getStringEntryDate(entryDate, true));
		}
		return dateField;
	}
	
	/**
	 * This method initializes panelButtons	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelButtons() {
		if (panelButtons == null) {
			panelButtons = new JPanel();
			panelButtons.setLayout(new FlowLayout());
			panelButtons.add(getApplyButton(), null);
			panelButtons.add(getAcceptButton(), null);
			panelButtons.add(getCancelButton(), null);
		}
		return panelButtons;
	}

	/**
	 * This method initializes acceptButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAcceptButton() {
		if (acceptButton == null) {
			acceptButton = new JButton();
			acceptButton.setText("Aceptar");
			acceptButton.setFont(new Font("Calibri", Font.PLAIN, 12));
			acceptButton.setPreferredSize(new Dimension(78, 28));
			acceptButton.setMnemonic(KeyEvent.VK_A);
			acceptButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){
					try{
						if(validateForm()){
							if(vis == null)
								visitors.add(new Visitor(ciField.getText(), nameField.getText(), lastNameField.getText(), entryDate));
							else{
								vis.setName(nameField.getText());
								vis.setCI(ciField.getText());
								vis.setLastName(lastNameField.getText());
								vis.setEntryDate(entryDate);
							}
							dispose();
						}
					}
					catch(EmptyException ex){
						if(visitors.size() > 0){
							if(JOptionPane.showConfirmDialog(DialogVisitor.this, "Realmente desea dejar de introducir datos", "Alerta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								dispose();
							else
								JOptionPane.showMessageDialog(DialogVisitor.this,
										ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(DialogVisitor.this,
								ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return acceptButton;
	}

	/**
	 * This method initializes cancelButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancelButton() {
		if (cancelButton == null) {
			cancelButton = new JButton();
			cancelButton.setText("Cancelar");
			cancelButton.setFont(new Font("Calibri", Font.PLAIN, 12));
			cancelButton.setMnemonic(KeyEvent.VK_C);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return cancelButton;
	}

	/**
	 * This method initializes applyButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getApplyButton() {
		if (applyButton == null) {
			applyButton = new JButton();
			applyButton.setText("Aplicar");
			applyButton.setFont(new Font("Calibri", Font.PLAIN, 12));
			applyButton.setPreferredSize(new Dimension(78, 28));
			applyButton.setMnemonic(KeyEvent.VK_P);
			applyButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						if(validateForm()){
							visitors.add(new Visitor(ciField.getText(), nameField.getText(), lastNameField.getText(), entryDate));
							clear();
						}
					}
					catch(EmptyException ex){
						JOptionPane.showMessageDialog(DialogVisitor.this,
								ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return applyButton;
	}
	
	private boolean validateForm() throws EmptyException{
		boolean fine = true;
		String auxText = null;
		
		auxText = nameField.getText();
		if(auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText)){
			throw new EmptyException("Valor no válido en el campo \"Nombre\"");
		}
		auxText = lastNameField.getText();
		if(fine && (auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText))){
			throw new EmptyException("Valor no válido en el campo \"Apellido\"");
		}
		auxText = ciField.getText();
		if(fine && (auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText))){
			throw new EmptyException("Valor no valido en el campo \"CI\"");
		}
		
		return fine;
	}
	
	private void clear(){
		ciField.setText("");
		lastNameField.setText("");
		nameField.setText("");
	}

	/**
	 * This method initializes ciField	
	 * 	
	 * @return javax.swing.JFormattedTextField	
	 */
	private JFormattedTextField getCiField() {
		if (ciField == null) {
			MaskFormatter mask = null;
			try{
				mask = new MaskFormatter("###########");
			}
			catch(ParseException e){
				JOptionPane.showMessageDialog(DialogVisitor.this,
						"No se pudo iniciar el campo \"CI\" con el formato apropiado\n" +
						"Por favor, emplee el formato ###########");
			}
			ciField = new JFormattedTextField(mask);
			ciField.setToolTipText("###########");
			ciField.setFont(new Font("Calibri", Font.PLAIN, 12));
			ciField.setColumns(12);
		}
		return ciField;
	}

	public ArrayList<Person> getVisitors(){
		return visitors;
	}

}  //  @jve:decl-index=0:visual-constraint="28,-28"
