package br.imd.visao;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Interface{

	private JButton buscar;
	private JButton atividadesAnomalas;

	private JFrame janela;

	private JPanel painel;

	private TextField name;
	private TextField id;

	private Label respName;
	private Label respId;

	private Panel p1;
	private Panel p2;
	private Panel p3;

	public static void main(String[] args){
		new Interface().montaTela();
	}
	/**
	 * Método Construtor
	 */
	public Interface(){
		this.p1 = new Panel();
		this.p2 = new Panel();
		this.p3 = new Panel();

		this.name = new TextField(15);
		this.id = new TextField(15);
	}
	/**
	 * Método montaTela para chamar os métodos que compõe nossa interface
	 */
	public void montaTela(){
		preparaJanela();
		preparaPainelPrincipal();
		janela();
		mostraJanela();
	}
	/**
	 * Método preparaJanela para setar o design e configurações da nossa interface
	 */
	public void preparaJanela(){
		janela = new JFrame("Insider Threat");
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setLayout(new GridLayout(3,2));
	}
	/**
	 * Método preparaPainelPrincipal para criar o painel
	 */
	private void preparaPainelPrincipal() {
		painel = new JPanel();
		/**
		 * Adicionando o painel a tela
		 */
		janela.add(painel);
	}
	/**
	 * Método janela que irá adicionar os botões, labels e textfields utilizados
	 */
	public void janela(){
		/**
		 * Criando os componentes
		 */
		respName = new Label("Nome:");
		respId = new Label("ID: ");

		buscar = new JButton("Buscar");	
		painel.add(buscar);
		atividadesAnomalas = new JButton("Atividades Suspeitas");
		painel.add(atividadesAnomalas);

		/**
		 * Define o layout dos Painels
		 */
		p1.setLayout(new GridLayout(3,2));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));
		p3.setLayout(new FlowLayout(FlowLayout.LEFT));

		/**
		 * Adiciona os componentes aos panels
		 */
		p1.add(respName);
		p1.add(name);
		p1.add(respId);
		p1.add(id);

		p2.add(buscar);

		p3.add(atividadesAnomalas);

		painel.add(p1);
		painel.add(p2);
		painel.add(p3);

		/**
		 * Registra o evento
		 */
		ButtonHandler handler = new ButtonHandler();
		buscar.addActionListener(handler);
		atividadesAnomalas.addActionListener(handler);

		TextFieldHandler text = new TextFieldHandler();
		name.addActionListener(text);
		id.addActionListener(text);

	}

	public void mostraJanela(){
		janela.pack();
		janela.setSize(540,540);
		janela.setVisible(true);
	}

	/*public void actionPerformed(ActionEvent evento) {
		buscar.setText("Botão foi clicado!");
		atividadesAnomalas.setText("Você vai querer buscar por data ou nome do usuário?");

		//Altera a fonte do aviso
		buscar.setFont(new Font("SansSerif", Font.BOLD, 20));
		atividadesAnomalas.setFont(new Font("SansSerif", Font.BOLD, 20));
	}*/

	//Classe interna para tratamento do botão
	public class ButtonHandler implements ActionListener{
		//Trata evento do botão
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(atividadesAnomalas, Interface.this, String.format("Você pressionou: %s", event.getActionCommand()), 0);
		}
	}

	private class TextFieldHandler implements ActionListener{
		public void actionPerformed(ActionEvent event){
			String string = "";

			if(event.getSource() == name){
				string = String.format("Nome: %s", event.getActionCommand());
			}
			else if(event.getSource() == id){
				string = String.format("Id: %s", event.getActionCommand());
			}
			JOptionPane.showMessageDialog(null, string);
		}
	}
}