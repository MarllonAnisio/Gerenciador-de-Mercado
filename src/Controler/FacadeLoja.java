package Controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.ProdutoNaoAtualizadoExeption;
import DAO.ProdutoNaoCadastradoException;
import DAO.ProdutoNaoEncontradoException;
import DAO.ProdutoNaoExisteException;
import DAO.UsuarioNaoAtualizadoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DAO.ValorInvalidoException;
import DTO.DtoProduto;
import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fabrica;
import Model.FabricaADM;
import Model.FabricaCliente;
import Model.FabricaFornecedor;
import Model.FabricaProduto;
import Model.Fornecedor;
import Model.Loja;
import Model.Pessoa;
import Model.Produto;

public class FacadeLoja {

	private Fabrica fab;
	private FabricaProduto fabricaP;
	public Loja loja;
	public Fornecedor fornecedor;
	public ADM adm;
	public Produto produto;
	public Cliente cliente;

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
	
	public boolean deleteProduto(DtoProduto prod) throws ProdutoNaoExisteException {
		loja = new Loja();
		return loja.deleteProduto(prod);
	}
	/**
	 * @throws ProdutoNaoEncontradoException */
	public Produto readProduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		loja = new Loja();
		return loja.readProduto(prod);
	}
	public boolean checarProduto() {
		
		return false;
	}
	/**
	 * @throws ProdutoNaoAtualizadoExeption */
	public boolean updateProduto(Produto prod) throws ProdutoNaoAtualizadoExeption {
		loja = new Loja();
		return loja.updateProduto(prod);
	}
	public ArrayList<Produto> retornaProdutos(){
		loja = new Loja();
		return loja.retornaProdutos();
	}
	public double getSaldo() {
		loja = new Loja();
		return loja.getSaldo();
	}
	public boolean setSaldo(double saldo) throws ValorInvalidoException {
		loja = new Loja();
		return loja.setSaldo(saldo);
	}
	public boolean deleteUserADM(DtoUser pessoa) throws UsuarioNaoExistenteException {
		adm = new ADM();
		return adm.deleteUser(pessoa);
	}
	public ADM readUserADM(DtoUser pessoa) throws UsuarioNaoEncontradaExeption {
		adm = new ADM();
		return adm.readUser(pessoa);
	}
	public boolean checarProduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		loja = new Loja();
		return loja.checarProduto(prod);
	}

	public boolean updateUserADM(Pessoa Pessoa) throws UsuarioNaoAtualizadoException, UsuarioNaoEncontradaExeption {
		adm = new ADM();
		return adm.updateUser(Pessoa);
	}

	public  ArrayList<ADM> retornarArrayADM(){
		adm = new ADM();
		return adm.retornarArrayADM();
	}
	public boolean procureADM(DtoUser user) throws UsuarioNaoEncontradaExeption {
		adm = new ADM();
		return adm.procureADM(user);
	}
	
	public boolean deleteUserCliente(DtoUser pessoa) throws UsuarioNaoExistenteException {
		cliente = new Cliente();
		return cliente.deleteUser(pessoa);
	}
	
	public Pessoa readUserCliente(DtoUser pessoa) throws UsuarioNaoEncontradaExeption {
		cliente = new Cliente();
		return cliente.readUser(pessoa);
	}
	
	public boolean updateUserCliente(Pessoa Pessoa) throws UsuarioNaoAtualizadoException, UsuarioNaoEncontradaExeption {
		cliente = new Cliente();
		return cliente.updateUser(Pessoa);
	}
	public ArrayList<Cliente> retornarArrayClientes(){
		cliente = new Cliente();
		return cliente.retornarArrayClientes();
	}
	public boolean procuraCliente(DtoUser user) throws UsuarioNaoEncontradaExeption {
		cliente = new Cliente();
		return cliente.procuraCliente(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
