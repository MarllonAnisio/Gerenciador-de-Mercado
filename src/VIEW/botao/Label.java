package VIEW.botao;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class Label extends JLabel {
	public Label(int x, int y, int l, int a,String nome) {
		this.setBounds(x,y,l,a);
		this.setText(nome);
		this.setForeground(Color.black);
	}
	public Label() {

	}
	
	public Label(int x, int y, int l, int a,String nome,Color c) {
		this.setBounds(x,y,l,a);
		this.setText(nome);
		this.setForeground(c);
	}

}
