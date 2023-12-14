package VIEW;

import javax.swing.*;

import Controler.FacadeFornecedor;
import Controler.FacadeLoja;
import DAO.ProdutoNaoEncontradoException;
import DAO.ProdutoNaoExisteException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DAO.ValorInvalidoException;
import DTO.DtoProduto;
import DTO.DtoUser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaADM extends JFrame {

    private JLabel labelSaldo;
    FacadeLoja fachada = new FacadeLoja();
    public TelaADM() {
        super("Tela de Administração");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 400);

        // Defina a cor de fundo da janela
        getContentPane().setBackground(new Color(173, 216, 230)); // LightSkyBlue

        // Configuração da barra de menu
        JMenuBar menuBar = new JMenuBar();

        // Barra de menu Recursos
        JMenu menuRecursos = new JMenu("Recursos");
      
        JMenuItem novoClienteItem = new JMenuItem("Novo Cliente");
        JMenuItem novoFornecedorItem = new JMenuItem("Novo Fornecedor");
        JMenuItem produtoLojaItem = new JMenuItem("Cadastrar produto para Loja");
        JMenuItem novoProdutoFornecedorItem = new JMenuItem("Novo Produto Fornecedor");
        JMenuItem deletarClienteItem = new JMenuItem("Deletar Cliente");
        JMenuItem deletarProdutoLojaItem = new JMenuItem("Deletar Produto da Loja");
        JMenuItem deletarProdutoFornecedorItem = new JMenuItem("Deletar Produto do Fornecedor");
        JMenuItem deletarFornecedorItem = new JMenuItem("Deletar Fornecedor");

        menuRecursos.add(novoClienteItem);
        menuRecursos.add(novoFornecedorItem);
        menuRecursos.add(produtoLojaItem);
        menuRecursos.add(novoProdutoFornecedorItem);
        menuRecursos.add(deletarClienteItem);
        menuRecursos.add(deletarProdutoLojaItem);
        menuRecursos.add(deletarProdutoFornecedorItem);
        menuRecursos.add(deletarFornecedorItem);

        // Adiciona ouvintes aos itens de menu de Recursos
        adicionarOuvinteMenu(novoClienteItem);
        adicionarOuvinteMenu(novoFornecedorItem);
        adicionarOuvinteMenu(produtoLojaItem);
        adicionarOuvinteMenu(novoProdutoFornecedorItem);
        adicionarOuvinteMenu(deletarClienteItem);
        adicionarOuvinteMenu(deletarProdutoLojaItem);
        adicionarOuvinteMenu(deletarProdutoFornecedorItem);
        adicionarOuvinteMenu(deletarFornecedorItem);

        menuBar.add(menuRecursos);

        // Barra de menu Pesquisa
        JMenu menuPesquisa = new JMenu("Pesquisa");
       
        JMenuItem pesquisaFornecedorCnpjItem = new JMenuItem("Pesquisa Fornecedor por CNPJ");
        JMenuItem pesquisaFornecedorNomeItem = new JMenuItem("Pesquisa Fornecedor por Nome");
        JMenuItem pesquisarProdutoLojaItem = new JMenuItem("Pesquisar Produto na Loja");
        JMenuItem pesquisarProdutoFornecedorItem = new JMenuItem("Pesquisar Produto no Fornecedor");

        menuPesquisa.add(pesquisaFornecedorCnpjItem);
        menuPesquisa.add(pesquisaFornecedorNomeItem);
        menuPesquisa.add(pesquisarProdutoLojaItem);
        menuPesquisa.add(pesquisarProdutoFornecedorItem);

        // Adiciona ouvintes aos itens de menu de Pesquisa
        adicionarOuvinteMenu(pesquisaFornecedorCnpjItem);
        adicionarOuvinteMenu(pesquisaFornecedorNomeItem);
        adicionarOuvinteMenu(pesquisarProdutoLojaItem);
        adicionarOuvinteMenu(pesquisarProdutoFornecedorItem);

        menuBar.add(menuPesquisa);

        // Barra de menu Loja
        JMenu menuLoja = new JMenu("Loja");
      
        JMenuItem estoqueProdutosItem = new JMenuItem("Estoque de Produtos");
        JMenuItem estoqueFornecedorItem = new JMenuItem("Estoque do Fornecedor");
        JMenuItem comprarProdutoFornecedorItem = new JMenuItem("Comprar Produto do Fornecedor");
        JMenuItem comprarProdutoItem = new JMenuItem("Comprar Produto");
        JMenuItem venderProdutoItem = new JMenuItem("Vender Produto");
        JMenuItem adicionarSaldoItem = new JMenuItem("Adicionar Saldo");

        menuLoja.add(estoqueProdutosItem);
        menuLoja.add(estoqueFornecedorItem);
        menuLoja.add(comprarProdutoFornecedorItem);
        menuLoja.add(comprarProdutoItem);
        menuLoja.add(venderProdutoItem);
        menuLoja.add(adicionarSaldoItem);

        // Adiciona ouvintes aos itens de menu de Loja
        adicionarOuvinteMenu(estoqueProdutosItem);
        adicionarOuvinteMenu(estoqueFornecedorItem);
        adicionarOuvinteMenu(comprarProdutoFornecedorItem);
        adicionarOuvinteMenu(comprarProdutoItem);
        adicionarOuvinteMenu(venderProdutoItem);
        adicionarOuvinteMenu(adicionarSaldoItem);

        menuBar.add(menuLoja);

        setJMenuBar(menuBar);

        // Configuração do label de saldo
        labelSaldo = new JLabel(String.valueOf(fachada.getSaldo()));
        labelSaldo.setHorizontalAlignment(SwingConstants.RIGHT);
        labelSaldo.setBorder(BorderFactory.createEmptyBorder(0, 0, 5, 10));

        add(labelSaldo, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void adicionarOuvinteMenu(JMenuItem itemMenu) {
        itemMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	DtoUser user;
            	String pley = itemMenu.getText();
	            FacadeFornecedor f = new FacadeFornecedor();
	            DtoProduto p;
	            switch (pley) {

	    		case "Novo Cliente":
	    			
	    			break;
	    			
	    		case "Novo Fornecedor":
	    			dispose();
	    			new TelaCadastroFornecedor();
	    			break;
	    			
	    		case "Cadastrar produto para Loja":
	    			dispose();
	    			new TelaCadastroProduto();
	    			break;
	    			
	    		case "Novo Produto Fornecedor":
	    			dispose();
	    			new TelaCadastroNovoProdutoFornecedor();
	    			break;
	    		case "Deletar Cliente":
	    			long valor = Long.parseLong(JOptionPane.showInputDialog("digite o cpf"));
	    			user = new DtoUser(0,valor);
	    			try {
						if(fachada.deleteUserCliente(user)) {
							JOptionPane.showMessageDialog(null, "Cliente Deletado", "sucesso", 2);
						}
					} catch (UsuarioNaoExistenteException e1) {
						JOptionPane.showMessageDialog(null, "usuario nao existe", "ação impossivel", 2);
					}
	    			break;
	    			
	    		case "Deletar Produto da Loja":
	    			String nomeprod = JOptionPane.showInputDialog("digite o nome do produto");
	    			p = new DtoProduto(nomeprod);
	    			try {
						if(fachada.deleteProduto(p)) {
							JOptionPane.showMessageDialog(null, "Produto Deletado", "sucesso", 2);
						}
					} catch (HeadlessException | ProdutoNaoExisteException e1) {
						JOptionPane.showMessageDialog(null, " Erro fatal", " ERRO!!!!!!!!!!!!!!", 2);
					}
	    			break;
	    			
	    			
	    		case "Deletar Produto do Fornecedor":
	    			long Cnpj = Long.parseLong(JOptionPane.showInputDialog(" "));
	    			user = new DtoUser(0,Cnpj);
	    			String nome = JOptionPane.showInputDialog("digite o nome do produto");
	    			p = new DtoProduto(nome);
	    			
	    			try {
						if(f.checarProdutoF(p, user)) {
							JOptionPane.showMessageDialog(null, " produto  Deletado", "sucesso", 2);
						}
					} catch (HeadlessException | ProdutoNaoEncontradoException | UsuarioNaoEncontradaExeption e1) {
						JOptionPane.showMessageDialog(null, " -----Erro fatal---- ", " ERRO!!!!!!!!!!!!!!", 2);
					}
	    			break;
	    		case "Deletar Fornecedor":
	    			long cnpj = Long.parseLong(JOptionPane.showInputDialog("digite o cpf"));
	    			user = new DtoUser(0,cnpj);
	    			
	    			try {
						if(f.deleteUser(user)) {
							JOptionPane.showMessageDialog(null, "Fornecedor Deletado", "sucesso", 2);
						}
					} catch (UsuarioNaoExistenteException e1) {
						JOptionPane.showMessageDialog(null, "usuario nao existe", "ação impossivel", 2);
					}
	    			break;
	    		case "Pesquisa Fornecedor por CNPJ":
	    			long c = Long.parseLong(JOptionPane.showInputDialog("digite o cpf"));
	    			user = new DtoUser(0,c);
	    			try {
						if(f.procuraFornecedor(user)) {
							JOptionPane.showMessageDialog(null, "Cliente Deletado", "sucesso", 2);
						}
					} catch (HeadlessException | UsuarioNaoEncontradaExeption e1) {
						JOptionPane.showMessageDialog(null, " -----Erro fatal---- ", " ERRO!!!!!!!!!!!!!!", 2);
						
					}
	    			break;
	    		case "Pesquisa Fornecedor por Nome":
	    			String name = JOptionPane.showInputDialog("digite o nome do fornecedor para saber se ele exixte no sistema");
	    			user = new DtoUser(name);
	    			try {
						if(f.procuraFornecedor(user)) {
							JOptionPane.showMessageDialog(null, "fornecedor se enc", "sucesso", 2);
						}
					} catch (HeadlessException | UsuarioNaoEncontradaExeption e1) {
						JOptionPane.showMessageDialog(null, " -----Erro fatal---- ", " ERRO!!!!!!!!!!!!!!", 2);
					}
	    			break;

	    		case "Pesquisar Produto na Loja":
	    			String produtoLo = JOptionPane.showInputDialog("digite o cpf");
	    			p = new DtoProduto(produtoLo);
	    			try {
						if(fachada.checarProduto(p)) {
							JOptionPane.showMessageDialog(null, "produto se encontra na loja", "sucesso", 2);
						}
					} catch (HeadlessException | ProdutoNaoEncontradoException e1) {
						JOptionPane.showMessageDialog(null, "Cliente Deletado", "sucesso", 2);
						
					}
	    			break;
	    		case "Pesquisar Produto no Fornecedor":
	    			long cnpj1 = Long.parseLong(JOptionPane.showInputDialog("digite o cnpj"));
	    			String nome1 = JOptionPane.showInputDialog("digite o nome do produto");
	    			DtoProduto d = new DtoProduto(nome1);
	    			user = new DtoUser(0,cnpj1);
	    			try {
						if(f.checarProdutoF(d, user)) {
							JOptionPane.showMessageDialog(null, "Cliente Deletado", "sucesso", 2);
						}
					} catch (HeadlessException | ProdutoNaoEncontradoException | UsuarioNaoEncontradaExeption e1) {
						
						JOptionPane.showMessageDialog(null, " Erro fatal", " ERRO!!!!!!!!!!!!!!", 2);
					}
	    			break;
	    		case "Estoque do Fornecedor":
	    			dispose();
	    			new EstoqueFornecedor();
	    			break;
	    			
	    		case "Estoque de Produtos":
	    			dispose();
	    			new TelaListaProdutos();
	    			break;
	    			
	    		case "Comprar Produto do Fornecedor":
	    			dispose();
	    			new TelaCompraProdutoFornecedor();
	    			break;
	    			
	    		case "Comprar Produto":
	    
		    		break;
		    		
		    		
	    		case "Vender Produto":
	    			dispose();
	    			new TelaVendaProduto();
		    		break;
		    		
	    		case "Adicionar Saldo":
	    			double saldo = Double.parseDouble(JOptionPane.showInputDialog("digite o valor R$ "));
		    		try {
						if(fachada.setSaldo(saldo)) {
							JOptionPane.showMessageDialog(null, "saldo adicionado com sucesso", "sucesso", 2);
						}
					} catch (ValorInvalidoException e1) {
						JOptionPane.showMessageDialog(null, "por favor apenas valores positivos ", "sucesso", 2);
						
					}
	    			break;
	    		
            }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TelaADM();
            }
        });
    }
}
											