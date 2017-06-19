package br.imd.controle;
/**
 * Classe Tree
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class Tree{

	private NoUsuario root;
	private NoMes todasAtividades;
	private NoMes normais;
	private NoMes anomalas;
	private NoAtividade atividadeDia;
	/**
	 * Método Construtor
	 */
	public Tree() {
		// construtor vazio
	}
	/**
	 * Método noUsuario
	 * @return root
	 */
	public NoUsuario getNo() {
		return this.root;
	}
	/**
	 * Método setNo
	 * @param noUsuario
	 */
	public void setNo(NoUsuario noUsuario) {
		this.root = noUsuario;
	}
	/**
	 * Método getTodasAtividades do tipo NoMes
	 * @return todasAtividades
	 */
	public NoMes getTodasAtividades() {
		return this.todasAtividades;
	}
	/**
	 * Método setTodasAtividades
	 * @param todasAtividades
	 */
	public void setTodasAtividades(NoMes todasAtividades) {
		this.todasAtividades = todasAtividades;
	}
	/**
	 * Metodo para retornar as atividades consideradas normais dos usuários
	 * @return normais
	 */
	public NoMes getNormais() {
		return normais;
	}
	/**
	 * Método setNormais
	 * @param normais
	 */
	public void setNormais(NoMes normais) {
		this.normais = normais;
	}
	/**
	 * Método getAnomalas
	 * @return anomalas
	 */
	public NoMes getAnomalas(){
		return this.anomalas;
	}
	/**
	 * Método setAnomalas
	 * @param anomalas
	 */
	public void setAnomalas(NoMes anomalas){
		this.anomalas = anomalas;
	}
	/**
	 * Método inserirActivity
	 * @param activity
	 */
	private void inserirActivity(Atividade activity){
		if(this.todasAtividades == null){
			this.todasAtividades = new NoMes();
		}
		else{
			
		}
	}
}