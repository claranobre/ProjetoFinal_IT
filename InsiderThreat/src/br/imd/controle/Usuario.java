package br.imd.controle;

public class Usuario {
	private int id;
	private String nome;
	private String email;
	private String funcao;
	
	public Usuario(int id, String nome, String email, String funcao){
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.funcao = funcao;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
}