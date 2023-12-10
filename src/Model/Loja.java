package Model;

import DAO.LojaDAO;
import DTO.DtoProduto;
import DTO.DtoUser;

public class Loja {

	private double saldo;
	private LojaDAO loja;
	
	public boolean adicionarProduto(Produto prod) {
		return loja.addProduto(prod);
	}
	public boolean deleteProduto(DtoProduto prod) {
		return loja.removerProduto(prod);
	}
	/***/
	public Produto readProduto(DtoProduto prod) {
		return loja.lerproduto(prod);
	}
	/***/
	public boolean updateProduto(Produto prod) {
		return loja.atualizarProduto(prod);
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
	
}
