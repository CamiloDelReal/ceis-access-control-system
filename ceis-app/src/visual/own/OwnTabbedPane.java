package visual.own;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import visual.MainFrame;

public class OwnTabbedPane extends JTabbedPane implements ChangeListener{
	private static final long serialVersionUID = 2734692855331019723L;
	
	private int tabCount = 0;
	private int indexSelected = 0;
	private JToolBar toolbar;
	
//--Constructors--
	public OwnTabbedPane(JToolBar toolbar){
		super();
		setFont(new Font("Calibri", 14, 12));
		addChangeListener(this);
		this.toolbar = toolbar;
	}
	
//--Redefine methods addTab--
	public void addTab(String title, String tooltips, String image, JComponent c){
		removeChangeListener(this);
		if(tabCount > 0)
			((PanelTab)getTabComponentAt(indexSelected)).getCloseButton().setDisabled();
		super.addTab(title, c);
		indexSelected = tabCount;
		setSelectedIndex(indexSelected);
		PanelTab panel = new PanelTab(this, title, image);
		//setTabLayoutPolicy(SCROLL_TAB_LAYOUT);
		setTabComponentAt(tabCount, panel);
		setToolTipTextAt(tabCount, tooltips);
		tabCount++;
		addChangeListener(this);
	}
	public void removeTab(int index){
		if( (index < indexSelected) || ((index == indexSelected) && (indexSelected == (tabCount - 1))))
			indexSelected--;
		updateIndex(index);
		super.remove(index);
		tabCount--;
		MainFrame.getInformationDisplayed().remove(index);
		if(getTabCount() == 0)
			toolbar.setVisible(false);
	}
	
	private void updateIndex(int firstIndex){
		for(int i = (firstIndex + 1); i < tabCount; i++)
			((PanelTab)getTabComponentAt(i)).getCloseButton().decreaseIndexOfTab();	
	}
	
//--Method of ChangeListener--
	public void stateChanged(ChangeEvent e){
		if(tabCount > 1){
			((PanelTab)getTabComponentAt(indexSelected)).getCloseButton().setDisabled();
			indexSelected = getSelectedIndex();
			((PanelTab)getTabComponentAt(indexSelected)).getCloseButton().setEnabled();
		}
	}
}

class PanelTab extends JPanel{
	private static final long serialVersionUID = 8406758262887778036L;
	
	private CloseButton closeButton;
	
//--Constructors--
	public PanelTab(OwnTabbedPane tab, String title, String image){
		super(new FlowLayout());
		setOpaque(false);
		setFont(new Font("Calibri", 14, 12));
		add(new JLabel(new ImageIcon(image)));
		JLabel labelTitle = new JLabel(title);
		labelTitle.setFont(new Font("Calibri", 14, 12));
		add(new JLabel(title));
		Icon []icons = {
				new ImageIcon("src/icons/close.png"),
				new ImageIcon("src/icons/closeHover.png"),
				new ImageIcon("src/icons/closePressed.png"),
				new ImageIcon("src/icons/closeDisabled.png")
		};
		closeButton = new CloseButton(tab, icons, tab.getTabCount() - 1);
		add(closeButton);
	}
	
	CloseButton getCloseButton(){
		return closeButton;
	}
}

class CloseButton extends JButton implements MouseListener, ActionListener{
	private static final long serialVersionUID = -26773622282903333L;
	
	private OwnTabbedPane tab;
	private Icon close;
	private Icon hover;
	private Icon pressed;
	private Icon disabled;
	private int indexOfTab;
	
//--Constructors--
	public CloseButton(OwnTabbedPane tab, Icon []icons, int indexOfTab){
		this.tab = tab;
		this.indexOfTab = indexOfTab;
		close = icons[0];
		hover = icons[1];
		pressed = icons[2];
		disabled = icons[3];
		setIcon(close);
		setPreferredSize(new Dimension(17, 17));
		setToolTipText("Cerrar");
		setContentAreaFilled(false);
		setFocusable(false);
		setRolloverEnabled(true);
		setFont(new Font("Calibri", 14, 12));
		addMouseListener(this);
		addActionListener(this);
	}
	
	void decreaseIndexOfTab(){
		indexOfTab--;
	}
	void setDisabled(){
		setIcon(disabled);
	}
	void setEnabled(){
		setIcon(close);
	}

//--Methods of MouseListener--
	public void mouseClicked(MouseEvent e){;}
	public void mouseEntered(MouseEvent e){
		CloseButton but = (CloseButton) e.getComponent();
		but.setIcon(hover);
	}
	public void mouseExited(MouseEvent e){
		CloseButton but = (CloseButton) e.getComponent();
		if(tab.getSelectedIndex() == indexOfTab)
			but.setIcon(close);
		else
			but.setIcon(disabled);
		
	}
	public void mousePressed(MouseEvent e){
		CloseButton but = (CloseButton) e.getComponent();
		but.setIcon(pressed);
	}
	public void mouseReleased(MouseEvent e){
		CloseButton but = (CloseButton) e.getComponent();
		but.setIcon(hover);
	}

//--Method of ActionListener--
	public void actionPerformed(ActionEvent e){
		tab.removeTab(indexOfTab);
	}
}