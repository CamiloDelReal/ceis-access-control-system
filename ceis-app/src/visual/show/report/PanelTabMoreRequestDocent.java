package visual.show.report;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.jdesktop.swingx.JXDatePicker;

import ceis.CEIS;
import ceis.person.registered.worker.Docent;
import ceis.rules.entities.Local;
import exception.EmptyDataShowException;

public class PanelTabMoreRequestDocent extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel panelContent = null;
	private JLabel labelheader1 = null;
	private JLabel labelHeader2 = null;
	private JLabel labelHeader3 = null;
	private JTextField locationField = null;
	private JPanel panelHeader = null;
	private JLabel labelHeader21 = null;
	private JLabel labelInit = null;
	private JLabel labelEnd = null;
	private JXDatePicker dateInit = null;
	private JXDatePicker dateEnd = null;
	private JButton view = null;
	private JComboBox comboLocals = null;
	private DefaultComboBoxModel comboModel = null;

	/**
	 * This is the default constructor
	 * @throws EmptyDataShowException 
	 */
	public PanelTabMoreRequestDocent() throws EmptyDataShowException {
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
		this.setSize(734, 145);
		this.setLayout(new BorderLayout());
		this.add(getPanelContent(), BorderLayout.NORTH);
	}

	/**
	 * This method initializes panelContent	
	 * 	
	 * @return javax.swing.JPanel	
	 * @throws EmptyDataShowException 
	 */
	private JPanel getPanelContent() throws EmptyDataShowException {
		if (panelContent == null) {
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridy = 2;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.insets = new Insets(0, 19, 0, 0);
			gridBagConstraints12.gridx = 0;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridheight = 4;
			gridBagConstraints5.fill = GridBagConstraints.NONE;
			gridBagConstraints5.anchor = GridBagConstraints.NORTH;
			gridBagConstraints5.insets = new Insets(0, 10, 0, 0);
			gridBagConstraints5.gridy = 1;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.BOTH;
			gridBagConstraints4.gridy = 4;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.insets = new Insets(0, 19, 0, 0);
			gridBagConstraints4.gridx = 0;
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.anchor = GridBagConstraints.WEST;
			gridBagConstraints3.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints3.gridy = 3;
			labelHeader3 = new JLabel();
			labelHeader3.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelHeader3.setText("Localizacion");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(14, 5, 2, 0);
			gridBagConstraints1.gridy = 1;
			labelHeader2 = new JLabel();
			labelHeader2.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelHeader2.setText("Seleccione el local al que pertenece la llave");
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.insets = new Insets(0, 0, 20, 0);
			gridBagConstraints.gridwidth = 2;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridy = 0;
			labelheader1 = new JLabel();
			labelheader1.setText("Docente que más ha solicitado una llave");
			labelheader1.setHorizontalAlignment(SwingConstants.CENTER);
			labelheader1.setFont(new Font("Calibri", Font.PLAIN, 18));
			panelContent = new JPanel();
			panelContent.setLayout(new GridBagLayout());
			panelContent.add(labelheader1, gridBagConstraints);
			panelContent.add(labelHeader2, gridBagConstraints1);
			panelContent.add(labelHeader3, gridBagConstraints3);
			panelContent.add(getLocationField(), gridBagConstraints4);
			panelContent.add(getPanelHeader(), gridBagConstraints5);
			panelContent.add(getComboLocals(), gridBagConstraints12);
		}
		return panelContent;
	}

	/**
	 * This method initializes locationField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getLocationField() {
		if (locationField == null) {
			locationField = new JTextField();
			locationField.setFont(new Font("Calibri", Font.PLAIN, 12));
			locationField.setEditable(false);
			locationField.setColumns(25);
			locationField.setPreferredSize(new Dimension(292, 28));
		}
		return locationField;
	}

	/**
	 * This method initializes panelHeader	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelHeader() {
		if (panelHeader == null) {
			GridBagConstraints gridBagConstraints211 = new GridBagConstraints();
			gridBagConstraints211.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints211.gridwidth = 2;
			gridBagConstraints211.gridx = 3;
			gridBagConstraints211.gridy = 3;
			gridBagConstraints211.insets = new Insets(0, 5, 0, 0);
			GridBagConstraints gridBagConstraints111 = new GridBagConstraints();
			gridBagConstraints111.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints111.gridx = 1;
			gridBagConstraints111.gridy = 3;
			gridBagConstraints111.insets = new Insets(0, 44, 0, 0);
			GridBagConstraints gridBagConstraints41 = new GridBagConstraints();
			gridBagConstraints41.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints41.gridx = 0;
			gridBagConstraints41.gridy = 3;
			gridBagConstraints41.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints31 = new GridBagConstraints();
			gridBagConstraints31.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints31.gridx = 1;
			gridBagConstraints31.gridy = 2;
			gridBagConstraints31.insets = new Insets(0, 30, 0, 0);
			labelEnd = new JLabel();
			labelEnd.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelEnd.setText("Hasta");
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.gridx = 0;
			gridBagConstraints21.gridy = 2;
			gridBagConstraints21.insets = new Insets(0, 2, 0, 0);
			labelInit = new JLabel();
			labelInit.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelInit.setText("Desde");
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints11.gridwidth = 5;
			gridBagConstraints11.gridx = 0;
			gridBagConstraints11.gridy = 1;
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			labelHeader21 = new JLabel();
			labelHeader21.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelHeader21.setText("Seleccione el rango de fechas");
			labelHeader21.setHorizontalAlignment(SwingConstants.CENTER);
			panelHeader = new JPanel();
			panelHeader.setLayout(new GridBagLayout());
			panelHeader.add(labelHeader21, gridBagConstraints11);
			panelHeader.add(labelInit, gridBagConstraints21);
			panelHeader.add(labelEnd, gridBagConstraints31);
			panelHeader.add(getDateInit(), gridBagConstraints41);
			panelHeader.add(getDateEnd(), gridBagConstraints111);
			panelHeader.add(getView(), gridBagConstraints211);
		}
		return panelHeader;
	}

	/**
	 * This method initializes dateInit	
	 * 	
	 * @return org.jdesktop.swingx.JXDatePicker	
	 */
	private JXDatePicker getDateInit() {
		if (dateInit == null) {
			dateInit = new JXDatePicker();
			dateInit.setFont(new Font("Calibri", Font.PLAIN, 12));
			dateInit.setPreferredSize(new Dimension(161, 28));
		}
		return dateInit;
	}

	/**
	 * This method initializes dateEnd	
	 * 	
	 * @return org.jdesktop.swingx.JXDatePicker	
	 */
	private JXDatePicker getDateEnd() {
		if (dateEnd == null) {
			dateEnd = new JXDatePicker();
			dateEnd.setFont(new Font("Calibri", Font.PLAIN, 12));
			dateEnd.setPreferredSize(new Dimension(161, 28));
		}
		return dateEnd;
	}

	/**
	 * This method initializes view	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getView() {
		if (view == null) {
			view = new JButton();
			view.setFont(new Font("Calibri", Font.PLAIN, 12));
			view.setText("Listar");
			view.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					locationField.setText("");
					Local local = (Local)comboModel.getSelectedItem();
					if(local == null){
						JOptionPane.showMessageDialog(PanelTabMoreRequestDocent.this, "Debe de indicar el local al que pertenece la llave", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Date init = dateInit.getDate();
					if(init == null){
						JOptionPane.showMessageDialog(PanelTabMoreRequestDocent.this, "Debe de indicar la fecha inicial de la busqueda", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Date end = dateEnd.getDate();
					if(end == null){
						JOptionPane.showMessageDialog(PanelTabMoreRequestDocent.this, "Debe de indicar la fecha final de la busqueda", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}	
					
					Calendar cInit = Calendar.getInstance();
					cInit.setTime(init);
					Calendar cEnd = Calendar.getInstance();
					cEnd.setTime(end);
					cEnd.set(Calendar.MINUTE, 59);
					cEnd.set(Calendar.HOUR_OF_DAY, 23);
					
					Docent doc = CEIS.getInstance().docentWithMoreRequestKey(cInit, cEnd, local.getKey());
					if(doc != null)
						locationField.setText(doc.toString());
					else
						JOptionPane.showMessageDialog(PanelTabMoreRequestDocent.this, "No se encontraron coincidencias, posiblemente ante la no existencia\n" +
								"de solicitudes de llaves en los registros", "Error", JOptionPane.ERROR_MESSAGE);
				}
			});
		}
		return view;
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
			comboModel.setSelectedItem(null);
			
			if(CEIS.getInstance().getLocals() == null)
				throw new EmptyDataShowException("No existen locales identificados en el centro");
			for(int i = 0; i < CEIS.getInstance().getLocals().size(); i++)
				comboModel.addElement(CEIS.getInstance().getLocals().get(i));
			comboModel.setSelectedItem(null);
		}
		return comboModel;
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
			comboLocals.setPreferredSize(new Dimension(246, 26));
			comboLocals.setFont(new Font("Calibri", Font.PLAIN, 12));
			comboLocals.setPreferredSize(new Dimension(200, 26));
		}
		return comboLocals;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
