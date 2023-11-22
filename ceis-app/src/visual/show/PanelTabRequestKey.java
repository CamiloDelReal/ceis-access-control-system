package visual.show;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;
import ceis.CEIS;
import ceis.control.entities.KeyRequest;
import ceis.control.scheme.Scheme;
import exception.DontExistException;
import exception.EmptyDataShowException;

public class PanelTabRequestKey extends JPanel implements DBActionButton, UpdateTabPanel{

	private static final long serialVersionUID = 1L;
	private JScrollPane scroll = null;
	private JTable table = null;
	private int oldRow;
	private DefaultTableModel tableModel = null;  //  @jve:decl-index=0:visual-constraint="536,82"
	private JLabel headerLabel = null;

	/**
	 * This is the default constructor
	 * @throws EmptyDataShowException 
	 */
	public PanelTabRequestKey() throws EmptyDataShowException {
		super();
		initialize();
		fillTable();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
		gridBagConstraints3.gridx = 0;
		gridBagConstraints3.insets = new Insets(0, 0, 20, 0);
		gridBagConstraints3.gridy = 0;
		headerLabel = new JLabel();
		headerLabel.setText("Registro del personal que actualmente tiene una llave en su poder");
		headerLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.fill = GridBagConstraints.BOTH;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.weightx = 1.0;
		gridBagConstraints.weighty = 1.0;
		gridBagConstraints.gridx = 0;
		this.setSize(479, 471);
		this.setLayout(new GridBagLayout());
		this.add(getScroll(), gridBagConstraints);
		this.add(headerLabel, gridBagConstraints3);
	}

	/**
	 * This method initializes scroll	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScroll() {
		if (scroll == null) {
			scroll = new JScrollPane();
			scroll.setViewportView(getTable());
		}
		return scroll;
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
			header.setReorderingAllowed(false);
			header.setFont(new Font("Calibri", 14, 12));
			
			table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int row = table.rowAtPoint(e.getPoint());
					if(row > -1){
						oldRow = row;
					}
				}
			});
			
			table.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					int row = 0;
					
					switch(e.getKeyCode()){
					case KeyEvent.VK_UP:
						row = table.getSelectedRow() - 1;
						break;
					case KeyEvent.VK_PAGE_UP:
						row = 0;
						break;
					case KeyEvent.VK_LEFT:
						row = 0;
						table.changeSelection(row, 0, false, false);
						break;
					case KeyEvent.VK_DOWN:
						row = table.getSelectedRow() + 1;
						if(row == table.getRowCount())
							row = table.getRowCount() - 1;
						break;
					case KeyEvent.VK_PAGE_DOWN:
						row = table.getRowCount() - 1;
						break;
					case KeyEvent.VK_RIGHT:
						row = table.getRowCount() - 1;
						table.changeSelection(row, 0, false, false);
						break;
					}
					oldRow = row;
				}
			});
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
			tableModel = new DefaultTableModel(new Object[]{"Persona","Llave del local","Extracción"}, 0){
				private static final long serialVersionUID = 1801151314293588124L;
				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
		}
		return tableModel;
	}
	
	private void fillTable() throws EmptyDataShowException{
		ArrayList<KeyRequest> access = CEIS.getInstance().getKeyRequested();
		
		if(access == null || access.isEmpty())
			throw new EmptyDataShowException("No hay personal registrado en el registro de solicitudes de llaves");
		
		for(int i = 0; i < access.size(); i++)
			tableModel.addRow(access.get(i).getDataKeyRequest());
	}
	
	public void selectPrev(){
		oldRow--;
		if(oldRow < 0)
			oldRow = table.getRowCount() - 1;
		table.changeSelection(oldRow, 0, false, false);
	}
	public void selectNext(){
		oldRow++;
		if(oldRow == table.getRowCount())
			oldRow = 0;
		table.changeSelection(oldRow, 0, false, false);
	}
	public void selectFirst(){
		oldRow = 0;
		table.changeSelection(oldRow, 0, false, false);
	}
	public void selectLast(){
		oldRow = table.getRowCount() - 1;
		table.changeSelection(oldRow, 0, false, false);
	}

	public void update() throws EmptyDataShowException {
		while(table.getRowCount() > 0)
			tableModel.removeRow(0);
		fillTable();
	}

	public void delete() throws DontExistException {
		int[] indices = table.getSelectedRows();
		ArrayList<KeyRequest> keys = CEIS.getInstance().getKeyRequested();
		
		for(int i = 0; i < indices.length; i++){
			keys.get(indices[i] - i).getKey().delivery();
			CEIS.getInstance().addControl(new Scheme(keys.get(indices[i] - i), Calendar.getInstance()));
			CEIS.getInstance().getControls().remove(keys.remove(indices[i] - i));
		}		
	}

	public Object getSelected() {
		return null;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
