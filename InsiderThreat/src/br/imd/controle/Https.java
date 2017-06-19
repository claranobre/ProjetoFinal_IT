package br.imd.controle;
/**
 * Classe Https 
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Https extends Atividade {
	private String url;
	/**
	 * Método Https
	 * @param urlAcessed
	 */
	public Https(String urlAcessed){
		this.url = urlAcessed;
	}
	/**
	 * Método getUrl
	 * @return url
	 */
	public String getUrl(){
		return url;
	}
}