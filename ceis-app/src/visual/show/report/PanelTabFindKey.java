package visual.show.report;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;

import ceis.CEIS;
import ceis.person.Registered;
import ceis.rules.entities.Key;
import exception.DontExistException;
import exception.EmptyDataShowException;

public class PanelTabFindKey extends JPanel implements DBActionButton, UpdateTabPanel{

	private static final long serialVersionUID = 1L;
	private JPanel panel = null;
	private JLabel labelHeader1 = null;
	private JLabel labelHeader2 = null;
	private JComboBox comboLocals = null;
	private JButton findButton = null;
	private JPanel panelAux = null;
	private DefaultComboBoxModel comboModel = null;  //  @jve:decl-index=0:visual-constraint="573,108"
	private JPanel panel2 = null;
	private JLabel labelHeader3 = null;
	private JTextField locationField = null;
	/**
	 * This is the default constructor
	 * @throws EmptyDataShowException 
	 */
	public PanelTabFindKey() throws EmptyDataShowException {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 * @throws EmptyDataShowException 
	 */
	private void initialize() throws EmptyDataShowException {
		this.setLayout(null);
		this.setSize(451, 202);
		this.add(getPanel(), null);
	}

	/**
	 * This method initializes panel	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws EmptyDataShowException 
	 */
	private JPanel getPanel() throws EmptyDataShowException {
		if (panel == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.anchor = GridBagConstraints.WEST;
			gridBagConstraints21.fill = GridBagConstraints.NONE;
			gridBagConstraints21.gridy = 3;
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.fill = GridBagConstraints.NONE;
			gridBagConstraints11.insets = new Insets(0, 14, 10, 0);
			gridBagConstraints11.gridy = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.fill = GridBagConstraints.NONE;
			gridBagConstraints1.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.gridy = 1;
			labelHeader2 = new JLabel();
			labelHeader2.setText("Seleccione el local al que pertenece la llave");
			labelHeader2.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 0, 20, 0);
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.gridy = 0;
			labelHeader1 = new JLabel();
			labelHeader1.setText("Buscador de llaves");
			labelHeader1.setHorizontalAlignment(SwingConstants.CENTER);
			labelHeader1.setFont(new Font("Calibri", Font.PLAIN, 18));
			panel = new JPanel();
			panel.setLayout(new GridBagLayout());
			panel.setBounds(new Rectangle(19, 14, 381, 151));
			panel.add(labelHeader1, gridBagConstraints);
			panel.add(labelHeader2, gridBagConstraints1);
			panel.add(getPanelAux(), gridBagConstraints11);
			panel.add(getPanel2(), gridBagConstraints21);
		}
		return panel;
	}

	/**
	 * This method initializes comboLocals	
	 * 	
	 * @return javax.swing.JComboBox	
	 * @throws EmptyDataShowException 
	 */
	private JComboBox getComboLocals() throws EmptyDataShowException {
		if (comboLocals == null) {
			comboLocals = new JComboBox(getComboModel());
			comboLocals.setPreferredSize(new Dimension(256, 26));
			comboLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return comboLocals;
	}

	/**
	 * This method initializes findButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getFindButton() {
		if (findButton == null) {
			findButton = new JButton();
			findButton.setText("Buscar");
			findButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					Key key = (Key)comboLocals.getSelectedItem();
					locationField.setText("");
					if(key != null){
						Registered reg = CEIS.getInstance().findPossessionOfKey(key);
						if(reg != null)
							locationField.setText(reg.toString());
						else
							locationField.setText("La llave indicada no esta en poder del personal");
					}
					else{
						JOptionPane.showMessageDialog(PanelTabFindKey.this, "Debe indicar el local al que pertenece la llave", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return findButton;
	}

	/**
	 * This method initializes panelAux	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws EmptyDataShowException 
	 */
	private JPanel getPanelAux() throws EmptyDataShowException {
		if (panelAux == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.LEFT);
			panelAux = new JPanel();
			panelAux.setLayout(flowLayout);
			panelAux.add(getComboLocals(), null);
			panelAux.add(getFindButton(), null);
		}
		return panelAux;
	}

	/**
	 * This method initializes comboModel	
	 * 	
	 * @return javax.swing.DefaultComboBoxModel	
	 * @throws EmptyDataShowException 
	 */
	private DefaultComboBoxModel getComboModel() throws EmptyDataShowException {
		if (comboModel == null) {
			comboModel = new DefaultComboBoxModel();
			
			if(CEIS.getInstance().getLocals() != null)
				for(int i = 0; i < CEIS.getInstance().getLocals().size(); i++)
					comboModel.addElement(CEIS.getInstance().getLocals().get(i).getKey());
			else
				throw new EmptyDataShowException("No hay locales identificados en el centro");
			comboModel.setSelectedItem(null);
		}
		return comboModel;
	}

	/**
	 * This method initializes panel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanel2() {
		if (panel2 == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 1;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(0, 19, 0, 0);
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.anchor = GridBagConstraints.WEST;
			gridBagConstraints2.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints2.gridy = 0;
			labelHeader3 = new JLabel();
			labelHeader3.setText("Localizacion");
			labelHeader3.setFont(new Font("Calibri", Font.PLAIN, 12));
			panel2 = new JPanel();
			panel2.setLayout(new GridBagLayout());
			panel2.add(labelHeader3, gridBagConstraints2);
			panel2.add(getLocationField(), gridBagConstraints3);
		}
		return panel2;
	}

	/**
	 * This method initializes locationField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLocationField() {
		if (locationField == null) {
			locationField = new JTextField();
			locationField.setColumns(33);
			locationField.setEditable(false);
			locationField.setPreferredSize(new Dimension(292, 28));
			locationField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return locationField;
	}

	public void delete() throws DontExistException {;}
	public void update() throws EmptyDataShowException {;}
	public Object getSelected() {
		return null;
	}
	public void selectFirst() {;}
	public void selectLast() {;}
	public void selectNext() {;}
	public void selectPrev() {;}

}  //  @jve:decl-index=0:visual-constraint="5,17"
