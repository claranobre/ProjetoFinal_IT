package br.imd.controle;

public class Atividades extends LeituraLog{

	private String idAtividade;
	private Device deviceUsado;

	
	public void logAnalyzer(){
		LeituraLog leitor = new LeituraLog();
	}

	/*public void acaoUsuario(){
		if(idAtividade == ACTIVITY_DEVICE){
			if(ACTIVITY_DEVICE == connect){
				dados.add(idAtividade);
				insert();
			}
			if(ACTIVITY_DEVICE == disconnect){
				dados.add(idAtividade);	
				insert();
			}else{
				System.out.println("ID incorreto");
			}
		}
		if(idAtividade == ACTIVITY_LOGON){
			if(ACTIVITY_LOGON == logon){
				dados.add(idAtividade);
				logon();
			}
			if(ACTIVITY_LOGON == logoff){
				dados.add(idAtividade);
				logon();
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

	}*/

	/*private void file(){}*/

	/*private boolean http(boolean acesso){
		if(acesso == true){
			return on;
		}else{
			return off;
		}
	}*/

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
}