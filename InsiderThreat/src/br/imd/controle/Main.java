package br.imd.controle;
import br.imd.controle.RespostaLog;

/**
 * Método principal sem interface gráfica
 */

public class Main extends LeituraLog{

	public static void main(String[] args) {
		String csvLogon = ("Dados/logon-sumarizado.csv");
		String csvDevice = ("Dados/device.csv");
		String csvHTTP = ("Dados/http-sumarizado.csv");
		String csvLDAP = ("Dados/ldap.csv");
		
		leituraArquivoLDAP(csvLDAP);
		leituraArquivoLogon(csvLogon);
		leituraArquivoDevice(csvDevice);
		leituraArquivoHTTP(csvHTTP);
		buscaUsuario("CVW0133"); //Users Random
		//System.out.println();
		//buscaUsuario("CBC0653");
		
		
		
		
	}

}
