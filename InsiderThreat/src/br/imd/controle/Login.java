package br.imd.controle;
/**
 * Classe Login
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Login extends Atividade{
	private String type;
	/**
	 * Método Login
	 * @param type
	 */
	public Login(String type){
		this.type = type;
	}
	/**
	 * Método getType
	 * @return type
	 */
	public String getType(){
		return this.type;
	}
	/**
	 * Método isLogon
	 * @return boolean
	 */
	public boolean isLogon(){
		if(this.type.equals("Logon")){
			return true;
		}
		return false;
	}
}