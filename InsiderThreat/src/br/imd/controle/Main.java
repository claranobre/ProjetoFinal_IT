package br.imd.controle;
import br.imd.controle.RespostaLog;

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
		buscaUsuario("ABL0836"); //Users Random
		System.out.println();
		buscaUsuario("CBC0653");
		
		
		/**
		 * Método principal sem interface gráfica
		 */
		
		//Tree raiz = new Tree();
		//raiz.insereUsuario();

		/*System.out.println("Pre Ordem: ");
		raiz.emordem(raiz);
		System.out.println("Pre Ordem: ");
		raiz.prefixado(raiz);
		System.out.println("Pos Ordem: ");
		raiz.posfixado(raiz);
		Tree raiz = new Tree();
		raiz.insereDados();
		*/
	}

}
