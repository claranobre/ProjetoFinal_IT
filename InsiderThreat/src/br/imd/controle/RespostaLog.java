package br.imd.controle;

import java.awt.Label;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe RespostaLog é responsável por setar todas as saídas dos arquivos lidos
 *
 */
public class RespostaLog extends Usuario{

	private static final int ID_DEVICE = 0, DATE_DEVICE = 1, USER_DEVICE = 2, PC_DEVICE = 3, ACTIVITY_DEVICE = 4;
	private static final int ID_HTTP = 0, DATE_HTTP = 1, USER_HTTP = 2, PC_HTTP = 3, ACTIVITY_HTTP = 4;
	private static final int ID_LOGON = 0, DATE_LOGON = 1, USER_LOGON = 2, PC_LOGON = 3, ACTIVITY_LOGON = 4;
	private static final int EMPLOYEE_NAME = 0, USER_ID = 1, DOMAIN = 2, EMAIL = 3, ROLE = 4;
	private static int month, day, year;
	private static int hora, minuto, segundo;
	/**
	 * ArrayList de usuários existentes no arquivo 'ldap.csv'
	 */
	static ArrayList<Usuario> users = new ArrayList<Usuario>();

	/**
	 * caracteres especiais que precisamos ler das strings de cada coluna
	 * e armazenar seus valores sem esses caracteres
	 */
	String line = "";
	String divisor = ",";
	String divisor2 = "/";
	String divisor3 = ":";
	String divisor4 = "-";
	String divisor5 = " ";


	/**
	 * Método respostaArquivoLogon irá retornar as Strings existentes no arquivo
	 * 'logon-sumarizado.csv'
	 * @param leitor
	 * @throws IOException
	 */
	public static void respostaArquivoLogon(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		String user, pc, id;

		while((line = leitor.readLine()) != null){
			String[] logon = line.split(divisor);
			id = logon[ID_LOGON];
			divisorDate(logon[DATE_LOGON]);
			user = divisorUser(logon[USER_LOGON]);
			pc = divisorPc(logon[PC_LOGON]);
			for(int i = 0; i < users.size(); i++){
				if(user.equals(users.get(i).getUser_ID())){
					users.get(i).newActivityLogon(id, pc, logon[ACTIVITY_LOGON], month, day, year, hora, minuto, segundo);
				}
			}
		}
	}
	/**
	 * Método respostaArquivoDevice irá armazenar em uma ArrayList os valores
	 * lidos no arquivo 'device.csv'
	 * @param leitor
	 * @throws IOException
	 */
	public static void respostaArquivoDevice(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		String user, pc, id;

		while((line = leitor.readLine()) != null){
			String[] device = line.split(divisor);
			id = device[ID_DEVICE];
			divisorDate(device[DATE_DEVICE]);
			user = divisorUser(device[USER_DEVICE]);
			pc = divisorPc(device[PC_DEVICE]);
			for(int i = 0; i < users.size(); i++){
				if(user.equals(users.get(i).getUser_ID())){
					users.get(i).newActivityDevice(id, pc, device[ACTIVITY_DEVICE], month, day, year, hora, minuto, segundo);
				}
			}	
		}
	}
	/**
	 * Método irá retornar os sites acessados pelo usuário
	 * @param leitor
	 * @throws IOException
	 */
	public static void respostaArquivoHTTP(BufferedReader leitor) throws IOException{
		String line = "";
		String divisor = ",";
		String user, pc, id;

		while((line = leitor.readLine()) != null){
			String[] http = line.split(divisor);
			id = http[ID_HTTP];
			divisorDate(http[DATE_HTTP]);
			user = divisorUser(http[USER_HTTP]);
			pc = divisorPc(http[PC_HTTP]);
			for(int i = 0; i < users.size(); i++){
				if(user.equals(users.get(i).getUser_ID())){
					users.get(i).newActivityHttp(id, pc, http[ACTIVITY_HTTP], month, day, year, hora, minuto, segundo);
				}
			}
		}		
	}
	/**
	 * Método respostaArquivoLDAP irá retornar os dados dos usuários existentes
	 * @param leitor
	 * @throws IOException
	 */
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
	/**
	 * Método divisorDate irá armazenar as datas excluindo os caracteres especiais
	 * @param date
	 */
	public static void divisorDate(String date){
		String divisor2 = "/";
		String divisor3 = ":";
		String divisor5 = " ";
		String days, horas;

		Scanner s = new Scanner(date).useDelimiter(divisor5);
		days = s.next();
		horas = s.next();
		s.close();
		s = new Scanner(days).useDelimiter(divisor2);
		month = Integer.parseInt(s.next());
		day = Integer.parseInt(s.next());
		year = Integer.parseInt(s.next());
		s.close();
		s = new Scanner(horas).useDelimiter(divisor3);
		hora = Integer.parseInt(s.next());
		minuto = Integer.parseInt(s.next());
		segundo = Integer.parseInt(s.next());
		s.close();
	}
	/**
	 * Método divisorUser irá retornar o usuário excluindo a String 'DTAA'
	 * @param user
	 * @return
	 */
	public static String divisorUser(String user){
		String divisor2 = "/";
		Scanner s = new Scanner(user).useDelimiter(divisor2);
		user = s.next();
		user = s.next();
		s.close();
		return user;
	}		
	/**
	 * Método divisorPC irá retornar a id do pc utilizado ignorando a palavra "PC-" antes da id
	 * @param pc
	 * @return
	 */
	public static String divisorPc(String pc){
		String divisor4 = "-";
		Scanner s = new Scanner(pc).useDelimiter(divisor4);
		pc = s.next();
		pc = s.next();
		s.close();
		return pc;
	}
	/**
	 * Método de busca do usuário para verificar se um usuário encontra-se na lista e para listar as atividades executadas por ele
	 * @param respName
	 */
	public static void buscaUsuario(Label respName){
		for(int i = 0; i < users.size(); i++){
			if(users.get(i).getUser_ID().equals(respName)){
				System.out.println("UserID : " + respName + " Nome: " + users.get(i).getName() + " Email: " + users.get(i).getEmail() + " Funcao: " + users.get(i).getRole());
			}
		}
	}
	/**
	 * Método usuariosSuspeitos para análise do perfil dos usuários e salvar as atividades anômalas em um arquivo
	 * @param year
	 * @param month
	 * @param day
	 */
	public static void usuariosSuspeitos(int year, int month, int day){
		ArrayList<Usuario> suspeitos = new ArrayList<Usuario>();
		double media_acessos = calculateMedia(year, month, day);
		ArrayList<Usuario> usuarios_com_acesso = usuariosComAcesso(year, month, day);
		double desvio_padrao = desvioPadraoDia(usuarios_com_acesso, media_acessos, year, month, day);

		for(int i = 0; i < usuarios_com_acesso.size(); i++){
			double desvio_usuario = 0;
			double acesso_usuario = (double) usuarios_com_acesso.get(i).getContadorDia(year, month, day);
			double variancia = acesso_usuario - media_acessos;
			desvio_usuario = Math.sqrt(Math.pow(variancia, 2));

			if(desvio_usuario > desvio_padrao){
				suspeitos.add(usuarios_com_acesso.get(i));
			}
		}

		try{

			File arquivo = new File("Dados/usuariosSuspeitos.txt");
			if(!arquivo.exists()){
				arquivo.createNewFile();
			}

			FileWriter fw = new FileWriter(arquivo);
			BufferedWriter bw = new BufferedWriter(fw);

			for(int i = 0; i < suspeitos.size(); i++){
				Usuario suspeito = suspeitos.get(i);


				bw.write("Nome: " + suspeito.getName() + " UserID: " + suspeito.getUser_ID() + " Email: " + suspeito.getEmail() + " Role: " + suspeito.getRole());
				bw.write("Atividades Suspeitas - Listadas Abaixo");
				bw.newLine();

				bw.write(suspeito.imprimirDia(2010, 01, 04));
				bw.write(suspeito.imprimirAtividadesDia(2010, 01, 04));

				bw.newLine();
			}

			bw.close();
			fw.close();

			FileReader fr = new FileReader(arquivo);
			BufferedReader br = new BufferedReader(fr);

			while(br.ready()){
				String linha = br.readLine();
			}
			br.close();
			fr.close();

		}catch(IOException ex){
			ex.printStackTrace();
		}
	}
	/**
	 * Método usuariosComAcesso
	 * @param year
	 * @param month
	 * @param day
	 * @return usuarios
	 */
	private static ArrayList<Usuario> usuariosComAcesso(int year, int month, int day){
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getContadorDia(year, month, day) > 0){
				usuarios.add(users.get(i));
			}
		}
		return usuarios;
	}
	/**
	 * Método calculateMedia
	 * @param year
	 * @param month
	 * @param day
	 * @return media
	 */
	private static double calculateMedia(int year, int month, int day){
		int totalActivities = 0;
		int usuariosOn = 0;
		for (int i = 0; i < users.size(); i++) {
			if(users.get(i).getContadorDia(year, month, day) > 0){
				totalActivities += users.get(i).getContadorDia(year, month, day);
				usuariosOn++;
			}
		}

		double media = totalActivities/(double) usuariosOn;
		return media;
	}
	/**
	 * Método desvioPadraoDia
	 * @param usuarios
	 * @param media_acesso
	 * @param year
	 * @param month
	 * @param day
	 * @return Math.sqrt(dp);
	 */
	private static double desvioPadraoDia (ArrayList<Usuario> usuarios, double media_acesso, int year, int month, int day){
		double dp = 0;
		for(int i = 0; i < usuarios.size(); i++){
			double acesso_usuario = (double) usuarios.get(i).getContadorDia(year, month, day);
			double variancia = acesso_usuario - media_acesso;
			dp += Math.pow(variancia, 2);
		}
		dp /= usuarios.size();
		return Math.sqrt(dp);
	}
	/**
	 * Método usuariosSuspeitos
	 * @param respData
	 */
	public void usuariosSuspeitos(Label respData) {
		// TODO Auto-generated method stub
		
	}
}