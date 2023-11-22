package visual.dialog.rules;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import visual.dialog.util.TypeRuleToCombo;
import visual.own.ToolButton;
import visual.util.GraphicSupport;
import ceis.CEIS;
import ceis.collection.PersonCollection;
import ceis.person.Person;
import ceis.rules.Rule;
import ceis.rules.entities.Local;
import ceis.rules.util.enumeration.TypeRule;
import exception.DontExistException;
import exception.EmptyException;
import exception.ErronealTimeException;

public class DialogNewRule extends JDialog {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<TypeRuleToCombo> typeInCombo;  //  @jve:decl-index=0:
	
	private Rule rule = null;
	
	private Calendar initWeek, endWeek, initWeekend, endWeekend;  //  @jve:decl-index=0:

	private JPanel jContentPane = null;

	private JLabel header = null;

	private JPanel panelRadios = null;

	private JRadioButton radiolocal = null;

	private JRadioButton radioKey = null;

	private JPanel panel1 = null;

	private JComboBox comboLocalKey = null;

	private JPanel panelSchedule = null;

	private ButtonGroup radioTypeGroup = null;  //  @jve:decl-index=0:visual-constraint="505,22"

	private JCheckBox weekCheck = null;

	private JLabel initWeekLabel = null;

	private JLabel endWeekLabel = null;

	private JSpinner initWeekSpinner = null;

	private JSpinner endWeekSpinner = null;

	private JCheckBox weekendCheck = null;

	private JLabel initWeekendLabel = null;

	private JLabel endWeekendLabel = null;

	private JSpinner initWeekendSpinner = null;

	private JSpinner endWeekendSpinner = null;

	private SpinnerDateModel modelInitWeek = null;  //  @jve:decl-index=0:visual-constraint="515,95"

	private SpinnerDateModel modelEndWeek = null;  //  @jve:decl-index=0:visual-constraint="595,96"

	private SpinnerDateModel modelInitWeekend = null;  //  @jve:decl-index=0:visual-constraint="676,97"

	private SpinnerDateModel modelEndWeekend = null;  //  @jve:decl-index=0:visual-constraint="773,99"

	private SimpleDateFormat formatInitWeek = null;  //  @jve:decl-index=0:visual-constraint="508,149"

	private SimpleDateFormat formatEndWeek = null;  //  @jve:decl-index=0:visual-constraint="589,147"

	private SimpleDateFormat formatInitWeekend = null;  //  @jve:decl-index=0:visual-constraint="674,147"

	private SimpleDateFormat formatEndWeekend = null;  //  @jve:decl-index=0:visual-constraint="775,149"

	private JSpinner.DateEditor editorInitWeek = null;  //  @jve:decl-index=0:visual-constraint="505,200"

	private JSpinner.DateEditor editorEndWeek = null;  //  @jve:decl-index=0:visual-constraint="586,201"

	private JSpinner.DateEditor editorInitWeekend = null;  //  @jve:decl-index=0:visual-constraint="673,199"

	private JSpinner.DateEditor editorEndWeekend = null;  //  @jve:decl-index=0:visual-constraint="772,200"

	private JLabel nameLabel = null;

	private JTextField nameField = null;

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

	private JLabel orientedLabel = null;

	private JComboBox comboOriented = null;

	private JPanel panelButtonBoth = null;

	private JButton apply = null;

	private JButton accept = null;

	private JButton cancel = null;

	private DefaultComboBoxModel modelLocalKeyCombo = null;  //  @jve:decl-index=0:visual-constraint="606,25"

	private DefaultComboBoxModel modelOrientedCombo = null;  //  @jve:decl-index=0:visual-constraint="730,26"

	private JPanel panelWeekDays = null;

	private JPanel panelWeekendDays = null;

	private JComboBox comboInitWeekDays = null;

	private JComboBox comboEndWeekDays = null;

	private DefaultComboBoxModel modelComboInitDaysWeek = null;  //  @jve:decl-index=0:visual-constraint="703,273"

	private DefaultComboBoxModel modelComboEndDaysWeek = null;  //  @jve:decl-index=0:visual-constraint="702,320"

	private JComboBox comboInitWeekendDays = null;

	private JComboBox comboEndWeekendDays = null;

	private DefaultComboBoxModel modelComboInitDaysWeekend = null;  //  @jve:decl-index=0:visual-constraint="705,435"

	private DefaultComboBoxModel modelComboEndDaysWeekend = null;  //  @jve:decl-index=0:visual-constraint="706,478"

	private JLabel sss = null;

	private JLabel ssss = null;

	/**
	 * @param owner
	 * @throws DontExistException 
	 */
	public DialogNewRule(Frame owner, Rule rule) throws DontExistException {
		super(owner, true);
		typeInCombo = TypeRuleToCombo.getInstance();
		this.rule = rule;
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
		this.setSize(678, 456);
		this.setTitle("Nueva regla - Acceso/Solicitud");
		this.setIconImage((new ImageIcon("src/icons/scheme.png")).getImage());
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		getRadioTypeGroup();
		pack();
		GraphicSupport.centerWindow(this);
		if(rule != null){
			apply.setEnabled(false);
			radiolocal.setSelected(false);
			radiolocal.setEnabled(false);
			radioKey.setSelected(false);
			radioKey.setEnabled(false);
			modelLocalKeyCombo.setSelectedItem(null);
			comboLocalKey.setEnabled(false);
			modelOrientedCombo.setSelectedItem(select(rule.getType()));
			if(rule.getType() == TypeRule.TO_SELECTED_PEOPLE){
				for(int i = 0; i < rule.getAuthorized().size(); i++){
					listAuthorizedModel.addElement(rule.getAuthorized().get(i));
					listPersonalModel.removeElement(rule.getAuthorized().get(i));
				}
			}
			nameField.setText(rule.getName());
		}
	}
	
	private TypeRuleToCombo select(TypeRule type){
		int i = 0;
		while( i < typeInCombo.size() && type != typeInCombo.get(i).getType())
			i++;

		return i < typeInCombo.size() ? typeInCombo.get(i) : null;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 * @throws DontExistException 
	 */
	private JPanel getJContentPane() throws DontExistException {
		if (jContentPane == null) {
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.gridwidth = 1;
			gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints31.anchor = GridBagConstraints.CENTER;
			gridBagConstraints31.gridy = 2;
			GridBagConstraints gridBagConstraints23 = new GridBagConstraints();
			gridBagConstraints23.gridx = 1;
			gridBagConstraints23.insets = new Insets(22, 10, 0, 0);
			gridBagConstraints23.gridy = 1;
			GridBagConstraints gridBagConstraints110 = new GridBagConstraints();
			gridBagConstraints110.gridx = 0;
			gridBagConstraints110.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints110.insets = new Insets(0, 0, 20, 0);
			gridBagConstraints110.gridy = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridy = 0;
			header = new JLabel();
			header.setText("Creación de una nueva regla");
			header.setHorizontalAlignment(SwingConstants.CENTER);
			header.setFont(new Font("Calibri", Font.PLAIN, 18));
			jContentPane = new JPanel();
			jContentPane.setLayout(new GridBagLayout());
			jContentPane.add(header, gridBagConstraints);
			jContentPane.add(getPanel1(), gridBagConstraints110);
			jContentPane.add(getChangePersonal1(), gridBagConstraints23);
			jContentPane.add(getPanelButtonBoth(), gridBagConstraints31);
		}
		return jContentPane;
	}

	/**
	 * This method initializes panelRadios	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelRadios() {
		if (panelRadios == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.LEFT);
			flowLayout.setHgap(14);
			panelRadios = new JPanel();
			panelRadios.setLayout(flowLayout);
			panelRadios.add(getRadiolocal(), null);
			panelRadios.add(getRadioKey(), null);
		}
		return panelRadios;
	}

	/**
	 * This method initializes radiolocal	
	 * 	
	 * @return javax.swing.JRadioButton	
	 */
	private JRadioButton getRadiolocal() {
		if (radiolocal == null) {
			radiolocal = new JRadioButton();
			radiolocal.setText("Local");
			radiolocal.setSelected(true);
			radiolocal.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return radiolocal;
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
		}
		return radioKey;
	}

	/**
	 * This method initializes panel1	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws DontExistException 
	 */
	private JPanel getPanel1() throws DontExistException {
		if (panel1 == null) {
			GridBagConstraints gridBagConstraints16 = new GridBagConstraints();
			gridBagConstraints16.gridx = 0;
			gridBagConstraints16.gridwidth = 2;
			gridBagConstraints16.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints16.gridy = 4;
			GridBagConstraints gridBagConstraints15 = new GridBagConstraints();
			gridBagConstraints15.fill = GridBagConstraints.BOTH;
			gridBagConstraints15.gridy = 1;
			gridBagConstraints15.weightx = 1.0;
			gridBagConstraints15.gridwidth = 2;
			gridBagConstraints15.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints15.gridx = 0;
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.gridx = 0;
			gridBagConstraints14.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints14.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints14.gridy = 0;
			nameLabel = new JLabel();
			nameLabel.setText("Nombre");
			nameLabel.setHorizontalAlignment(SwingConstants.LEADING);
			nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
			nameLabel.setLabelFor(getNameField());
			nameLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.BOTH;
			gridBagConstraints2.gridy = 3;
			gridBagConstraints2.weightx = 1.0;
			gridBagConstraints2.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints2.gridx = 0;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints1.gridy = 2;
			panel1 = new JPanel();
			panel1.setLayout(new GridBagLayout());
			panel1.add(getPanelRadios(), gridBagConstraints1);
			panel1.add(getComboLocalKey(), gridBagConstraints2);
			panel1.add(nameLabel, gridBagConstraints14);
			panel1.add(getNameField(), gridBagConstraints15);
			panel1.add(getPanelSchedule(), gridBagConstraints16);
		}
		return panel1;
	}

	/**
	 * This method initializes comboLocalKey	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws DontExistException 
	 */
	private JComboBox getComboLocalKey() throws DontExistException {
		if (comboLocalKey == null) {
			comboLocalKey = new JComboBox(getModelLocalKeyCombo());
			comboLocalKey.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return comboLocalKey;
	}

	/**
	 * This method initializes panelSchedule	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelSchedule() {
		if (panelSchedule == null) {
			GridBagConstraints gridBagConstraints26 = new GridBagConstraints();
			gridBagConstraints26.gridx = 0;
			gridBagConstraints26.gridwidth = 2;
			gridBagConstraints26.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints26.gridy = 5;
			GridBagConstraints gridBagConstraints25 = new GridBagConstraints();
			gridBagConstraints25.gridx = 0;
			gridBagConstraints25.gridwidth = 2;
			gridBagConstraints25.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints25.gridy = 1;
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.gridx = 1;
			gridBagConstraints12.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints12.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints12.gridy = 8;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints11.gridy = 6;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.gridy = 8;
			endWeekendLabel = new JLabel();
			endWeekendLabel.setText("Hasta");
			endWeekendLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.gridx = 0;
			gridBagConstraints9.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints9.gridy = 6;
			initWeekendLabel = new JLabel();
			initWeekendLabel.setText("Desde");
			initWeekendLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.gridwidth = 2;
			gridBagConstraints8.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints8.insets = new Insets(0, 5, 0, 5);
			gridBagConstraints8.gridy = 4;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints7.gridy = 3;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.insets = new Insets(0, 0, 0, 5);
			gridBagConstraints6.gridy = 2;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 0;
			gridBagConstraints5.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints5.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints5.gridy = 3;
			endWeekLabel = new JLabel();
			endWeekLabel.setText("Hasta");
			endWeekLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridy = 2;
			initWeekLabel = new JLabel();
			initWeekLabel.setText("Desde");
			initWeekLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.fill = GridBagConstraints.NONE;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.insets = new Insets(5, 5, 0, 5);
			gridBagConstraints3.gridy = 0;
			panelSchedule = new JPanel();
			panelSchedule.setLayout(new GridBagLayout());
			panelSchedule.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.gray, 1), "Horario", TitledBorder.LEFT, TitledBorder.TOP, new Font("Calibri", Font.PLAIN, 13), Color.black));
			panelSchedule.add(getWeekCheck(), gridBagConstraints3);
			panelSchedule.add(initWeekLabel, gridBagConstraints4);
			panelSchedule.add(endWeekLabel, gridBagConstraints5);
			panelSchedule.add(getInitWeekSpinner(), gridBagConstraints6);
			panelSchedule.add(getEndWeekSpinner(), gridBagConstraints7);
			panelSchedule.add(getWeekendCheck(), gridBagConstraints8);
			panelSchedule.add(initWeekendLabel, gridBagConstraints9);
			panelSchedule.add(endWeekendLabel, gridBagConstraints10);
			panelSchedule.add(getInitWeekendSpinner(), gridBagConstraints11);
			panelSchedule.add(getEndWeekendSpinner(), gridBagConstraints12);
			panelSchedule.add(getPanelWeekDays(), gridBagConstraints25);
			panelSchedule.add(getPanelWeekendDays(), gridBagConstraints26);
		}
		return panelSchedule;
	}

	/**
	 * This method initializes radioTypeGroup	
	 * 	
	 * @return javax.swing.ButtonGroup	
	 */
	private ButtonGroup getRadioTypeGroup() {
		if (radioTypeGroup == null) {
			radioTypeGroup = new ButtonGroup();
			radioTypeGroup.add(getRadiolocal());
			radioTypeGroup.add(getRadioKey());
		}
		return radioTypeGroup;
	}

	/**
	 * This method initializes weekCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getWeekCheck() {
		if (weekCheck == null) {
			weekCheck = new JCheckBox();
			weekCheck.setText("Entre semana");
			weekCheck.setHorizontalAlignment(SwingConstants.LEFT);
			weekCheck.setVerticalTextPosition(SwingConstants.CENTER);
			weekCheck.setHorizontalTextPosition(SwingConstants.RIGHT);
			weekCheck.setMnemonic(KeyEvent.VK_UNDEFINED);
			weekCheck.setSelected(true);
			weekCheck.setFont(new Font("Calibri", Font.PLAIN, 12));
			weekCheck.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						initWeekSpinner.setEnabled(true);
						endWeekSpinner.setEnabled(true);
						comboInitWeekDays.setEnabled(true);
						comboEndWeekDays.setEnabled(true);
					}
					else{
						initWeekSpinner.setEnabled(false);
						endWeekSpinner.setEnabled(false);
						comboInitWeekDays.setEnabled(false);
						comboEndWeekDays.setEnabled(false);
					}
				}
			});
		}
		return weekCheck;
	}

	/**
	 * This method initializes initWeekSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getInitWeekSpinner() {
		if (initWeekSpinner == null) {
			initWeekSpinner = new JSpinner(getModelInitWeek());
			initWeekSpinner.setEditor(getEditorInitWeek());
			initWeekSpinner.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return initWeekSpinner;
	}

	/**
	 * This method initializes endWeekSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getEndWeekSpinner() {
		if (endWeekSpinner == null) {
			endWeekSpinner = new JSpinner(getModelEndWeek());
			endWeekSpinner.setEditor(getEditorEndWeek());
			endWeekSpinner.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return endWeekSpinner;
	}

	/**
	 * This method initializes weekendCheck	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getWeekendCheck() {
		if (weekendCheck == null) {
			weekendCheck = new JCheckBox();
			weekendCheck.setText("Fin de semana");
			weekendCheck.setSelected(true);
			weekendCheck.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(e.getStateChange() == ItemEvent.SELECTED){
						initWeekendSpinner.setEnabled(true);
						endWeekendSpinner.setEnabled(true);
						comboInitWeekendDays.setEnabled(true);
						comboEndWeekendDays.setEnabled(true);
					}
					else{
						initWeekendSpinner.setEnabled(false);
						endWeekendSpinner.setEnabled(false);
						comboInitWeekendDays.setEnabled(false);
						comboEndWeekendDays.setEnabled(false);
					}
				}
			});
			weekendCheck.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return weekendCheck;
	}

	/**
	 * This method initializes initWeekendSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getInitWeekendSpinner() {
		if (initWeekendSpinner == null) {
			initWeekendSpinner = new JSpinner(getModelInitWeekend());
			initWeekendSpinner.setFont(new Font("Calibri", Font.PLAIN, 12));
			initWeekendSpinner.setEditor(getEditorInitWeekend());
		}
		return initWeekendSpinner;
	}

	/**
	 * This method initializes endWeekendSpinner	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getEndWeekendSpinner() {
		if (endWeekendSpinner == null) {
			endWeekendSpinner = new JSpinner(getModelEndWeekend());
			endWeekendSpinner.setFont(new Font("Calibri", Font.PLAIN, 12));
			endWeekendSpinner.setEditor(getEditorEndWeekend());
		}
		return endWeekendSpinner;
	}

	/**
	 * This method initializes modelInitWeek	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getModelInitWeek() {
		if (modelInitWeek == null) {
			modelInitWeek = new SpinnerDateModel();
		}
		return modelInitWeek;
	}

	/**
	 * This method initializes modelEndWeek	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getModelEndWeek() {
		if (modelEndWeek == null) {
			modelEndWeek = new SpinnerDateModel();
		}
		return modelEndWeek;
	}

	/**
	 * This method initializes modelInitWeekend	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getModelInitWeekend() {
		if (modelInitWeekend == null) {
			modelInitWeekend = new SpinnerDateModel();
		}
		return modelInitWeekend;
	}

	/**
	 * This method initializes modelEndWeekend	
	 * 	
	 * @return javax.swing.SpinnerDateModel	
	 */
	private SpinnerDateModel getModelEndWeekend() {
		if (modelEndWeekend == null) {
			modelEndWeekend = new SpinnerDateModel();
		}
		return modelEndWeekend;
	}

	/**
	 * This method initializes formatInitWeek	
	 * 	
	 * @return java.text.SimpleDateFormat	
	 */
	private SimpleDateFormat getFormatInitWeek() {
		if (formatInitWeek == null) {
			formatInitWeek = new SimpleDateFormat("hh:mm a");
		}
		return formatInitWeek;
	}

	/**
	 * This method initializes formatEndWeek	
	 * 	
	 * @return java.text.SimpleDateFormat	
	 */
	private SimpleDateFormat getFormatEndWeek() {
		if (formatEndWeek == null) {
			formatEndWeek = new SimpleDateFormat("hh:mm a");
		}
		return formatEndWeek;
	}

	/**
	 * This method initializes formatInitWeekend	
	 * 	
	 * @return java.text.SimpleDateFormat	
	 */
	private SimpleDateFormat getFormatInitWeekend() {
		if (formatInitWeekend == null) {
			formatInitWeekend = new SimpleDateFormat("hh:mm a");
		}
		return formatInitWeekend;
	}

	/**
	 * This method initializes formatEndWeekend	
	 * 	
	 * @return java.text.SimpleDateFormat	
	 */
	private SimpleDateFormat getFormatEndWeekend() {
		if (formatEndWeekend == null) {
			formatEndWeekend = new SimpleDateFormat("hh:mm a");
		}
		return formatEndWeekend;
	}

	/**
	 * This method initializes editorInitWeek	
	 * 	
	 * @return javax.swing.JSpinner.DateEditor	
	 */
	private JSpinner.DateEditor getEditorInitWeek() {
		if (editorInitWeek == null) {
			editorInitWeek = new JSpinner.DateEditor(getInitWeekSpinner(), getFormatInitWeek().toPattern());
			editorInitWeek.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			editorInitWeek.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return editorInitWeek;
	}

	/**
	 * This method initializes editorEndWeek	
	 * 	
	 * @return javax.swing.JSpinner.DateEditor	
	 */
	private JSpinner.DateEditor getEditorEndWeek() {
		if (editorEndWeek == null) {
			editorEndWeek = new JSpinner.DateEditor(getEndWeekSpinner(), getFormatEndWeek().toPattern());
		}
		return editorEndWeek;
	}

	/**
	 * This method initializes editorInitWeekend	
	 * 	
	 * @return javax.swing.JSpinner.DateEditor	
	 */
	private JSpinner.DateEditor getEditorInitWeekend() {
		if (editorInitWeekend == null) {
			editorInitWeekend = new JSpinner.DateEditor(getInitWeekendSpinner(), getFormatInitWeekend().toPattern());
		}
		return editorInitWeekend;
	}

	/**
	 * This method initializes editorEndWeekend	
	 * 	
	 * @return javax.swing.JSpinner.DateEditor	
	 */
	private JSpinner.DateEditor getEditorEndWeekend() {
		if (editorEndWeekend == null) {
			editorEndWeekend = new JSpinner.DateEditor(getEndWeekendSpinner(), getFormatEndWeekend().toPattern());
		}
		return editorEndWeekend;
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
		}
		return nameField;
	}

	/**
	 * This method initializes changePersonal1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getChangePersonal1() {
		if (changePersonal1 == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.BOTH;
			gridBagConstraints21.gridy = 1;
			gridBagConstraints21.weightx = 1.0;
			gridBagConstraints21.gridwidth = 3;
			gridBagConstraints21.insets = new Insets(0, 14, 5, 0);
			gridBagConstraints21.gridx = 0;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints13.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints13.gridy = 0;
			orientedLabel = new JLabel();
			orientedLabel.setText("Orientada a");
			orientedLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints22 = new GridBagConstraints();
			gridBagConstraints22.fill = GridBagConstraints.BOTH;
			gridBagConstraints22.gridx = 2;
			gridBagConstraints22.gridy = 3;
			gridBagConstraints22.weightx = 1.0;
			gridBagConstraints22.weighty = 1.0;
			gridBagConstraints22.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints20 = new GridBagConstraints();
			gridBagConstraints20.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints20.gridy = 2;
			gridBagConstraints20.gridx = 2;
			changeLabelHeader2 = new JLabel();
			changeLabelHeader2.setFont(new Font("Calibri", Font.PLAIN, 12));
			changeLabelHeader2.setText("Personal autorizado");
			changeLabelHeader2.setEnabled(false);
			changeLabelHeader2.setLabelFor(getScrollAuthorized());
			changeLabelHeader2.setDisplayedMnemonic(KeyEvent.VK_S);
			GridBagConstraints gridBagConstraints19 = new GridBagConstraints();
			gridBagConstraints19.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints19.gridy = 3;
			gridBagConstraints19.gridx = 1;
			GridBagConstraints gridBagConstraints18 = new GridBagConstraints();
			gridBagConstraints18.fill = GridBagConstraints.BOTH;
			gridBagConstraints18.gridx = 0;
			gridBagConstraints18.gridy = 3;
			gridBagConstraints18.weightx = 1.0;
			gridBagConstraints18.weighty = 1.0;
			gridBagConstraints18.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints17 = new GridBagConstraints();
			gridBagConstraints17.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints17.gridy = 2;
			gridBagConstraints17.gridx = 0;
			changeLabelHeader1 = new JLabel();
			changeLabelHeader1.setFont(new Font("Calibri", Font.PLAIN, 12));
			changeLabelHeader1.setText("Personal del centro");
			changeLabelHeader1.setEnabled(false);
			changeLabelHeader1.setLabelFor(getScrollPersonal());
			changeLabelHeader1.setDisplayedMnemonic(KeyEvent.VK_E);
			changePersonal1 = new JPanel();
			changePersonal1.setLayout(new GridBagLayout());
			changePersonal1.add(changeLabelHeader1, gridBagConstraints17);
			changePersonal1.add(getScrollPersonal(), gridBagConstraints18);
			changePersonal1.add(getPanelButton(), gridBagConstraints19);
			changePersonal1.add(changeLabelHeader2, gridBagConstraints20);
			changePersonal1.add(getScrollAuthorized(), gridBagConstraints22);
			changePersonal1.add(orientedLabel, gridBagConstraints13);
			changePersonal1.add(getComboOriented(), gridBagConstraints21);
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
			scrollPersonal.setPreferredSize(new Dimension(183, 245));
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
			listPersonal.setEnabled(false);
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
			panelButton.setEnabled(true);
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
			add.setEnabled(false);
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
			del.setEnabled(false);
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
			scrollAuthorized.setPreferredSize(new Dimension(183, 245));
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
			listAuthorized.setEnabled(false);
		}
		return listAuthorized;
	}

	/**
	 * This method initializes comboOriented	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboOriented() {
		if (comboOriented == null) {
			comboOriented = new JComboBox(getModelOrientedCombo());
			comboOriented.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					if(comboOriented.getSelectedItem() != null && ((TypeRuleToCombo)comboOriented.getSelectedItem()).getType() == TypeRule.TO_SELECTED_PEOPLE){
						changeLabelHeader1.setEnabled(true);
						changeLabelHeader2.setEnabled(true);
						listPersonal.setEnabled(true);
						listAuthorized.setEnabled(true);
						add.setEnabled(true);
						del.setEnabled(true);
						
						for(int i = 0; i < CEIS.getInstance().getPersons().size(); i++)
							listPersonalModel.addElement(CEIS.getInstance().getPerson(i));
						if(listAuthorizedModel.getSize() > 0){
							for(int i = 0; i < listAuthorizedModel.getSize(); i++)
								listPersonalModel.removeElement(listAuthorizedModel.get(i));
						}
					}
					else{
						changeLabelHeader1.setEnabled(false);
						changeLabelHeader2.setEnabled(false);
						listPersonal.setEnabled(false);
						listAuthorized.setEnabled(false);
						add.setEnabled(false);
						del.setEnabled(false);
						
						listPersonalModel.clear();
					}
				}
			});
		}
		return comboOriented;
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
					try{
						if(validateForm()){
							Local local = (Local)modelLocalKeyCombo.getSelectedItem();
							TypeRule type = ((TypeRuleToCombo)modelOrientedCombo.getSelectedItem()).getType();
							PersonCollection persons = null;
							if(type == TypeRule.TO_SELECTED_PEOPLE){
								persons = new PersonCollection();
								for(int i = 0; i < listAuthorizedModel.getSize(); i++)
									persons.add((Person)listAuthorizedModel.getElementAt(i));
							}
							suggestDaysInCalendar();
							Rule rule = new Rule(initWeek, endWeek, initWeekend, endWeekend, persons, nameField.getText(), type);
							if(radiolocal.isSelected())
								local.addRule(rule);
							else
								local.getKey().addRule(rule);
							
							clear();
						}
					}
					catch(EmptyException ex1){
						JOptionPane.showMessageDialog(DialogNewRule.this, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (ErronealTimeException ex2) {
						JOptionPane.showMessageDialog(DialogNewRule.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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
					try{
						if(validateForm()){
							Local local = (Local)modelLocalKeyCombo.getSelectedItem();
							TypeRule type = ((TypeRuleToCombo)modelOrientedCombo.getSelectedItem()).getType();
							PersonCollection persons = null;
							if(type == TypeRule.TO_SELECTED_PEOPLE){
								persons = new PersonCollection();
								for(int i = 0; i < listAuthorizedModel.getSize(); i++)
									persons.add((Person)listAuthorizedModel.getElementAt(i));
							}
							suggestDaysInCalendar();
							
							if(rule == null){
								Rule ruleAux = new Rule(initWeek, endWeek, initWeekend, endWeekend, persons, nameField.getText(), type);
								if(radiolocal.isSelected())
									local.addRule(ruleAux);
								else
									local.getKey().addRule(ruleAux);
							}
							else{
								rule.setName(nameField.getText());
								rule.setType(type);
								rule.setAuthorized(persons);
								rule.setSchedule(initWeek, endWeek, initWeekend, endWeekend);
							}
							
							dispose();
						}
					}
					catch(EmptyException ex1){
						JOptionPane.showMessageDialog(DialogNewRule.this, ex1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (ErronealTimeException ex2) {
						JOptionPane.showMessageDialog(DialogNewRule.this, ex2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
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

	/**
	 * This method initializes modelLocalKeyCombo	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 * @throws DontExistException 
	 */
	private DefaultComboBoxModel getModelLocalKeyCombo() throws DontExistException {
		if (modelLocalKeyCombo == null) {
			modelLocalKeyCombo = new DefaultComboBoxModel();
			
			ArrayList<Local> locals = CEIS.getInstance().getLocals();
			if(locals == null || locals.isEmpty())
				throw new DontExistException("No hay locales a los que puedan ser asignados\n" +
						"reglas de acceso o de solicitudes de llave");
			for(int i = 0; i < locals.size(); i++)
				modelLocalKeyCombo.addElement(locals.get(i));
			
			modelLocalKeyCombo.setSelectedItem(null);
		}
		return modelLocalKeyCombo;
	}

	/**
	 * This method initializes modelOrientedCombo	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getModelOrientedCombo() {
		if (modelOrientedCombo == null) {
			modelOrientedCombo = new DefaultComboBoxModel();
			
			for(int i = 0; i < typeInCombo.size(); i++)
				modelOrientedCombo.addElement(typeInCombo.get(i));
			
			modelOrientedCombo.setSelectedItem(null);
		}
		return modelOrientedCombo;
	}
	
	private boolean validateForm() throws EmptyException, ErronealTimeException{
		boolean done = true;
		
		String aux = nameField.getText();
		if(aux == null || aux.isEmpty() || GraphicSupport.isEmpty(aux)){
			done = false;
			nameField.setText("");
			throw new EmptyException("Valor no válido en el campo \"Nombre\"");
		}
		
		if(rule == null && modelLocalKeyCombo.getSelectedItem() == null){
			done = false;
			modelLocalKeyCombo.setSelectedItem(null);
			throw new EmptyException("Debe seleccionar el nombre del local");
		}
		
		if(!weekCheck.isSelected() && !weekendCheck.isSelected())
			throw new ErronealTimeException("La regla de acceso debe ser aplicada en un horario" +
					"\nPor favor, marque un horario");
		
		initializeCalendar();
		if(!weekCheck.isSelected()){
			initWeek = null;
			endWeek = null;
		}
		if(!weekendCheck.isSelected()){
			initWeekend = null;
			endWeekend = null;
		}
		
		if(weekCheck.isSelected()){
			if(initWeek.compareTo(endWeek) <= 0){
				initWeek.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				endWeek.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			}
			else{
				done = false;
				throw new ErronealTimeException("La hora de inicio del horario entre semana debe ser predecedora a la hora de fin");
			}
		}
		else{
			initWeek = null;
			endWeek = null;
		}
		if(weekendCheck.isSelected()){
			if(initWeekend.compareTo(endWeekend) <= 0){
				initWeekend.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
				endWeekend.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);
			}
			else{
				done = false;
				throw new ErronealTimeException("La hora de inicio del horario de fin de semana debe ser predecedora a la hora de fin");
			}
		}
		else{
			initWeekend = null;
			endWeekend = null;
		}
		
		if(modelOrientedCombo.getSelectedItem() == null){
			done = false;
			throw new EmptyException("Debe indicar al tipo de persona sobre los cuales se aplicará la regla");
		}
		else if(((TypeRuleToCombo)modelOrientedCombo.getSelectedItem()).getType() == TypeRule.TO_SELECTED_PEOPLE){
			if(listAuthorizedModel.isEmpty()){
				done = false;
				throw new EmptyException("Ha indicado la opcion de dirigir la regla a personas seleccionadas" +
						"\nPor favor, indique quienes serán");
			}
		}
		
		return done;
	}
	
	private void initializeCalendar(){
		Calendar aux = Calendar.getInstance();
		
		initWeek = Calendar.getInstance();
		aux.setTime(modelInitWeek.getDate());
		initWeek.set(Calendar.HOUR, aux.get(Calendar.HOUR));
		initWeek.set(Calendar.MINUTE, aux.get(Calendar.MINUTE));
		initWeek.set(Calendar.SECOND, 0);
		initWeek.set(Calendar.MILLISECOND, 0);
		initWeek.set(Calendar.AM_PM, aux.get(Calendar.AM_PM));
		
		endWeek = Calendar.getInstance();
		aux.setTime(modelEndWeek.getDate());
		endWeek.set(Calendar.HOUR, aux.get(Calendar.HOUR));
		endWeek.set(Calendar.MINUTE, aux.get(Calendar.MINUTE));
		endWeek.set(Calendar.SECOND, 0);
		endWeek.set(Calendar.MILLISECOND, 0);
		endWeek.set(Calendar.AM_PM, aux.get(Calendar.AM_PM));
		
		initWeekend = Calendar.getInstance();
		aux.setTime(modelInitWeekend.getDate());
		initWeekend.set(Calendar.HOUR, aux.get(Calendar.HOUR));
		initWeekend.set(Calendar.MINUTE, aux.get(Calendar.MINUTE));
		initWeekend.set(Calendar.SECOND, 0);
		initWeekend.set(Calendar.MILLISECOND, 0);
		initWeekend.set(Calendar.AM_PM, aux.get(Calendar.AM_PM));
		
		endWeekend = Calendar.getInstance();
		aux.setTime(modelEndWeekend.getDate());
		endWeekend.set(Calendar.HOUR, aux.get(Calendar.HOUR));
		endWeekend.set(Calendar.MINUTE, aux.get(Calendar.MINUTE));
		endWeekend.set(Calendar.SECOND, 0);
		endWeekend.set(Calendar.MILLISECOND, 0);
		endWeekend.set(Calendar.AM_PM, aux.get(Calendar.AM_PM));
		
	}
	
	private void suggestDaysInCalendar(){
		if(weekCheck.isSelected()){
			initWeek.set(Calendar.DAY_OF_WEEK, dayOfWeek((String)modelComboInitDaysWeek.getSelectedItem()));
			endWeek.set(Calendar.DAY_OF_WEEK, dayOfWeek((String)modelComboEndDaysWeek.getSelectedItem()));
		}
		if(weekendCheck.isSelected()){
			initWeekend.set(Calendar.DAY_OF_WEEK, dayOfWeek((String)modelComboInitDaysWeekend.getSelectedItem()));
			endWeekend.set(Calendar.DAY_OF_WEEK, dayOfWeek((String)modelComboEndDaysWeekend.getSelectedItem()));
		}
	}
	private int dayOfWeek(String cad){
		int day = 0;
		
		if(cad.equalsIgnoreCase("Domingo"))
			day = Calendar.SUNDAY;
		else if(cad.equalsIgnoreCase("Lunes"))
			day = Calendar.MONDAY;
		else if(cad.equalsIgnoreCase("Martes"))
			day = Calendar.TUESDAY;
		else if(cad.equalsIgnoreCase("Miércoles"))
			day = Calendar.WEDNESDAY;
		else if(cad.equalsIgnoreCase("Jueves"))
			day = Calendar.THURSDAY;
		else if(cad.equalsIgnoreCase("Viernes"))
			day = Calendar.FRIDAY;
		else if(cad.equalsIgnoreCase("Sábado"))
			day = Calendar.SATURDAY;
		
		return day;
	}


	/**
	 * This method initializes panelWeekDays	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelWeekDays() {
		if (panelWeekDays == null) {
			sss = new JLabel();
			sss.setText("--");
			sss.setFont(new Font("Calibri", Font.PLAIN, 12));
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setHgap(8);
			panelWeekDays = new JPanel();
			panelWeekDays.setLayout(flowLayout1);
			panelWeekDays.add(getComboInitWeekDays(), null);
			panelWeekDays.add(sss, null);
			panelWeekDays.add(getComboEndWeekDays(), null);
		}
		return panelWeekDays;
	}


	/**
	 * This method initializes panelWeekendDays	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelWeekendDays() {
		if (panelWeekendDays == null) {
			ssss = new JLabel();
			ssss.setText("--");
			ssss.setFont(new Font("Calibri", Font.PLAIN, 12));
			FlowLayout flowLayout2 = new FlowLayout();
			flowLayout2.setHgap(8);
			GridBagConstraints gridBagConstraints24 = new GridBagConstraints();
			gridBagConstraints24.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints24.gridy = 0;
			gridBagConstraints24.weightx = 1.0;
			gridBagConstraints24.gridx = 0;
			panelWeekendDays = new JPanel();
			panelWeekendDays.setLayout(flowLayout2);
			panelWeekendDays.add(getComboInitWeekendDays(), null);
			panelWeekendDays.add(ssss, null);
			panelWeekendDays.add(getComboEndWeekendDays(), null);
		}
		return panelWeekendDays;
	}


	/**
	 * This method initializes comboInitWeekDays	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboInitWeekDays() {
		if (comboInitWeekDays == null) {
			comboInitWeekDays = new JComboBox(getModelComboInitDaysWeek());
			comboInitWeekDays.setPreferredSize(new Dimension(90, 26));
			comboInitWeekDays.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					int index = comboInitWeekDays.getSelectedIndex();
					modelComboEndDaysWeek.removeAllElements();
					for(int i = index; i < Rule.week.length; i++)
						modelComboEndDaysWeek.addElement(Rule.week[i]);
						
				}
			});
		}
		return comboInitWeekDays;
	}


	/**
	 * This method initializes comboEndWeekDays	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboEndWeekDays() {
		if (comboEndWeekDays == null) {
			comboEndWeekDays = new JComboBox(getModelComboEndDaysWeek());
			comboEndWeekDays.setPreferredSize(new Dimension(90, 26));
		}
		return comboEndWeekDays;
	}


	/**
	 * This method initializes modelComboInitDaysWeek	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getModelComboInitDaysWeek() {
		if (modelComboInitDaysWeek == null) {
			modelComboInitDaysWeek = new DefaultComboBoxModel();
			for(int i = 0; i < Rule.week.length ; i++)
			modelComboInitDaysWeek.addElement(Rule.week[i]);
		}
		return modelComboInitDaysWeek;
	}


	/**
	 * This method initializes modelComboEndDaysWeek	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getModelComboEndDaysWeek() {
		if (modelComboEndDaysWeek == null) {
			modelComboEndDaysWeek = new DefaultComboBoxModel();
			for(int i = 0; i < Rule.week.length; i++)
				modelComboEndDaysWeek.addElement(Rule.week[i]);
		}
		return modelComboEndDaysWeek;
	}


	/**
	 * This method initializes comboInitWeekendDays	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboInitWeekendDays() {
		if (comboInitWeekendDays == null) {
			comboInitWeekendDays = new JComboBox(getModelComboInitDaysWeekend());
			comboInitWeekendDays.setPreferredSize(new Dimension(90, 26));
			comboInitWeekendDays.addItemListener(new java.awt.event.ItemListener() {
				public void itemStateChanged(java.awt.event.ItemEvent e) {
					int index = comboInitWeekendDays.getSelectedIndex();
					modelComboEndDaysWeekend.removeAllElements();
					for(int i = index; i < Rule.weekend.length; i++)
						modelComboEndDaysWeekend.addElement(Rule.weekend[i]);
				}
			});
		}
		return comboInitWeekendDays;
	}


	/**
	 * This method initializes comboEndWeekendDays	
	 * 	
	 * @return javax.swing.JComboBox	
	 */
	private JComboBox getComboEndWeekendDays() {
		if (comboEndWeekendDays == null) {
			comboEndWeekendDays = new JComboBox(getModelComboEndDaysWeekend());
			comboEndWeekendDays.setPreferredSize(new Dimension(90, 26));
		}
		return comboEndWeekendDays;
	}


	/**
	 * This method initializes modelComboInitDaysWeekend	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getModelComboInitDaysWeekend() {
		if (modelComboInitDaysWeekend == null) {
			modelComboInitDaysWeekend = new DefaultComboBoxModel();
			modelComboInitDaysWeekend.addElement(Rule.weekend[0]);
			modelComboInitDaysWeekend.addElement(Rule.weekend[1]);
		}
		return modelComboInitDaysWeekend;
	}


	/**
	 * This method initializes modelComboEndDaysWeekend	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 */
	private DefaultComboBoxModel getModelComboEndDaysWeekend() {
		if (modelComboEndDaysWeekend == null) {
			modelComboEndDaysWeekend = new DefaultComboBoxModel();
			modelComboEndDaysWeekend.addElement(Rule.weekend[0]);
			modelComboEndDaysWeekend.addElement(Rule.weekend[1]);
		}
		return modelComboEndDaysWeekend;
	}
	
	private void clear(){
		nameField.setText("");
		radiolocal.setSelected(true);
		modelLocalKeyCombo.setSelectedItem(null);
		listPersonalModel.clear();
		listAuthorizedModel.clear();
		//modelOrientedCombo.setSelectedItem(null);
		weekCheck.setSelected(true);
		weekendCheck.setSelected(true);
		modelComboInitDaysWeek.setSelectedItem(Rule.week[0]);
		modelComboEndDaysWeek.setSelectedItem(Rule.week[0]);
		modelComboInitDaysWeekend.setSelectedItem(Rule.weekend[0]);
		modelComboEndDaysWeekend.setSelectedItem(Rule.weekend[0]);
		initWeek = null;
		endWeek = null;
		initWeekend = null;
		endWeekend = null;
		modelOrientedCombo.setSelectedItem(null);
	}

}  //  @jve:decl-index=0:visual-constraint="77,272"
