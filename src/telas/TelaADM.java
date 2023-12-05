package telas;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class TelaADM {
	
	JMenuItem itemNovoClente = new JMenuItem("Nova Cliente");
	JMenuItem itemNovoFornecedor = new JMenuItem("Nova Fornecedor");
	JMenuItem itemNovoProduto = new JMenuItem("Nova Produto");
	
	JMenuItem itemEstoque = new JMenuItem("Estoque");
	JMenuItem itemRelatorio = new JMenuItem("Relatório");
	JMenuItem itemHistorioVend = new JMenuItem("Histórico de Vendas");
	JMenuItem itemVender = new JMenuItem("Vender");
	JMenuItem itemComprar = new JMenuItem("Comprar");
	
	JMenuItem itemEditFornecedor = new JMenuItem("Fornecedor");
	JMenuItem itemEditCliente = new JMenuItem("Cliente");
	JMenuItem itemEditProdFornece = new JMenuItem("Produto do Fornecedor");
	JMenuItem itemEditProdMercad = new JMenuItem("Produto do Mercado");
	
	
	public TelaADM() {
		JFrame j = new JFrame();
		
		j.setContentPane(new ImagemPanel("src/imgs/g.png"));
		
		j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		j.setSize(540,400);
		j.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		j.setResizable(false);
		j.setTitle("~Administrador~");
		j.setLocationRelativeTo(null);
		adicionarComponetes_1(j);
		//adicionarComponetes_2(j);
		
		j.setVisible(true);
	}
	
	JLabel titulo(JFrame j, String t) { 
		JLabel label = new JLabel(t);
		return label;
	}
	
	
	void adicionarComponetes_1(JFrame j) {
		JMenuBar menu = new JMenuBar();
		j.add(menu);
		
		JMenu opFile = new JMenu("File");
		opFile.setFont(new Font("Arial",Font.BOLD,12));
		
		opFile.add(itemNovoClente);
		menu.add(opFile);
		opFile.add(itemNovoFornecedor);
		menu.add(opFile);
		opFile.add(itemNovoProduto);
		menu.add(opFile);
		
		
		
		JMenu opFinancas = new JMenu("Finanças");
		opFile.setFont(new Font("Arial",Font.BOLD,12));
		
		opFinancas.add(itemEstoque);
		menu.add(opFinancas);
		opFinancas.add(itemRelatorio);
		menu.add(opFinancas);
		opFinancas.add(itemHistorioVend);
		menu.add(opFinancas);
		opFinancas.add(itemVender);
		menu.add(opFinancas);
		opFinancas.add(itemComprar);
		menu.add(opFinancas);
		
		
		JMenu opEditar = new JMenu("Editar");
		opFile.setFont(new Font("Arial",Font.BOLD,12));
		
		opEditar.add(itemEditFornecedor);
		menu.add(opEditar);
		opEditar.add(itemEditCliente);
		menu.add(opEditar);
		opEditar.add(itemEditProdFornece);
		menu.add(opEditar);
		opEditar.add(itemEditProdMercad);
		menu.add(opEditar);
		
	
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
