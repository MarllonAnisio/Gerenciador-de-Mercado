package Model;

import java.util.ArrayList;

import DAO.PessoaDAO;
import DAO.ProdutoDoFornecedorDAO;
import DAO.ProdutoNaoEncontradoException;
import DAO.UsuarioNaoAtualizadoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoUser;
import DTO.DtoProduto;

public class Fornecedor extends Pessoa {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	private PessoaDAO banco = new PessoaDAO();
	private ProdutoDoFornecedorDAO produto = new ProdutoDoFornecedorDAO();
	private Produto produtop;
	private Fornecedor fornecedor;
	public Fornecedor(DtoUser pessoa) {
		super(pessoa);
	}
	public Fornecedor() {
		
	}
	public boolean adicionarProduto(Produto prod) {
		for(Produto produto: produtos) {
			if(produto.getNameProduto().equals(prod.getNameProduto())&& produto.getNomeMarca().equals(prod.getNomeMarca())){
				return false;
			}
		}
		produtos.add(prod);
		return true;
	}
	public Produto lerProduto(DtoProduto prod) {
		for(Produto produto: produtos) {
			if(produto.getNameProduto().equals(prod.getNameProduto())){
				return produto;
			}
		}
		return null;
	}
	public boolean removerProduto(DtoProduto prod) {
		for(Produto produto: produtos) {
			if(produto.getNameProduto().equals(prod.getNameProduto())&& produto.getNomeMarca().equals(prod.getNomeMarca())){
				produtos.remove(produto);
				return true;
			}
		}
		return false;
	}
	public boolean AtualizarProduto(Produto prod) {
		for(Produto produto: produtos) {
			if(produto.getNameProduto().equals(prod.getNameProduto()) && produto.getNomeMarca().equals(prod.getNomeMarca())) {
				produtos.remove(produto);
				produto = prod;
				produtos.add(produto);
				return true;
			}
			
		}
		return false;
	}
	
	public  ArrayList<Fornecedor> retornaArrayFornecedor(){
		return banco.retornaArrayFornecedor();
	}
	public boolean checarProdutoF(DtoProduto prod, DtoUser fornecedor) throws ProdutoNaoEncontradoException, UsuarioNaoEncontradaExeption {
		return produto.checarProduto(null, fornecedor);
		
	}
	public boolean checarProdutoFF(DtoProduto prod) {
		for(Produto x: produtos) {
			if(x.getNameProduto().equals(prod)) {
				return true;
			}
		}
		return false;
		
	}
	
	public Produto checarProdutoR(DtoProduto prod, DtoUser forn ) throws UsuarioNaoEncontradaExeption {
		fornecedor = banco.lerFornecedor(forn);
		if(fornecedor != null) {
			for(Produto x: produtos) {
				if(x.getNameProduto().equals(prod)) {
					return x;
				}
			}
		}
		return null;
		
	}
	
	
	
	/**
	 * parte do trajeto até o banco este fará  a criação do mesmo
	 * @throws UsuarioNaoCadastradoException 
	 * 
	 * */
	
	public boolean deleteUser(DtoUser pessoa) throws UsuarioNaoExistenteException {
		return banco.removerFornecedor(pessoa);
	}
	
	public Pessoa readUser(DtoUser pessoa) throws UsuarioNaoEncontradaExeption {
		return banco.lerFornecedor(pessoa);
	}
	
	public boolean updateUser(Pessoa pessoa) throws UsuarioNaoAtualizadoException, UsuarioNaoEncontradaExeption {
		if(banco.atualizarFornecedor(pessoa)) {
			return true;
		}
		return false;
	}
	/**
	 * retornando Array de produtos
	 * @throws UsuarioNaoEncontradaExeption 
	 * */
	public boolean procuraFornecedor(DtoUser user) throws UsuarioNaoEncontradaExeption {
		return banco.checagemFornecedores(user);
	}
	
	public ArrayList<Produto> retornaArrayProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
}
