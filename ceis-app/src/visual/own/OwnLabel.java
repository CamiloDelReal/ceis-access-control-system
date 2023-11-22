package visual.own;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JLabel;

public class OwnLabel extends JLabel implements MouseListener{
	private static final long serialVersionUID = -8683179700472196645L;
	
	private String text;
	
//--Constructors--
	public OwnLabel(String text, Icon image, String tips){
		super(text, image, JLabel.LEFT);
		setHorizontalAlignment(LEFT);
		//setPreferredSize(new Dimension(170, 16));
		this.text = text;
		setToolTipText(tips);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		setFont(new Font("Calibri", 14, 12));
		setOpaque(false);
		
		addMouseListener(this);
	}
	
//--Methods of MoseListener--
	public void mouseEntered(MouseEvent e){
		setText("<html><body><u>" + text + "</u></body></html>");
	}
	public void mouseExited(MouseEvent e){
		
		setText(text);
	}
	public void mouseClicked(MouseEvent e){;}
	public void mousePressed(MouseEvent e){;}
	public void mouseReleased(MouseEvent e){;}
}