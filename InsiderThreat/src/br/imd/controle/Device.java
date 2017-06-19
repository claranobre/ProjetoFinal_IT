package br.imd.controle;
/**
 * Classe Device
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Device extends Atividade{
	private String type;
	/**
	 * Método Device
	 * @param type
	 */
	public Device(String type){
		this.type = type;
	}
	/**
	 * Método getType
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * Método isConnect
	 * @return boolean
	 */
	public boolean isConnect(){
		if(this.type.equals("Connect")){
			return true;
		}
		return false;
	}
}
