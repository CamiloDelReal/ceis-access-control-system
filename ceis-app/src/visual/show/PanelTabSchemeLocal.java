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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;
import ceis.CEIS;
import ceis.control.scheme.Scheme;
import exception.DontExistException;
import exception.EmptyDataShowException;

public class PanelTabSchemeLocal extends JPanel implements DBActionButton, UpdateTabPanel{

	private static final long serialVersionUID = 1L;
	private int oldRow;
	private JLabel headerLabel = null;
	private JLabel headerLabel2 = null;
	private JScrollPane scroll = null;
	private JTable table = null;
	private DefaultTableModel tableModel = null;  //  @jve:decl-index=0:visual-constraint="536,90"

	/**
	 * This is the default constructor
	 * @throws EmptyDataShowException 
	 */
	public PanelTabSchemeLocal() throws EmptyDataShowException {
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
		GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
		gridBagConstraints2.fill = GridBagConstraints.BOTH;
		gridBagConstraints2.gridy = 2;
		gridBagConstraints2.weightx = 1.0;
		gridBagConstraints2.weighty = 1.0;
		gridBagConstraints2.gridx = 0;
		GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
		gridBagConstraints1.gridx = 0;
		gridBagConstraints1.insets = new Insets(0, 0, 20, 0);
		gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints1.gridy = 1;
		headerLabel2 = new JLabel();
		headerLabel2.setText("Entradas y salidas de locales");
		headerLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel2.setFont(new Font("Calibri", Font.PLAIN, 14));
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
		gridBagConstraints.gridy = 0;
		headerLabel = new JLabel();
		headerLabel.setText("Registro de trazas");
		headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		headerLabel.setFont(new Font("Calibri", Font.PLAIN, 18));
		this.setSize(456, 488);
		this.setLayout(new GridBagLayout());
		this.add(headerLabel, gridBagConstraints);
		this.add(headerLabel2, gridBagConstraints1);
		this.add(getScroll(), gridBagConstraints2);
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
			tableModel = new DefaultTableModel(new Object[]{"Persona","Local","Entrada", "Salida"}, 0){
				private static final long serialVersionUID = 1801151314293588124L;
				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
		}
		return tableModel;
	}
	
	private void fillTable() throws EmptyDataShowException{
		ArrayList<Scheme> schemes = CEIS.getInstance().getSchemeByAccess();
		
		if(schemes == null || schemes.isEmpty())
			throw new EmptyDataShowException("No se ha generado aun ninguna traza");
		
		for(int i = 0; i < schemes.size(); i++)
			tableModel.addRow(schemes.get(i).getStringData());
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

	public void delete() throws DontExistException {;}

	public Object getSelected() {
		return null;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
