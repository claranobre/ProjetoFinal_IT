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
	/**
	 * ArrayList de Atividades para poder gerenciar o que cada usuário executou
	 */
	private ArrayList<Atividades> atividades = new ArrayList<Atividades>();
	
	/**
	 * Método Construtor vazio
	 */
	public Usuario(){}
	/**
	 * Método para armazenar as atividades que o usuário executou no dia indicado
	 * @return void
	 */	
	public void diaCorrente(){}
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
		Atividades device = new Atividades();
		device.setId(id);
		device.setPc(pc);
		device.setDevice(connect);
		device.setDate(month, day, year, hour, minute, second);
		atividades.add(device);
	}
	/**
	 * Método newActivityLogon armazena a atividade na ArrayList que o usuário
	 * executou no device analisado, salvando também a ID do device
	 * @param pc
	 * @param logon
	 */
	public void newActivityLogon(String id, String pc, String logon, int month, int day, int year, int hour, int minute, int second){
		Atividades logons = new Atividades();
		logons.setId(id);
		logons.setPc(pc);
		logons.setLogon(logon);
		logons.setDate(month, day, year, hour, minute, second);
		atividades.add(logons);
	}
	/**
	 * Método newActivityHttp armazena os sites acessados pelo usuário, salvando
	 * também a ID do device utilizado
	 * @param pc
	 * @param http
	 */
	public void newActivityHttp(String id, String pc, String http, int month, int day, int year, int hour, int minute, int second){
		Atividades https = new Atividades();
		https.setId(id);
		https.setPc(pc);
		https.setHttp(http);
		https.setDate(month, day, year, hour, minute, second);
		atividades.add(https);
	}
	/**
	 * Método imprimirAtividades imprime as atividades executadas pelo usuário buscado
	 * @return void
	 */
	public void imprimirAtividades(){
		for (int i = 0; i < atividades.size(); i++){
			if(atividades.get(i).isUsedConnect()){
				System.out.println("Data: " + atividades.get(i).getDate() + " PC: "+ atividades.get(i).getPc() + " Atividade: " + atividades.get(i).getDevice());
			}
			else if(atividades.get(i).isUsedLogon()){
				System.out.println("Data: " + atividades.get(i).getDate() + " PC: "+ atividades.get(i).getPc() + " Atividade: " + atividades.get(i).getLogon());
			}
			else{
				System.out.println("Data: " + atividades.get(i).getDate() + " PC: "+ atividades.get(i).getPc() + " Atividade: " + atividades.get(i).getHttp());
			}
			
			
		}
	}
}