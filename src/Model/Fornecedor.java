package Model;

import java.util.ArrayList;

import DAO.PessoaDAO;
import DTO.DtoUser;
import DTO.DtoProduto;

public class Fornecedor extends Pessoa {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	PessoaDAO banco = new PessoaDAO();
	
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
	
	/**
	 * parte do trajeto até o banco este fará  a criação do mesmo
	 * */
	public boolean criarUser(Pessoa cliente){
		return banco.criarUser(cliente);
	}
	public boolean deleteUser(DtoUser pessoa) {
		return banco.deleteUserFornecedor(pessoa);
	}
	
	public Pessoa readUser(DtoUser pessoa) {
		return banco.readFornecedor(pessoa);
	}
	
	public boolean updateUser(Pessoa pessoa) {
		if(banco.atualizarFornecedor(pessoa)) {
			return true;
		}
		return false;
	}
	/**
	 * retornando Array de produtos
	 * */
	public boolean procuraFornecedor(DtoUser user) {
		return banco.procureFornecedor(user);
	}
	
	public ArrayList<Produto> retornaArrayProdutos() {
		return produtos;
	}
	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
}
