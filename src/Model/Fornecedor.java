package Model;

import java.util.ArrayList;

import DTO.DtoUser;
import DTO.DtoProduto;

public class Fornecedor extends Pessoa {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	
	public Fornecedor(DtoUser pessoa) {
		super(pessoa);
		
	}
	public void criarUser(Pessoa user) {
		
		
	}
	public boolean adicionarProduto(Produto prod) {
		for(Produto x: produtos) {
			if(x.getName().equals(prod.getName())){
				return false;
			}
		}
		produtos.add(prod);
		return true;
	}
	public Produto lerProduto(DtoProduto prod) {
		for(Produto produto: produtos) {
			if(produto.getName().equals(prod.getNameProduto())){
				return produto;
			}
		}
		return null;
	}
	public boolean removerProduto(DtoProduto prod) {
		for(Produto produto: produtos) {
			if(produto.getName().equals(prod.getNameProduto())){
				produtos.remove(produto);
				return true;
			}
		}
		return false;
	}

	
	public boolean deleteUsuario(DtoUser person) {
		// Deletar um usuario fornecedor
		return false;
	}


	public Pessoa readUsuario(DtoUser person) {
		//ler um Usuario fornecedor
		return null;
	}


	public void updateUsuario(DtoUser person) {
		// atualizar um usuario fornecedor do sistema
		
	}
	



	public ArrayList<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}
	
	

	


	
}
