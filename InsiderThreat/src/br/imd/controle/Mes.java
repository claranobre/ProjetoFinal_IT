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
//				System.out.println(dias.get(i).getValores());
				return dias.get(i).getCounterActivity();
			}
		}
		return -1;
	}
}