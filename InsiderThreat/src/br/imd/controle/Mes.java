package br.imd.controle;

import java.util.ArrayList;

public class Mes {
	private int mes;
	private ArrayList<Dia> dias;
	
	public Mes(int mes){
		dias = new ArrayList<Dia>();
		this.mes = mes;
		for(int i = 1; i <= 31; i++){
			dias.add(new Dia(i));
		}
	}
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public void newActivity(Atividade activity){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == activity.getDay()){
				dias.get(i).increment(activity);
				break;
			}
		}
	}
	
	public String getDayValors(int day){
		for (int i = 0; i < dias.size(); i++) {
			if(dias.get(i).getDia() == day){
				return dias.get(i).getValores();
			}
		}
		return "";
	}
}
