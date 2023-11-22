package visual.dialog.control;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import visual.util.GraphicSupport;
import ceis.CEIS;
import ceis.control.entities.KeyRequest;
import ceis.control.entities.LocalAccess;
import ceis.person.Person;
import ceis.person.Visitor;
import ceis.rules.RulesCollection;
import ceis.rules.entities.Key;
import ceis.rules.entities.Local;
import exception.DontExistException;
import exception.DontPosibleException;
import exception.DuplicityException;
import exception.EmptyException;

public class DialogAccess extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private boolean localOrKey;
	
	private Calendar date;  //  @jve:decl-index=0:

	private JPanel jContentPane = null;

	private JLabel header = null;

	private JPanel panelCenter = null;

	private JPanel panelRadio = null;

	private JRadioButton radioLocal = null;

	private JRadioButton radioKey = null;

	private ButtonGroup buttonGroup = null;  //  @jve:decl-index=0:visual-constraint="516,368"

	private JLabel labelLocal = null;

	private JComboBox comboLocals = null;

	private JLabel stateLabel = null;

	private JLabel actualDate = null;

	private JTextField dateField = null;

	private JLabel registeredLabel = null;

	private JList listPersonal = null;

	private JScrollPane scrollPersonal = null;

	private DefaultListModel listPersonalModel = null;  //  @jve:decl-index=0:visual-constraint="423,363"

	private DefaultComboBoxModel localsModel = null;  //  @jve:decl-index=0:visual-constraint="342,364"

	private ImageIcon iconPosibleAccess = null;  //  @jve:decl-index=0:visual-constraint="42,369"

	private ImageIcon iconNotPosibleAccess = null;  //  @jve:decl-index=0:visual-constraint="36,410"

	private ImageIcon iconPosibleRequestKey = null;  //  @jve:decl-index=0:visual-constraint="157,366"

	private ImageIcon iconNotPosibleRequestKey = null;  //  @jve:decl-index=0:visual-constraint="155,416"

	private JPanel panelButtonBoth = null;

	private JButton apply = null;

	private JButton accept = null;

	private JButton cancel = null;

	/**
	 * @param owner
	 * @throws DontExistException 
	 */
	public DialogAccess(Frame owner, boolean localOrKey) throws DontExistException {
		super(owner);
		this.localOrKey = localOrKey;
		initialize();
		getRootPane().setDefaultButton(accept);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws DontExistException 
	 */
	private void initialize() throws DontExistException {
		this.setSize(497, 332);
		this.setTitle("Acceder");
		this.setIconImage((new ImageIcon("src/icons/door_in.png").getImage()));
		this.setContentPane(getJContentPane());
		GraphicSupport.centerWindow(this);
		getButtonGroup();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws DontExistException 
	 */
	private JPanel getJContentPane() throws DontExistException {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridwidth = 2;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.gridy = 4;
			GridBagConstraints gridBagConstraints51 = new GridBagConstraints();
			gridBagConstraints51.fill = GridBagConstraints.BOTH;
			gridBagConstraints51.gridy = 3;
			gridBagConstraints51.weightx = 1.0;
			gridBagConstraints51.weighty = 1.0;
			gridBagConstraints51.insets = new Insets(0, 24, 10, 10);
			gridBagConstraints51.gridx = 1;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.gridx = 1;
			gridBagConstraints41.insets = new Insets(0, 10, 0, 10);
			gridBagConstraints41.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints41.gridy = 2;
			registeredLabel = new JLabel();
			registeredLabel.setText("Personal registrado en el centro");
			registeredLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.gridheight = 2;
			gridBagConstraints31.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints31.insets = new Insets(0, 10, 10, 0);
			gridBagConstraints31.gridy = 2;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 0, 15, 0);
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridy = 0;
			header = new JLabel();
			if(localOrKey)
				header.setText("Solicitud de acceso al centro");
			else
				header.setText("Solicitud de llave");
			header.setFont(new Font("Calibri", Font.PLAIN, 18));
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(header, gridBagConstraints);
			jContentPane.add(getPanelCenter(), gridBagConstraints31);
			jContentPane.add(registeredLabel, gridBagConstraints41);
			jContentPane.add(getScrollPersonal(), gridBagConstraints51);
			jContentPane.add(getPanelButtonBoth(), gridBagConstraints11);
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelCenter	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws DontExistException 
	 */
	private JPanel getPanelCenter() throws DontExistException {
		if (panelCenter == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 5;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints1.gridy = 4;
			actualDate = new JLabel();
			actualDate.setText("Día/Hora actual");
			actualDate.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.insets = new Insets(10, 0, 10, 0);
			gridBagConstraints6.gridy = 3;
			stateLabel = new JLabel();
			stateLabel.setText("");
			stateLabel.setHorizontalAlignment(SwingConstants.CENTER);
			stateLabel.setPreferredSize(new Dimension(215, 20));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 2;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints5.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints4.gridy = 1;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			gridBagConstraints3.anchor = GridBagConstraints.CENTER;
			gridBagConstraints3.gridy = 0;
			panelCenter = new JPanel();
			panelCenter.setLayout(new GridBagLayout());
			panelCenter.add(getPanelRadio(), gridBagConstraints3);
			panelCenter.add(labelLocal, gridBagConstraints4);
			panelCenter.add(getComboLocals(), gridBagConstraints5);
			panelCenter.add(stateLabel, gridBagConstraints6);
			panelCenter.add(actualDate, gridBagConstraints1);
			panelCenter.add(getDateField(), gridBagConstraints2);
		}
		return panelCenter;
	}

	/**
	 * This method initializes panelRadio	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRadio() {
		if (panelRadio == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHgap(8);
			labelLocal = new JLabel();
			labelLocal.setText("Locales");
			labelLocal.setFont(new Font("Calibri", Font.PLAIN, 12));
			panelRadio = new JPanel();
			panelRadio.setLayout(flowLayout);
			panelRadio.add(getRadioLocal(), null);
			panelRadio.add(getRadioKey(), null);
		}
		return panelRadio;
	}

	/**
	 * This method initializes radioLocal	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioLocal() {
		if (radioLocal == null) {
			radioLocal = new JRadioButton();
			radioLocal.setText("Local");
			if(localOrKey)
				radioLocal.setSelected(true);
			radioLocal.setFont(new Font("Calibri", Font.PLAIN, 12));
			radioLocal.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(radioLocal.isSelected())
						header.setText("Solicitud de acceso al centro");
					else
						header.setText("Solicitud de llave");
				}
			});
			radioLocal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						isPosibleAccess();
					} catch (DontPosibleException e1) {}
				}
			});
		}
		return radioLocal;
	}

	/**
	 * This method initializes radioKey	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadioKey() {
		if (radioKey == null) {
			radioKey = new JRadioButton();
			if(!localOrKey)
				radioKey.setSelected(true);
			radioKey.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						isPosibleAccess();
					} catch (DontPosibleException e1) {}
				}
			});
			radioKey.setText("Llave");
			radioKey.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return radioKey;
	}

	/**
	 * This method initializes buttonGroup	
	 * 	
	 * @return javax.swing.ButtonGroup	
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getRadioLocal());
			buttonGroup.add(getRadioKey());
		}
		return buttonGroup;
	}

	/**
	 * This method initializes comboLocals	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws DontExistException 
	 */
	private JComboBox getComboLocals() throws DontExistException {
		if (comboLocals == null) {
			comboLocals = new JComboBox(getLocalsModel());
			comboLocals.setPreferredSize(new Dimension(60, 26));
			comboLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
			comboLocals.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					try {
						isPosibleAccess();
					} catch (DontPosibleException e1) {}
				}
			});
		}
		return comboLocals;
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
			date = Calendar.getInstance();
			dateField.setText(GraphicSupport.getStringEntryDate(date, true));
		}
		return dateField;
	}

	/**
	 * This method initializes listPersonal	
	 * 	
	 * @return javax.swing.JList	
	 * @throws DontExistException 
	 */
	private JList getListPersonal() throws DontExistException {
		if (listPersonal == null) {
			listPersonal = new JList(getListPersonalModel());
			listPersonal.setFont(new Font("Calibri", Font.PLAIN, 12));
			listPersonal.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			listPersonal.setSelectedIndex(0);
			listPersonal
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							try {
								isPosibleAccess();
							} catch (DontPosibleException e1) {}
						}
					});
		}
		return listPersonal;
	}

	/**
	 * This method initializes scrollPersonal	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws DontExistException 
	 */
	private JScrollPane getScrollPersonal() throws DontExistException {
		if (scrollPersonal == null) {
			scrollPersonal = new JScrollPane(getListPersonal());
			scrollPersonal.setPreferredSize(new Dimension(230, 200));
			scrollPersonal.setViewportView(getListPersonal());
		}
		return scrollPersonal;
	}

	/**
	 * This method initializes listPersonalModel	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 * @throws DontExistException 
	 */
	private DefaultListModel getListPersonalModel() throws DontExistException {
		if (listPersonalModel == null) {
			listPersonalModel = new DefaultListModel();
			
			if(CEIS.getInstance().getPersons() == null)
				throw new DontExistException("No se ha registrado al personal del centro");
			
			for(int i = 0; i < CEIS.getInstance().getPersons().size(); i++)
				listPersonalModel.addElement(CEIS.getInstance().getPerson(i));
		}
		return listPersonalModel;
	}

	/**
	 * This method initializes localsModel	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 * @throws DontExistException 
	 */
	private DefaultComboBoxModel getLocalsModel() throws DontExistException {
		if (localsModel == null) {
			localsModel = new DefaultComboBoxModel();
			
			ArrayList<Local> locals = CEIS.getInstance().getLocals();
			if(locals == null)
				throw new DontExistException("No se han creado locales a los cuales se pueda acceder");
				
			for(int i = 0; i < locals.size(); i++)
				localsModel.addElement(locals.get(i));
			
			localsModel.setSelectedItem(null);
		}
		return localsModel;
	}
	
	private boolean isPosibleAccess() throws DontPosibleException{
		boolean done = true;
		Local local = (Local)localsModel.getSelectedItem();
		Person person = (Person)listPersonal.getSelectedValue();
		
		if(local != null && person != null){		
			RulesCollection rules = null;
			if(radioLocal.isSelected())
				rules = local.getRules();
			else
				rules = local.getKey().getRules();
			
			if(radioKey.isSelected() && person instanceof Visitor){
				done = false;
			}
			
			if(done && rules != null)
				done = rules.isPosibleEntry(person, local, Calendar.getInstance());
		
			if(done){
				if(radioLocal.isSelected()){
					stateLabel.setIcon(getIconPosibleAccess());
				}
				else{
					stateLabel.setIcon(getIconPosibleRequestKey());
				}
			}
			else{
				if(radioLocal.isSelected()){
					stateLabel.setIcon(getIconNotPosibleAccess());
				}
				else{
					stateLabel.setIcon(getIconNotPosibleRequestKey());
				}
			}
		}
		
		return done;
	}

	/**
	 * This method initializes iconPosibleAccess	
	 * 	
	 * @return javax.swing.ImageIcon	
	 */
	private ImageIcon getIconPosibleAccess() {
		if (iconPosibleAccess == null) {
			iconPosibleAccess = new ImageIcon("src/icons/localAvailable.png");
		}
		return iconPosibleAccess;
	}

	/**
	 * This method initializes iconNotPosibleAccess	
	 * 	
	 * @return javax.swing.ImageIcon	
	 */
	private ImageIcon getIconNotPosibleAccess() {
		if (iconNotPosibleAccess == null) {
			iconNotPosibleAccess = new ImageIcon("src/icons/localDontAvailable.png");
		}
		return iconNotPosibleAccess;
	}

	/**
	 * This method initializes iconPosibleRequestKey	
	 * 	
	 * @return javax.swing.ImageIcon	
	 */
	private ImageIcon getIconPosibleRequestKey() {
		if (iconPosibleRequestKey == null) {
			iconPosibleRequestKey = new ImageIcon("src/icons/KeyAvailable.png");
		}
		return iconPosibleRequestKey;
	}

	/**
	 * This method initializes iconNotPosibleRequestKey	
	 * 	
	 * @return javax.swing.ImageIcon	
	 */
	private ImageIcon getIconNotPosibleRequestKey() {
		if (iconNotPosibleRequestKey == null) {
			iconNotPosibleRequestKey = new ImageIcon("src/icons/KeyDontAvailable.png");
		}
		return iconNotPosibleRequestKey;
	}
	
	/**
	 * This method initializes panelButtonBoth	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelButtonBoth() {
		if (panelButtonBoth == null) {
			panelButtonBoth = new JPanel();
			panelButtonBoth.setLayout(new FlowLayout());
			panelButtonBoth.add(getApply(), null);
			panelButtonBoth.add(getAccept(), null);
			panelButtonBoth.add(getCancel(), null);
		}
		return panelButtonBoth;
	}

	/**
	 * This method initializes apply	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getApply() {
		if (apply == null) {
			apply = new JButton();
			apply.setFont(new Font("Calibri", Font.PLAIN, 12));
			apply.setMnemonic(KeyEvent.VK_P);
			apply.setText("Aplicar");
			apply.setPreferredSize(new Dimension(78, 28));
			apply.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						if(validateForm()){
							Person person = (Person)listPersonal.getSelectedValue();
							if(radioLocal.isSelected()){							
								Local local = (Local)comboLocals.getSelectedItem();
								CEIS.getInstance().addControl(new LocalAccess(person, date, local));
							}
							else{
								Key key = (Key)((Local)comboLocals.getSelectedItem()).getKey();
								CEIS.getInstance().addControl(new KeyRequest(person, date, key));
								key.loan();
							}
						}
					}
					catch (EmptyException ex1) {
						JOptionPane.showMessageDialog(DialogAccess.this, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DontPosibleException ex2) {
						JOptionPane.showMessageDialog(DialogAccess.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DuplicityException ex3) {
						JOptionPane.showMessageDialog(DialogAccess.this, ex3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return apply;
	}

	/**
	 * This method initializes accept	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAccept() {
		if (accept == null) {
			accept = new JButton();
			accept.setFont(new Font("Calibri", Font.PLAIN, 12));
			accept.setMnemonic(KeyEvent.VK_A);
			accept.setText("Aceptar");
			accept.setPreferredSize(new Dimension(78, 28));
			accept.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						if(validateForm()){
							Person person = (Person)listPersonal.getSelectedValue();
							Local local = (Local)comboLocals.getSelectedItem();
							if(radioLocal.isSelected()){							
								CEIS.getInstance().addControl(new LocalAccess(person, date, local));
							}
							else{
								Key key = (Key)((Local)comboLocals.getSelectedItem()).getKey();
								CEIS.getInstance().addControl(new KeyRequest(person, date, key));
								key.loan();
							}
							dispose();
						}
					}
					catch (EmptyException ex1) {
						JOptionPane.showMessageDialog(DialogAccess.this, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DontPosibleException ex2) {
						JOptionPane.showMessageDialog(DialogAccess.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DuplicityException ex3) {
						JOptionPane.showMessageDialog(DialogAccess.this, ex3.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return accept;
	}
	
	private boolean validateForm() throws EmptyException, DontPosibleException, DuplicityException{
		boolean done = true;
		
		if(comboLocals.getSelectedItem() == null){
			done = false;
			if(radioLocal.isSelected())
				throw new EmptyException("Debe seleccionar el local al que desea acceder");
			else
				throw new EmptyException("Debe seleccionar de que local es la llave que desea solicitar");
		}
		
		if(listPersonal.getSelectedValue() == null){
			done = false;
			if(radioLocal.isSelected())
				throw new EmptyException("Debe indicarse que persona desea acceder al centro");
			else
				throw new EmptyException("Debe indicarse que persona desea solicitar una llave");
		}
		
		Person person = (Person)listPersonal.getSelectedValue();
		if(radioKey.isSelected() && person instanceof Visitor){
			done = false;
			throw new DontPosibleException("La persona que esta intentando solicitar una llave es un visitante\n" +
					"Este tipo de persona no tiene permisos para solicitar llaves");
		}
		
		if(!isPosibleAccess()){
			done = false;
			if(radioLocal.isSelected())
				throw new DontPosibleException("La persona seleccionada no esta autorizada a acceder al centro. \n" +
						"Por favor remitase a las reglas de acceso del local seleccionado para mas informacion");
			else
				throw new DontPosibleException("La persona seleccionada no esta autorizada a solicitar la llave del local seleccionado. \n" +
						"Por favor remitase a las reglas de acceso de la llave del local seleccionado para mas informacion");
				
		}
		
		String ci = ((Person)listPersonal.getSelectedValue()).getCI();
		if(radioLocal.isSelected() && CEIS.getInstance().isInsideInSomeLocal(ci)){
			done = false;
			throw new DuplicityException("La persona que esta intentado acceder se encuentra en el registro de acceso\n" +
					"Debe de indicarse que termino su visita a un local para poder acceder a otro");
		}
		Key key = null;
		if(radioKey.isSelected() && !(key = (Key)((Local)localsModel.getSelectedItem()).getKey()).isAvailable()){
			done = false;
			ArrayList<KeyRequest> keys = CEIS.getInstance().getKeyRequested();
			if(keys != null && !keys.isEmpty()){
				String namePerson = null;
				for(int i = 0; i < keys.size(); i++)
					if(key.toString().equalsIgnoreCase(keys.get(i).getKey().toString()))
						namePerson = keys.get(i).getWho().toString();
				throw new DuplicityException("La llave que se esta intentando extraer no ha sido devuelta aun por\n" + namePerson);
			}
		}
		
		return done;
	}

	/**
	 * This method initializes cancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton();
			cancel.setFont(new Font("Calibri", Font.PLAIN, 12));
			cancel.setMnemonic(KeyEvent.VK_C);
			cancel.setText("Cancelar");
			cancel.setPreferredSize(new Dimension(78, 28));
			cancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return cancel;
	}

}  //  @jve:decl-index=0:visual-constraint="48,1"
