package br.imd.controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class RespostaLog {
	
	private static final int ID_DEVICE = 0, DATE_DEVICE = 1, USER_DEVICE = 2, PC_DEVICE = 3, ACTIVITY_DEVICE = 4;
	private static final int ID_HTTP = 0, DATE_HTTP = 1, USER_HTTP = 2, PC_HTTP = 3, ACTIVITY_HTTP = 4;
	private static final int ID_LOGON = 0, DATE_LOGON = 1, USER_LOGON = 2, PC_LOGON = 3, ACTIVITY_LOGON = 4;
	private static final int EMPLOYEE_NAME = 0, USER_ID = 1, DOMAIN = 2, EMAIL = 3, ROLE = 4;
	
	public static void respostaArquivoLogon(BufferedReader leitor) throws IOException{
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String> logonId = new ArrayList<String>();
		ArrayList<String> logonData = new ArrayList<String>();
		ArrayList<String> logonUser = new ArrayList<String>();
		ArrayList<String> logonPc = new ArrayList<String>();
		ArrayList<String> logonActivity = new ArrayList<String>();

		while((line = leitor.readLine()) != null){
			String[] logon = line.split(csvSplitBy);
			logonId.add(logon[ID_LOGON]);
			logonData.add(logon[DATE_LOGON]);
			logonUser.add(logon[USER_LOGON]);
			logonPc.add(logon[PC_LOGON]);
			logonActivity.add(logon[ACTIVITY_LOGON]);
		}
	}
	
	public static void respostaArquivoDevice(BufferedReader leitor) throws IOException{
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String> deviceId = new ArrayList<String>();
		ArrayList<String> deviceData = new ArrayList<String>();
		ArrayList<String> deviceUser = new ArrayList<String>();
		ArrayList<String> devicePc = new ArrayList<String>();
		ArrayList<String> deviceActivity = new ArrayList<String>();
				
		while((line = leitor.readLine()) != null){
			String[] device = line.split(csvSplitBy);
			deviceId.add(device[ID_DEVICE]);
			deviceData.add(device[DATE_DEVICE]);
			deviceUser.add(device[USER_DEVICE]);
			devicePc.add(device[PC_DEVICE]);
			deviceActivity.add(device[ACTIVITY_DEVICE]);
		}
		
		for (int i = 0; i < deviceData.size(); i++) {
			System.out.println(deviceData.get(i));
		}
	}
	
	public static void respostaArquivoHTTP(BufferedReader leitor) throws IOException{
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String> httpId = new ArrayList<String>();
		ArrayList<String> httpData = new ArrayList<String>();
		ArrayList<String> httpUser = new ArrayList<String>();
		ArrayList<String> httpPc = new ArrayList<String>();
		ArrayList<String> httpActivity = new ArrayList<String>();
		
		while((line = leitor.readLine()) != null){
			String[] http = line.split(csvSplitBy);
			httpId.add(http[ID_HTTP]);
			httpData.add(http[DATE_HTTP]);
			httpUser.add(http[USER_HTTP]);
			httpPc.add(http[PC_HTTP]);
			httpActivity.add(http[ACTIVITY_HTTP]);

		}
	}

	public static void respostaArquivoLDAP(BufferedReader leitor) throws IOException{
		String line = "";
		String csvSplitBy = ",";
		ArrayList<String> employeeName = new ArrayList<String>();
		ArrayList<String> userId = new ArrayList<String>();
		ArrayList<String> domain = new ArrayList<String>();
		ArrayList<String> email = new ArrayList<String>();
		ArrayList<String> role = new ArrayList<String>();
		
		while((line = leitor.readLine()) != null){
			String[] ldap = line.split(csvSplitBy);
			employeeName.add(ldap[EMPLOYEE_NAME]);
			userId.add(ldap[USER_ID]);
			domain.add(ldap[DOMAIN]);
			email.add(ldap[EMAIL]);
			role.add(ldap[ROLE]);
		}
	}
}
