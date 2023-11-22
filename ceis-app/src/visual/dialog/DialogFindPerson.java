package visual.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import visual.util.GraphicSupport;
import ceis.CEIS;
import ceis.collection.PersonCollection;
import ceis.person.registered.StudentAssistant;
import ceis.person.registered.worker.Docent;
import ceis.person.registered.worker.TecnicAdmin;

public class DialogFindPerson extends JDialog {

	private static final long serialVersionUID = 1L;

	private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="10,10"

	private JPanel jPanel = null;

	private JLabel jLabel = null;

	private JTextField jTextField = null;

	private JButton jButton = null;

	private JScrollPane jScrollPane = null;

	private JTable table = null;

	private DefaultTableModel tableModel = null;  //  @jve:decl-index=0:visual-constraint="537,134"

	private JLabel nameToFind = null;

	/**
	 * @param owner
	 */
	public DialogFindPerson(Frame owner) {
		super(owner);
		initialize();
		GraphicSupport.centerWindow(this);
		getRootPane().setDefaultButton(jButton);
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(462, 350);
		this.setTitle("Buscador");
		this.setIconImage((new ImageIcon("src/icons/search.png")).getImage());
		this.setContentPane(getJContentPane());
		this.setResizable(false);
		this.pack();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setVgap(7);
			jContentPane = new JPanel();
			jContentPane.setLayout(borderLayout);
			jContentPane.setSize(new Dimension(406, 275));
			jContentPane.add(getJPanel(), BorderLayout.NORTH);
			jContentPane.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.insets = new Insets(0, 5, 0, 0);
			gridBagConstraints11.anchor = GridBagConstraints.WEST;
			gridBagConstraints11.gridy = 1;
			nameToFind = new JLabel();
			nameToFind.setText("Nombre");
			nameToFind.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 2;
			gridBagConstraints5.anchor = GridBagConstraints.SOUTH;
			gridBagConstraints5.insets = new Insets(0, 2, 0, 0);
			gridBagConstraints5.gridy = 2;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridy = 2;
			gridBagConstraints4.weightx = 1.0;
			gridBagConstraints4.anchor = GridBagConstraints.SOUTH;
			gridBagConstraints4.insets = new Insets(0, 19, 0, 0);
			gridBagConstraints4.gridx = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridwidth = 3;
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.insets = new Insets(0, 0, 20, 0);
			gridBagConstraints.gridy = 0;
			jLabel = new JLabel();
			jLabel.setText("Buscador");
			jLabel.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel, gridBagConstraints);
			jPanel.add(getJTextField(), gridBagConstraints4);
			jPanel.add(getJButton(), gridBagConstraints5);
			jPanel.add(nameToFind, gridBagConstraints11);
		}
		return jPanel;
	}

	/**
	 * This method initializes jTextField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getJTextField() {
		if (jTextField == null) {
			jTextField = new JTextField();
			jTextField.setColumns(20);
			jTextField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return jTextField;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.setText("Buscar");
			jButton.setFont(new Font("Calibri", Font.PLAIN, 12));
			jButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					while(table.getRowCount() > 0)
						tableModel.removeRow(0);
					
					String auxText = jTextField.getText();
					if(auxText == null || auxText.isEmpty() || GraphicSupport.isEmpty(auxText)){
						JOptionPane.showMessageDialog(DialogFindPerson.this, "Debe escribir el texto a buscar", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					PersonCollection persons = CEIS.getInstance().findPersonalByName(auxText);
					String[] row = new String[3];
					if(persons != null){
						for(int i = 0; i < persons.size(); i++){
							row[0] = persons.get(i).toString();
							row[1] = persons.get(i).getCI();
							if(persons.get(i) instanceof StudentAssistant)
								row[2] = "Alumno Ayudante";
							else if(persons.get(i) instanceof Docent)
								row[2] = "Docente";
							else if(persons.get(i) instanceof TecnicAdmin)
								row[2] = "Técnico/Administrativo";
							else
								row[2] = "Visitante";
							
							tableModel.addRow(row);
						}
					}
				}
			});
		}
		return jButton;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setPreferredSize(new Dimension(456, 228));
			jScrollPane.setViewportView(getTable());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes table	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTable() {
		if (table == null) {
			table = new JTable(getTableModel());
			table.setFont(new Font("Calibri", Font.PLAIN, 12));
			JTableHeader header = table.getTableHeader();
			header.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return table;
	}

	/**
	 * This method initializes tableModel	
	 * 	
	 * @return javax.swing.table.DefaultTableModel	
	 */
	private DefaultTableModel getTableModel() {
		if (tableModel == null) {
			tableModel = new DefaultTableModel(new Object[]{"Nombre y apellidos", "CI", "Tipo"}, 0){
				private static final long serialVersionUID = -7773855093199040638L;
				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
		}
		return tableModel;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
