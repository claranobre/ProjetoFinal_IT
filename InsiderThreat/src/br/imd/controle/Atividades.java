package br.imd.controle;

public class Atividades{
	
	private String connect;
	private String logon;
	private String access;
	private int day, month, year, hour, minute, second;
	private String pc;
	
	public void setDate(int day, int month, int year, int hour, int minute, int second){
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
	}
	
	//public getDate(){} Discutir a forma de devolver
	
	public void setDevice(String activity){
		if(activity == "Connect"){
			this.connect = "Connected";
		}else{
			this.connect = "Disconnected";
		}
	}
	
	public String getDevice(){
		return connect;
	}

	public void setLogon(String activity){
		if(activity == "Logon"){
			this.logon = "Login";
		}else{
			this.logon = "Logoff";
		}
	}
	
	public String getLogon(){
		return logon;
	}

	public void setHttp(String site){
		this.access = site;
	}
	
	public String getHttp(){
		return access;
	}
	
	public void setPc(String pc){
		this.pc = pc;
	}
	
	public String getPc(){
		return pc;
	}
}