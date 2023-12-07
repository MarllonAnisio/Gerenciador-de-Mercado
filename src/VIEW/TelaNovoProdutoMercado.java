package VIEW;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class TelaNovoProdutoMercado {
	
	JPanel painel_1 = null; 
	JPanel painel_2 = null; 
	JPanel painel_3= null; 
	JPanel painel_4= null; 
	JPanel painel_5= null; 
	JPanel painel_6= null; 
	JPanel painel_7= null; 
	JPanel painel_8= null;
	JPanel painel_9= null; 
<<<<<<< HEAD:src/telas/TelaNovoProdutoMercado.java
	JPanel painel_10= null;
	JPanel painel_11= null;
	JTextField inpProduto = null; //use esse atributo. Pege o conteúdo usando o getText()
	JTextField inpPreco = null;//use esse atributo. Pege o conteúdo usando o getText()
	JTextField inpPrecoUnidade = null;//use esse atributo. Pege o conteúdo usando o getText()
	JTextField inpMarca = null;//use esse atributo. Pege o conteúdo usando o getText()
	JTextField inpEstoque  = null;//use esse atributo. Pege o conteúdo usando o getText()
=======
	
	JTextField inpProduto = null;
	JTextField inpPreco = null;
	JTextField inpPrecoUnidade = null;
	JTextField inpMarca = null;
	JTextField inpEstoque  = null;
>>>>>>> repoOriginal/main:src/VIEW/TelaNovoProdutoMercado.java
	
	JTextField inpPeso = null;//use esse atributo. Pege o conteúdo usando o getText()
	JRadioButton inpG = null;
	JRadioButton inpKg = null;
	JRadioButton inpMl = null;
	JRadioButton inpL = null;
	JComboBox<String> inpFornecedores = null;
	String[] listaDeFornecedores = {"Fornecedor JP","Fornecedor Mercado"};
	
	JTextArea inpDescricao = null;
	
	JButton bntCadastrar = new JButton("Cadastrar");;
	
	
	
	JButton bnt = null;
	
	public TelaNovoProdutoMercado() {
		JFrame j = new JFrame();
		
		j.setContentPane(new ImagemPanel("src/imgs/g.png"));
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(700,550);
		j.setLayout(null);
		j.setResizable(false);
		j.setTitle("~Produto do Fornecedor~");
		j.setLocationRelativeTo(null);
		adicionarComponetes_1(j);
		adicionarComponetes_2(j);
		
		j.setVisible(true);
		
		
		
		//*Exemplo de como pegar o dado de um campo - Isso é um ouvinto anônimo interno.
		bntCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.out.println(inpProduto.getText());
			}
		});
		
		
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
		adicionarTitulo(j,"Cadastre um Novo Produto");
		
		
		painel_2 = painel(j,new Color(100,120,120,100));
		painel_2.setBounds(0, painel_1.getHeight()*1, j.getWidth(), 40);
		JLabel produto = new JLabel("Produto: ");
		corTextoPadrao(produto, 15,"Arial");
		painel_2.add(produto);
		inpProduto = new JTextField(20);
		inpProduto.setFont(new Font("Arial",Font.BOLD,14));
		painel_2.add(inpProduto);
		
		painel_3 = painel(j,new Color(100,120,120,100));
		painel_3.setBounds(0, painel_1.getHeight()*2, j.getWidth(), 40);
		JLabel preco = new JLabel("Preço(R$): ");
		corTextoPadrao(preco, 15,"Arial");
		painel_3.add(preco);
		inpPreco = new JTextField(20);
		inpPreco.setFont(new Font("Arial",Font.BOLD,14));
		painel_3.add(inpPreco);
		
		painel_4 = painel(j,new Color(100,120,120,100));
		painel_4.setBounds(0, painel_1.getHeight()*3, j.getWidth(), 40);
		JLabel precoUnida = new JLabel("Preço Unidade(R$): ");
		corTextoPadrao(precoUnida, 15,"Arial");
		painel_4.add(precoUnida);
		inpPrecoUnidade = new JTextField(20);
		inpPrecoUnidade.setFont(new Font("Arial",Font.BOLD,14));
		painel_4.add(inpPrecoUnidade);
		
		painel_5 = painel(j,new Color(100,120,120,100));
		painel_5.setBounds(0, painel_1.getHeight()*4, j.getWidth(), 40);
		JLabel marca = new JLabel("Marca: ");
		corTextoPadrao(marca, 15,"Arial");
		painel_5.add(marca);
		inpMarca = new JTextField(20);
		inpMarca.setFont(new Font("Arial",Font.BOLD,14));
		painel_5.add(inpMarca);
		
		painel_6 = painel(j,new Color(100,120,120,100));
		painel_6.setBounds(0, painel_1.getHeight()*5, j.getWidth(), 40);
		JLabel estoque = new JLabel("Estoque: ");
		corTextoPadrao(estoque, 15,"Arial");
		painel_6.add(estoque);
		inpEstoque= new JTextField(20);
		inpEstoque.setFont(new Font("Arial",Font.BOLD,14));
		painel_6.add(inpEstoque);
		
		
		
        painel_7 = painel(j,new Color(10,10,10,0));
        painel_7.setLayout(null);
        
        Border border = BorderFactory.createLineBorder(Color.WHITE); // Cria uma borda preta
        
        painel_7.setBorder(BorderFactory.createTitledBorder(border, "Peso", TitledBorder.LEFT, TitledBorder.TOP, new Font("Arial",Font.BOLD,14),new Color(255,255,255) )); // Adiciona um título à borda
        painel_7.setBounds(35,painel_1.getHeight()*6,j.getWidth()-100,70);
        
        painel_8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        painel_8.setBounds(20,15,painel_7.getWidth(),30);
        painel_8.setBackground(new Color(200,59,23,0));
        inpPeso = new JTextField(10);
        inpPeso.setFont(new Font("Arial",Font.BOLD,14));
        painel_8.add(inpPeso);
        painel_7.add(painel_8);
        
        painel_9 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        painel_9.setBounds(painel_7.getX(),19*2,painel_7.getWidth()-painel_7.getX(),35);
        painel_9.setBackground(new Color(200,59,23,0));
        inpG = new JRadioButton("g");
        inpKg = new JRadioButton("Kg");
        inpMl = new JRadioButton("Ml");
        inpL = new JRadioButton("l");
        painel_9.add(inpG);
        painel_9.add(inpKg);
        painel_9.add(inpMl);
        painel_9.add(inpL);
        ButtonGroup b = new ButtonGroup();
        b.add(inpG);
        b.add(inpKg);
        b.add(inpMl);
        b.add(inpL);
        painel_7.add(painel_9);
            
        j.add(painel_7);
        
	
        painel_10 = painel(j,new Color(100,120,120,100));
		painel_10.setBounds(0, painel_1.getHeight()*8, j.getWidth(), 40);
		JLabel fornecedor = new JLabel("Fornecedores: ");
		corTextoPadrao(fornecedor, 15,"Arial");
		painel_10.add(fornecedor);
		inpFornecedores= new JComboBox<String>(listaDeFornecedores);
		inpFornecedores.setFont(new Font("Arial",Font.BOLD,14));
		painel_10.add(inpFornecedores);

		painel_11 = painel(j,new Color(100,120,120,100));
		painel_11.setBounds(0, painel_1.getHeight()*9, j.getWidth(), 100);
		JLabel descri = new JLabel("Descrição do Produto: ");
		corTextoPadrao(descri, 15,"Arial");
		painel_11.add(descri);
		inpDescricao= new JTextArea(4,20);
		inpDescricao.setFont(new Font("Arial",Font.BOLD,14));
		
		inpDescricao.setWrapStyleWord(true); // Permite que as palavras sejam quebradas para ajustar na largura
		inpDescricao.setLineWrap(true); // Faz com que o texto pule para a próxima linha quando atingir o final na horizontal
		JScrollPane scrollPane = new JScrollPane(inpDescricao);
		inpDescricao.setFont(new Font("Arial",Font.BOLD,14));
		painel_11.add(scrollPane);
		
	
       
        
        
	}
	
	void adicionarComponetes_2(JFrame j) {
				
		JPanel painel = painel(j,new Color(100,120,120,0));
		painel.setBounds(0,(painel_1.getHeight())*12-10, j.getWidth(), painel_1.getHeight());
		
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
