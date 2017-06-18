package br.imd.controle;

public class Login extends Atividade{
	private String type;
	
	public Login(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
	
	public boolean isLogon(){
		if(this.type.equals("Logon")){
			return true;
		}
		return false;
	}
}
