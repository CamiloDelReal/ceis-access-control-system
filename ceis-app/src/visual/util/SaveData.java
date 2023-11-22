package visual.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ceis.CEIS;
import ceis.person.Person;
import exception.DuplicityException;

public class SaveData {
	
	public static void insertDataInCEIS(ArrayList<Person> list) throws DuplicityException{
		CEIS ceis = CEIS.getInstance();
		
		for(int i = 0; i < list.size(); i++)
			try{
				ceis.addPerson(list.get(i));
			}
			catch(DuplicityException ex){
				throw ex;
			}
	}
	
	public static String savePicture(String image, int id){
		String savedPicture = "resource/" + id +".png";
		
		try{
			FileInputStream in = new FileInputStream(image);
			BufferedInputStream reader = new BufferedInputStream(in, 4096);
			FileOutputStream out = new FileOutputStream(savedPicture);
			BufferedOutputStream writer = new BufferedOutputStream(out, 4096);
			byte[] buffer = new byte[4096];
			int byteRead = 0;
			while((byteRead = reader.read(buffer, 0, 4096)) >= 0)
				writer.write(buffer, 0, byteRead);
			reader.close();
			writer.flush();
			writer.close();
		}
		catch(Throwable ex){
			JOptionPane.showMessageDialog(null, "Error en copia de imagen");
		}
		
		return savedPicture;
		
	}
}
