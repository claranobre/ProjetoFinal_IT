package br.imd.controle;

import java.util.ArrayList;
/**
 * Classe Mes
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Mes {
	private int mes;
	private ArrayList<Dia> dias;
	/**
	 * Método Construtor
	 * @param mes
	 */
	public Mes(int mes){
		dias = new ArrayList<Dia>();
		this.mes = mes;
		for(int i = 1; i <= 31; i++){
			dias.add(new Dia(i));
		}
	}
	/**
	 * Método getMes
	 * @return mes
	 */
	public int getMes() {
		return mes;
	}
	/**
	 * Método setMes
	 * @param mes
	 */
	public void setMes(int mes) {
		this.mes = mes;
	}
	/**
	 * Método newActivity
	 * @param activity
	 */
	public void newActivity(Atividade activity){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == activity.getDay()){
				dias.get(i).increment(activity);
				break;
			}
		}
	}
	/**
	 * Método getDayValors
	 * @param day
	 * @return dias.get(i).getValores()
	 */
	public String getDayValors(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getValores();
			}
		}
		return "";
	}
	/**
	 * Método getDayCounter
	 * @param day
	 * @return dias.get(i).getCounterActivity()
	 */
	public int getDayCounter(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getCounterActivity();
			}
		}
		return -1;
	}
	/**
	 * Método getDayCounterConnect
	 * @param day
	 * @return dias.get(i).getCounterActivityConnect() ou -1
	 */
	public int getDayCounterConnect(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getCounterActivityConnect();
			}
		}
		return -1;
	}
	/**
	 * Método getDayCounterDisconnect
	 * @param day
	 * @return dias.get(i).getCounterActivityDisconnect() ou -1
	 */
	public int getDayCounterDisconnect(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getCounterActivityDisconnect();
			}
		}
		return -1;
	}
	/**
	 * Método getDayCounterLogon
	 * @param day
	 * @return dias.get(i).getCounterActivityLogon() ou -1
	 */
	public int getDayCounterLogon(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getCounterActivityLogon();
			}
		}
		return -1;
	}
	/**
	 * Método getDayCounterLogoff
	 * @param day
	 * @return dias.get(i).getCounterActivityLogoff() ou -1
	 */
	public int getDayCounterLogoff(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getCounterActivityLogoff();
			}
		}
		return -1;
	}
	/**
	 * Método getDayCounterHttp
	 * @param day
	 * @return dias.get(i).getCounterActivityHttp() ou -1
	 */
	public int getDayCounterHttp(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getCounterActivityHttp();
			}
		}
		return -1;
	}
}