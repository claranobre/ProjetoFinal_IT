package br.imd.controle;
/**
 * Classe NoUsuario
 * @author Ana Clara e Felipe Gilberto
 *
 */
public class NoUsuario {
	private Usuario user;
	/**
	 * Método noUsuario
	 * @param usuario
	 */
    public NoUsuario(Usuario usuario) {
        this.user = usuario;
    }
    /**
     * Método getUser do tipo Usuario
     * @return user
     */
	public Usuario getUser() {
		return user;
	}
	/**
	 * Método setUser
	 * @param user
	 */
	public void setUser(Usuario user) {
		this.user = user;
	}
}