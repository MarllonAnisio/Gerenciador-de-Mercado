package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import VIEW.TelaADM;
import VIEW.TelaLogin;
import VIEW.TelaNovaContaADM;

public class OuvinteCliente implements ActionListener,MouseListener, Ouvinte{
	private JFrame frame;
	private Ouvinte ouvinteBnt;
	
	/**
	 * 
	 * @param telaPraAbrir: Use esse parametro para abrir a próxima tela
	 * @param frame: use esse parametro para fechar a tela atual
	 */
	public OuvinteCliente(Ouvinte telaPraAbrir, JFrame frame) {
		this.frame = frame;
		ouvinteBnt = telaPraAbrir;
	}

	public void actionPerformed(ActionEvent e) {
		frame.dispose();
		
		if(ouvinteBnt instanceof TelaADM) {
			Ouvinte t = new TelaADM();
			t.desenharTela();
		}
		else if(ouvinteBnt instanceof TelaLogin) {
			TelaLogin t = new TelaLogin();
			t.desenharTela();
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		frame.dispose();
		
		if(ouvinteBnt instanceof TelaNovaContaADM) {
			Ouvinte t = new TelaNovaContaADM();
			t.desenharTela();
		}
	}

	public void mousePressed(MouseEvent e) {}

	public void mouseReleased(MouseEvent e) {}

	public void mouseEntered(MouseEvent e) {}

	public void mouseExited(MouseEvent e) {}
	
	
	
	public Ouvinte getOuvinteBnt() {
		return ouvinteBnt;
	}
	
	public void desenharTela() {
		
	}
}
