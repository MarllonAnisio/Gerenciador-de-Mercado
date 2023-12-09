package Controler;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import VIEW.TelaADM;
import VIEW.TelaLogin;
import VIEW.TelaNovaContaADM;
import VIEW.TelaNovoCliente;

public class OuvinteADM implements ActionListener,MouseListener,WindowListener, Ouvinte{
	private JFrame frame;
	private Ouvinte ouvinteBnt;
	
	/**
	 * 
	 * @param telaPraAbrir: Use esse parametro para abrir a próxima tela
	 * @param frame: use esse parametro para fechar a tela atual
	 */
	public OuvinteADM(Ouvinte telaPraAbrir, JFrame frame) {
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
			Ouvinte t = new TelaLogin();
			t.desenharTela();
		}
		else if(ouvinteBnt instanceof TelaNovoCliente) {
			Ouvinte t = new TelaNovoCliente();
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
	
	 @Override
     public void windowClosing(WindowEvent e) {
		 
         int escolha = JOptionPane.showConfirmDialog(frame, "Voltar para a tela de Login?",
                 "Fechar Janela", JOptionPane.YES_NO_OPTION);
         
         if (escolha == JOptionPane.YES_OPTION) {
             frame.dispose();
             new TelaLogin();
         }
         
     }

	public void windowOpened(WindowEvent e) {}

	public void windowClosed(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowActivated(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}
	
	
	
	public Ouvinte getOuvinteBnt() {
		return ouvinteBnt;
	}
	
	public void desenharTela() {
		
	}
}
