package Model;

import java.util.ArrayList;

import DTO.DtoUser;
import DTO.DtoProduto;

public class Fornecedor extends Pessoa {

	private ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	
	public Fornecedor(DtoUser pessoa) {
		super(pessoa);
		
	}
	public void createUsuario(Pessoa person) {
		// criar um usuario fornecedor
	}

	
	public boolean deleteUsuario(Pessoa person) {
		// Deletar um usuario fornecedor
		return false;
	}


	public Pessoa readUsuario(Pessoa pessoa) {
		//ler um Usuario fornecedor
		return null;
	}


	public void updateUsuario() {
		// atualizar um usuario fornecedor do sistema
		
	}
	



	public ArrayList<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	


	
}
