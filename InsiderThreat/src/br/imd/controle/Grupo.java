package br.imd.controle;

import java.util.ArrayList;

public class Grupo {
	private ArrayList<String> funcaoUsuario;
	private int idGrupo;
	
	public Grupo(){}
	
	public void permissoes(ArrayList<String> regras){
		
	}

	public ArrayList<String> getFuncaoUsuario() {
		return funcaoUsuario;
	}

	public void setFuncaoUsuario(ArrayList<String> funcaoUsuario) {
		this.funcaoUsuario = funcaoUsuario;
	}

	public int getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(int idGrupo) {
		this.idGrupo = idGrupo;
	}
}
