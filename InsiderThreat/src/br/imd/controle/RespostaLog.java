package br.imd.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RespostaLog {
	
	private static final int ID_DEVICE = 0, DATE_DEVICE = 1, USER_DEVICE = 2, PC_DEVICE = 3, ACTIVITY_DEVICE = 4;
	private static final int ID_HTTP = 0, DATE_HTTP = 1, USER_HTTP = 2, PC_HTTP = 3, ACTIVITY_HTTP = 4;
	private static final int ID_LOGON = 0, DATE_LOGON = 1, USER_LOGON = 2, PC_LOGON = 3, ACTIVITY_LOGON = 4;
	private static final int EMPLOYEE_NAME = 0, USER_ID = 1, DOMAIN = 2, EMAIL = 3, ROLE = 4;
	private static final int MES = 0, DIA = 1, ANO = 2; 
	private static final int HORA = 0, MINUTO = 1, SEGUNDO = 3;
	
	
	String line = "";
	String divisor = ",";
	String divisor2 = "/";
	String divisor3 = ":";
	String divisor4 = "-";
	String divisor5 = " ";
	
	
	
	public static void respostaArquivoLogon(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		ArrayList<String> logonId = new ArrayList<String>();
		ArrayList<String> logonDate = new ArrayList<String>();
		ArrayList<String> logonUser = new ArrayList<String>();
		ArrayList<String> logonPc = new ArrayList<String>();
		ArrayList<String> logonActivity = new ArrayList<String>();

		while((line = leitor.readLine()) != null){
			String[] logon = line.split(divisor);
			logonId.add(logon[ID_LOGON]);
			logonDate.add(logon[DATE_LOGON]);
			logonUser.add(logon[USER_LOGON]);
			logonPc.add(logon[PC_LOGON]);
			logonActivity.add(logon[ACTIVITY_LOGON]);
		}
		divisorDate(logonDate);
	}
	
	public static void respostaArquivoDevice(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		ArrayList<String> deviceId = new ArrayList<String>();
		ArrayList<String> deviceDate = new ArrayList<String>();
		ArrayList<String> deviceUser = new ArrayList<String>();
		ArrayList<String> devicePc = new ArrayList<String>();
		ArrayList<String> deviceActivity = new ArrayList<String>();
				
		while((line = leitor.readLine()) != null){
			String[] device = line.split(divisor);
			deviceId.add(device[ID_DEVICE]);
			deviceDate.add(device[DATE_DEVICE]);
			deviceUser.add(device[USER_DEVICE]);
			devicePc.add(device[PC_DEVICE]);
			deviceActivity.add(device[ACTIVITY_DEVICE]);
		}
		
	}
	
	public static void respostaArquivoHTTP(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		ArrayList<String> httpId = new ArrayList<String>();
		ArrayList<String> httpDate = new ArrayList<String>();
		ArrayList<String> httpUser = new ArrayList<String>();
		ArrayList<String> httpPc = new ArrayList<String>();
		ArrayList<String> httpActivity = new ArrayList<String>();
		
		while((line = leitor.readLine()) != null){
			String[] http = line.split(divisor);
			httpId.add(http[ID_HTTP]);
			httpDate.add(http[DATE_HTTP]);
			httpUser.add(http[USER_HTTP]);
			httpPc.add(http[PC_HTTP]);
			httpActivity.add(http[ACTIVITY_HTTP]);
		}
	}

	public static void respostaArquivoLDAP(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		ArrayList<String> employeeName = new ArrayList<String>();
		ArrayList<String> userId = new ArrayList<String>();
		ArrayList<String> domain = new ArrayList<String>();
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> role = new ArrayList<String>();
		
		while((line = leitor.readLine()) != null){
			String[] ldap = line.split(divisor);
			employeeName.add(ldap[EMPLOYEE_NAME]);
			userId.add(ldap[USER_ID]);
			domain.add(ldap[DOMAIN]);
			email.add(ldap[EMAIL]);
			role.add(ldap[ROLE]);
		}
		imprimirCampo(role);
	}
	
	public static void divisorDate(ArrayList<String> date){
		String line = "";
		String divisor = ",";
		String divisor2 = "/";
		String divisor3 = ":";
		String divisor4 = "-";
		String divisor5 = " ";
		ArrayList<String> diasDate = new ArrayList<String>();
		ArrayList<String> horasDate = new ArrayList<String>();
		int dias[] = {0};
		int mes[] = {0};
		String input;
		
		
		for (int i = 0; i < date.size(); i++){
			input = date.get(i);
			Scanner s = new Scanner(input).useDelimiter(divisor5);
			
			//diasDate.add(s.next());
			//horasDate.add(s.next());
		}
		
		//imprimirCampo(diasDate);
		//imprimirCampo(horasDate);
		
		/*
		for (int i = 0; i < diasDate.size(); i++){
			String[] data = line.split(divisor2);
			int valor = Integer.parseInt(data[MES]);
			mes[valor]++;
			valor = Integer.parseInt(data[DIA]);
			dias[valor]++;
		}
		
		for (int i = 0; i < date.size(); i++){
			String[] data = line.split(divisor3);
			int valor = Integer.parseInt(data[HORA]);
			[valor]++;
			valor = Integer.parseInt(data[DIA]);
			dias[valor]++;
		}
		*/
		
	}
	
	public void divisorUser(){
		
	}
	
	public void divisorPc(){
		
	}
	
	public static void imprimirCampo(ArrayList<String> campo){
		for (int i = 0; i < campo.size(); i++){
			System.out.println(campo.get(i));
		}
	}
}
