package br.imd.visao;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.imd.controle.Usuario;

public class InterfaceUI{

	private JButton listaUsuarios;
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
	public Object suspeitos;
	public ArrayList<Usuario> users;

	/**
	 * Método Construtor
	 */
	public InterfaceUI(){
		this.p1 = new Panel();
		this.p2 = new Panel();

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
		listaUsuarios = new JButton("Usuários do Sistema");
		painel.add(listaUsuarios);
		atividadesAnomalas = new JButton("Atividades Suspeitas");
		painel.add(atividadesAnomalas);

		/**
		 * Define o layout dos Painels
		 */
		p1.setLayout(new GridLayout(3,2));
		p2.setLayout(new FlowLayout(FlowLayout.LEFT));

		/**
		 * Adiciona os componentes aos panels
		 */
		p1.add(respName);
		p1.add(name);
		p1.add(respId);
		p1.add(id);

		p2.add(listaUsuarios);
		p2.add(buscar);
		p2.add(atividadesAnomalas);

		painel.add(p1);
		painel.add(p2);

		/**
		 * Registra o evento
		 */
		ButtonHandler handler = new ButtonHandler();
		buscar.addActionListener(handler);
		listaUsuarios.addActionListener(handler);
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

	/**
	 * Classe interna para tratamento dos botões
	 * @author clara
	 *
	 */
	public class ButtonHandler implements ActionListener{
		/**
		 * Tratador de eventos
		 */
		public void actionPerformed(ActionEvent event){
			if(event.getSource() == listaUsuarios){
				InputStream arquivo = null;
				try {
					arquivo = new FileInputStream("Dados/ldap.csv");
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				InputStreamReader inputStream = new InputStreamReader(arquivo);
				BufferedReader leitor = new BufferedReader(inputStream);

				String s = null;
				try {
					s = leitor.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}

				while (s != null) {
					System.out.println(s);
					try {
						s = leitor.readLine();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				try {
					leitor.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			else if(event.getSource() == buscar){
				buscar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
						for(int i = 0; i < users.size(); i++){
							Object user = null;
							if(users.get(i).getUser_ID().equals(user)){
								System.out.println("UserID : " + user + " Nome: " + users.get(i).getName() + " Email: " + users.get(i).getEmail() + " Funcao: " + users.get(i).getRole());
							}
						}
					}
				});
			}
			else if(event.getSource() == atividadesAnomalas){
				ArrayList<Usuario> suspeitos = usuariosSuspeitos(2010, 01, 04);
				File arquivoAtividades = new File("Dados/listaAtividades.txt");
				BufferedWriter escrever = null;
				try {
					escrever = new BufferedWriter(new FileWriter(arquivoAtividades));
				} catch (IOException e) {
					e.printStackTrace();
				}

				for(int i = 0; i < suspeitos.size(); i++){
					try {
						escrever.write("Nome: " + suspeitos.get(i).getName() + " UserID: " + suspeitos.get(i).getUser_ID() + " Email: " + suspeitos.get(i).getEmail() + " Role: " + suspeitos.get(i).getRole());
						escrever.write("Atividades Suspeitas - Listadas Abaixo");
						escrever.newLine();
						//escrever.write(suspeitos.get(i).imprimirDia(2010, 01, 04));
						//escrever.write(suspeitos.get(i).imprimirAtividadesDia(2010, 01, 04));
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						escrever.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						escrever.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

	private ArrayList<Usuario> usuariosSuspeitos(int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
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