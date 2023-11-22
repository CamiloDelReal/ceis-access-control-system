package visual.show;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import visual.own.ToolButton;
import visual.util.GraphicSupport;
import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;
import ceis.CEIS;
import ceis.rules.Rule;
import ceis.rules.RulesCollection;
import ceis.rules.entities.Local;
import ceis.rules.util.enumeration.TypeRule;
import exception.DontExistException;
import exception.EmptyDataShowException;

public class PanelTabRules extends JPanel implements UpdateTabPanel, DBActionButton{

	private static final long serialVersionUID = 1L;
	private Rule rule;
	private JDialog dialog = null;
	private JLabel header = null;
	private JPanel panelLocalsJKeys = null;
	private JPanel scheduleAccess = null;
	private JLabel labelWeekAccess = null;
	private JTextField scheduleWeekAccess = null;
	private JLabel labelWeekendAccess = null;
	private JTextField scheduleWeekendAccess = null;
	private JPanel scheduleRequest = null;
	private JLabel labelWeekRequest = null;
	private JTextField scheduleWeekRequest = null;
	private JLabel labelWeekendRequest = null;
	private JTextField scheduleWeekendRequest = null;
	private JPanel panelBoth = null;
	private JLabel labelAccess = null;
	private JLabel labelRequest = null;
	private JList listRulesAccess = null;
	private JList listRulesRequest = null;
	private JScrollPane scrollRulesAccess = null;
	private JScrollPane scrollRulesRequest = null;
	private JList listLocals = null;
	private JScrollPane scrollLocals = null;
	private DefaultListModel modelListLocals = null;  //  @jve:decl-index=0:visual-constraint="697,12"
	private DefaultListModel modelListAccess = null;  //  @jve:decl-index=0:visual-constraint="694,67"
	private DefaultListModel modelListRequest = null;  //  @jve:decl-index=0:visual-constraint="696,115"
	private JLabel labelLocals = null;
	private JPanel panelOrientedLocalRule = null;
	private JLabel orientedLocalRule = null;
	private JTextField orientedLocalField = null;
	private JPanel panelOrientedKeyRule = null;
	private JLabel orientedKeyRule = null;
	private JTextField orientedKeyField = null;
	private JDialog dialogDelete = null;  //  @jve:decl-index=0:visual-constraint="790,147"
	private JPanel contentPane = null;
	private JCheckBox ruleAccess = null;
	private JCheckBox ruleRequest = null;
	private JButton acept = null;
	private JButton cancel = null;
	private JPanel panelButton = null;
	private JDialog dialogModify = null;  //  @jve:decl-index=0:visual-constraint="750,440"
	private JPanel contentPane1 = null;
	private JPanel panelButton1 = null;
	private JButton acept1 = null;
	private JButton cancel1 = null;
	private JRadioButton jRadioButton = null;
	private JRadioButton jRadioButton1 = null;
	private ButtonGroup buttonGroup = null;  //  @jve:decl-index=0:visual-constraint="927,379"
	private ToolButton toolButton = null;
	private ToolButton toolButton1 = null;
	private JDialog dialogSeeAuthorizedAccess = null;  //  @jve:decl-index=0:visual-constraint="15,570"
	private JPanel jContentPane = null;
	private JScrollPane jScrollPane = null;
	private JButton jButton = null;
	private JList listAuthoAccess = null;
	private DefaultListModel modelList1 = null;  //  @jve:decl-index=0:visual-constraint="248,591"
	/**
	 * This is the default constructor
	 * @throws DontExistException 
	 */
	public PanelTabRules() throws DontExistException {
		super();
		initialize();
		getButtonGroup();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws DontExistException 
	 */
	private void initialize() throws DontExistException {
		labelLocals = new JLabel();
		labelLocals.setText("Seleccione el local");
		labelLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
		GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
		gridBagConstraints22.gridx = 1;
		gridBagConstraints22.insets = new Insets(10, 5, 0, 0);
		gridBagConstraints22.gridy = 4;
		GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
		gridBagConstraints16.gridx = 0;
		gridBagConstraints16.insets = new Insets(10, 0, 0, 0);
		gridBagConstraints16.fill = GridBagConstraints.VERTICAL;
		gridBagConstraints16.gridy = 4;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints.gridy = 0;
		header = new JLabel();
		header.setText("Reglas");
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.setSize(677, 540);
		this.setLayout(new GridBagLayout());
		this.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.add(header, gridBagConstraints);
		this.add(getPanelLocalsJKeys(), gridBagConstraints16);
		this.add(getPanelBoth(), gridBagConstraints22);
	}

	/**
	 * This method initializes panelLocalsJKeys	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws DontExistException 
	 */
	private JPanel getPanelLocalsJKeys() throws DontExistException {
		if (panelLocalsJKeys == null) {
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = -1;
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints5.anchor = GridBagConstraints.WEST;
			gridBagConstraints5.gridy = -1;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.fill = GridBagConstraints.BOTH;
			gridBagConstraints15.gridy = 1;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.weighty = 1.0;
			gridBagConstraints15.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints15.gridx = 0;
			panelLocalsJKeys = new JPanel();
			panelLocalsJKeys.setLayout(new GridBagLayout());
			panelLocalsJKeys.setOpaque(false);
			panelLocalsJKeys.add(getScrollLocals(), gridBagConstraints15);
			panelLocalsJKeys.add(labelLocals, gridBagConstraints5);
		}
		return panelLocalsJKeys;
	}

	/**
	 * This method initializes scheduleAccess	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getScheduleAccess() {
		if (scheduleAccess == null) {
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 3;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints3.gridy = 2;
			labelWeekendAccess = new JLabel();
			labelWeekendAccess.setText("Fin de semana");
			labelWeekendAccess.setPreferredSize(new Dimension(112, 16));
			labelWeekendAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 1;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints1.gridy = 0;
			labelWeekAccess = new JLabel();
			labelWeekAccess.setText("Entre semana");
			labelWeekAccess.setPreferredSize(new Dimension(112, 16));
			labelWeekAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
			scheduleAccess = new JPanel();
			scheduleAccess.setLayout(new GridBagLayout());
			scheduleAccess.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Horario", TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.PLAIN, 13), Color.black));
			scheduleAccess.add(labelWeekAccess, gridBagConstraints1);
			scheduleAccess.add(getScheduleWeekAccess(), gridBagConstraints2);
			scheduleAccess.add(labelWeekendAccess, gridBagConstraints3);
			scheduleAccess.add(getScheduleWeekendAccess(), gridBagConstraints4);
		}
		return scheduleAccess;
	}

	/**
	 * This method initializes scheduleWeekAccess	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getScheduleWeekAccess() {
		if (scheduleWeekAccess == null) {
			scheduleWeekAccess = new JTextField();
			scheduleWeekAccess.setColumns(15);
			scheduleWeekAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
			scheduleWeekAccess.setEditable(false);
			scheduleWeekAccess.setText("");
		}
		return scheduleWeekAccess;
	}

	/**
	 * This method initializes scheduleWeekendAccess	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getScheduleWeekendAccess() {
		if (scheduleWeekendAccess == null) {
			scheduleWeekendAccess = new JTextField();
			scheduleWeekendAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
			scheduleWeekendAccess.setEditable(false);
			scheduleWeekendAccess.setColumns(15);
		}
		return scheduleWeekendAccess;
	}

	/**
	 * This method initializes scheduleRequest	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getScheduleRequest() {
		if (scheduleRequest == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridy = -1;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.weighty = 1.0;
			gridBagConstraints12.gridx = -1;
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.fill = GridBagConstraints.BOTH;
			gridBagConstraints41.gridx = 0;
			gridBagConstraints41.gridy = 3;
			gridBagConstraints41.weightx = 1.0;
			gridBagConstraints41.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints31.gridx = 0;
			gridBagConstraints31.gridy = 2;
			gridBagConstraints31.insets = new Insets(0, 2, 0, 0);
			labelWeekendRequest = new JLabel();
			labelWeekendRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelWeekendRequest.setText("Fin de semana");
			labelWeekendRequest.setPreferredSize(new Dimension(112, 16));
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.BOTH;
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 0;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			labelWeekRequest = new JLabel();
			labelWeekRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelWeekRequest.setText("Entre semana");
			labelWeekRequest.setPreferredSize(new Dimension(112, 16));
			scheduleRequest = new JPanel();
			scheduleRequest.setLayout(new GridBagLayout());
			scheduleRequest.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Horario", TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.PLAIN, 13), Color.black));
			scheduleRequest.add(labelWeekRequest, gridBagConstraints11);
			scheduleRequest.add(getScheduleWeekRequest(), gridBagConstraints21);
			scheduleRequest.add(labelWeekendRequest, gridBagConstraints31);
			scheduleRequest.add(getScheduleWeekendRequest(), gridBagConstraints41);
		}
		return scheduleRequest;
	}

	/**
	 * This method initializes scheduleWeekRequest	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getScheduleWeekRequest() {
		if (scheduleWeekRequest == null) {
			scheduleWeekRequest = new JTextField();
			scheduleWeekRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
			scheduleWeekRequest.setEditable(false);
			scheduleWeekRequest.setColumns(15);
			scheduleWeekRequest.setText("");
		}
		return scheduleWeekRequest;
	}

	/**
	 * This method initializes scheduleWeekendRequest	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getScheduleWeekendRequest() {
		if (scheduleWeekendRequest == null) {
			scheduleWeekendRequest = new JTextField();
			scheduleWeekendRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
			scheduleWeekendRequest.setColumns(15);
			scheduleWeekendRequest.setEditable(false);
		}
		return scheduleWeekendRequest;
	}

	/**
	 * This method initializes panelBoth	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelBoth() {
		if (panelBoth == null) {
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.gridx = 3;
			gridBagConstraints19.insets = new Insets(69, 8, 10, 0);
			gridBagConstraints19.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints19.gridy = 2;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.gridx = 3;
			gridBagConstraints18.insets = new Insets(69, 8, 10, 0);
			gridBagConstraints18.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints18.gridy = 5;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 3;
			gridBagConstraints14.insets = new Insets(0, 8, 0, 0);
			gridBagConstraints14.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints14.gridy = 6;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 3;
			gridBagConstraints13.insets = new Insets(0, 8, 0, 0);
			gridBagConstraints13.fill = GridBagConstraints.NONE;
			gridBagConstraints13.ipadx = 0;
			gridBagConstraints13.gridy = 3;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.fill = GridBagConstraints.BOTH;
			gridBagConstraints10.gridy = 5;
			gridBagConstraints10.weightx = 1.0;
			gridBagConstraints10.weighty = 1.0;
			gridBagConstraints10.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints10.gridheight = 2;
			gridBagConstraints10.anchor = GridBagConstraints.NORTH;
			gridBagConstraints10.gridx = 1;
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.BOTH;
			gridBagConstraints9.gridy = 2;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.weighty = 1.0;
			gridBagConstraints9.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints9.gridheight = 2;
			gridBagConstraints9.gridx = 1;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 1;
			gridBagConstraints8.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints8.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints8.gridy = 4;
			labelRequest = new JLabel();
			labelRequest.setText("Reglas de solicitud de llave");
			labelRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints7.gridy = 1;
			labelAccess = new JLabel();
			labelAccess.setText("Reglas de acceso");
			labelAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
			panelBoth = new JPanel();
			panelBoth.setLayout(new GridBagLayout());
			panelBoth.add(labelAccess, gridBagConstraints7);
			panelBoth.add(labelRequest, gridBagConstraints8);
			panelBoth.add(getScrollRulesAccess(), gridBagConstraints9);
			panelBoth.add(getScrollRulesRequest(), gridBagConstraints10);
			panelBoth.add(getScheduleAccess(), gridBagConstraints13);
			panelBoth.add(getScheduleRequest(), gridBagConstraints14);
			panelBoth.add(getPanelOrientedKeyRule(), gridBagConstraints18);
			panelBoth.add(getPanelOrientedLocalRule(), gridBagConstraints19);
		}
		return panelBoth;
	}

	/**
	 * This method initializes listRulesAccess	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getListRulesAccess() {
		if (listRulesAccess == null) {
			listRulesAccess = new JList(getModelListAccess());
			listRulesAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
			listRulesAccess.setOpaque(true);
			listRulesAccess
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							Rule rule = (Rule) listRulesAccess.getSelectedValue();
							if(rule != null){
								labelWeekAccess.setText(rule.getWeekScheduleLabel());
								scheduleWeekAccess.setText(rule.getWeekSchedule());
								labelWeekendAccess.setText(rule.getWeekendScheduleLabel());
								scheduleWeekendAccess.setText(rule.getWeekendSchedule());
								orientedLocalField.setText(getStringByTypeRule(rule.getType()));
								if(rule.getType() == TypeRule.TO_SELECTED_PEOPLE)
									toolButton.setEnabled(true);
								else
									toolButton.setEnabled(false);
							}
							else
								toolButton.setEnabled(false);
						}
					});
		}
		return listRulesAccess;
	}

	/**
	 * This method initializes listRulesRequest	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getListRulesRequest() {
		if (listRulesRequest == null) {
			listRulesRequest = new JList(getModelListRequest());
			listRulesRequest
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							Rule rule = (Rule) listRulesRequest.getSelectedValue();
							if(rule != null){
								labelWeekRequest.setText(rule.getWeekScheduleLabel());
								scheduleWeekRequest.setText(rule.getWeekSchedule());
								labelWeekendRequest.setText(rule.getWeekendScheduleLabel());
								scheduleWeekendRequest.setText(rule.getWeekendSchedule());
								orientedKeyField.setText(getStringByTypeRule(rule.getType()));
								if(rule.getType() == TypeRule.TO_SELECTED_PEOPLE)
									toolButton1.setEnabled(true);
								else
									toolButton1.setEnabled(false);
							}
							else
								toolButton1.setEnabled(false);
						}
					});
			listRulesRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
			listRulesRequest.setOpaque(true);
		}
		return listRulesRequest;
	}

	/**
	 * This method initializes scrollRulesAccess	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRulesAccess() {
		if (scrollRulesAccess == null) {
			scrollRulesAccess = new JScrollPane(getListRulesAccess());
			scrollRulesAccess.setPreferredSize(new Dimension(200, 200));
			scrollRulesAccess.setViewportView(getListRulesAccess());
		}
		return scrollRulesAccess;
	}

	/**
	 * This method initializes scrollRulesRequest	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollRulesRequest() {
		if (scrollRulesRequest == null) {
			scrollRulesRequest = new JScrollPane(getListRulesRequest());
			scrollRulesRequest.setPreferredSize(new Dimension(200, 200));
			scrollRulesRequest.setViewportView(getListRulesRequest());
		}
		return scrollRulesRequest;
	}

	/**
	 * This method initializes listLocals	
	 * 	
	 * @return javax.swing.JList	
	 * @throws DontExistException 
	 */
	private JList getListLocals() throws DontExistException {
		if (listLocals == null) {
			listLocals = new JList(getModelListLocals());
			listLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
			listLocals.setOpaque(true);
			listLocals
					.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
						public void valueChanged(javax.swing.event.ListSelectionEvent e) {
							Local local = (Local)listLocals.getSelectedValue();
							modelListAccess.clear();
							fillListAccess(local);
							modelListRequest.clear();
							fillListRequest(local);
						}
					});
		}
		return listLocals;
	}

	/**
	 * This method initializes scrollLocals	
	 * 	
	 * @return javax.swing.JScrollPane	
	 * @throws DontExistException 
	 */
	private JScrollPane getScrollLocals() throws DontExistException {
		if (scrollLocals == null) {
			scrollLocals = new JScrollPane(getListLocals());
			scrollLocals.setPreferredSize(new Dimension(250, 140));
			scrollLocals.setViewportView(getListLocals());
		}
		return scrollLocals;
	}

	/**
	 * This method initializes modelListLocals	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 * @throws DontExistException 
	 */
	private DefaultListModel getModelListLocals() throws DontExistException {
		if (modelListLocals == null) {
			modelListLocals = new DefaultListModel();
			fillListLocals();
		}
		return modelListLocals;
	}
	
	private void fillListLocals() throws DontExistException{
		ArrayList<Local> locals = CEIS.getInstance().getLocals();
		
		if(locals == null || locals.isEmpty())
			throw new DontExistException("No se han creado locales en el centro");
		
		for(int i = 0; i < locals.size(); i++)
			modelListLocals.addElement(locals.get(i));
	}
	
	private void fillListAccess(Local local){
		if(local == null)
			return;
		
			RulesCollection rules = local.getRules();
			
		if(rules != null){			
			for(int i = 0; i < rules.size(); i++)
				modelListAccess.addElement(rules.get(i));
		}
	}
	
	private void fillListRequest(Local local){
		if(local == null)
			return;
		
		RulesCollection rules = local.getKey().getRules();
		
		if(rules != null)
			for(int i = 0; i < rules.size(); i++)
				modelListRequest.addElement(rules.get(i));
	}

	/**
	 * This method initializes modelListAccess	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getModelListAccess() {
		if (modelListAccess == null) {
			modelListAccess = new DefaultListModel();
		}
		return modelListAccess;
	}

	/**
	 * This method initializes modelListRequest	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getModelListRequest() {
		if (modelListRequest == null) {
			modelListRequest = new DefaultListModel();
		}
		return modelListRequest;
	}

	/**
	 * This method initializes panelOrientedLocalRule	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelOrientedLocalRule() {
		if (panelOrientedLocalRule == null) {
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.gridx = 1;
			gridBagConstraints27.insets = new Insets(0, 0, 0, 1);
			gridBagConstraints27.gridy = 1;
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = GridBagConstraints.BOTH;
			gridBagConstraints17.gridy = 1;
			gridBagConstraints17.weightx = 1.0;
			gridBagConstraints17.insets = new Insets(0, 14, 0, 1);
			gridBagConstraints17.gridx = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints6.gridy = 0;
			orientedLocalRule = new JLabel();
			orientedLocalRule.setText("Orientada a");
			orientedLocalRule.setFont(new Font("Calibri", Font.PLAIN, 12));
			panelOrientedLocalRule = new JPanel();
			panelOrientedLocalRule.setLayout(new GridBagLayout());
			panelOrientedLocalRule.add(orientedLocalRule, gridBagConstraints6);
			panelOrientedLocalRule.add(getOrientedLocalField(), gridBagConstraints17);
			panelOrientedLocalRule.add(getToolButton(), gridBagConstraints27);
		}
		return panelOrientedLocalRule;
	}

	/**
	 * This method initializes orientedLocalField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOrientedLocalField() {
		if (orientedLocalField == null) {
			orientedLocalField = new JTextField();
			orientedLocalField.setColumns(13);
			orientedLocalField.setFont(new Font("Calibri", Font.PLAIN, 12));
			orientedLocalField.setEditable(false);
		}
		return orientedLocalField;
	}

	/**
	 * This method initializes panelOrientedKeyRule	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelOrientedKeyRule() {
		if (panelOrientedKeyRule == null) {
			GridBagConstraints gridBagConstraints28 = new GridBagConstraints();
			gridBagConstraints28.gridx = 1;
			gridBagConstraints28.insets = new Insets(0, 0, 0, 1);
			gridBagConstraints28.gridy = 1;
			GridBagConstraints gridBagConstraints171 = new GridBagConstraints();
			gridBagConstraints171.fill = GridBagConstraints.BOTH;
			gridBagConstraints171.gridx = 0;
			gridBagConstraints171.gridy = 1;
			gridBagConstraints171.weightx = 1.0;
			gridBagConstraints171.insets = new Insets(0, 14, 0, 1);
			GridBagConstraints gridBagConstraints61 = new GridBagConstraints();
			gridBagConstraints61.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints61.gridx = 0;
			gridBagConstraints61.gridy = 0;
			gridBagConstraints61.insets = new Insets(0, 2, 0, 0);
			orientedKeyRule = new JLabel();
			orientedKeyRule.setFont(new Font("Calibri", Font.PLAIN, 12));
			orientedKeyRule.setText("Orientada a");
			panelOrientedKeyRule = new JPanel();
			panelOrientedKeyRule.setLayout(new GridBagLayout());
			panelOrientedKeyRule.add(orientedKeyRule, gridBagConstraints61);
			panelOrientedKeyRule.add(getOrientedKeyField(), gridBagConstraints171);
			panelOrientedKeyRule.add(getToolButton1(), gridBagConstraints28);
		}
		return panelOrientedKeyRule;
	}

	/**
	 * This method initializes orientedKeyField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOrientedKeyField() {
		if (orientedKeyField == null) {
			orientedKeyField = new JTextField();
			orientedKeyField.setEditable(false);
			orientedKeyField.setFont(new Font("Calibri", Font.PLAIN, 12));
			orientedKeyField.setColumns(13);
		}
		return orientedKeyField;
	}
	
	private String getStringByTypeRule(TypeRule type){
		String result = null;
		
		if(type == TypeRule.TO_ALL)
			result = "Todo el personal";
		else if(type == TypeRule.TO_DOCENT )
			result = "Docentes";
		else if(type == TypeRule.TO_SELECTED_PEOPLE )
			result = "Personal seleccionado";
		else if(type == TypeRule.TO_STUDENTASSISTANT )
			result = "Alumnos ayudantes";
		else if(type == TypeRule.TO_TECNICADMIN )
			result = "Técnicos-Administrativos";
		else if(type == TypeRule.TO_VISITOR )
			result = "Visitantes";
		else if(type == TypeRule.TO_WORKER_OF_LOCAL )
			result = "Trabajadores del local";
		
		return result;
	}

	public void delete() throws DontExistException {
		 dialog = getDialogDelete();
		 dialog.setVisible(true);
	}

	public void update() throws EmptyDataShowException {
		modelListAccess.removeAllElements();
		modelListRequest.removeAllElements();
		modelListLocals.removeAllElements();
		orientedLocalField.setText("");
		scheduleWeekAccess.setText("");
		scheduleWeekendAccess.setText("");
		orientedKeyField.setText("");
		scheduleWeekRequest.setText("");
		scheduleWeekendRequest.setText("");
		try {
			fillListLocals();
		}
		catch (DontExistException e) {
			JOptionPane.showMessageDialog(PanelTabRules.this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * This method initializes dialogDelete	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getDialogDelete() {
		if (dialogDelete == null) {
			dialogDelete = new JDialog();
			dialogDelete.setModal(true);
			dialogDelete.setSize(new Dimension(186, 124));
			dialogDelete.setResizable(false);
			dialogDelete.setTitle("¿Que eliminar?");
			dialogDelete.setContentPane(getContentPane());
			GraphicSupport.centerWindow(dialogDelete);
		}
		return dialogDelete;
	}

	/**
	 * This method initializes contentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getContentPane() {
		if (contentPane == null) {
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.gridx = 1;
			gridBagConstraints24.insets = new Insets(10, 0, 0, 0);
			gridBagConstraints24.gridy = 2;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 0;
			gridBagConstraints23.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints23.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints23.gridwidth = 2;
			gridBagConstraints23.gridy = 1;
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.gridx = 0;
			gridBagConstraints20.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints20.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints20.gridwidth = 2;
			gridBagConstraints20.anchor = GridBagConstraints.WEST;
			gridBagConstraints20.gridy = 0;
			contentPane = new JPanel();
			contentPane.setLayout(new GridBagLayout());
			contentPane.add(getRuleAccess(), gridBagConstraints20);
			contentPane.add(getRuleRequest(), gridBagConstraints23);
			contentPane.add(getPanelButton(), gridBagConstraints24);
		}
		return contentPane;
	}

	/**
	 * This method initializes ruleAccess	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getRuleAccess() {
		if (ruleAccess == null) {
			ruleAccess = new JCheckBox();
			ruleAccess.setText("Regla de acceso a local");
			ruleAccess.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return ruleAccess;
	}

	/**
	 * This method initializes ruleRequest	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getRuleRequest() {
		if (ruleRequest == null) {
			ruleRequest = new JCheckBox();
			ruleRequest.setText("Regla de solicitud de llave");
			ruleRequest.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return ruleRequest;
	}

	/**
	 * This method initializes acept	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAcept() {
		if (acept == null) {
			acept = new JButton();
			acept.setText("Aceptar");
			acept.setFont(new Font("Calibri", Font.PLAIN, 12));
			acept.setPreferredSize(new Dimension(75, 28));
			acept.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Local local = (Local)listLocals.getSelectedValue();
					
					if(local != null){					
						if(ruleAccess.isSelected()){
							Rule rule = (Rule)listRulesAccess.getSelectedValue();
							local.getRules().remove(rule);
						}
						if(ruleRequest.isSelected()){
							Rule rule = (Rule)listRulesRequest.getSelectedValue();
							local.getKey().getRules().remove(rule);
						}
					}
					ruleAccess.setSelected(false);
					ruleRequest.setSelected(false);
					dialog.dispose();
				}
			});
		}
		return acept;
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
			cancel.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ruleAccess.setSelected(false);
					ruleRequest.setSelected(false);
					dialogDelete.dispose();
				}
			});
		}
		return cancel;
	}

	/**
	 * This method initializes panelButton	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelButton() {
		if (panelButton == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.LEFT);
			panelButton = new JPanel();
			panelButton.setLayout(flowLayout);
			panelButton.add(getAcept(), null);
			panelButton.add(getCancel(), null);
		}
		return panelButton;
	}

	public Object getSelected() {
		JDialog dialog = getDialogModify();
		dialog.setVisible(true);
		return rule;
	}
	public void selectFirst() {;}
	public void selectLast() {;}
	public void selectNext() {;}
	public void selectPrev() {;}

	/**
	 * This method initializes dialogModify	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getDialogModify() {
		if (dialogModify == null) {
			dialogModify = new JDialog();
			dialogModify.setModal(true);
			dialogModify.setSize(new Dimension(184, 124));
			dialogModify.setResizable(false);
			dialogModify.setContentPane(getContentPane1());
			dialogModify.setTitle("¿Que modificar?");
			GraphicSupport.centerWindow(dialogModify);
		}
		return dialogModify;
	}

	/**
	 * This method initializes contentPane1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getContentPane1() {
		if (contentPane1 == null) {
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 1;
			gridBagConstraints26.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints26.anchor = GridBagConstraints.WEST;
			gridBagConstraints26.gridy = 1;
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 1;
			gridBagConstraints25.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints25.anchor = GridBagConstraints.WEST;
			gridBagConstraints25.gridy = 0;
			GridBagConstraints gridBagConstraints241 = new GridBagConstraints();
			gridBagConstraints241.insets = new Insets(10, 0, 0, 0);
			gridBagConstraints241.gridy = 2;
			gridBagConstraints241.gridx = 1;
			contentPane1 = new JPanel();
			contentPane1.setLayout(new GridBagLayout());
			contentPane1.add(getPanelButton1(), gridBagConstraints241);
			contentPane1.add(getJRadioButton(), gridBagConstraints25);
			contentPane1.add(getJRadioButton1(), gridBagConstraints26);
		}
		return contentPane1;
	}

	/**
	 * This method initializes panelButton1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelButton1() {
		if (panelButton1 == null) {
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setAlignment(FlowLayout.LEFT);
			panelButton1 = new JPanel();
			panelButton1.setLayout(flowLayout1);
			panelButton1.add(getAcept1(), null);
			panelButton1.add(getCancel1(), null);
		}
		return panelButton1;
	}

	/**
	 * This method initializes acept1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getAcept1() {
		if (acept1 == null) {
			acept1 = new JButton();
			acept1.setFont(new Font("Calibri", Font.PLAIN, 12));
			acept1.setText("Aceptar");
			acept1.setPreferredSize(new Dimension(75, 28));
			acept1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if(jRadioButton.isSelected())
						rule = (Rule)listRulesAccess.getSelectedValue();
					else
						rule = (Rule)listRulesRequest.getSelectedValue();
					dialogModify.dispose();
				}
			});
		}
		return acept1;
	}

	/**
	 * This method initializes cancel1	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getCancel1() {
		if (cancel1 == null) {
			cancel1 = new JButton();
			cancel1.setFont(new Font("Calibri", Font.PLAIN, 12));
			cancel1.setText("Cancelar");
			cancel1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					rule = null;
					dialogModify.dispose();
				}
			});
		}
		return cancel1;
	}

	/**
	 * This method initializes jRadioButton	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton() {
		if (jRadioButton == null) {
			jRadioButton = new JRadioButton();
			jRadioButton.setText("Regla de acceso a local");
		}
		return jRadioButton;
	}

	/**
	 * This method initializes jRadioButton1	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getJRadioButton1() {
		if (jRadioButton1 == null) {
			jRadioButton1 = new JRadioButton();
			jRadioButton1.setText("Regla de solicitud de llave");
		}
		return jRadioButton1;
	}

	/**
	 * This method initializes buttonGroup	
	 * 	
	 * @return javax.swing.ButtonGroup	
	 */
	private ButtonGroup getButtonGroup() {
		if (buttonGroup == null) {
			buttonGroup = new ButtonGroup();
			buttonGroup.add(getJRadioButton());
			buttonGroup.add(getJRadioButton1());
		}
		return buttonGroup;
	}

	/**
	 * This method initializes toolButton	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getToolButton() {
		if (toolButton == null) {
			toolButton = new ToolButton(new ImageIcon("src/icons/scheme.png"), null, "Ver personal asociado");
			toolButton.setEnabled(false);
			toolButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Rule ruleAux = (Rule)listRulesAccess.getSelectedValue();
					JDialog dialog = getDialogSeeAuthorizedAccess(ruleAux);
					dialog.setVisible(true);
					dialog = null;
				}
			});
		}
		return toolButton;
	}

	/**
	 * This method initializes toolButton1	
	 * 	
	 * @return visual.own.ToolButton	
	 */
	private ToolButton getToolButton1() {
		if (toolButton1 == null) {
			toolButton1 = new ToolButton(new ImageIcon("src/icons/scheme.png"), null, "Rev pesonal asociado");
			toolButton1.setEnabled(false);
			toolButton1.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Rule ruleAux = (Rule)listRulesRequest.getSelectedValue();
					JDialog dialog = getDialogSeeAuthorizedAccess(ruleAux);
					dialog.setVisible(true);
					dialog = null;
				}
			});
		}
		return toolButton1;
	}

	/**
	 * This method initializes dialogSeeAuthorizedAccess	
	 * 	
	 * @return javax.swing.JDialog	
	 */
	private JDialog getDialogSeeAuthorizedAccess(Rule ruleAux) {
			dialogSeeAuthorizedAccess = new JDialog();
			dialogSeeAuthorizedAccess.setSize(new Dimension(204, 281));
			dialogSeeAuthorizedAccess.setModal(true);
			dialogSeeAuthorizedAccess.setTitle("Personal autorizado");
			dialogSeeAuthorizedAccess.setResizable(false);
			dialogSeeAuthorizedAccess.setContentPane(getJContentPane());
			modelList1.removeAllElements();
			if(ruleAux != null){
				if(ruleAux.getAuthorized() != null)
					for(int i = 0; i < ruleAux.getAuthorized().size(); i++)
						modelList1.addElement(ruleAux.getAuthorized().get(i));
			}
			GraphicSupport.centerWindow(dialogSeeAuthorizedAccess);

		return dialogSeeAuthorizedAccess;
	}

	/**
	 * This method initializes jContentPane	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints30 = new GridBagConstraints();
			gridBagConstraints30.fill = GridBagConstraints.BOTH;
			gridBagConstraints30.gridy = 0;
			gridBagConstraints30.weightx = 1.0;
			gridBagConstraints30.weighty = 1.0;
			gridBagConstraints30.gridx = 0;
			GridBagConstraints gridBagConstraints29 = new GridBagConstraints();
			gridBagConstraints29.gridx = 0;
			gridBagConstraints29.fill = GridBagConstraints.NONE;
			gridBagConstraints29.gridy = 1;
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(getJButton(), gridBagConstraints29);
			jContentPane.add(getJScrollPane(), gridBagConstraints30);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getListAuthoAccess());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Aceptar");
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					dialogSeeAuthorizedAccess.dispose();
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes listAuthoAccess	
	 * 	
	 * @return javax.swing.JList	
	 */
	private JList getListAuthoAccess() {
		if (listAuthoAccess == null) {
			listAuthoAccess = new JList(getModelList1());
		}
		return listAuthoAccess;
	}

	/**
	 * This method initializes modelList1	
	 * 	
	 * @return javax.swing.DefaultListModel	
	 */
	private DefaultListModel getModelList1() {
		if (modelList1 == null) {
			modelList1 = new DefaultListModel();
		}
		return modelList1;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
