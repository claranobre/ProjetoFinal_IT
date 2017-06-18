package br.imd.controle;

public class Https extends Atividade {
	private String url;
	
	public Https(String urlAcessed){
		this.url = urlAcessed;
	}
	
	public String getUrl(){
		return url;
	}
}
