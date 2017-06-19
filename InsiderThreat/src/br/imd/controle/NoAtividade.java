package br.imd.controle;
import java.util.ArrayList;
/**
 * Classe NoAtividade
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class NoAtividade {
	int id;
	ArrayList<Atividade> atividadesDia;
	/**
	 * Método noAtividade
	 * @param id
	 */
	public NoAtividade(int id){
		this.id = id;
	}
	/**
	 * Método getId
	 * @return id
	 */
	public int getId() {
		return id;
	}
	/**
	 * Método setId
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * Método getAtividadesDia do tipo ArrayList de Atividaade
	 * @return atividadesDia
	 */
	public ArrayList<Atividade> getAtividadesDia() {
		return atividadesDia;
	}
	/**
	 * Método setAtividadesDia
	 * @param atividadesDia
	 */
	public void setAtividadesDia(ArrayList<Atividade> atividadesDia) {
		this.atividadesDia = atividadesDia;
	}
}
