package br.imd.controle;

public class Usuario extends LeituraLog {
	
	public Usuario(){
		/*RespostaLog.USER_ID;
		RespostaLog.EMPLOYEE_NAME;
		RespostaLog.EMAIL;
		RespostaLog.DOMAIN;
		respostaLog.ROLE;*/
			
	}

	public static void main(String[] args){
		String csvLDAP = ("Dados/ldap.csv");
		leituraArquivoLDAP(csvLDAP);
	}
}