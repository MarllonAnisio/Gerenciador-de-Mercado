package Controler;

import java.util.ArrayList;

import DAO.ProdutoNaoEncontradoException;
import DAO.UsuarioNaoAtualizadoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoProduto;
import DTO.DtoUser;
import Model.Fornecedor;
import Model.Pessoa;
import Model.Produto;

public class FacadeFornecedor {

 private Fornecedor f = new Fornecedor();
 
 
 
	
	public Produto lerProduto(DtoProduto prod) {
		return f.lerProduto(prod);
	}
	public boolean removerProduto(DtoProduto prod) {
		
		return f.removerProduto(prod);
	}
	public boolean AtualizarProduto(Produto prod) {
		
		return f.AtualizarProduto(prod);
	}
	
	public  ArrayList<Fornecedor> retornaArrayFornecedor(){
		
		return f.retornaArrayFornecedor();
	}
	public boolean checarProdutoF(DtoProduto prod, DtoUser fornecedor) throws ProdutoNaoEncontradoException, UsuarioNaoEncontradaExeption {
	
		return f.checarProdutoF(prod, fornecedor);
		
	}
	public boolean checarProdutoFF(DtoProduto prod) {

		return f.checarProdutoFF(prod);
	}
	
	public boolean checarProduto(DtoProduto prod, DtoUser forn ) throws UsuarioNaoEncontradaExeption, ProdutoNaoEncontradoException {
		return f.checarProdutoF(prod, forn);
	}
	
	public boolean deleteUser(DtoUser pessoa) throws UsuarioNaoExistenteException {
			return f.deleteUser(pessoa);
	}
	
	public Pessoa readUser(DtoUser pessoa) throws UsuarioNaoEncontradaExeption {
		return f.readUser(pessoa);
	}
	
	public boolean updateUser(Pessoa pessoa) throws UsuarioNaoAtualizadoException, UsuarioNaoEncontradaExeption {
		return f.updateUser(pessoa);
	}
	/**
	 * retornando Array de produtos
	 * @throws UsuarioNaoEncontradaExeption 
	 * */
	public boolean procuraFornecedor(DtoUser user) throws UsuarioNaoEncontradaExeption {
		return f.procuraFornecedor(user);
	}
	
	public ArrayList<Produto> retornaArrayProdutos() {
		return f.retornaArrayProdutos();
	}
 }
