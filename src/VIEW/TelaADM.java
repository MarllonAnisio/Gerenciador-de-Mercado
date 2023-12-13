package VIEW;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import Controler.FacadeLoja;
import Controler.Ouvinte;
import Controler.OuvinteADM;

public class TelaADM extends JFrame implements Ouvinte{
	
	public JMenuItem produtoLoja = new JMenuItem("adicionar produto a loja");
	public JMenuItem novoCliente = new JMenuItem("Nova Cliente");
	public JMenuItem novoFornecedor = new JMenuItem("Novo Fornecedor");
	public JMenuItem novoProdutoFornecedor = new JMenuItem("adicionar produto a fornecedor");
	public JMenuItem deletarCliente = new JMenuItem("deletar Cliente");
	public JMenuItem deletarProdutoLoja = new JMenuItem("deletar produto da loja");
	public JMenuItem deletarFornecedor = new JMenuItem("deletar fornecedor");
	public JMenuItem deletarProdutoFornecedor = new JMenuItem("deletar produto de fornecedor");

	public JMenuItem pesquisaFornecedorCnpj = new JMenuItem("pesquisar fornecedor por CNPJ");
	public JMenuItem pesquisaFornecedorNome = new JMenuItem("pesquise um fornecedor por nome");
	public JMenuItem pesquisarProdutoLoja = new JMenuItem("pesquisar produto na loja");
	public JMenuItem pesquisarProdutoFornecedor = new JMenuItem("pesquise um produto em um fornecedor");
	public JMenuItem pesquisarClienteCPF = new JMenuItem("pesquise um cliente por CPF");

	public JMenuItem comprarProdutoFornecedor = new JMenuItem("comprar Produto de Fornecedor");
	public JMenuItem comprarProduto = new JMenuItem("Comprar Produto");
	public JMenuItem venderProduto = new JMenuItem("Vender");
	public JMenuItem estoqueProdutos = new JMenuItem("estoque da loja");
	public JMenuItem estoqueFornecedor = new JMenuItem("estoque de fornecedores");
	public JMenuItem adicionarSaldo = new JMenuItem("adicionar saldo a empresa");
	FacadeLoja loja = new FacadeLoja();
	public TelaADM() {
		
	}
	public void desenharTela() {
		
		setContentPane(new ImagemPanel("src/VIEW/super-mercado_2.jpg"));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(540,400);
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		
		setResizable(false);
		setTitle("~Administrador~");
		setLocationRelativeTo(null);
		adicionarComponetes_1(this);
		Ouvinte ouvinte = new OuvinteADM(new TelaLogin(), this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener((WindowListener)ouvinte);
		ouvinte = new OuvinteADM(new TelaNovoCliente(), this);
		novoFornecedor.addActionListener((ActionListener)ouvinte);
		
		setVisible(true);
		
	}
	
	
	JLabel titulo(JFrame j, String t) { 
		JLabel label = new JLabel(t);
		return label;
	}
	
	
	public void adicionarComponetes_1(JFrame j) {
		JMenuBar menu = new JMenuBar();
		j.add(menu);
		
		JMenu opFile = new JMenu("Recursos");
		opFile.setFont(new Font("Arial",Font.BOLD,12));
		
		opFile.add(novoCliente);
		menu.add(opFile);
		opFile.add(novoFornecedor);
		menu.add(opFile);
		opFile.add(produtoLoja);
		menu.add(opFile);
		opFile.add(novoProdutoFornecedor);
		menu.add(opFile);
		opFile.add(deletarCliente);
		menu.add(opFile);
		opFile.add(deletarProdutoLoja);
		menu.add(opFile);
		opFile.add(deletarProdutoFornecedor);
		menu.add(opFile);
		opFile.add(deletarFornecedor);
		menu.add(opFile);
		
			
		JMenu opFinancas = new JMenu("Pesquisa");
		opFile.setFont(new Font("Arial",Font.BOLD,12));
		
		menu.add(opFinancas);
		opFinancas.add(pesquisaFornecedorCnpj);
		menu.add(opFinancas);
		opFinancas.add(pesquisaFornecedorNome);
		menu.add(opFinancas);
		opFinancas.add(pesquisarProdutoLoja);
		menu.add(opFinancas);
		opFinancas.add(pesquisarProdutoFornecedor);
		menu.add(opFinancas);
		
		

		JMenu opEditar = new JMenu("Loja");
		opFile.setFont(new Font("Arial",Font.BOLD,12));
		
		opEditar.add(estoqueProdutos);
		menu.add(opEditar);
		opEditar.add(estoqueFornecedor);
		menu.add(opEditar);
		opEditar.add(comprarProdutoFornecedor);
		menu.add(opEditar);
		opEditar.add(comprarProduto);
		menu.add(opEditar);
		opEditar.add(venderProduto);
		menu.add(opEditar);
		opEditar.add(adicionarSaldo);
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
