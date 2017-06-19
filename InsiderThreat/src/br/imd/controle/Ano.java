package br.imd.controle;

import java.util.ArrayList;
/**
 * Classe Ano
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Ano {
	private int ano;
	private ArrayList<Mes> meses;
	
	public Ano(int ano){
		meses = new ArrayList<Mes>();
		this.ano = ano;
		for(int i = 1; i <= 12; i++){
			meses.add(new Mes(i));
		}
	}
	
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public void newActivity(Atividade activity){
		for (int i = 0; i < meses.size(); i++) {
			if(meses.get(i).getMes() == activity.getMonth()){
				meses.get(i).newActivity(activity);
				break;
			}
		}
	}
	
	public String getMonthValors(int month, int day){
		for (int i = 0; i < meses.size(); i++) {
			if(meses.get(i).getMes() == month){
				return meses.get(i).getDayValors(day);
			}
		}
		return "";
	}
	
	public int getMonthCounter(int month, int day){
		for (int i = 0; i < meses.size(); i++) {
			if(meses.get(i).getMes() == month){
				return meses.get(i).getDayCounter(day);
			}
		}
		return -1;
	}
}
