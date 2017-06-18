package br.imd.controle;

import java.util.ArrayList;

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
		//buscaUsuario("CVW0133");
		ArrayList<Usuario> suspeitos = usuariosSuspeitos(2010, 01, 04);
		for(int i = 0; i < suspeitos.size(); i++){
			System.out.println("Nome: " + suspeitos.get(i).getName() + " UserID: " + suspeitos.get(i).getUser_ID() + " Email: " + suspeitos.get(i).getEmail() + " Role: " + suspeitos.get(i).getRole());
			System.out.println("Atividades Suspeitas - Listadas Abaixo");
			suspeitos.get(i).imprimirDia(2010, 01, 04);
			suspeitos.get(i).imprimirAtividadesDia(2010, 01, 04);
			System.out.println();
		}
	}
}