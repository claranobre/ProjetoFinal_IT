package br.imd.controle;
<<<<<<< HEAD
=======
import br.imd.controle.RespostaLog;
import br.imd.visao.CapturaEventoBotao;
>>>>>>> 3474fe3336c2eaf78e28c275af5fcd68a607ae0b

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
		buscaUsuario("CVW0133");
<<<<<<< HEAD
		
=======

>>>>>>> 3474fe3336c2eaf78e28c275af5fcd68a607ae0b
	}
}