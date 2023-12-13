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
	public Loja loja = new Loja();
	public Fornecedor fornecedor = new Fornecedor();
	public ADM adm = new ADM();
	public Produto produto = new Produto();

	public boolean criarADM(DtoUser user) {
		fab = new FabricaADM();
		try {
			return fab.criarTipoPessoa(user);
		} catch (UsuarioNaoCadastradoException e) {
			JOptionPane.showMessageDialog(null, "usuario ja cadastrado", "ação impossivel", 2);
		}
		return false;
	}

	public boolean criarCliente(DtoUser user) {
		fab = new FabricaCliente();
		try {
			return fab.criarTipoPessoa(user);
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "usuario ja cadastrado", "ação impossivel", 2);
			
		}
		return false;
	}

	public boolean criarFornecedor(DtoUser user) {
		fab = new FabricaFornecedor();
		try {
			return fab.criarTipoPessoa(user);
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "usuario ja cadastrado", "ação impossivel", 2);
			
		}
		return false;
		
	}
	public boolean criarProdutoFornecedor(DtoProduto prod, DtoUser user) {
		fabricaP = new FabricaProduto();
		try {
			return	fabricaP.ProdutoFornecedor(prod, user);
		} catch (UsuarioNaoEncontradaExeption e) {
			JOptionPane.showMessageDialog(null, "fornecedor não encontrado", "ação impossivel", 2);
			e.printStackTrace();
		}catch( ProdutoNaoCadastradoException e) {
			JOptionPane.showMessageDialog(null, "produto ja cadastrado", "ação impossivel", 2);
		}
		return false;
		
	}
	
	public boolean adicionarProdutoLoja(DtoProduto prod) {
		fabricaP = new FabricaProduto();
		try {
			return fabricaP.produtoLoja(prod);
		} catch (ProdutoNaoCadastradoException e) {
			JOptionPane.showMessageDialog(null, "produto ja cadastrado", "ação impossivel", 2);
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
