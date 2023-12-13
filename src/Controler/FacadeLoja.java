package Controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ProdutoNaoCadastradoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoProduto;
import DTO.DtoUser;
import Model.ADM;
import Model.Fabrica;
import Model.FabricaADM;
import Model.FabricaCliente;
import Model.FabricaFornecedor;
import Model.FabricaProduto;
import Model.Fornecedor;
import Model.Loja;
import Model.Produto;

public class FacadeLoja {

	private Fabrica fab;
	private FabricaProduto fabricaP;
	Loja loja = new Loja();
	Fornecedor fornecedor = new Fornecedor();
	ADM adm = new ADM();
	Produto produto = new Produto();

	public void criarADM(DtoUser user) {
		fab = new FabricaADM();
		try {
			fab.criarTipoPessoa(user);
		} catch (UsuarioNaoCadastradoException e) {
			JOptionPane.showMessageDialog(null, "usuario ja cadastrado", "ação impossivel", 2);
		}
	}

	public void criarCliente(DtoUser user) {
		fab = new FabricaCliente();
		try {
			fab.criarTipoPessoa(user);
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "usuario ja cadastrado", "ação impossivel", 2);
			
		}
	}

	public void criarFornecedor(DtoUser user) {
		fab = new FabricaFornecedor();
		try {
			fab.criarTipoPessoa(user);
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "usuario ja cadastrado", "ação impossivel", 2);
			
		}
		
	}
	public void criarProdutoFornecedor(DtoProduto prod, DtoUser user) {
		fabricaP = new FabricaProduto();
		try {
			fabricaP.ProdutoFornecedor(prod, user);
		} catch (UsuarioNaoEncontradaExeption e) {
			JOptionPane.showMessageDialog(null, "fornecedor não encontrado", "ação impossivel", 2);
			e.printStackTrace();
		}catch( ProdutoNaoCadastradoException e) {
			JOptionPane.showMessageDialog(null, "produto ja cadastrado", "ação impossivel", 2);
		}
		
	}
	
	public void adicionarProdutoLoja(DtoProduto prod) {
		fabricaP = new FabricaProduto();
		try {
			fabricaP.produtoLoja(prod);
		} catch (ProdutoNaoCadastradoException e) {
			JOptionPane.showMessageDialog(null, "produto ja cadastrado", "ação impossivel", 2);
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
