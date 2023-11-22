package visual.dialog.localkey;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import visual.own.ToolButton;
import visual.util.GraphicSupport;
import ceis.CEIS;
import ceis.collection.RegisteredCollection;
import ceis.person.Registered;
import ceis.rules.entities.Key;
import ceis.rules.entities.Local;
import ceis.rules.entities.RulesEntities;
import exception.DuplicityException;
import exception.EmptyException;

public class DialogNewLocal extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<RulesEntities> entities;
	
	private Local local;

	private JPanel jContentPane = null;

	private JLabel header = null;

	private JLabel nameLabel = null;

	private JTextField nameField = null;

	private JPanel panelButtonBoth = null;

	private JButton apply = null;

	private JButton accept = null;

	private JButton cancel = null;

	private JPanel changePersonal1 = null;

	private JLabel changeLabelHeader1 = null;

	private JScrollPane scrollPersonal = null;

	private JList listPersonal = null;

	private DefaultListModel listPersonalModel = null;

	private JPanel panelButton = null;

	private ToolButton add = null;

	private ToolButton del = null;

	private JLabel changeLabelHeader2 = null;

	private JScrollPane scrollAuthorized = null;

	private JList listAuthorized = null;

	private DefaultListModel listAuthorizedModel = null;

	/**
	 * @param owner
	 */
	public DialogNewLocal(Frame owner, Local local) {
		super(owner, true);
		this.local = local;
		entities = new ArrayList<RulesEntities>();
		initialize();
		getRootPane().setDefaultButton(accept);
		GraphicSupport.centerWindow(this);
		fillToModify();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(448, 348);
		this.setTitle("Nuevo Local");
		this.setFont(new Font("Calibri", Font.PLAIN, 12));
		this.setResizable(false);
		this.setIconImage((new ImageIcon("src/icons/door.png")).getImage());
		this.setContentPane(getJContentPane());
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.insets = new Insets(5, 5, 5, 5);
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints31.gridwidth = 2;
			gridBagConstraints31.gridy = 3;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints2.gridwidth = 2;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.gridx = 1;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints1.gridy = 1;
			nameLabel = new JLabel();
			nameLabel.setText("Nombre");
			nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
			nameLabel.setLabelFor(getNameField());
			nameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.insets = new Insets(0, 0, 5, 0);
			gridBagConstraints.gridy = 0;
			header = new JLabel();
			header.setText("Creación de un nuevo local");
			header.setHorizontalAlignment(SwingConstants.CENTER);
			header.setFont(new Font("Calibri", Font.PLAIN, 18));
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(header, gridBagConstraints);
			jContentPane.add(nameLabel, gridBagConstraints1);
			jContentPane.add(getNameField(), gridBagConstraints2);
			jContentPane.add(getPanelButtonBoth(), gridBagConstraints31);
			jContentPane.add(getChangePersonal1(), gridBagConstraints5);
		}
		return jContentPane;
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
			apply.setText("Aplicar");
			apply.setFont(new Font("Calibri", Font.PLAIN, 12));
			apply.setMnemonic(KeyEvent.VK_P);
			apply.setPreferredSize(new Dimension(78, 28));
			apply.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						if(validateForm()){
							Local local = new Local(null, nameField.getText(), collectWorkers(), null);
							Key key = new Key(null, local);
							local.setKey(key);
							entities.add(local);
							entities.add(key);
							
							clear();
							fillPersonalList();
						}
					}
					catch(EmptyException ex1){
						JOptionPane.showMessageDialog(DialogNewLocal.this, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch(DuplicityException ex2){
						JOptionPane.showMessageDialog(DialogNewLocal.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
			accept.setText("Aceptar");
			accept.setFont(new Font("Calibri", Font.PLAIN, 12));
			accept.setMnemonic(KeyEvent.VK_A);
			accept.setPreferredSize(new Dimension(78, 28));
			accept.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try{
						if(validateForm()){
							if(local == null){
								Local local = new Local(null, nameField.getText(), collectWorkers(), null);
								Key key = new Key(null, local);
								local.setKey(key);
								entities.add(local);
								entities.add(key);
							}
							else{
								local.setName(nameField.getText());
								local.setWorkers(collectWorkers());
							}
							
							dispose();
						}
					}
					catch(EmptyException ex){
						if(entities.size() > 0){
							if(JOptionPane.showConfirmDialog(DialogNewLocal.this, "Realmente desea dejar de introducir datos", "Alerta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
								dispose();
							else
								JOptionPane.showMessageDialog(DialogNewLocal.this,
								ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(DialogNewLocal.this,
									ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch(DuplicityException ex2){
						JOptionPane.showMessageDialog(DialogNewLocal.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return accept;
	}

	/**
	 * This method initializes cancel	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancel() {
		if (cancel == null) {
			cancel = new JButton();
			cancel.setText("Cancelar");
			cancel.setFont(new Font("Calibri", Font.PLAIN, 12));
			cancel.setMnemonic(KeyEvent.VK_C);
			cancel.setPreferredSize(new Dimension(78, 28));
			cancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dispose();
				}
			});
		}
		return cancel;
	}

	/**
	 * This method initializes changePersonal1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getChangePersonal1() {
		if (changePersonal1 == null) {
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.fill = GridBagConstraints.BOTH;
			gridBagConstraints22.gridx = 2;
			gridBagConstraints22.gridy = 1;
			gridBagConstraints22.weightx = 1.0;
			gridBagConstraints22.weighty = 1.0;
			gridBagConstraints22.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints20.gridy = 0;
			gridBagConstraints20.gridx = 2;
			changeLabelHeader2 = new JLabel();
			changeLabelHeader2.setFont(new Font("Calibri", Font.PLAIN, 12));
			changeLabelHeader2.setText("Personal autorizado");
			changeLabelHeader2.setLabelFor(getScrollAuthorized());
			changeLabelHeader2.setDisplayedMnemonic(KeyEvent.VK_S);
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints19.gridy = 1;
			gridBagConstraints19.gridx = 1;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.fill = GridBagConstraints.BOTH;
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridy = 1;
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.weighty = 1.0;
			gridBagConstraints18.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints17.gridy = 0;
			gridBagConstraints17.gridx = 0;
			changeLabelHeader1 = new JLabel();
			changeLabelHeader1.setFont(new Font("Calibri", Font.PLAIN, 12));
			changeLabelHeader1.setText("Personal del centro");
			changeLabelHeader1.setLabelFor(getScrollPersonal());
			changeLabelHeader1.setDisplayedMnemonic(KeyEvent.VK_E);
			changePersonal1 = new JPanel();
			changePersonal1.setLayout(new GridBagLayout());
			changePersonal1.add(changeLabelHeader1, gridBagConstraints17);
			changePersonal1.add(getScrollPersonal(), gridBagConstraints18);
			changePersonal1.add(getPanelButton(), gridBagConstraints19);
			changePersonal1.add(changeLabelHeader2, gridBagConstraints20);
			changePersonal1.add(getScrollAuthorized(), gridBagConstraints22);
		}
		return changePersonal1;
	}

	/**
	 * This method initializes scrollPersonal	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollPersonal() {
		if (scrollPersonal == null) {
			scrollPersonal = new JScrollPane();
			scrollPersonal.setFont(new Font("Calibri", Font.PLAIN, 12));
			scrollPersonal.setViewportView(getListPersonal());
			scrollPersonal.setPreferredSize(new Dimension(183, 200));
		}
		return scrollPersonal;
	}

	/**
	 * This method initializes listPersonalModel	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getListPersonalModel() {
		if (listPersonalModel == null) {
			listPersonalModel = new DefaultListModel();
			
			fillPersonalList();
		}
		return listPersonalModel;
	}

	/**
	 * This method initializes listPersonal	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getListPersonal() {
		if (listPersonal == null) {
			listPersonal = new JList(getListPersonalModel());
			listPersonal.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return listPersonal;
	}

	/**
	 * This method initializes panelButton	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelButton() {
		if (panelButton == null) {
			GridBagConstraints gridBagConstraints181 = new GridBagConstraints();
			gridBagConstraints181.insets = new Insets(10, 0, 0, 0);
			gridBagConstraints181.gridy = 1;
			gridBagConstraints181.gridx = 0;
			GridBagConstraints gridBagConstraints171 = new GridBagConstraints();
			gridBagConstraints171.insets = new Insets(0, 0, 10, 0);
			gridBagConstraints171.gridy = 0;
			gridBagConstraints171.gridx = 0;
			panelButton = new JPanel();
			panelButton.setLayout(new GridBagLayout());
			panelButton.add(getAdd(), gridBagConstraints171);
			panelButton.add(getDel(), gridBagConstraints181);
		}
		return panelButton;
	}

	/**
	 * This method initializes add	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getAdd() {
		if (add == null) {
			add = new ToolButton(new ImageIcon("src/icons/add.png"), null, "Añadir");
			add.setMnemonic(KeyEvent.VK_S);
			add.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object[] selectedValues = listPersonal.getSelectedValues();
					int[] arrayIndices = listPersonal.getSelectedIndices();
					
					if(selectedValues != null && selectedValues.length > 0)
						for(int i = 0; i < selectedValues.length; i++)
							listAuthorizedModel.addElement(selectedValues[i]);
						
					if(arrayIndices != null && arrayIndices.length > 0)
						for(int i = 0; i < arrayIndices.length; i++)
							listPersonalModel.removeElementAt(arrayIndices[i] - i);
				}
			});
		}
		return add;
	}

	/**
	 * This method initializes del	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getDel() {
		if (del == null) {
			del = new ToolButton(new ImageIcon("src/icons/delete.png"), null,
					"Quitar");
			del.setMnemonic(KeyEvent.VK_D);
			del.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Object[] selectedValues = listAuthorized.getSelectedValues();
					int[] arrayIndices = listAuthorized.getSelectedIndices();
					
					if(selectedValues != null && selectedValues.length > 0)
						for(int i = 0; i < selectedValues.length; i++)
							listPersonalModel.addElement(selectedValues[i]);
						
					if(arrayIndices != null && arrayIndices.length > 0)
						for(int i = 0; i < arrayIndices.length; i++)
							listAuthorizedModel.removeElementAt(arrayIndices[i] - i);
				}
			});
		}
		return del;
	}

	/**
	 * This method initializes scrollAuthorized	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollAuthorized() {
		if (scrollAuthorized == null) {
			scrollAuthorized = new JScrollPane();
			scrollAuthorized.setPreferredSize(new Dimension(183, 200));
			scrollAuthorized.setViewportView(getListAuthorized());
		}
		return scrollAuthorized;
	}

	/**
	 * This method initializes listAuthorizedModel	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getListAuthorizedModel() {
		if (listAuthorizedModel == null) {
			listAuthorizedModel = new DefaultListModel();
		}
		return listAuthorizedModel;
	}

	/**
	 * This method initializes listAuthorized	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getListAuthorized() {
		if (listAuthorized == null) {
			listAuthorized = new JList(getListAuthorizedModel());
			listAuthorized.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return listAuthorized;
	}
	
	private boolean validateForm() throws EmptyException, DuplicityException{
		boolean done = true;
		
		String aux = nameField.getText();		
		if(aux == null || aux.isEmpty() || GraphicSupport.isEmpty(aux)){
			done = false;
			nameField.setText("");
			throw new EmptyException("Valor no válido en al campo \"Nombre\"");
		}
		int exist = CEIS.getInstance().existLocal(aux);
		if(exist != -1 && local != null && !local.getName().equalsIgnoreCase(aux)){
			nameField.setText("");
			throw new DuplicityException("Ya hay registrado un local de nombre: " + aux);
		}
		
		return done;
	}

	private RegisteredCollection collectWorkers(){
		int size = listAuthorizedModel.getSize();
		RegisteredCollection registered = new RegisteredCollection(size);
		
		for(int i = 0; i < size; i++)
			registered.add((Registered)listAuthorizedModel.get(i));
		
		return registered.isEmpty() ? null : registered;
	}
	
	private void fillPersonalList(){
		RegisteredCollection list = CEIS.getInstance().getRegistered();
		
		if(list != null && !list.isEmpty())
			for(int i = 0; i < list.size(); i++)
				listPersonalModel.addElement(list.get(i));
	}
	
	private void clear(){
		nameField.setText("");
		listPersonalModel.clear();
		listAuthorizedModel.clear();
	}
	
	public ArrayList<RulesEntities> getRulesEntities(){
		return entities;
	}
	
	private void fillToModify(){
		if(local != null){
			apply.setEnabled(false);
			nameField.setText(local.getName());
			
			for(int i = 0, j = 0; i < local.getRegistereds().size(); i++, j = 0){
				while(j < listPersonalModel.size() && 
						!local.getRegistered(i).getCI().equalsIgnoreCase(((Registered)listPersonalModel.get(j)).getCI()))
					j++;
				
				if(j < listPersonalModel.size())
					listPersonalModel.removeElementAt(j);
				listAuthorizedModel.addElement(local.getRegistered(i));
			}				
					
		}
	}
}  //  @jve:decl-index=0:visual-constraint="85,18"
