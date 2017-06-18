package br.imd.controle;

public class Device extends Atividade{
	private String type;

	public Device(String type){
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean isConnect(){
		if(this.type.equals("Connect")){
			return true;
		}
		return false;
	}
}
