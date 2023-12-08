package VIEW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import Controler.OuvinteCadastrarCliente;
import Controler.OuvinteVoltarTelaADM;
import Controler.OuvinteVoltarTelaLogin;

public class TelaNovoCliente {
	
	JPanel painel_1 = null; 
	JPanel painel_2 = null; 
	JPanel painel_3= null; 
	JPanel painel_4= null; 
	JPanel painel_5= null; 
	JPanel painel_6= null; 
	JTextField inpNome = null;
	JTextField inpTelefone = null;
	JTextField inpCPF = null;
	JTextField inpCidade = null;
	JRadioButton inpMasculino = null;
	JRadioButton inpFeminino = null;
	JRadioButton inpOutro = null;
	
	
	
	JButton bnt = new JButton("Cadastrar");
	JButton bntVoltar = new JButton("Voltar");
	
	public TelaNovoCliente() {
		JFrame j = new JFrame();
		
		j.setContentPane(new ImagemPanel("src/VIEW/super-mercado.jpg"));
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(540,400);
		j.setLayout(null);
		j.setResizable(false);
		j.setTitle("~Novo Cliente~");
		j.setLocationRelativeTo(null);
		adicionarComponetes_1(j);
		adicionarComponetes_2(j);
		
		OuvinteCadastrarCliente n = new OuvinteCadastrarCliente(j);
		bnt.addActionListener(n);
		
		OuvinteVoltarTelaADM n2 = new OuvinteVoltarTelaADM(j);
		bntVoltar.addActionListener(n2);
		
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
		adicionarTitulo(j,"Cadastre um Novo Cliente");
		
		
		painel_2 = painel(j,new Color(100,120,120,100));
		painel_2.setBounds(0, painel_1.getHeight()*2, j.getWidth(), 40);
		JLabel nome = new JLabel("Nome: ");
		corTextoPadrao(nome, 15,"Arial");
		painel_2.add(nome);
		inpNome = new JTextField(20);
		inpNome.setFont(new Font("Arial",Font.BOLD,14));
		painel_2.add(inpNome);
		
		
		painel_3 = painel(j,new Color(100,120,120,100));
		painel_3.setBounds(0, painel_1.getHeight()*3, j.getWidth(), 40);
		JLabel telefone = new JLabel("Telefone: ");
		corTextoPadrao(telefone, 15,"Arial");
		painel_3.add(telefone);
		inpTelefone = new JTextField(20);
		inpTelefone.setFont(new Font("Arial",Font.BOLD,14));
		painel_3.add(inpTelefone);
		
		painel_4 = painel(j,new Color(100,120,120,100));
		painel_4.setBounds(0, painel_1.getHeight()*4, j.getWidth(), 40);
		JLabel cpf = new JLabel("CPF: ");
		corTextoPadrao(cpf, 15,"Arial");
		painel_4.add(cpf);
		inpCPF = new JTextField(20);
		inpCPF.setFont(new Font("Arial",Font.BOLD,14));
		painel_4.add(inpCPF);
		
		
		painel_5 = painel(j,new Color(100,120,120,100));
		painel_5.setBounds(0, painel_1.getHeight()*5, j.getWidth(), 40);
		JLabel cidade = new JLabel("Cidade: ");
		corTextoPadrao(cidade, 15,"Arial");
		painel_5.add(cidade);
		inpCidade = new JTextField(20);
		inpCidade.setFont(new Font("Arial",Font.BOLD,14));
		painel_5.add(inpCidade);
		
		painel_6 = painel(j,new Color(100,120,120,100));
		painel_6.setBounds(0, painel_1.getHeight()*6, j.getWidth(), 40);
		JLabel genero = new JLabel("Gênero: ");
		corTextoPadrao(genero, 15,"Arial");
		painel_6.add(genero);
		inpMasculino = new JRadioButton("Masculino");
		inpFeminino = new JRadioButton("Feminino");
		inpOutro = new JRadioButton("Outro");
		
		inpMasculino.setFont(new Font("Arial",Font.BOLD,14));
		inpFeminino.setFont(new Font("Arial",Font.BOLD,14));
		inpOutro.setFont(new Font("Arial",Font.BOLD,14));
		
		ButtonGroup generos = new ButtonGroup();
		generos.add(inpMasculino);
		generos.add(inpFeminino);
		generos.add(inpOutro);
		
		painel_6.add(inpMasculino);
		painel_6.add(inpFeminino);
		painel_6.add(inpOutro);
	}
	
	void adicionarComponetes_2(JFrame j) {
				
		JPanel painel_5 = painel(j,new Color(100,120,120,0));
		painel_5.setBounds(0,painel_1.getHeight()*8, j.getWidth(), painel_1.getHeight());
		painel_5.add(bntVoltar);
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
