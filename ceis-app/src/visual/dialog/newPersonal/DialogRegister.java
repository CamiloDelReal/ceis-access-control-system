package visual.dialog.newPersonal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import visual.own.LabelToChooser;
import visual.own.OwnLabel;
import visual.util.ExtendedFileFilter;
import visual.util.GraphicSupport;
import ceis.CEIS;
import ceis.person.Person;
import ceis.person.Registered;
import exception.DontExistException;
import exception.DuplicityException;
import exception.EmptyException;

public abstract class DialogRegister extends JDialog {

	private static final long serialVersionUID = 1L;
	
	protected ArrayList<Person> entryList;
	
	private Registered person;

	protected JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="39,60"

	protected JPanel panelInfoPersonal = null;

	protected JLabel nameLabel = null;

	protected JTextField nameField = null;

	protected JLabel lastNameLabel = null;

	protected JTextField lastNameField = null;

	protected JLabel ciLabel = null;

	protected JFormattedTextField ciField = null;

	protected MaskFormatter formatCI = null;  //  @jve:decl-index=0:visual-constraint="403,12"

	protected JLabel phoneLabel = null;

	protected JFormattedTextField phoneField = null;

	protected JLabel addressLabel = null;

	protected JTextArea addressField = null;

	protected MaskFormatter formatPhone = null;  //  @jve:decl-index=0:visual-constraint="396,58"

	protected JScrollPane scrollAddressField = null;

	protected JPanel panelPicture = null;

	protected JLabel picture = null;

	protected OwnLabel setPicture = null;
	
	protected File image;

	protected JPanel panelOtherInfo = null;

	protected JLabel idLabel = null;

	protected JFormattedTextField idField = null;

	protected JLabel labelOther1 = null;

	protected JComboBox comboOther1 = null;

	protected JLabel labelOther2 = null;

	protected JComboBox comboOther2 = null;

	protected JPanel panelButtons = null;

	protected JButton applyButton = null;

	protected JButton acceptButton = null;

	protected JButton cancelButton = null;

	protected JLabel labelHeader1 = null;

	protected JLabel labelHeader2 = null;

	protected MaskFormatter formatID = null;  //  @jve:decl-index=0:visual-constraint="416,123"

	protected DefaultComboBoxModel comboOther1Model = null;  //  @jve:decl-index=0:visual-constraint="497,81"

	protected DefaultComboBoxModel comboOther2Model = null;  //  @jve:decl-index=0:visual-constraint="489,139"

	/**
	 * @param owner
	 * @throws DontExistException 
	 */
	public DialogRegister(Frame owner, Registered person) throws DontExistException {
		super(owner, true);
		entryList = new ArrayList<Person>();
		initialize();
		getRootPane().setDefaultButton(acceptButton);
		GraphicSupport.centerWindow(this);
		ownInitialization();
		this.person = person;
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(329, 409);
		this.setContentPane(getJContentPane());
		this.setResizable(false);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 0;
			gridBagConstraints23.gridwidth = 2;
			gridBagConstraints23.insets = new Insets(8, 0, 0, 0);
			gridBagConstraints23.gridy = 4;
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.gridx = 1;
			gridBagConstraints22.insets = new Insets(18, 5, 0, 0);
			gridBagConstraints22.gridy = 3;
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 1;
			gridBagConstraints21.insets = new Insets(12, 0, 0, 40);
			gridBagConstraints21.gridy = 2;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 0;
			gridBagConstraints20.gridheight = 2;
			gridBagConstraints20.insets = new Insets(14, 0, 0, 0);
			gridBagConstraints20.gridy = 2;
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 0;
			gridBagConstraints19.gridwidth = 2;
			gridBagConstraints19.gridy = 1;
			labelHeader2 = new JLabel();
			labelHeader2.setText("Type person");
			labelHeader2.setFont(new Font("Calibri", Font.PLAIN, 14));
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.gridx = 0;
			gridBagConstraints17.gridwidth = 2;
			gridBagConstraints17.gridy = 0;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.setSize(new Dimension(323, 373));
			jContentPane.add(getLabelHeader1(), gridBagConstraints17);
			jContentPane.add(labelHeader2, gridBagConstraints19);
			jContentPane.add(getPanelInfoPersonal(), gridBagConstraints20);
			jContentPane.add(getPanelPicture(), gridBagConstraints21);
			jContentPane.add(getPanelOtherInfo(), gridBagConstraints22);
			jContentPane.add(getPanelButtons(), gridBagConstraints23);
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelInfoPersonal	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelInfoPersonal() {
		if (panelInfoPersonal == null) {
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.fill = GridBagConstraints.BOTH;
			gridBagConstraints8.gridy = 9;
			gridBagConstraints8.weightx = 1.0;
			gridBagConstraints8.weighty = 1.0;
			gridBagConstraints8.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints8.gridwidth = 2;
			gridBagConstraints8.gridheight = 2;
			gridBagConstraints8.ipady = 15;
			gridBagConstraints8.gridx = 0;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 0;
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints7.gridy = 8;
			addressLabel = new JLabel();
			addressLabel.setText("Dirección");
			addressLabel.setDisplayedMnemonic(KeyEvent.VK_R);
			addressLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.fill = GridBagConstraints.BOTH;
			gridBagConstraints6.gridy = 7;
			gridBagConstraints6.weightx = 1.0;
			gridBagConstraints6.gridwidth = 2;
			gridBagConstraints6.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints6.gridx = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints5.gridy = 6;
			phoneLabel = new JLabel();
			phoneLabel.setText("Teléfono");
			phoneLabel.setDisplayedMnemonic(KeyEvent.VK_T);
			phoneLabel.setLabelFor(getPhoneField());
			phoneLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 5;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.gridwidth = 4;
			gridBagConstraints4.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints3.gridy = 4;
			ciLabel = new JLabel();
			ciLabel.setText("CI");
			ciLabel.setDisplayedMnemonic(KeyEvent.VK_I);
			ciLabel.setLabelFor(getCiField());
			ciLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridy = 3;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.gridwidth = 4;
			gridBagConstraints2.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridy = 2;
			lastNameLabel = new JLabel();
			lastNameLabel.setText("Apellido(s)");
			lastNameLabel.setDisplayedMnemonic(KeyEvent.VK_E);
			lastNameLabel.setLabelFor(getLastNameField());
			lastNameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.fill = GridBagConstraints.BOTH;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.weightx = 1.0;
			gridBagConstraints1.gridwidth = 4;
			gridBagConstraints1.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints1.gridx = 0;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.anchor = GridBagConstraints.WEST;
			gridBagConstraints.gridy = 0;
			nameLabel = new JLabel();
			nameLabel.setText("Nombre(s)");
			nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
			nameLabel.setLabelFor(getNameField());
			nameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			panelInfoPersonal = new JPanel();
			panelInfoPersonal.setLayout(new GridBagLayout());
			panelInfoPersonal.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Datos personales", TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.PLAIN, 14), Color.black));
			panelInfoPersonal.add(nameLabel, gridBagConstraints);
			panelInfoPersonal.add(getNameField(), gridBagConstraints1);
			panelInfoPersonal.add(lastNameLabel, gridBagConstraints11);
			panelInfoPersonal.add(getLastNameField(), gridBagConstraints2);
			panelInfoPersonal.add(ciLabel, gridBagConstraints3);
			panelInfoPersonal.add(getCiField(), gridBagConstraints4);
			panelInfoPersonal.add(phoneLabel, gridBagConstraints5);
			panelInfoPersonal.add(getPhoneField(), gridBagConstraints6);
			panelInfoPersonal.add(addressLabel, gridBagConstraints7);
			panelInfoPersonal.add(getScrollAddressField(), gridBagConstraints8);
		}
		return panelInfoPersonal;
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
			lastNameField.setColumns(12);
			lastNameField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return lastNameField;
	}

	/**
	 * This method initializes ciField	
	 * 	
	 * @return javax.swing.JFormattedTextField	
	 */
	private JFormattedTextField getCiField() {
		if (ciField == null) {
			ciField = new JFormattedTextField(getFormatCI());
			ciField.setColumns(12);
			ciField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return ciField;
	}

	/**
	 * This method initializes formatCI	
	 * 	
	 * @return javax.swing.text.MaskFormatter	
	 */
	private MaskFormatter getFormatCI() {
		if (formatCI == null) {
			try {
				formatCI = new MaskFormatter();
				formatCI.setMask("###########");
			} catch (ParseException ex) {
				JOptionPane.showMessageDialog(DialogRegister.this, "No se pudo cargar el formato especificado para el campo \"CI\"" +
						"\nPor favor, haga uso del formato \"###########\"", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return formatCI;
	}

	/**
	 * This method initializes phoneField	
	 * 	
	 * @return javax.swing.JFormattedTextField	
	 */
	private JFormattedTextField getPhoneField() {
		if (phoneField == null) {
			phoneField = new JFormattedTextField(getFormatPhone());
			phoneField.setColumns(12);
			phoneField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return phoneField;
	}

	/**
	 * This method initializes addressField	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAddressField() {
		if (addressField == null) {
			addressField = new JTextArea();
			addressField.setColumns(12);
			addressField.setRows(2);
			addressField.setLineWrap(true);
			addressField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return addressField;
	}

	/**
	 * This method initializes formatPhone	
	 * 	
	 * @return javax.swing.text.MaskFormatter	
	 */
	private MaskFormatter getFormatPhone() {
		if (formatPhone == null) {
			try {
				formatPhone = new MaskFormatter();
				formatPhone.setMask("###-####");
			} catch (ParseException ex) {
				JOptionPane.showMessageDialog(DialogRegister.this, "No se pudo cargar el formato especificado para el campo \"Teléfono\"" +
						"\nPor favor, haga uso del formato \"### ####\"", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return formatPhone;
	}

	/**
	 * This method initializes scrollAddressField	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollAddressField() {
		if (scrollAddressField == null) {
			scrollAddressField = new JScrollPane(getAddressField());
			scrollAddressField.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollAddressField.setViewportBorder(null);
		}
		return scrollAddressField;
	}

	/**
	 * This method initializes panelPicture	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelPicture() {
		if (panelPicture == null) {
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridy = 1;
			setPicture = new OwnLabel("Cambiar imagen", null, "Click para selecionar una imagen");
			setPicture.setFont(new Font("Calibri", Font.PLAIN, 10));
			setPicture.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					JFileChooser chooser = new JFileChooser();
					ExtendedFileFilter filter = new ExtendedFileFilter("jpg, jpeg, png", new String[]{"JPG", "JPEG", "PNG"});
					chooser.addChoosableFileFilter(filter);
					filter = new ExtendedFileFilter("jpg", new String[]{"JPG"});
					chooser.addChoosableFileFilter(filter);
					filter = new ExtendedFileFilter("jpeg", new String[]{"JPEG"});
					chooser.addChoosableFileFilter(filter);
					filter = new ExtendedFileFilter("png", new String[]{"PNG"});
					chooser.addChoosableFileFilter(filter);
					LabelToChooser lab = new LabelToChooser(chooser);
					chooser.setAccessory(lab);
					int status = chooser.showOpenDialog(null);
					if(status == JFileChooser.APPROVE_OPTION){			
						image = chooser.getSelectedFile();
						ImageIcon icon = new ImageIcon(image.toString());
						icon = GraphicSupport.scaleImageIcon(icon, 80, 100);
						picture.setIcon(icon);
					}
				}
			});
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 0;
			gridBagConstraints12.gridy = 0;
			picture = new JLabel(new ImageIcon("src/icons/unknown_user.png"));
			picture.setText("");
			panelPicture = new JPanel();
			panelPicture.setLayout(new GridBagLayout());
			panelPicture.add(picture, gridBagConstraints12);
			panelPicture.add(setPicture, gridBagConstraints18);

		}
		return panelPicture;
	}

	/**
	 * This method initializes panelOtherInfo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelOtherInfo() {
		if (panelOtherInfo == null) {
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.fill = GridBagConstraints.BOTH;
			gridBagConstraints16.gridy = 5;
			gridBagConstraints16.weightx = 1.0;
			gridBagConstraints16.gridwidth = 2;
			gridBagConstraints16.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints16.gridx = 0;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.gridx = 0;
			gridBagConstraints15.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints15.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints15.gridy = 4;
			labelOther2 = new JLabel();
			labelOther2.setText("Other2...");
			labelOther2.setLabelFor(getComboOther2());
			labelOther2.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.BOTH;
			gridBagConstraints14.gridy = 3;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.gridwidth = 2;
			gridBagConstraints14.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints14.gridx = 0;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints13.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints13.gridy = 2;
			labelOther1 = new JLabel();
			labelOther1.setText("Other1..");
			labelOther1.setLabelFor(getComboOther1());
			labelOther1.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridy = 1;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.gridwidth = 2;
			gridBagConstraints10.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints10.gridx = 0;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints9.gridy = 0;
			idLabel = new JLabel();
			idLabel.setText("ID");
			idLabel.setDisplayedMnemonic(KeyEvent.VK_D);
			idLabel.setLabelFor(getIdField());
			idLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			panelOtherInfo = new JPanel();
			panelOtherInfo.setLayout(new GridBagLayout());
			panelOtherInfo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Especificidades" , TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.PLAIN, 14), Color.black));
			panelOtherInfo.add(idLabel, gridBagConstraints9);
			panelOtherInfo.add(getIdField(), gridBagConstraints10);
			panelOtherInfo.add(labelOther1, gridBagConstraints13);
			panelOtherInfo.add(getComboOther1(), gridBagConstraints14);
			panelOtherInfo.add(labelOther2, gridBagConstraints15);
			panelOtherInfo.add(getComboOther2(), gridBagConstraints16);
		}
		return panelOtherInfo;
	}

	/**
	 * This method initializes idField	
	 * 	
	 * @return javax.swing.JFormattedTextField	
	 */
	private JFormattedTextField getIdField() {
		if (idField == null) {
			idField = new JFormattedTextField(getFormatID());
			idField.setColumns(12);
			idField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return idField;
	}

	/**
	 * This method initializes comboOther1	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboOther1() {
		if (comboOther1 == null) {
			comboOther1 = new JComboBox(getComboOther1Model());
			comboOther1.setFont(new Font("Calibri", Font.PLAIN, 12));

		}
		return comboOther1;
	}

	/**
	 * This method initializes comboOther2	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboOther2() {
		if (comboOther2 == null) {
			comboOther2 = new JComboBox(getComboOther2Model());
			comboOther2.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return comboOther2;
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
	 * This method initializes applyButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getApplyButton() {
		if (applyButton == null) {
			applyButton = new JButton();
			applyButton.setFont(new Font("Calibri", Font.PLAIN, 12));
			applyButton.setMnemonic(KeyEvent.VK_P);
			applyButton.setText("Aplicar");
			applyButton.setPreferredSize(new Dimension(78, 28));
			applyButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						if(validateForm()){
							String imageString;
							if(image != null){
								imageString = image.toString();
							}
							else{
								imageString = "src/icons/unknown_user.png";
							}
							collectData(imageString);								
						}
						clear();
					}
					catch(EmptyException ex1){
						JOptionPane.showMessageDialog(DialogRegister.this,
								ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DuplicityException ex2) {
						JOptionPane.showMessageDialog(DialogRegister.this,
								ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return applyButton;
	}

	/**
	 * This method initializes acceptButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAcceptButton() {
		if (acceptButton == null) {
			acceptButton = new JButton();
			acceptButton.setFont(new Font("Calibri", Font.PLAIN, 12));
			acceptButton.setMnemonic(KeyEvent.VK_A);
			acceptButton.setText("Aceptar");
			acceptButton.setPreferredSize(new Dimension(78, 28));
			acceptButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
				try{
						if(validateForm()){
							String imageString;
							if(image != null){
								imageString = image.toString();
							}
							else{
								imageString = "src/icons/unknown_user.png";
							}
							
							collectData(imageString);
						}
						dispose();
					}
					catch(EmptyException ex){
						if(entryList.size() > 0){
							if(JOptionPane.showConfirmDialog(DialogRegister.this, "Realmente desea dejar de introducir datos", "Alerta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								dispose();
							else
								JOptionPane.showMessageDialog(DialogRegister.this,
								ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(DialogRegister.this,
									ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DuplicityException ex2) {
						JOptionPane.showMessageDialog(DialogRegister.this,
								ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
			cancelButton.setFont(new Font("Calibri", Font.PLAIN, 12));
			cancelButton.setText("Cancelar");
			cancelButton.setMnemonic(KeyEvent.VK_C);
			cancelButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return cancelButton;
	}

	/**
	 * This method initializes labelHeader1	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLabelHeader1() {
		if (labelHeader1 == null) {
			labelHeader1 = new JLabel();
			labelHeader1.setFont(new Font("Calibri", Font.PLAIN, 18));
			labelHeader1.setText("Registro de ingreso al centro");
			labelHeader1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return labelHeader1;
	}

	/**
	 * This method initializes formatID	
	 * 	
	 * @return javax.swing.text.MaskFormatter	
	 */
	private MaskFormatter getFormatID() {
		if (formatID == null) {
			try {
				formatID = new MaskFormatter();
				formatID.setMask("#####");
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(DialogRegister.this, "No se pudo cargar el formato especificado para el campo \"ID\"" +
						"\nPor favor, haga uso del formato \"#####\"", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		return formatID;
	}

	/**
	 * This method initializes comboOther1Model	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getComboOther1Model() {
		if (comboOther1Model == null) {
			comboOther1Model = new DefaultComboBoxModel();
		}
		return comboOther1Model;
	}

	/**
	 * This method initializes comboOther2Model	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getComboOther2Model() {
		if (comboOther2Model == null) {
			comboOther2Model = new DefaultComboBoxModel();
		}
		return comboOther2Model;
	}
	
	private boolean validateForm() throws EmptyException, DuplicityException{
		boolean fine = true;
		String auxText = null;
		
		auxText = nameField.getText();
		if(auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText)){
			nameField.setText("");
			fine = false;
			throw new EmptyException("Valor no válido en el campo \"Nombre\"");
		}
		auxText = lastNameField.getText();
		if(fine && (auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText))){
			lastNameField.setText("");
			fine = false;
			throw new EmptyException("Valor no válido en el campo \"Apellido\"");
		}
		auxText = ciField.getText();
		if(fine && (auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText))){
			ciField.setText("");
			fine = false;
			throw new EmptyException("Valor no válido en el campo \"CI\"");
		}
		if(CEIS.getInstance().find(auxText) != null && !auxText.equalsIgnoreCase(person.getCI())){
			ciField.setText("");
			fine = false;
			throw new DuplicityException("El valor de \"CI\" se encuentra en los datos de otra persona");
		}
		auxText = addressField.getText();
		if(fine && (auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText))){
			addressField.setText("");
			fine = false;
			throw new EmptyException("Valor no válido en el campo \"Dirección\"");
		}
		auxText = idField.getText();
		if(fine && (auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText))){
			idField.setText("");
			fine = false;
			throw new EmptyException("Valor no válido en el campo \"ID\"");
		}
		if(CEIS.getInstance().find(Integer.parseInt(auxText)) != null && Integer.parseInt(auxText) != person.getID()){
			idField.setText("");
			fine = false;
			throw new DuplicityException("El valor de \"ID\" se encuentra en los datos de otra persona");
		}
		if(comboOther2Model.getSelectedItem() == null){
			comboOther2Model.setSelectedItem(null);
			fine = false;
			throw new EmptyException("Es obligatorio indicar la categoria del docente");
		}
		
		return fine;
	}
	
	private void clear(){
		comboOther1Model.setSelectedItem(null);
		comboOther2Model.setSelectedItem(null);
		idField.setText("");
		addressField.setText("");
		phoneField.setText("");
		ciField.setText("");
		lastNameField.setText("");
		nameField.setText("");
		image = null;
		picture.setIcon(new ImageIcon("src/icons/unknown_user.png"));
	}
	
	public ArrayList<Person> getEntryList(){
		return entryList;
	}
	
	protected abstract void collectData(String image);
	protected abstract void ownInitialization() throws DontExistException;

}  //  @jve:decl-index=0:visual-constraint="21,21"
