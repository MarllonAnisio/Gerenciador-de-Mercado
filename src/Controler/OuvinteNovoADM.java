package Controler;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import VIEW.TelaNovaContaADM;

public class OuvinteNovoADM implements MouseListener{
	private JFrame tela;
	
	public OuvinteNovoADM(JFrame tela) {
		this.tela = tela;
	}
	
	public void mouseClicked(MouseEvent e) {
		tela.dispose();
		new TelaNovaContaADM();
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
	
}
