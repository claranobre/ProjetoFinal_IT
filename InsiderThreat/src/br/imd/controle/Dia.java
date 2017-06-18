package br.imd.controle;

public class Dia {
	private int counterLogon =  0;
	private int counterLogoff = 0;
	private int counterConnect = 0;
	private int counterDisconnect = 0;
	private int counterHttp = 0;
	private int dia;
	
	public Dia(int dia){
		this.dia = dia;
	}
	
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	private void incrementLogon(){
		this.counterLogon++;
	}
	
	private void incrementLogoff(){
		this.counterLogoff++;
	}
	
	private void incrementConnect(){
		this.counterConnect++;
	}
	
	private void incrementDisconnect(){
		this.counterDisconnect++;
	}
	
	private void incrementHttps(){
		this.counterHttp++;
	}
	
	public void increment(Atividade a){
		if(a instanceof Device){
			Device d = (Device) a;
			if(d.isConnect()){
				incrementConnect();
			}
			else{
				incrementDisconnect();
			}
		}
		else if(a instanceof Https){	
			incrementHttps();
		}
		else if(a instanceof Login){
			Login l = (Login) a;
			if(l.isLogon()){
				incrementLogon();
			}
			else{
				incrementLogoff();
			}
		}
	}
	
	public int getCounterActivity(){
		int a = this.counterConnect + this.counterDisconnect + this.counterHttp + this.counterLogoff + this.counterLogon; 
		return a;
	}
	
	public String getValores(){
		return "{connect: "+ this.counterConnect + " disconnect: " + this.counterDisconnect + " Logon: " + this.counterLogon +" Logoff: " + counterLogoff +" Https: " + counterHttp +"}";
	}
}
