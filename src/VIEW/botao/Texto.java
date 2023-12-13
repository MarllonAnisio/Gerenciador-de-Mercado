package VIEW.botao;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

public class Texto extends JTextField{
	public Texto(int x, int y, int l, int a) {
		this.setBounds(x, y, l, a);
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
}
