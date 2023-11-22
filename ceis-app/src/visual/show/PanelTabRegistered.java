package visual.show;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.text.MaskFormatter;

import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;
import ceis.CEIS;
import exception.DontExistException;
import exception.EmptyDataShowException;

public abstract class PanelTabRegistered extends JPanel implements DBActionButton, UpdateTabPanel{

	private static final long serialVersionUID = 1L;
	protected JLabel labelHeader = null;
	protected JScrollPane scrollTable = null;
	protected JTable table = null;
	protected DefaultTableModel tableModel = null;  //  @jve:decl-index=0:visual-constraint="657,39"
	protected JPanel panelInfo = null;
	protected JLabel picture = null;
	protected JLabel ciLabel = null;
	protected JTextField ciField = null;
	protected JLabel phoneLabel = null;
	protected JFormattedTextField phoneField = null;
	protected JLabel addressLabel = null;
	protected JTextArea addressField = null;
	protected JScrollPane jScrollPane = null;
	protected JTextField other1Field = null;
	protected JLabel other1Label = null;
	protected JLabel other2Label = null;
	protected JTextField other2Field = null;
	protected MaskFormatter formatPhone = null;  //  @jve:decl-index=0:visual-constraint="494,201"
	protected int oldRow;
	/**
	 * This is the default constructor
	 */
	public PanelTabRegistered() throws EmptyDataShowException{
		super();
		initialize();
		oldRow = 0;
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
		GridBagConstraints gridBagConstraints21 = new GridBagConstraints();
		gridBagConstraints21.gridx = 1;
		gridBagConstraints21.insets = new Insets(0, 5, 0, 5);
		gridBagConstraints21.gridy = 1;
		GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
		gridBagConstraints11.fill = GridBagConstraints.BOTH;
		gridBagConstraints11.gridy = 1;
		gridBagConstraints11.weightx = 1.0;
		gridBagConstraints11.weighty = 1.0;
		gridBagConstraints11.gridx = 0;
		GridBagConstraints gridBagConstraints = new GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.insets = new Insets(0, 0, 5, 0);
		gridBagConstraints.gridy = 0;
		this.setSize(368, 461);
		this.setLayout(new GridBagLayout());
		this.add(getLabelHeader(), gridBagConstraints);
		this.add(getScrollTable(), gridBagConstraints11);
		this.add(getPanelInfo(), gridBagConstraints21);
	}

	/**
	 * This method initializes labelHeader	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getLabelHeader() {
		if (labelHeader == null) {
			labelHeader = new JLabel();
			labelHeader.setText("Personal registrado en el centro");
			labelHeader.setFont(new Font("Calibri", Font.PLAIN, 18));
		}
		return labelHeader;
	}

	/**
	 * This method initializes scrollTable	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollTable() {
		if (scrollTable == null) {
			scrollTable = new JScrollPane();
			scrollTable.setViewportView(getTable());
			scrollTable.setFont(new Font("Calibri", Font.PLAIN, 12));
			scrollTable.setPreferredSize(new Dimension(200, 428));
			scrollTable.setViewportView(getTable());
			scrollTable.setViewportView(getTable());
		}
		return scrollTable;
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
			header.setFont(new Font("Calibri", Font.PLAIN, 12));
			TableColumn col = table.getColumn("ID");
			col.setPreferredWidth(80);
			col.setMaxWidth(100);
			
			table.addMouseListener(new MouseAdapter(){
				public void mouseClicked(MouseEvent e){
					int row = table.rowAtPoint(e.getPoint());
					if(row > -1){
						oldRow = row;
						String value = String.valueOf(tableModel.getValueAt(row, 0));
						int id = Integer.parseInt(value);
						showData(id);
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
					
					if(row > -1){
						oldRow = row;
						showData(Integer.parseInt(String.valueOf(tableModel.getValueAt(row, 0))));
					}
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
				tableModel = new DefaultTableModel(new Object[] { "ID",
				"Nombre y apellidos" }, 0) {
					private static final long serialVersionUID = 89458464741302362L;
					public boolean isCellEditable(int row, int column) {
						return false;
					}
				};
		}
		return tableModel;
	}

	/**
	 * This method initializes panelInfo	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getPanelInfo() {
		if (panelInfo == null) {
			GridBagConstraints gridBagConstraints14 = new GridBagConstraints();
			gridBagConstraints14.fill = GridBagConstraints.BOTH;
			gridBagConstraints14.gridy = 11;
			gridBagConstraints14.weightx = 1.0;
			gridBagConstraints14.gridwidth = 2;
			gridBagConstraints14.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints14.gridx = 0;
			GridBagConstraints gridBagConstraints13 = new GridBagConstraints();
			gridBagConstraints13.gridx = 0;
			gridBagConstraints13.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints13.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints13.gridy = 10;
			other2Label = new JLabel();
			other2Label.setText("label Other 2");
			other2Label.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints12 = new GridBagConstraints();
			gridBagConstraints12.fill = GridBagConstraints.BOTH;
			gridBagConstraints12.gridy = 9;
			gridBagConstraints12.weightx = 1.0;
			gridBagConstraints12.gridwidth = 2;
			gridBagConstraints12.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints12.gridx = 0;
			GridBagConstraints gridBagConstraints10 = new GridBagConstraints();
			gridBagConstraints10.gridx = 0;
			gridBagConstraints10.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints10.insets = new Insets(14, 1, 0, 0);
			gridBagConstraints10.gridy = 8;
			other1Label = new JLabel();
			other1Label.setText("labelOther 1");
			other1Label.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints9 = new GridBagConstraints();
			gridBagConstraints9.fill = GridBagConstraints.BOTH;
			gridBagConstraints9.gridy = 8;
			gridBagConstraints9.weightx = 1.0;
			gridBagConstraints9.gridwidth = 2;
			gridBagConstraints9.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints9.gridx = 0;
			GridBagConstraints gridBagConstraints8 = new GridBagConstraints();
			gridBagConstraints8.gridx = 0;
			gridBagConstraints8.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints8.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints8.gridy = 7;
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints7.gridy = 6;
			gridBagConstraints7.weightx = 1.0;
			gridBagConstraints7.weighty = 1.0;
			gridBagConstraints7.gridwidth = 2;
			gridBagConstraints7.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints7.ipady = 15;
			gridBagConstraints7.anchor = GridBagConstraints.NORTH;
			gridBagConstraints7.gridheight = 1;
			gridBagConstraints7.gridx = 0;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 0;
			gridBagConstraints6.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints6.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints6.gridy = 5;
			addressLabel = new JLabel();
			addressLabel.setText("Dirección");
			addressLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.fill = GridBagConstraints.BOTH;
			gridBagConstraints5.gridy = 4;
			gridBagConstraints5.weightx = 1.0;
			gridBagConstraints5.gridwidth = 2;
			gridBagConstraints5.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints5.gridx = 0;
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.gridx = 0;
			gridBagConstraints4.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints4.insets = new Insets(0, 1, 0, 0);
			gridBagConstraints4.gridy = 3;
			phoneLabel = new JLabel();
			phoneLabel.setText("Teléfono");
			phoneLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.fill = GridBagConstraints.BOTH;
			gridBagConstraints3.gridy = 2;
			gridBagConstraints3.weightx = 1.0;
			gridBagConstraints3.gridwidth = 2;
			gridBagConstraints3.insets = new Insets(0, 14, 0, 0);
			gridBagConstraints3.gridx = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints2.insets = new Insets(14, 1, 0, 0);
			gridBagConstraints2.gridy = 1;
			ciLabel = new JLabel();
			ciLabel.setText("CI");
			ciLabel.setFont(new Font("Calibri", Font.PLAIN, 12));
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.insets = new Insets(20, 12, 0, 30);
			gridBagConstraints1.gridy = 0;
			panelInfo = new JPanel();
			panelInfo.setLayout(new GridBagLayout());
			panelInfo.add(getPicture(), gridBagConstraints1);
			panelInfo.add(ciLabel, gridBagConstraints2);
			panelInfo.add(getCiField(), gridBagConstraints3);
			panelInfo.add(phoneLabel, gridBagConstraints4);
			panelInfo.add(getPhoneField(), gridBagConstraints5);
			panelInfo.add(addressLabel, gridBagConstraints6);
			panelInfo.add(getJScrollPane(), gridBagConstraints7);
			panelInfo.add(other1Label, gridBagConstraints10);
			panelInfo.add(getOther1Field(), gridBagConstraints12);
			panelInfo.add(other2Label, gridBagConstraints13);
			panelInfo.add(getOther2Field(), gridBagConstraints14);
		}
		return panelInfo;
	}

	/**
	 * This method initializes picture	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getPicture() {
		if (picture == null) {
			picture = new JLabel();
			picture.setIcon(new ImageIcon("src/icons/unknown_user.png"));
		}
		return picture;
	}

	/**
	 * This method initializes ciField	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getCiField() {
		if (ciField == null) {
			ciField = new JTextField();
			ciField.setColumns(12);
			ciField.setEditable(false);
			ciField.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return ciField;
	}

	/**
	 * This method initializes phoneField	
	 * 	
	 * @return javax.swing.JFormattedTextField	
	 */
	private JFormattedTextField getPhoneField() {
		if (phoneField == null) {
			phoneField = new JFormattedTextField(getFormatPhone());
			phoneField.setColumns(12);
			phoneField.setEditable(false);
		}
		return phoneField;
	}

	/**
	 * This method initializes addressField	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getAddressField() {
		if (addressField == null) {
			addressField = new JTextArea();
			addressField.setColumns(12);
			addressField.setFont(new Font("Calibri", Font.PLAIN, 12));
			addressField.setEditable(false);
			addressField.setLineWrap(true);
			addressField.setRows(2);
		}
		return addressField;
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane(getAddressField());
			jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		}
		return jScrollPane;
	}

	/**
	 * This method initializes other1Field	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOther1Field() {
		if (other1Field == null) {
			other1Field = new JTextField();
			other1Field.setColumns(12);
			other1Field.setEditable(false);
			other1Field.setFont(new Font("Calibri", Font.PLAIN, 12));
		}
		return other1Field;
	}

	/**
	 * This method initializes other2Field	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getOther2Field() {
		if (other2Field == null) {
			other2Field = new JTextField();
			other2Field.setColumns(12);
			other2Field.setFont(new Font("Calibri", Font.PLAIN, 12));
			other2Field.setEditable(false);
		}
		return other2Field;
	}

	/**
	 * This method initializes formatPhone	
	 * 	
	 * @return javax.swing.text.MaskFormatter	
	 */
	private MaskFormatter getFormatPhone() {
		if (formatPhone == null) {
			formatPhone = new MaskFormatter();
			try{
				formatPhone.setMask("###-####");
			}
			catch(ParseException ex){;}
		}
		return formatPhone;
	}
	
	protected void clear(){
		ciField.setText("");
		phoneField.setText("");
		addressField.setText("");
		other1Field.setText("");
		other2Field.setText("");
	}
	
	public void changeSelRow(int row, int column){
		table.changeSelection(oldRow, column, false, false);
		showData(Integer.parseInt(String.valueOf(tableModel.getValueAt(oldRow, column))));
	}
	public void selectPrev(){
		oldRow--;
		if(oldRow < 0)
			oldRow = table.getRowCount() - 1;
		changeSelRow(oldRow, 0);
	}
	public void selectNext(){
		oldRow++;
		if(oldRow == table.getRowCount())
			oldRow = 0;
		changeSelRow(oldRow, 0);
	}
	public void selectFirst(){
		oldRow = 0;
		changeSelRow(oldRow, 0);
	}
	public void selectLast(){
		oldRow = table.getRowCount() - 1;
		changeSelRow(oldRow, 0);
	}
	
	public abstract void fillTable() throws EmptyDataShowException;
	protected abstract void showData(int id);
	
	public void update() throws EmptyDataShowException{
		while(table.getRowCount() > 0)
			tableModel.removeRow(0);
		fillTable();
	}
	
	public void delete() throws DontExistException{
		int[] indices = table.getSelectedRows();
		
		for(int i = 0; i < indices.length; i++){
			int idSelected = Integer.parseInt(String.valueOf(tableModel.getValueAt(indices[i], 0)));
			CEIS.getInstance().removePerson(idSelected);
		}
	}
	
	public Object getSelected() {
		return null;
	}

}  //  @jve:decl-index=0:visual-constraint="26,27"
