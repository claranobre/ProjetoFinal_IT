package br.imd.controle;

import java.util.ArrayList;

public class Calendario {
	private ArrayList<Ano> anos;
	
	public Calendario(){
		anos = new ArrayList<Ano>();
		for(int i = 2010; i <= 2018; i++){
			anos.add(new Ano(i));
		}
	}
	
	public void newActivity(Atividade activity){
		for (int i = 0; i < anos.size(); i++) {
			if(anos.get(i).getAno() == activity.getYear()){
				anos.get(i).newActivity(activity);
				break;
			}
		}
	}
	
	public String getYearValors(int year, int month, int day){
		for (int i = 0; i < anos.size(); i++) {
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthValors(month, day);
			}
		}
		return "";
	}
	
	public int getYearCounter(int year, int month, int day){
		for(int i = 0; i < anos.size(); i++){
			if(anos.get(i).getAno() == year){
				return anos.get(i).getMonthCounter(month, day);
			}
		}
		return -1;
	}

}
