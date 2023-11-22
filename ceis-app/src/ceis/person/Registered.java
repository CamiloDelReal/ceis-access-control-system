package ceis.person;

import visual.util.GraphicSupport;
import visual.util.SaveData;


public abstract class Registered extends Person{
	protected int id;
	protected String address;
	protected String phone;
	protected String picture;
	
//--Constructor--
	public Registered(String ci, String name, String lastName, int id,
					  String address, String phone, String pictureString){
		super(ci, name, lastName);
		this.id = id;
		this.address = address;
		this.phone = phone;
		if(pictureString != null && !pictureString.isEmpty() && !GraphicSupport.isEmpty(pictureString))
			picture = SaveData.savePicture(pictureString, id);
	}
	
//--Interface--
	public void setID(int id){
		this.id = id;
	}
	public int getID(){
		return id;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	public String getAddress(){
		return address;
	}
	
	public void setPhone(String phone){
		this.phone = phone;
	}
	public String getPhone(){
		return phone;
	}
	
	public void setPicture(String pictureString){
		picture = pictureString;
	}
	public String getPicture(){
		return picture;
	}
	
}