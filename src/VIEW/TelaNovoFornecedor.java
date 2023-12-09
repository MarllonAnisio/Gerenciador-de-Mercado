package VIEW;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Controler.Ouvinte;

public class TelaNovoFornecedor extends JFrame implements Ouvinte{
	
	JPanel painel_1 = null; 
	JPanel painel_2 = null; 
	JPanel painel_3= null; 
	JPanel painel_4= null; 
	JPanel painel_5= null; 
	JPanel painel_6= null; 
	JPanel painel_7= null; 
	JTextField inpNome = null;
	JTextField inpTelefone = null;
	JTextField inpCNPJ = null;
	JTextField inpCidade = null;
	JComboBox<String> inpHorarioFuncionamento = null;
	JTextArea inpDescricao = null;
	
	
	JButton bntCadastrar = null;
	
	
	
	JButton bnt = null;
	
	public TelaNovoFornecedor() {
	}
	public void desenharTela() {
		
		setContentPane(new ImagemPanel("src/VIEW/super-mercado.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(540,400);
		setLayout(null);
		setResizable(false);
		setTitle("~Novo Fornecedor~");
		setLocationRelativeTo(null);
		adicionarComponetes_1(this);
		adicionarComponetes_2(this);
		
		setVisible(true);

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
		adicionarTitulo(j,"Cadastre um Novo Fornecedor");
		
		
		painel_2 = painel(j,new Color(100,120,120,100));
		painel_2.setBounds(0, painel_1.getHeight()*1, j.getWidth(), 40);
		JLabel nome = new JLabel("Nome: ");
		corTextoPadrao(nome, 15,"Arial");
		painel_2.add(nome);
		inpNome = new JTextField(20);
		inpNome.setFont(new Font("Arial",Font.BOLD,14));
		painel_2.add(inpNome);
		
		
		painel_3 = painel(j,new Color(100,120,120,100));
		painel_3.setBounds(0, painel_1.getHeight()*2, j.getWidth(), 40);
		JLabel telefone = new JLabel("Telefone: ");
		corTextoPadrao(telefone, 15,"Arial");
		painel_3.add(telefone);
		inpTelefone = new JTextField(20);
		inpTelefone.setFont(new Font("Arial",Font.BOLD,14));
		painel_3.add(inpTelefone);
		
		painel_4 = painel(j,new Color(100,120,120,100));
		painel_4.setBounds(0, painel_1.getHeight()*3, j.getWidth(), 40);
		JLabel cnpj = new JLabel("CNPJ: ");
		corTextoPadrao(cnpj, 15,"Arial");
		painel_4.add(cnpj);
		inpCNPJ = new JTextField(20);
		inpCNPJ.setFont(new Font("Arial",Font.BOLD,14));
		painel_4.add(inpCNPJ);
		
		
		painel_5 = painel(j,new Color(100,120,120,100));
		painel_5.setBounds(0, painel_1.getHeight()*4, j.getWidth(), 40);
		JLabel cidade = new JLabel("Cidade: ");
		corTextoPadrao(cidade, 15,"Arial");
		painel_5.add(cidade);
		inpCidade = new JPasswordField(20);
		inpCidade.setFont(new Font("Arial",Font.BOLD,14));
		painel_5.add(inpCidade);
		
		painel_6 = painel(j,new Color(100,120,120,100));
		painel_6.setBounds(0, painel_1.getHeight()*5, j.getWidth(), 40);
		JLabel HFuncionamento = new JLabel("Horário de funciomamento: ");
		corTextoPadrao(HFuncionamento, 15,"Arial");
		painel_6.add(HFuncionamento);
		
		String[] horarios = {"07:30 - 11:00","07:30 - 12:00", "08:00 - 12:00","13:00 - 15:00","13:00 - 17:00"};
		inpHorarioFuncionamento = new JComboBox<String>(horarios);
		inpHorarioFuncionamento.setFont(new Font("Arial",Font.BOLD,14));
		painel_6.add(inpHorarioFuncionamento);
		
		
		painel_7 = painel(j,new Color(100,120,120,100));
		painel_7.setBounds(0, painel_1.getHeight()*6, j.getWidth(), 80);
		JLabel descricao = new JLabel("Descrição: ");
		corTextoPadrao(descricao, 15,"Arial");
		painel_7.add(descricao);
		inpDescricao = new JTextArea(4,20);
		inpDescricao.setWrapStyleWord(true); // Permite que as palavras sejam quebradas para ajustar na largura
		inpDescricao.setLineWrap(true); // Faz com que o texto pule para a próxima linha quando atingir o final na horizontal
		JScrollPane scrollPane = new JScrollPane(inpDescricao);
		inpDescricao.setFont(new Font("Arial",Font.BOLD,14));
		painel_7.add(scrollPane);
		
		
	}
	
	void adicionarComponetes_2(JFrame j) {
				
		JPanel painel = painel(j,new Color(100,120,120,100));
		painel.setBounds(0,painel_1.getHeight()*8, j.getWidth(), painel_1.getHeight());
		
		bntCadastrar = new JButton("Cadastrar");
		painel.add(bntCadastrar);
		
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
