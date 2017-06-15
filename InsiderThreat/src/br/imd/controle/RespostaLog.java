package br.imd.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RespostaLog extends Usuario{

	private static final int ID_DEVICE = 0, DATE_DEVICE = 1, USER_DEVICE = 2, PC_DEVICE = 3, ACTIVITY_DEVICE = 4;
	private static final int ID_HTTP = 0, DATE_HTTP = 1, USER_HTTP = 2, PC_HTTP = 3, ACTIVITY_HTTP = 4;
	private static final int ID_LOGON = 0, DATE_LOGON = 1, USER_LOGON = 2, PC_LOGON = 3, ACTIVITY_LOGON = 4;
	private static final int EMPLOYEE_NAME = 0, USER_ID = 1, DOMAIN = 2, EMAIL = 3, ROLE = 4;
	private static final int MES = 0, DIA = 1, ANO = 2; 
	private static final int HORA = 0, MINUTO = 1, SEGUNDO = 3;
	static ArrayList<Usuario> users = new ArrayList<Usuario>();
	
	
	String line = "";
	String divisor = ",";
	String divisor2 = "/";
	String divisor3 = ":";
	String divisor4 = "-";
	String divisor5 = " ";
	
	
	
	public static void respostaArquivoLogon(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";

		while((line = leitor.readLine()) != null){
			String[] logon = line.split(divisor);
			String user, pc;
			//divisorDate(DATE_LOGON);
			user = divisorUser(logon[USER_LOGON]);
			pc = divisorPc(logon[PC_LOGON]);
			for(int i = 1; i < users.size(); i++){
				System.out.println(users.get(i).getUser_ID());
				if(users.get(i).getUser_ID() == user){
					users.get(i).newActivityDevice(pc, user);
					System.out.println("opa");
				}
			}
		}
		
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
		divisorDate(deviceDate);
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
		divisorDate(httpDate);
	}

	public static void respostaArquivoLDAP(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		
		while((line = leitor.readLine()) != null){
			String[] ldap = line.split(divisor);
			Usuario novo = new Usuario();
			novo.setUsuario(ldap[EMPLOYEE_NAME], ldap[USER_ID], ldap[DOMAIN], ldap[EMAIL], ldap[ROLE]);
			users.add(novo);
		}
	}
	
	public static void divisorDate(ArrayList<String> date){
		String divisor2 = "/";
		String divisor3 = ":";
		String divisor5 = " ";
		ArrayList<String> diasDate = new ArrayList<String>();
		ArrayList<String> horasDate = new ArrayList<String>();
		String input;
		int day, month, year, hour, minute, second;
		
		for (int i = 1; i < date.size(); i++){
			input = date.get(i);
			Scanner s = new Scanner(input).useDelimiter(divisor5);
			diasDate.add(s.next());
			horasDate.add(s.next());
		}
		
		
		for (int i = 0; i < diasDate.size(); i++){
			input = diasDate.get(i);
			Scanner s = new Scanner(input).useDelimiter(divisor2);
			int valor = Integer.parseInt(s.next());
			//
			//valor = Integer.parseInt(s.next());
			//dias[valor-1]++;
		}
		
		
		/*for (int i = 0; i < date.size(); i++){
			String[] data = line.split(divisor3);
			int valor = Integer.parseInt(data[HORA]);
			[valor]++;
			valor = Integer.parseInt(data[DIA]);
			dias[valor]++;
		*/
	}
		
	public static String divisorUser(String user){
		String divisor2 = "/";
		Scanner s = new Scanner(user).useDelimiter(divisor2);
		user = s.next();
		user = s.next();
		s.close();
		return user;
	}
		
	
	public static String divisorPc(String pc){
		String divisor4 = "-";
		Scanner s = new Scanner(pc).useDelimiter(divisor4);
		pc = s.next();
		pc = s.next();
		s.close();
		return pc;
	}
	
	public static void imprimirCampo(ArrayList<String> campo){
		for (int i = 0; i < campo.size(); i++){
			System.out.println(campo.get(i));
		}
	}
		
	public static void imprimirLista(ArrayList<Usuario> lista){
		for (int i = 1; i < lista.size(); i++){
			System.out.println("UserID: "+ lista.get(i).getName());
		}
	}
}
