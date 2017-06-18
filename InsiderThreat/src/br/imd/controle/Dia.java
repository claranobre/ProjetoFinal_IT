package br.imd.controle;

public class Dia {
	private int contadorLogon =  0;
	private int contadorLogoff = 0;
	private int contadorConnect = 0;
	private int contadorDisconnect = 0;
	private int contadorHttp = 0;
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
		this.contadorLogon++;
	}
	
	private void incrementLogoff(){
		this.contadorLogoff++;
	}
	
	private void incrementConnect(){
		this.contadorConnect++;
	}
	
	private void incrementDisconnect(){
		this.contadorDisconnect++;
	}
	
	private void incrementHttps(){
		this.contadorHttp++;
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
	
	public String getValores(){
		return "{connect: "+ this.contadorConnect + " disconnect: " + this.contadorDisconnect + " Logon: " + this.contadorLogon +" Logoff: " + contadorLogoff +" Https: " + contadorHttp +"}";
	}
}
