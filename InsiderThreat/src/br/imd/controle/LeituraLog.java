package br.imd.controle;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Ana Clara e Felipe Gilberto
 * Classe Leitura Log para ler os arquivos de log analisados
 */

public class LeituraLog extends RespostaLog{
	
	/**
	 * Método leituraArquivoLogon para ler o arquivo Logon-sumarizado.csv
	 * @param csvLogon
	 */
	public static void leituraArquivoLogon(String csvLogon){
		BufferedReader leitor = null;
		try{
			leitor = new BufferedReader(new FileReader(csvLogon));
			respostaArquivoLogon(leitor);
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
	
	/**
	 * Método leituraArquivoDevice para ler o arquivo Device.csv
	 * @param csvDevice
	 */

	public static void leituraArquivoDevice(String csvDevice){
		BufferedReader leitor = null;
		try{
			leitor = new BufferedReader(new FileReader(csvDevice));
			respostaArquivoDevice(leitor);
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
	
	/**
	 * Método leituraArquivoHTTP para ler o arquivo http-sumarizado.csv
	 * @param csvHTTP
	 */

	public static void leituraArquivoHTTP(String csvHTTP){
		BufferedReader leitor = null;
		try{
			leitor = new BufferedReader(new FileReader(csvHTTP));
			respostaArquivoHTTP(leitor);
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

	/**
	 * Método leituraArquivoLDAP para ler o arquivo ldap.csv
	 * @param csvLDAP
	 */
	
	public static void leituraArquivoLDAP(String csvLDAP){
		BufferedReader leitor = null;
		try{
			leitor = new BufferedReader(new FileReader(csvLDAP));
			respostaArquivoLDAP(leitor);
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
}