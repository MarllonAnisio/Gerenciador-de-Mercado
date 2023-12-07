package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import VIEW.TelaADM;
import VIEW.TelaLogin;
import VIEW.TelaNovaContaADM;
import VIEW.TelaNovoCliente;

public class OuvinteCadastrarCliente implements ActionListener{

	private JFrame tela;
	
	public OuvinteCadastrarCliente(JFrame tela) {
		this.tela = tela;
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println("Lógica para cadastrar o Cliente.");
	}
	
}
