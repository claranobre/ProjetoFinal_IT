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
<<<<<<< HEAD
	private Calendario calendar;
	private ArrayList<Atividade> atividade = new ArrayList<Atividade>();
=======
	
	private int contadorLogon =  0;
	private int contadorLogoff = 0;
	private int contadorConnect = 0;
	private int contadorDisconnect = 0;
	private int contadorHttp = 0;
	/**
	 * Matriz bidimensional para armazenar os valores de meses e dias analisados
	 */
	//private int contadorAtividades[][] = new int[12][31];
	/**
	 * Matriz bidimensional para armazenar a quantidade de connect e disconnect do device do usuário
	 */ 
	private int contadorAtividadesConnect[][] = new int [12][31];
	private int contadorAtividadesDisconnect[][] = new int [12][31];
	/**
	 * Matriz bidimensional para armazenar a quantidade de logons e logoffs do usuário
	 */
	private static int contadorAtividadesLogon[][] = new int [12][31];
	private static int contadorAtividadesLogoff[][] = new int [12][31];
	/**
	 * Matriz bidimensional para armazenar a quantidade de sites acessados pelo usuário
	 */
	private int contadorAtividadesHttp[][] = new int[12][31];
	/**
	 * ArrayList de Atividades para poder gerenciar o que cada usuário executou
	 */
	private ArrayList<Atividades> atividades = new ArrayList<Atividades>();
>>>>>>> 3474fe3336c2eaf78e28c275af5fcd68a607ae0b

	public Usuario(){
		calendar = new Calendario();
	}
	
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
		atividade.add(device);
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
		atividade.add(logons);
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
		atividade.add(http);
		calendar.newActivity(http);
	}
	/**
	 * Método imprimirAtividades imprime as atividades executadas pelo usuário buscado
	 * @return void
	 */
	public void imprimirAtividades(){
		for (int i = 0; i < atividade.size(); i++){
			if(atividade.get(i) instanceof Device){
				Device d = (Device) atividade.get(i);
				System.out.println(d.getType());
				
			}
			else if(atividade.get(i) instanceof Https){
				Https h = (Https) atividade.get(i);
				System.out.println(h.getUrl());
				
			}
			else if(atividade.get(i) instanceof Login){
				Login l = (Login) atividade.get(i);
				System.out.println(l.getType());
			}
		}
	}
	
	public void imprimirDia(int ano, int mes, int dia){
		System.out.println(calendar.getYearValors(ano, mes, dia));
	}
}