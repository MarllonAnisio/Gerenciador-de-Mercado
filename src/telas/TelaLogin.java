package telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaLogin {
	
	JPanel painel_1 = null; 
	JPanel painel_2 = null; 
	JPanel painel_3= null; 
	JPanel painel_4= null; 
	JPanel painel_5= null; 
	JTextField inpEmail = null;
	JPasswordField inpSenha = null;
	JButton bnt = null;
	
	public TelaLogin() {
		JFrame j = new JFrame();
		
		j.setContentPane(new ImagemPanel("src/imgs/g.png"));
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(540,400);
		j.setLayout(null);
		j.setResizable(false);
		j.setTitle("~Login~");
		j.setLocationRelativeTo(null);
		adicionarComponetes_1(j);
		adicionarComponetes_2(j);
		
		j.setVisible(true);
	}
	
	JLabel titulo(JFrame j, String t) { 
		JLabel label = new JLabel(t);
		return label;
	}
	
	void adicionarTitulo(JFrame j, String title) {
		painel_1.setSize(j.getWidth(),40);
		JLabel t1 = titulo(j, title);
		corTextoPadrao(t1, 25, "Serif");
		painel_1.add(t1);
		
	}
	
	
	void adicionarComponetes_1(JFrame j) {

		painel_1 = painel(j,new Color(10,10,10,150));
		adicionarTitulo(j,"Bem-Vindo ao Gerenciado de Mercado");
		
		
		painel_2 = painel(j,new Color(100,120,120,100));
		painel_2.setBounds(0, painel_1.getHeight()*3, j.getWidth(), 40);
		JLabel email = new JLabel("Email: ");
		corTextoPadrao(email, 15,"Arial");
		painel_2.add(email);
		inpEmail = new JTextField(20);
		inpEmail.setFont(new Font("Arial",Font.BOLD,14));
		painel_2.add(inpEmail);
		
		
		painel_3 = painel(j,new Color(100,120,120,100));
		painel_3.setBounds(0, painel_1.getHeight()*4, j.getWidth(), 40);
		JLabel senha = new JLabel("Senha: ");
		corTextoPadrao(senha, 15,"Arial");
		painel_3.add(senha);
		inpSenha = new JPasswordField(20);
		inpSenha.setFont(new Font("Arial",Font.BOLD,14));
		painel_3.add(inpSenha);
	}
	
	void adicionarComponetes_2(JFrame j) {

		painel_4 = painel(j,new Color(100,120,120,0));
		JLabel  ms= new JLabel("Nova conta");
		painel_4.setBounds(120, painel_1.getHeight()*5, j.getWidth(), painel_1.getHeight());
		corTextoPadrao(ms, 12,"Arial");
		painel_4.add(ms);
		
		ms.addMouseListener(new MouseAdapter() {
			
			public void mouseExited(MouseEvent e) {
				ms.setForeground(new Color(255,255,255));
				j.repaint();
			}
			
			public void mouseEntered(MouseEvent e) {
				ms.setForeground(new Color(10,10,10));
				j.repaint();
			}
		});
		
				
		JPanel painel_5 = painel(j,new Color(255,255,255,0));
		painel_5.setBounds(0,painel_1.getHeight()*7, j.getWidth(), painel_1.getHeight());
		bnt = new JButton("Acessar");
		painel_5.add(bnt);
		
	}
	
	void corFont(JLabel j, int sizeFont) {
		j.setFont(new Font("Arial",Font.BOLD,sizeFont));
		j.setForeground(new Color(200,200,200));
	}
	
	void corTextoPadrao(JLabel j,int sizeFont, String font) {
		j.setFont(new Font(font,Font.BOLD,sizeFont));
		j.setForeground(new Color(250,250,250));
	}
	
	JPanel painel(JFrame j, Color c) {
		JPanel p = new JPanel();
		p.setBounds(0,0,300,300);
		p.setBackground(c);
		j.add(p);
		return p;
	}
	JPanel getJPainel( Color c) {
		JPanel p = new JPanel();
		p.setBackground(c);
		return p;
	}

}
