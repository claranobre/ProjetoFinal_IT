package br.imd.controle;


public class Main extends LeituraLog{

	public static void main(String[] args) {
		String csvLogon = ("Dados/logon-sumarizado.csv");
		String csvDevice = ("Dados/device.csv");
		String csvHTTP = ("Dados/http-sumarizado.csv");
		String csvLDAP = ("Dados/ldap.csv");
		
		//leituraArquivoLogon(csvLogon);
		//leituraArquivoDevice(csvDevice);
		leituraArquivoHTTP(csvHTTP);
		//leituraArquivoLDAP(csvLDAP);
		
		/**
		 * Método principal sem interface gráfica
		 */
		
<<<<<<< HEAD
		//Tree raiz = new Tree();
		//raiz.insereUsuario();

		/*System.out.println("Pre Ordem: ");
		raiz.emordem(raiz);
		System.out.println("Pre Ordem: ");
		raiz.prefixado(raiz);
		System.out.println("Pos Ordem: ");
		raiz.posfixado(raiz);
	*/
=======
		Tree raiz = new Tree();
		//raiz.insereDados();
>>>>>>> 3ac37dc0158ac83e5f13c26b4248999adb06bf72
	}

}