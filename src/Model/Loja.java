package Model;

import DAO.LojaDAO;

public class Loja {

	private LojaDAO loja;
	public boolean adicionarProduto(Produto prod) {
		return loja.addProduto(prod);
	}
	
	
	
}
