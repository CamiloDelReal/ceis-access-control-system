package visual.show;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;
import ceis.CEIS;
import ceis.collection.RegisteredCollection;
import ceis.rules.RulesCollection;
import ceis.rules.entities.Key;
import ceis.rules.entities.Local;
import ceis.rules.entities.RulesEntities;
import exception.DontExistException;
import exception.EmptyDataShowException;

public class PanelTabLocal extends JPanel implements UpdateTabPanel, DBActionButton{

	private static final long serialVersionUID = 1L;
	private JLabel header = null;
	private JPanel changePersonal1 = null;  //  @jve:decl-index=0:visual-constraint="0,84"
	private JScrollPane scrollPersonal = null;
	private JList listLocals = null;
	private DefaultListModel listLocalsModel = null;
	private JLabel changeLabelHeader2 = null;
	private JScrollPane scrollAuthorized = null;
	private JList listAuthorized = null;
	private DefaultListModel listAuthorizedModel = null;
	private JLabel ruleLabel = null;
	private JList listRules = null;
	private JScrollPane scrollRules = null;
	private JPanel panelRadios = null;
	private JRadioButton radioLocal = null;
	private JRadioButton radioKey = null;
	private JLabel localsLabel = null;
	private ButtonGroup buttonGroup = null;  //  @jve:decl-index=0:visual-constraint="856,132"
	private DefaultListModel listRulesModel = null;  //  @jve:decl-index=0:visual-constraint="864,206"
	/**
	 * This is the default constructor
	 * @throws DontExistException 
	 */
	public PanelTabLocal() throws DontExistException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws DontExistException 
	 */
	private void initialize() throws DontExistException {
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 1;
		gridBagConstraints1.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints1.gridy = 1;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridy = 0;
		header = new JLabel();
		header.setText("Locales del centro");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.setSize(794, 626);
		this.setLayout(new GridBagLayout());
		this.setMaximumSize(new Dimension(2147483647, 2147483647));
		this.add(header, gridBagConstraints);
		this.add(getChangePersonal1(), gridBagConstraints1);
	}

	/**
	 * This method initializes changePersonal1	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws DontExistException 
	 */
	private JPanel getChangePersonal1() throws DontExistException {
		if (changePersonal1 == null) {
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints2.gridy = 2;
			localsLabel = new JLabel();
			localsLabel.setText("Locales");
			localsLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 3;
			gridBagConstraints5.fill = GridBagConstraints.NONE;
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 2;
			gridBagConstraints4.insets = new Insets(0, 0, 15, 0);
			gridBagConstraints4.gridy = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 4;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.weighty = 1.0;
			gridBagConstraints3.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints3.gridx = 3;
			ruleLabel = new JLabel();
			ruleLabel.setText("Reglas que tiene asociado");
			ruleLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.fill = GridBagConstraints.BOTH;
			gridBagConstraints22.gridx = 2;
			gridBagConstraints22.gridy = 4;
			gridBagConstraints22.weightx = 1.0;
			gridBagConstraints22.weighty = 1.0;
			gridBagConstraints22.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.BOTH;
			gridBagConstraints20.gridy = 2;
			gridBagConstraints20.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints20.gridx = 2;
			changeLabelHeader2 = new JLabel();
			changeLabelHeader2.setEnabled(true);
			changeLabelHeader2.setDisplayedMnemonic(KeyEvent.VK_S);
			changeLabelHeader2.setText("Personal radicado en el local");
			changeLabelHeader2.setLabelFor(getScrollAuthorized());
			changeLabelHeader2.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.fill = GridBagConstraints.BOTH;
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridy = 4;
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.weighty = 1.0;
			gridBagConstraints18.insets = new Insets(0, 14, 0, 0);
			changePersonal1 = new JPanel();
			changePersonal1.setLayout(new GridBagLayout());
			changePersonal1.setSize(new Dimension(817, 601));
			changePersonal1.add(getScrollPersonal(), gridBagConstraints18);
			changePersonal1.add(changeLabelHeader2, gridBagConstraints20);
			changePersonal1.add(getScrollAuthorized(), gridBagConstraints22);
			changePersonal1.add(getScrollRules(), gridBagConstraints3);
			changePersonal1.add(header, gridBagConstraints4);
			changePersonal1.add(getPanelRadios(), gridBagConstraints5);
			changePersonal1.add(localsLabel, gridBagConstraints2);
			getButtonGroup();
		}
		return changePersonal1;
	}

	/**
	 * This method initializes scrollPersonal	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws DontExistException 
	 */
	private JScrollPane getScrollPersonal() throws DontExistException {
		if (scrollPersonal == null) {
			scrollPersonal = new JScrollPane();
			scrollPersonal.setFont(new Font("Calibri", Font.PLAIN, 12));
			scrollPersonal.setViewportView(getListLocals());
			scrollPersonal.setPreferredSize(new Dimension(240, 500));
		}
		return scrollPersonal;
	}

	/**
	 * This method initializes listLocalsModel	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 * @throws DontExistException 
	 */
	private DefaultListModel getListLocalsModel() throws DontExistException {
		if (listLocalsModel == null) {
			listLocalsModel = new DefaultListModel();
			
			fillLocals();
		}
		return listLocalsModel;
	}
	
	private void fillLocals() throws DontExistException{
		ArrayList<Local> locals = CEIS.getInstance().getLocals();
		if(locals == null || locals.isEmpty())
			throw new DontExistException("No hay locales creados");
		for(int i = 0; i < locals.size(); i++)
			listLocalsModel.addElement(locals.get(i));
	}

	/**
	 * This method initializes listLocals	
	 * 	
	 * @return javax.swing.JList	
	 * @throws DontExistException 
	 */
	private JList getListLocals() throws DontExistException {
		if (listLocals == null) {
			listLocals = new JList(getListLocalsModel());
			listLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
			listLocals.setOpaque(true);
			listLocals.setEnabled(true);
			listLocals
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							Object sel = listLocals.getSelectedValue();
							if(sel != null){
								if(radioLocal.isSelected())
									fillList((Local)sel);
								else{
									Key key = CEIS.getInstance().findKey(((Local)sel).getName());
									fillList(key);
								}
							}								
						}
					});
			listLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return listLocals;
	}

	/**
	 * This method initializes scrollAuthorized	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollAuthorized() {
		if (scrollAuthorized == null) {
			scrollAuthorized = new JScrollPane();
			scrollAuthorized.setPreferredSize(new Dimension(240, 500));
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
			listAuthorized.setOpaque(true);
			listAuthorized.setEnabled(true);
			listAuthorized.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return listAuthorized;
	}

	/**
	 * This method initializes listRules	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getListRules() {
		if (listRules == null) {
			listRules = new JList(getListRulesModel());
			listRules.setFont(new Font("Calibri", Font.PLAIN, 12));
			listRules.setOpaque(true);
		}
		return listRules;
	}

	/**
	 * This method initializes scrollRules	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRules() {
		if (scrollRules == null) {
			scrollRules = new JScrollPane(getListRules());
			scrollRules.setPreferredSize(new Dimension(240, 500));
			scrollRules.setOpaque(true);
			scrollRules.setViewportView(getListRules());
		}
		return scrollRules;
	}

	/**
	 * This method initializes panelRadios	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRadios() {
		if (panelRadios == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setHgap(10);
			panelRadios = new JPanel();
			panelRadios.setLayout(flowLayout);
			panelRadios.add(ruleLabel, null);
			panelRadios.add(getRadioLocal(), null);
			panelRadios.add(getRadioKey(), null);
		}
		return panelRadios;
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
			radioLocal.setSelected(true);
			radioLocal.setFont(new Font("Calibri", Font.PLAIN, 12));
			radioLocal.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Local local = (Local)listLocals.getSelectedValue();
					listRulesModel.clear();
					RulesCollection rules = local.getRules();
					if(rules != null)
						for(int i = 0; i < rules.size(); i++)
							listRulesModel.addElement(rules.get(i));
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
			radioKey.setText("Llave");
			radioKey.setFont(new Font("Calibri", Font.PLAIN, 12));
			radioKey.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Local local = (Local)listLocals.getSelectedValue();
					listRulesModel.clear();
					RulesCollection rules = local.getKey().getRules();
					if(rules != null)
						for(int i = 0; i < rules.size(); i++)
							listRulesModel.addElement(rules.get(i));
				}
			});
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
			buttonGroup.add(getRadioKey());
			buttonGroup.add(getRadioLocal());
		}
		return buttonGroup;
	}
	
	private void fillList(RulesEntities re){
		listRulesModel.clear();
		if(re.getRules() != null){
			RulesCollection rules = re.getRules();
			for(int i = 0; i < rules.size(); i++)
				listRulesModel.addElement(re.getRules().get(i));
		}
		
		listAuthorizedModel.clear();
		if(re instanceof Local){
			RegisteredCollection regs = ((Local)re).getRegistereds();
			if(regs != null)
				for(int i = 0; i < regs.size(); i++)
					listAuthorizedModel.addElement(((Local)re).getRegistered(i));
		}
		else{
			RegisteredCollection regs = ((Key)re).getLocal().getRegistereds();
			if(regs != null)
				for(int i = 0; i < regs.size(); i++)
					listAuthorizedModel.addElement(((Key)re).getLocal().getRegistered(i));
		}
	}

	/**
	 * This method initializes listRulesModel	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getListRulesModel() {
		if (listRulesModel == null) {
			listRulesModel = new DefaultListModel();
		}
		return listRulesModel;
	}

	public void delete() throws DontExistException {
		Object[] selectedValues = listLocals.getSelectedValues();
		
		if(selectedValues != null && selectedValues.length > 0)
			for(int i = 0; i < selectedValues.length; i++){
				CEIS.getInstance().getRulesEntities().remove(selectedValues[i]);
			}
	}

	public void update() throws EmptyDataShowException {
		listLocalsModel.clear();
		try {
			fillLocals();
		}
		catch (DontExistException ex){
			JOptionPane.showMessageDialog(PanelTabLocal.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		listAuthorizedModel.clear();
		listRulesModel.clear();
	}
	public Object getSelected() {
		Local loc = (Local)listLocals.getSelectedValue();
		return loc;
	}
	public void selectFirst() {;}
	public void selectLast() {;}
	public void selectNext() {;}
	public void selectPrev() {;}

}  //  @jve:decl-index=0:visual-constraint="10,10"
