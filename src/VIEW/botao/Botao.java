package VIEW.botao;
import java.awt.Color;
import javax.swing.JButton;


public class Botao extends JButton {
	private OuvinteDoMouse om = new OuvinteDoMouse();

	public Botao(int x, int y, int l, int a, String s) {
		this.setBounds(x,y,l,a);
		this.setText(s);
		this.addMouseListener(om);
		}
		public Botao(int x, int y, int l, int a, String s, Color c) {
			this.setBounds(x,y,l,a);
			this.setText(s);
			this.setForeground(c);
			this.addMouseListener(om);

		}
		
		public Botao(int x, int y, int l, int a, Color c, String s, Color b) {
			this.setBounds(x,y,l,a);
			this.setText(s);
			this.setForeground(c);
			this.setBackground(b);
			this.addMouseListener(om);

		
	}

}
