package visual.show;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import exception.DontExistException;
import exception.EmptyDataShowException;

import visual.util.forDBAction.DBActionButton;
import visual.util.forDBAction.UpdateTabPanel;

public class PanelTabAbout extends JPanel implements DBActionButton, UpdateTabPanel{

	private static final long serialVersionUID = 1L;
	private JLabel jLabel = null;
	private JLabel jLabel1 = null;
	private JLabel jLabel2 = null;
	private JLabel jLabel3 = null;
	private JLabel jLabel4 = null;
	private JPanel jPanel = null;
	private JLabel jLabel5 = null;
	private JLabel jLabel6 = null;
	private JPanel jPanel1 = null;

	/**
	 * This is the default constructor
	 */
	public PanelTabAbout() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		jLabel6 = new JLabel();
		jLabel6.setText("Fecha de desarrollo junio 2011");
		jLabel6.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabel5 = new JLabel();
		jLabel5.setText("Versión 1.0");
		jLabel5.setFont(new Font("Calibri", Font.PLAIN, 12));
		jLabel4 = new JLabel();
		jLabel4.setText("para el control de acceso al CEIS");
		jLabel4.setFont(new Font("Calibri", Font.PLAIN, 24));
		jLabel3 = new JLabel();
		jLabel3.setText("Sistema informático");
		jLabel3.setFont(new Font("Calibri", Font.PLAIN, 24));
		jLabel2 = new JLabel();
		jLabel2.setText("José Antonio Echeverría");
		jLabel2.setFont(new Font("Calibri", Font.PLAIN, 10));
		jLabel1 = new JLabel();
		jLabel1.setText("Instituto Superior Politécnico");
		jLabel1.setFont(new Font("Calibri", Font.PLAIN, 10));
		this.setSize(574, 184);
		this.setLayout(null);
		this.add(getJPanel1(), null);
	}

	/**
	 * This method initializes jLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getJLabel() {
		if (jLabel == null) {
			jLabel = new JLabel();
			jLabel.setText("");
			jLabel.setIcon(new ImageIcon("src/icons/logo_cujae.png"));
		}
		return jLabel;
	}

	/**
	 * This method initializes jPanel	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel() {
		if (jPanel == null) {
			GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
			gridBagConstraints3.anchor = GridBagConstraints.SOUTHWEST;
			gridBagConstraints3.gridx = 0;
			gridBagConstraints3.gridy = 0;
			gridBagConstraints3.insets = new Insets(0, 20, 0, 0);
			GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
			gridBagConstraints4.insets = new Insets(0, 20, 0, 13);
			gridBagConstraints4.gridy = 1;
			gridBagConstraints4.gridx = 0;
			jPanel = new JPanel();
			jPanel.setLayout(new GridBagLayout());
			jPanel.add(jLabel4, gridBagConstraints4);
			jPanel.add(jLabel3, gridBagConstraints3);
		}
		return jPanel;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints7 = new GridBagConstraints();
			gridBagConstraints7.gridx = 1;
			gridBagConstraints7.gridy = 2;
			GridBagConstraints gridBagConstraints6 = new GridBagConstraints();
			gridBagConstraints6.gridx = 1;
			gridBagConstraints6.gridy = 1;
			GridBagConstraints gridBagConstraints5 = new GridBagConstraints();
			gridBagConstraints5.gridx = 1;
			gridBagConstraints5.gridy = 0;
			GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
			gridBagConstraints2.gridx = 0;
			gridBagConstraints2.gridy = 2;
			GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
			gridBagConstraints1.gridx = 0;
			gridBagConstraints1.gridy = 1;
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.gridx = 0;
			gridBagConstraints.gridy = 0;
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setBounds(new Rectangle(28, 25, 460, 118));
			jPanel1.add(getJLabel(), gridBagConstraints);
			jPanel1.add(jLabel1, gridBagConstraints1);
			jPanel1.add(jLabel2, gridBagConstraints2);
			jPanel1.add(getJPanel(), gridBagConstraints5);
			jPanel1.add(jLabel5, gridBagConstraints6);
			jPanel1.add(jLabel6, gridBagConstraints7);
		}
		return jPanel1;
	}

	public Object getSelected() {
		return null;
	}
	public void selectFirst() {;}
	public void selectLast() {;}
	public void selectNext() {;}
	public void selectPrev() {;}
	public void delete() throws DontExistException {;}
	public void update() throws EmptyDataShowException {;}

}  //  @jve:decl-index=0:visual-constraint="10,10"
