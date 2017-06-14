package br.imd.controle;

import java.util.ArrayList;

public class Atividades extends RespostaLog{

	private String idAtividade;
	private String deviceUsado;
	
	private ArrayList<String> diasSemana;
	
	
	public void diaCorrente(){}
	
	public void anteriores(){}
	
	public void suspeitas(){}

	
	public void AnalisadorDeLog(){}

	public void acaoUsuario(){
		if(idAtividade == ACTIVITY_DEVICE){
			if(deviceActivity == connect){
				
			}
			if(deviceActivity == disconnect){

			}else{
				System.out.println("ID incorreto");
			}
		}
		if(idAtividade == ACTIVITY_LOGON){
			if(logonActivity == logon){
			}
			if(logonActivity == logoff){
			}else{
				System.out.println("ID incorreto");
			}
		}

	}

	private boolean insert(boolean acao){
		if(acao == true){
			return connect;
		}else{
			return disconnect;
		}
	}

	private boolean logon(boolean acao){
		if(acao == true){
			return logon;
		}else{
			return logoff;
		}
	}

	private void email(){
		ArrayList<Usuario> email = new ArrayList<Usuario>();

	}

	
	private boolean http(boolean acesso){
		if(acesso == true){
			return on;
		}else{
			return off;
		}
	}

	public String getIdAtividade() {
		return idAtividade;
	}
	public void setIdAtividade(String idAtividade) {
		this.idAtividade = idAtividade;
	}
	public Device getDeviceUsado() {
		return deviceUsado;
	}
	public void setDeviceUsado(Device deviceUsado) {
		this.deviceUsado = deviceUsado;
	}
	}*/
}
