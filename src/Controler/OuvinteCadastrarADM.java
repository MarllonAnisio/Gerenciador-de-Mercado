package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import VIEW.TelaLogin;
import VIEW.TelaNovaContaADM;

public class OuvinteCadastrarADM implements ActionListener{

	private JFrame tela;
	
	public OuvinteCadastrarADM(JFrame tela) {
		this.tela = tela;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Lógica para cadastrar o ADM");
	}
	
	
	
}
