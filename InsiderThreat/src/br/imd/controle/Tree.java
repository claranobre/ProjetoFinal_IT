package br.imd.controle;

public class Tree{

	private No usuario; /* raíz da árvore */
	private No acao;
	private Tree leftTree;
	private Tree rightTree;
	private Tree maiorFilho;
	/**
	 * atributos para criacao da interface gráfica da Arvore Binaria de Busca
	 */
	private int height;
	private int posX;
	private int posY;
	private int tam = 50; /* valor do tamanho base da arvore */
	private boolean control = false;

	public Tree() {
		// construtor vazio
	}
	/**
	 * Método para retornar as atividades consideradas anormais dos usuários
	 * @return rightTree
	 */
	public Tree getRightTree() {
		return rightTree;
	}

	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}
	/**
	 * Metodo para retornar as atividades consideradas normais dos usuários
	 * @return leftTree
	 */
	public Tree getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void insereAcao(){
		Atividade acao = new Atividade();
		No no = new No(acao);
		inserir(no);
	}

	private void inserir(No no) {
		if (this.acao == null) {
			this.acao = no;
		} else {
			//if (no.acao > this.usuario.acaoUsuario()) {
				if (this.rightTree == null) {
					this.rightTree = new Tree();
				}
				this.rightTree.inserir(no);
			//} else if (no.acao < this.usuario.acaoUsuario()) {
				if (this.leftTree == null) {
					this.leftTree = new Tree();
				}
				this.leftTree.inserir(no);
			}
		}
	//}

	public Tree buscar(int acao, Tree busca) {
		if (acao < busca.usuario.acaoUsuario()) {
			if (busca.leftTree == null) {
				System.out.println("No nao Encontrado " + acao);
				this.control = false;
				return null;
			} else {
				buscar(acao, busca.leftTree);
			}
		} else if (acao == busca.usuario.acaoUsuario()) {
			System.out.println("No Encontrado, Usuario: " + busca.usuario.acaoUsuario());
			this.control = true;
			return busca;
		} else {
			if (busca.rightTree == null) {
				System.out.println("No nao Encontrado: " + acao);
				this.control = false;
				return null;
			} else {
				//buscar(busca.rightTree);
			}
		}
		return null;
	}
	
	public Tree maiorNo(Tree maior){
		if(maior.rightTree.usuario != null){
			maiorNo(maior.rightTree);
		}
		return maior;
	}
	
	public Tree remover(int acao, Tree remove){
		remove = buscar(acao, remove);
		if (this.control){
			if(remove.leftTree == null && remove.rightTree == null){
				remove.usuario = null;
				
			}else if(remove.leftTree != null && remove.rightTree == null){
				remove.usuario = leftTree.usuario;
				remove.setLeftTree(null);
			}
			else if(remove.leftTree == null && remove.rightTree != null){
				remove.usuario = rightTree.usuario;
				remove.setRightTree(null);
				
			} else {
				maiorFilho = maiorNo(remove);
				remove = maiorFilho;
			}
		} else{
			System.out.println("Não encontrado nos registros");
		}
		return null;
	}

	/*public busca emordem(Tree node) {
		if (node != null) {
			if(node.usuario != null){
				emordem(node.leftTree);
				System.out.println(node.usuario.acaoUsuario() + " " + node.usuario.acaoUsuario());
				emordem(node.rightTree);
			}
		}
	}*/

	/*public busca prefixado(Tree node) {
		if (node != null) {
			if(node.usuario != null){
				System.out.println(node.usuario.acaoUsuario() + " " + node.usuario.acaoUsuario());
				prefixado(node.leftTree);
				prefixado(node.rightTree);
			}
		}
	}*/

	/*public busca posfixado(Tree node) {
		if (node != null) {
			if(node.usuario != null){
				posfixado(node.leftTree);
				posfixado(node.rightTree);
				System.out.println(node.usuario.acaoUsuario() + " " + node.usuario.acaoUsuario());
			}
		}
	}*/

	/*public voacao paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Font fonte = new Font("Arial", Font.BOLD, 16);

		if (this.leftTree != null) {
			g2d.drawLine(posX + (tam / 2), posY + (tam / 2), this.leftTree.posX + (tam / 2),
					this.leftTree.posY + (tam / 2));
		}
		if (this.rightTree != null) {
			g2d.drawLine(posX + (tam / 2), posY + (tam / 2), this.rightTree.posX + (tam / 2),
					this.rightTree.posY + (tam / 2));
		}

		g2d.setStroke(new BasicStroke(3));
		g2d.drawOval(posX, posY, tam, tam);

		g2d.setFont(fonte);
		g2d.drawString(String.valueOf(usuario.getUsuario().getacao()),
				posX + ((tam / 2) - 4 * (String.valueOf(usuario.getUsuario().getacao()).length())),
				posY + ((tam / 2) + 4));
		}
*/
}