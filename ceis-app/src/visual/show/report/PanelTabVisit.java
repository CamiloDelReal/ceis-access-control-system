package visual.show.report;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import org.jdesktop.swingx.JXDatePicker;

import visual.util.GraphicSupport;
import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;
import ceis.CEIS;
import ceis.collection.ControlCollection;
import ceis.control.entities.LocalAccess;
import ceis.control.scheme.Scheme;
import exception.DontExistException;
import exception.EmptyDataShowException;

public class PanelTabVisit extends JPanel  implements DBActionButton, UpdateTabPanel{

	private static final long serialVersionUID = 1L;
	private JPanel panelHeader = null;
	private JLabel labelHeder1 = null;
	private JLabel labelHeader2 = null;
	private JLabel labelInit = null;
	private JLabel labelEnd = null;
	private JXDatePicker dateInit = null;
	private JXDatePicker dateEnd = null;
	private JButton view = null;
	private JScrollPane scroll = null;
	private JTable table = null;
	private DefaultTableModel tableModel = null;  //  @jve:decl-index=0:visual-constraint="524,116"
	private int oldRow;

	/**
	 * This is the default constructor
	 */
	public PanelTabVisit() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setVgap(7);
		this.setLayout(borderLayout);
		this.setSize(456, 538);
		this.add(getPanelHeader(), BorderLayout.NORTH);
		this.add(getScroll(), BorderLayout.CENTER);
	}

	/**
	 * This method initializes panelHeader	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelHeader() {
		if (panelHeader == null) {
			GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
			gridBagConstraints21.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints21.gridwidth = 2;
			gridBagConstraints21.gridx = 3;
			gridBagConstraints21.gridy = 3;
			gridBagConstraints21.insets = new Insets(0, 5, 0, 0);
			GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
			gridBagConstraints11.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints11.gridx = 1;
			gridBagConstraints11.gridy = 3;
			gridBagConstraints11.insets = new Insets(0, 44, 0, 0);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.gridy = 3;
			gridBagConstraints4.insets = new Insets(0, 14, 0, 0);
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints3.gridx = 1;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.insets = new Insets(0, 30, 0, 0);
			labelEnd = new JLabel();
			labelEnd.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelEnd.setText("Hasta");
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 2;
			gridBagConstraints2.insets = new Insets(0, 2, 0, 0);
			labelInit = new JLabel();
			labelInit.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelInit.setText("Desde");
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.anchor = GridBagConstraints.WEST;
			gridBagConstraints1.insets = new Insets(0, 0, 0, 0);
			gridBagConstraints1.gridwidth = 5;
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 1;
			gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
			labelHeader2 = new JLabel();
			labelHeader2.setFont(new Font("Calibri", Font.PLAIN, 12));
			labelHeader2.setText("Seleccione el rango de fechas");
			labelHeader2.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints.gridwidth = 5;
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			gridBagConstraints.insets = new Insets(0, 0, 20, 0);
			labelHeder1 = new JLabel();
			labelHeder1.setFont(new Font("Calibri", Font.PLAIN, 18));
			labelHeder1.setText("Visitas que he recibido el centro");
			labelHeder1.setHorizontalAlignment(SwingConstants.CENTER);
			panelHeader = new JPanel();
			panelHeader.setLayout(new GridBagLayout());
			panelHeader.add(labelHeder1, gridBagConstraints);
			panelHeader.add(labelHeader2, gridBagConstraints1);
			panelHeader.add(labelInit, gridBagConstraints2);
			panelHeader.add(labelEnd, gridBagConstraints3);
			panelHeader.add(getDateInit(), gridBagConstraints4);
			panelHeader.add(getDateEnd(), gridBagConstraints11);
			panelHeader.add(getView(), gridBagConstraints21);
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
					while(table.getRowCount() > 0)
						tableModel.removeRow(0);
					
					Date init = dateInit.getDate();
					if(init == null){
						JOptionPane.showMessageDialog(PanelTabVisit.this, "Debe de indicar la fecha inicial de la busqueda", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					Date end = dateEnd.getDate();
					if(end == null){
						JOptionPane.showMessageDialog(PanelTabVisit.this, "Debe de indicar la fecha final de la busqueda", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}					
					Calendar cInit = Calendar.getInstance();
					cInit.setTime(init);
					Calendar cEnd = Calendar.getInstance();
					cEnd.setTime(end);
					cEnd.set(Calendar.MINUTE, 59);
					cEnd.set(Calendar.HOUR_OF_DAY, 23);
					
					try {
						fillTable(cInit, cEnd);
					} 
					catch (EmptyDataShowException ex) {
						JOptionPane.showMessageDialog(PanelTabVisit.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			});
		}
		return view;
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
			header.setFont(new Font("Calibri", Font.PLAIN, 12));
			
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
			tableModel = new DefaultTableModel(new Object[]{"Nombre y apellidos", "Local", "Fecha"}, 0){
				private static final long serialVersionUID = 8099913044040789850L;

				public boolean isCellEditable(int row, int column){
					return false;
				}
			};
		}
		return tableModel;
	}
	
	private void fillTable(Calendar init, Calendar end) throws EmptyDataShowException{
		ControlCollection data = CEIS.getInstance().findVisit(init, end);
		String[] row = new String[3];
		
		if(data == null)
			throw new EmptyDataShowException("No se han registrado visitas al centro en el rango de fechas indicado");
			
		for(int i = 0; i < data.size(); i++){
			row[0] = data.get(i).getWho().toString();
			if(data.get(i) instanceof LocalAccess)
				row[1] = ((LocalAccess)data.get(i)).getLocal().toString();
			else
				row[1] = ((Scheme)data.get(i)).getRulesEntities().toString();
			row[2] = GraphicSupport.getStringEntryDate(data.get(i).getInit(), true);
			tableModel.addRow(row);
		}
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

	public Object getSelected() {
		return null;
	}

	public void delete() throws DontExistException {;}

	public void update() throws EmptyDataShowException {;}

}  //  @jve:decl-index=0:visual-constraint="10,10"
