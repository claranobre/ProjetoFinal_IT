package br.imd.visao;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

public class Interface extends JFrame{
	
	private JButton buscar;
	private JButton atividadesAnomalas;
	
	private static TextField name;
	private static TextField id;
	private static Label respName;
	private static Label respId;
	private static Panel p1 = new Panel();
	private static Panel p2 = new Panel();
	private static Panel p3 = new Panel();

	public Interface(){
		setLayout(new FlowLayout());
		/**
		 * Criando os componentes
		 */
		buscar = new JButton("Buscar");
		atividadesAnomalas = new JButton("Atividades Suspeitas");
		respName = new Label("Nome:");
		name = new TextField(15);
		respId = new Label("ID: ");
		id = new TextField(15);
		
		ButtonHandler handler = new ButtonHandler();
		buscar.addActionListener(handler);
		atividadesAnomalas.addActionListener(handler);
	}

	/**
	 * Define o layout do Container Básico
	 */
	setLayout(new GridLayout(3,2));
	/**
	 * Define o layout do Container Básico
	 */
	setLayout(new GridLayout(2,1));
	/**
	 * Define o layout dos Painels
	 */
	p1.setLayout(new GridLayout(2,2));
	p2.setLayout(new FlowLayout(FlowLayout.CENTER));
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

		caixa.add(p1);
		caixa.add(p2);
		caixa.add(p3);
		janela.setVisible(true);
	}
}