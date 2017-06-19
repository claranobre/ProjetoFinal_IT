package br.imd.controle;
/**
 * Classe Dia
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Dia {
	private int counterLogon =  0;
	private int counterLogoff = 0;
	private int counterConnect = 0;
	private int counterDisconnect = 0;
	private int counterHttp = 0;
	private int dia;
	/**
	 * Método Construtor
	 * @param dia
	 */
	public Dia(int dia){
		this.dia = dia;
	}
	/**
	 * Método getDia
	 * @return dia
	 */
	public int getDia() {
		return dia;
	}
	/**
	 * Método setDia
	 * @param dia
	 */
	public void setDia(int dia) {
		this.dia = dia;
	}
	/**
	 * Método incrementLogon()
	 */
	private void incrementLogon(){
		this.counterLogon++;
	}
	/**
	 * Método incrementoLogoff
	 */
	private void incrementLogoff(){
		this.counterLogoff++;
	}
	/**
	 * Método incrementConnect
	 */
	private void incrementConnect(){
		this.counterConnect++;
	}
	/**
	 * Método incrementDisconnect
	 */
	private void incrementDisconnect(){
		this.counterDisconnect++;
	}
	/**
	 * Método incrementHttps
	 */
	private void incrementHttps(){
		this.counterHttp++;
	}
	/**
	 * Método increment
	 * @param a
	 */
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
	/**
	 * Método getCounterActivity
	 * @return a
	 */
	public int getCounterActivity(){
		int a = this.counterConnect + this.counterDisconnect + this.counterHttp + this.counterLogoff + this.counterLogon; 
		return a;
	}
	/**
	 * Método getCounterActivityConnect
	 * @return counterConnect
	 */
	public int getCounterActivityConnect(){
		return this.counterConnect;
	}
	/**
	 * Método getCounterActivityDisconnect
	 * @return counterDisconnect
	 */
	public int getCounterActivityDisconnect() {
		return counterDisconnect;
	}
	/**
	 * Método getCounterActivityLogon
	 * @return counterLogon
	 */
	public int getCounterActivityLogon() {
		return counterLogon;
	}
	/**
	 * Método getCounterActivityLogoff
	 * @return counterLogoff
	 */
	public int getCounterActivityLogoff() {
		return counterLogoff;
	}
	/**
	 * Método getCounterActivityHttp
	 * @return counterHttp
	 */
	public int getCounterActivityHttp() {
		return counterHttp;
	}

	/**
	 * Método do tipo String getValores
	 * @return counterConnect, counterDisconnect, counterLogon, counterLogoff, counterHttp
	 */
	public String getValores(){
		return "{connect: "+ this.counterConnect + " disconnect: " + this.counterDisconnect + " Logon: " + this.counterLogon +" Logoff: " + counterLogoff +" Https: " + counterHttp +"}";
	}
}