package br.imd.controle;

public class Tree{

	private No root;
	private Tree leftTree;
	private Tree rightTree;
	private Tree maiorFilho;
	private int height;
	private int posX;
	private int posY;
	private int tam = 50; /* valor do tamanho base da árvore */
	private boolean control = false;

	public Tree() {
		// construtor vazio
	}

	public Tree getRightTree() {
		return rightTree;
	}

	public void setRightTree(Tree rightTree) {
		this.rightTree = rightTree;
	}

	public Tree getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(Tree leftTree) {
		this.leftTree = leftTree;
	}

	public No getRoot() {
		return root;
	}

	public void setRoot(No root) {
		this.root = root;
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

	public void insereUsuario(int id, String nome, String email, String funcao) {
		Usuario usuario = new Usuario(id, nome, email, funcao);
		No no = new No(usuario);
		inserir(no);
	}

	private void inserir(No no) {
		if (this.root == null) {
			this.root = no;
		} else {
			if (no.getUsuario().getId() > this.root.getUsuario().getId()) {
				if (this.rightTree == null) {
					this.rightTree = new Tree();
				}
				this.rightTree.inserir(no);
			} else if (no.getUsuario().getId() < this.root.getUsuario().getId()) {
				if (this.leftTree == null) {
					this.leftTree = new Tree();
				}
				this.leftTree.inserir(no);
			}
		}

	}

	public Tree buscar(int id, Tree busca) {
		if (id < busca.root.getUsuario().getId()) {
			if (busca.leftTree == null) {
				System.out.println("No nao Encontrado " + id);
				this.control = false;
				return null;
			} else {
				buscar(id, busca.leftTree);
			}
		} else if (id == busca.root.getUsuario().getId()) {
			System.out.println("No Encontrado, Usuario: " + busca.root.getUsuario().getNome());
			this.control = true;
			return busca;
		} else {
			if (busca.rightTree == null) {
				System.out.println("No nao Encontrado: " + id);
				this.control = false;
				return null;
			} else {
				buscar(id, busca.rightTree);
			}
		}
		return null;
	}
	
	public Tree maiorNo(Tree maior){
		if(maior.rightTree.root != null){
			maiorNo(maior.rightTree);
		}
		return maior;
	}
	
	public Tree remover(int id, Tree remove){
		remove = buscar(id, remove);
		if (this.control){
			if(remove.leftTree == null && remove.rightTree == null){
				remove.root = null;
				
			}else if(remove.leftTree != null && remove.rightTree == null){
				remove.root = leftTree.root;
				remove.setLeftTree(null);
			}
			else if(remove.leftTree == null && remove.rightTree != null){
				remove.root = rightTree.root;
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

	public void emordem(Tree node) {
		if (node != null) {
			if(node.root != null){
				emordem(node.leftTree);
				System.out.println(node.root.getUsuario().getId() + " " + node.root.getUsuario().getNome());
				emordem(node.rightTree);
			}
		}
	}

	public void prefixado(Tree node) {
		if (node != null) {
			if(node.root != null){
				System.out.println(node.root.getUsuario().getId() + " " + node.root.getUsuario().getNome());
				prefixado(node.leftTree);
				prefixado(node.rightTree);
			}
		}
	}

	public void posfixado(Tree node) {
		if (node != null) {
			if(node.root != null){
				posfixado(node.leftTree);
				posfixado(node.rightTree);
				System.out.println(node.root.getUsuario().getId() + " " + node.root.getUsuario().getNome());
			}
		}
	}

	/*public void paint(Graphics g) {
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
		g2d.drawString(String.valueOf(root.getUsuario().getid()),
				posX + ((tam / 2) - 4 * (String.valueOf(root.getUsuario().getid()).length())),
				posY + ((tam / 2) + 4));
		}
*/
}