package visual.show;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;
import ceis.CEIS;
import ceis.person.Person;
import exception.DontExistException;
import exception.EmptyDataShowException;

public class PanelTabVisitor extends JPanel implements DBActionButton, UpdateTabPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JScrollPane jScrollPane = null;
	private JTable tableVisitor = null;
	private DefaultTableModel tableModelVisitor = null;  //  @jve:decl-index=0:visual-constraint="407,76"
	private int oldRow;

	/**
	 * This is the default constructor
	 */
	public PanelTabVisitor() throws EmptyDataShowException{
		super();
		oldRow = 0;
		initialize();
		try{
			fillTable();
		}
		catch(EmptyDataShowException e){
			throw e;
		}
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.fill = GridBagConstraints.BOTH;
		gridBagConstraints1.gridy = 1;
		gridBagConstraints1.weightx = 1.0;
		gridBagConstraints1.weighty = 1.0;
		gridBagConstraints1.gridx = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		jLabel = new JLabel();
		jLabel.setText("Registro de las personas que han visitado el centro");
		jLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.setSize(382, 232);
		this.setLayout(new GridBagLayout());
		this.add(jLabel, gridBagConstraints);
		this.add(getJScrollPane(), gridBagConstraints1);
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getTableVisitor());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes tableVisitor	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTableVisitor() {
		if (tableVisitor == null) {
			tableVisitor = new JTable(getTableModelVisitor());
			tableVisitor.setFont(new Font("Calibri", Font.PLAIN, 12));
			JTableHeader header = tableVisitor.getTableHeader();
			header.setReorderingAllowed(false);
			header.setFont(new Font("Calibri", 14, 12));
			TableColumn col = tableVisitor.getColumn("CI");
			col.setPreferredWidth(130);
			col.setMaxWidth(200);
			
			tableVisitor.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int row = tableVisitor.rowAtPoint(e.getPoint());
					if(row > -1){
						oldRow = row;
					}
				}
			});
			
			tableVisitor.addKeyListener(new KeyAdapter(){
				public void keyPressed(KeyEvent e){
					int row = 0;
					
					switch(e.getKeyCode()){
					case KeyEvent.VK_UP:
						row = tableVisitor.getSelectedRow() - 1;
						break;
					case KeyEvent.VK_PAGE_UP:
						row = 0;
						break;
					case KeyEvent.VK_LEFT:
						row = 0;
						tableVisitor.changeSelection(row, 0, false, false);
						break;
					case KeyEvent.VK_DOWN:
						row = tableVisitor.getSelectedRow() + 1;
						if(row == tableVisitor.getRowCount())
							row = tableVisitor.getRowCount() - 1;
						break;
					case KeyEvent.VK_PAGE_DOWN:
						row = tableVisitor.getRowCount() - 1;
						break;
					case KeyEvent.VK_RIGHT:
						row = tableVisitor.getRowCount() - 1;
						tableVisitor.changeSelection(row, 0, false, false);
						break;
					}
					oldRow = row;
				}
			});
		}
		return tableVisitor;
	}

	/**
	 * This method initializes tableModelVisitor	
	 * 	
	 * @return javax.swing.table.DefaultTableModel	
	 */
	private DefaultTableModel getTableModelVisitor() {
		if (tableModelVisitor == null) {
			tableModelVisitor = new DefaultTableModel(new Object[]{
					"CI", "Nombre y apellidos", "Entrada"
					}, 0){
						private static final long serialVersionUID = 1801151314293588124L;
						public boolean isCellEditable(int row, int column){
							return false;
						}
			};
		}
		return tableModelVisitor;
	}
	
	private void fillTable() throws EmptyDataShowException{
		String [][]dataVisitor = CEIS.getInstance().getVisitorDataArray();
		
		if(dataVisitor == null)
			throw new EmptyDataShowException("No han habido visitantes en estos días");
		
		for(int i = 0; i < dataVisitor.length; i++)
			tableModelVisitor.addRow(dataVisitor[i]);
		
		tableVisitor.changeSelection(0, 0, false, false);
	}
	

	public void selectPrev(){
		oldRow--;
		if(oldRow < 0)
			oldRow = tableVisitor.getRowCount() - 1;
		tableVisitor.changeSelection(oldRow, 0, false, false);
	}
	public void selectNext(){
		oldRow++;
		if(oldRow == tableVisitor.getRowCount())
			oldRow = 0;
		tableVisitor.changeSelection(oldRow, 0, false, false);
	}
	public void selectFirst(){
		oldRow = 0;
		tableVisitor.changeSelection(oldRow, 0, false, false);
	}
	public void selectLast(){
		oldRow = tableVisitor.getRowCount() - 1;
		tableVisitor.changeSelection(oldRow, 0, false, false);
	}

	public void update() throws EmptyDataShowException {
		while(tableVisitor.getRowCount() > 0)
			tableModelVisitor.removeRow(0);
		fillTable();
	}

	public void delete() throws DontExistException {
		int[] indices = tableVisitor.getSelectedRows();
		
		for(int i = 0; i < indices.length; i++){
			String ciSelected = String.valueOf(tableModelVisitor.getValueAt(indices[i], 0));
			CEIS.getInstance().removePerson(ciSelected);
		}		
	}

	public Object getSelected() {
		Person person = null;
		String ci = String.valueOf(tableModelVisitor.getValueAt(oldRow, 0));
		person = CEIS.getInstance().findVisitor(ci);
			
		return person;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
