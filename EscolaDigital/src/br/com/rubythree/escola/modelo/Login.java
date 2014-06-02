package br.com.rubythree.escola.modelo;

public class Login {
	private int id;
	private String user;
	private String password;
	
	public int getID(){
		return this.id;
	}
	public void setID(int id){
		this.id = id;
	}
	
	public String getUser(){
		return this.user;
	}
	public void setUser(String user){
		this.user = user;
	}
	
	public String getPass(){
		return this.password;
	}
	public void setPass(String password){
		this.password = password;
	}
}
