package visual.own;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class ToolButton extends JButton implements MouseListener{
	private static final long serialVersionUID = 2937769161658451303L;
	
	//--Constructors--
	public ToolButton(Icon image, Icon imageDisabled, String tips){
		super(image);
		setToolTipText(tips);
		setFont(new Font("Calibri", 14, 12));
		setDisabledIcon(imageDisabled);
		setFocusable(false);
		setContentAreaFilled(true);
		setPreferredSize(new Dimension(24, 24));
		addMouseListener(this);
	}
	
//--Methods of MouseListener--
	public void mouseClicked(MouseEvent e){;}
	public void mouseEntered(MouseEvent e){;}
	public void mouseExited(MouseEvent e){;}
	public void mousePressed(MouseEvent e){;}
	public void mouseReleased(MouseEvent e){;}
	

}