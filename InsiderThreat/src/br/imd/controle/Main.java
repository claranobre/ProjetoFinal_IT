package br.imd.controle;

import org.jfree.ui.RefineryUtilities;

import br.imd.visao.GeradorHistograma;
import br.imd.visao.InterfaceUI;

/**
 * Classe Principal com Interface Gráfica
 * @author Ana Clara e Felipe Gilberto
 */

public class Main extends LeituraLog{
	public static void main(String[] args) {
		/**
		 * Interface Gráfica
		 */
		InterfaceUI insiderThreat = new InterfaceUI();
		insiderThreat.montaTela();
		
		String csvLogon = ("Dados/logon-sumarizado.csv");
		String csvDevice = ("Dados/device.csv");
		String csvHTTP = ("Dados/http-sumarizado.csv");
		String csvLDAP = ("Dados/ldap.csv");

		leituraArquivoLDAP(csvLDAP);
		leituraArquivoLogon(csvLogon);
		leituraArquivoDevice(csvDevice);
		leituraArquivoHTTP(csvHTTP);
		/**
		 * Função para buscar o usuário e criar o seu Histograma
		 */
		buscaUsuario("KEE0997", 2010, 01, 04);
	}
}