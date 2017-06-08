package br.imd.controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeituraLog {

	private static final int ID_DEVICE = 0, DATE_DEVICE = 1, USER_DEVICE = 2, PC_DEVICE = 3, ACTIVITY_DEVICE = 4;
	private static final int ID_HTTP = 0, DATE_HTTP = 1, USER_HTTP = 2, PC_HTTP = 3, ACTIVITY_HTTP = 4;
	private static final int ID_LOGON = 0, DATE_LOGON = 1, USER_LOGON = 2, PC_LOGON = 3, ACTIVITY_LOGON = 4;
	private static final int EMPLOYEE_NAME = 0, USER_ID = 1, EMAIL = 2, DOMAIN = 3, ROLE = 4;

	private ArrayList<String> entrada;
	private ArrayList<String> acaoUsuario;

	BufferedReader leitor = null;
	String line = "";
	String csvSplitBy = ",";

	public void leituraArquivo(){
		ArrayList<String> csvFile = new ArrayList<String>();
		csvFile.add("/home/clara/Documents/UFRN/Linguagem de Programacao II/2017.1/ProjetoFinal_IT/Dados/logon-sumarizado.csv");
		csvFile.add("/home/clara/Documents/UFRN/Linguagem de Programacao II/2017.1/ProjetoFinal_IT/Dados/http-sumarizado.csv");
		csvFile.add("/home/clara/Documents/UFRN/Linguagem de Programacao II/2017.1/ProjetoFinal_IT/Dados/ldap.csv");
		csvFile.add("/home/clara/Documents/UFRN/Linguagem de Programacao II/2017.1/ProjetoFinal_IT/Dados/device.csv");

		try{

			this.leitor = new BufferedReader(new FileReader());

		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch (IOException e){
			e.printStackTrace();
		} finally{
			if(leitor != null){
				try{
					leitor.close();
				}catch (IOException e){
					e.printStackTrace();
				}
			}
		}	
	}	


	public void respostaArquivo() throws IOException{
		while((line = leitor.readLine()) != null){
			String[] logonUsuario = line.split(csvSplitBy);
			String[] deviceUsuario = line.split(csvSplitBy);
			String[] ldapUsuario = line.split(csvSplitBy);
			String[] httpUsuario = line.split(csvSplitBy);

			System.out.println("Usuario: [id = " + logonUsuario[ID_LOGON] + "]"
					+ " [Date: = " + logonUsuario[DATE_LOGON] + "]" + " [User = " + logonUsuario[USER_LOGON] + "]"
					+ " [PC = " + logonUsuario[PC_LOGON] + "]" + " [Activity = "
					+ logonUsuario[ACTIVITY_LOGON] + "]");


			System.out.println("Usuario: [id = " + deviceUsuario[ID_DEVICE] + "]"
					+ " [Date: = " + deviceUsuario[DATE_DEVICE] + "]" + " [User = " + deviceUsuario[USER_DEVICE] + "]"
					+ " [PC = " + deviceUsuario[PC_DEVICE] + "]" + " [Activity = "
					+ deviceUsuario[ACTIVITY_DEVICE] + "]");

			System.out.println("Usuario: [id = " + httpUsuario[ID_HTTP] + "]"
					+ " [Date: = " + httpUsuario[DATE_HTTP] + "]" + " [User = " + httpUsuario[USER_HTTP] + "]"
					+ " [PC = " + httpUsuario[PC_HTTP] + "]" + " [Activity = "
					+ httpUsuario[ACTIVITY_HTTP] + "]");

			/*System.out.println("Usuario: [id = " + logonUsuario[ID_LOGON] + "]"
					+ " [Date: = " + logonUsuario[DATE_LOGON] + "]" + " [User = " + logonUsuario[USER_LOGON] + "]"
					+ " [PC = " + logonUsuario[PC_LOGON] + "]" + " [Activity = "
					+ logonUsuario[ACTIVITY_LOGON] + "]");*/

		}
	}	
}