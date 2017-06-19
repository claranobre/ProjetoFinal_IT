package br.imd.controle;

import java.util.ArrayList;
/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe Usuario, raíz da árvore
 *
 */
public class Usuario{
	private String name;
	private String user_ID;
	private String domain;
	private String email;
	private String role;
	private Calendario calendar;
	private ArrayList<Atividade> atividades = new ArrayList<Atividade>();

	/**
	 * Método Construtor
	 */
	public Usuario(){
		calendar = new Calendario();
	}
	/**
	 * Método diaCorrente
	 * @param month
	 * @param day
	 */
	public void diaCorrente(int month, int day){
	}
	/**
	 * Método para armazenar as atividades anteriores do usuário
	 * @return void
	 */
	public void anteriores(){}
	/**
	 * Método para armazenar as atividades suspeitas e o usuário que a executou
	 * @return void
	 */
	public void suspeitas(){}
	/**
	 * Método SetUsuario para armazenar os dados de cada usuário
	 * @param name
	 * @param user_ID
	 * @param domain
	 * @param email
	 * @param role
	 * @return void
	 */
	public void setUsuario(String name, String user_ID, String domain, String email, String role){
		this.name = name;
		this.user_ID = user_ID;
		this.domain = domain;
		this.email = email;
		this.role = role;
	}
	/**
	 * Método getName
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Método setName
	 * @param name
	 * return void
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * Método getUser_ID
	 * @return user_ID
	 */
	public String getUser_ID() {
		return user_ID;
	}
	/**
	 * Método setUuser_ID
	 * @param user_ID
	 * @return void
	 */
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	/**
	 * Método getDomain
	 * @return domain
	 */
	public String getDomain() {
		return domain;
	}
	/**
	 * Método setDomain
	 * @param domain
	 * @return void
	 */
	public void setDomain(String domain) {
		this.domain = domain;
	}
	/**
	 * Método getEmail
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Método setEmail
	 * @param email
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Método getRole
	 * @return role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * Método getRole
	 * @param role
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * Método newActivityDevice armazena a atividade na ArrayList que o usuário
	 * executou no device analisado, salvando também a ID do device
	 * @param pc
	 * @param connect
	 */
	public void newActivityDevice(String id, String pc, String connect, int month, int day, int year, int hour, int minute, int second){
		Atividade device = new Device(connect);
		device.setId(id);
		device.setPc(pc);
		device.setDate(month, day, year, hour, minute, second);
		atividades.add(device);
		calendar.newActivity(device);
	}
	/**
	 * Método newActivityLogon armazena a atividade na ArrayList que o usuário
	 * executou no device analisado, salvando também a ID do device
	 * @param pc
	 * @param logon
	 */
	public void newActivityLogon(String id, String pc, String logon, int month, int day, int year, int hour, int minute, int second){
		Atividade logons = new Login(logon);
		logons.setId(id);
		logons.setPc(pc);
		logons.setDate(month, day, year, hour, minute, second);
		atividades.add(logons);
		calendar.newActivity(logons);
	}
	/**
	 * Método newActivityHttp armazena os sites acessados pelo usuário, salvando
	 * também a ID do device utilizado
	 * @param pc
	 * @param url
	 */
	public void newActivityHttp(String id, String pc, String url, int month, int day, int year, int hour, int minute, int second){
		Atividade http = new Https(url);
		http.setId(id);
		http.setPc(pc);
		http.setDate(month, day, year, hour, minute, second);
		atividades.add(http);
		calendar.newActivity(http);
	}
	/**
	 * Método getContadorDia
	 * @param year
	 * @param month
	 * @param day
	 * @return calendar.getYearCounter(year, month, day)
	 */
	public int getContadorDia(int year, int month, int day){
		return calendar.getYearCounter(year, month, day);
	}
	/**
	 * Método imprimirAtividades imprime as atividades executadas pelo usuário buscado
	 * @return void
	 */	
	public String imprimirAtividade(Atividade a){
		if(a instanceof Device){
			Device d = (Device) a;
			return (String) d.getType();
			
		}
		else if(a instanceof Https){
			Https h = (Https) a;
			return (String) h.getUrl();
			
		}
		else if(a instanceof Login){
			Login l = (Login) a;
			return (String) l.getType();
		}
		return "";
	}
	/**
	 * Método imprimirAtividades
	 */
	public void imprimirAtividades(){
		for (int i = 0; i < atividades.size(); i++){
			imprimirAtividade(atividades.get(i));
		}
	}
	/**
	 * Método imprimirAtividadesDia
	 * @param ano
	 * @param mes
	 * @param dia
	 * @return string
	 */
	public String imprimirAtividadesDia(int ano, int mes, int dia){
		String string = "";
		for(int i = 0; i < atividades.size(); i++){
			Atividade a = atividades.get(i);
			if(a.isFromDate(ano, mes, dia)){
				string += imprimirAtividade(a) + "\n";
			}
		}
		return string;
	}
	/**
	 * Método imprimirDia
	 * @param ano
	 * @param mes
	 * @param dia
	 * @return (String) calendar.getYearValors(ano, mes, dia)
	 */
	public String imprimirDia(int ano, int mes, int dia){
		return (String) calendar.getYearValors(ano, mes, dia);
	}
}