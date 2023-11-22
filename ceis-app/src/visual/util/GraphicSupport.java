package visual.util;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.Window;
import java.util.Calendar;

import javax.swing.ImageIcon;

public class GraphicSupport {
	public static void centerWindow(Window wnd){
		Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		wnd.setLocation((size.width - wnd.getWidth()) / 2, (size.height - wnd.getHeight()) / 2);
	}
	public static boolean isEmpty(String text){
		int i = 0;
		
		while(i < text.length() && text.charAt(i) == ' ')
			i++;
		
		return i == text.length() ? true : false;
	}
	
	public static void toLower(String array[]) {
		for (int i=0, n=array.length; i<n; i++) {
			array[i] = array[i].toLowerCase();
		}
	}

	public static String getStringEntryDate(Calendar cal, boolean day){
		String entry = "";
		String aux = "";
		String[] dayOfWeek = {
				"Domingo",
				"Lunes",
				"Martes",
				"Miercoles",
				"Jueves",
				"Viernes",
				"Sabado"
			};
		
		if(cal != null){
			if(day)
				entry = dayOfWeek[cal.get(Calendar.DAY_OF_WEEK) - 1] + " ";
			entry += String.valueOf(cal.get(Calendar.DAY_OF_MONTH)) + "/";
			entry += String.valueOf(cal.get(Calendar.MONTH) + 1) + "/";
			entry += String.valueOf(cal.get(Calendar.YEAR)) + "  ";
			aux = String.valueOf(cal.get(Calendar.HOUR));
			if(aux.equals("0"))
				aux = "12";
			if(aux.length() == 1)
				aux = "0" + aux;
			entry += aux + ":";
			aux = String.valueOf(cal.get(Calendar.MINUTE));
			if(aux.length() == 1)
				aux = "0" + aux;
			entry += aux + ":";
			aux = String.valueOf(cal.get(Calendar.SECOND));
			if(aux.length() == 1)
				aux = "0" + aux;
			entry += aux;
			if(cal.get(Calendar.AM_PM) == Calendar.AM)
				entry += " AM";
			else
				entry += " PM";
		}
		
		return entry;
	}
	
	public static ImageIcon scaleImageIcon(ImageIcon icon, int width, int height){
		if(icon.getIconWidth() != width || icon.getIconHeight() != height)
			icon = new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_DEFAULT));
		
		return icon;
	}
}
