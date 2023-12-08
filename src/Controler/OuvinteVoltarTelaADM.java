package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import VIEW.TelaADM;

public class OuvinteVoltarTelaADM implements ActionListener{
	private JFrame tela;
	
	public OuvinteVoltarTelaADM(JFrame tela) {
		this.tela = tela;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		tela.dispose();
		new TelaADM();
		
	}
	
	
	
}
