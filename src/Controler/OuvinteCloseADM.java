package Controler;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import VIEW.TelaLogin;

public class OuvinteCloseADM implements WindowListener{
	
	private JFrame tela;
	
	public OuvinteCloseADM(JFrame tela) {
		this.tela = tela;
	}
	
	 @Override
     public void windowClosing(WindowEvent e) {
         int escolha = JOptionPane.showConfirmDialog(tela, "Voltar para a tela de Login?",
                 "Fechar Janela", JOptionPane.YES_NO_OPTION);
         
         if (escolha == JOptionPane.YES_OPTION) {
             tela.dispose(); // Fecha a janela
             new TelaLogin();
         }
     }

	public void windowOpened(WindowEvent e) {}

	public void windowClosed(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowActivated(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}
	
	
	
}
