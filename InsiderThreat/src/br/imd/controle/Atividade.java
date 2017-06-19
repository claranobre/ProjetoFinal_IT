package br.imd.controle;

/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe Atividades
 *
 */

public abstract class Atividade{

	private String id;
	private int day, month, year;
	private int hour, minute, second;
	
	private String pc;

	/**
	 * Método setDate
	 * @param day
	 * @param month
	 * @param year
	 * @param hour
	 * @param minute
	 * @param second
	 * @return void
	 */
	
	public void setDate(int month, int day, int year, int hour, int minute, int second){
		this.day = day;
		this.month = month;
		this.year = year;
		this.hour = hour;
		this.minute = minute;
		this.second = second;
 
	}
	/**
	 * Método getDay
	 * @return day
	 */
	public int getDay() {
		return day;
	}
	/**
	 * Método getMonth
	 * @return month
	 */
	public int getMonth() {
		return month;
	}
	/**
	 * Método getYear
	 * @return year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * Método setPc
	 * @param pc
	 * @return void
	 */

	public void setPc(String pc){
		this.pc = pc;
	}
	/**
	 * Método getPc
	 * @return pc
	 */
	public String getPc(){
		return pc;
	}
	/**
	 * Método setID
	 * @param id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 * Método getId
	 * @return id
	 */
	public String getId(){
		return id;
	}
	/**
	 * Método isFromDate
	 * @param year
	 * @param month
	 * @param day
	 * @return
	 */
	public boolean isFromDate(int year, int month, int day){
		if(this.year == year && this.month == month && this.day == day){
			return true;
		}
		return false;
	}
}