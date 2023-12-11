package Model;

import DAO.LojaDAO;
import DAO.ProdutoNaoAtualizadoExeption;
import DAO.ProdutoNaoCadastradoException;
import DAO.ProdutoNaoEncontradoException;
import DAO.ProdutoNaoExisteException;
import DTO.DtoProduto;
import DTO.DtoUser;

public class Loja {

	private double saldo;
	private LojaDAO loja;
	
	public boolean adicionarProduto(Produto prod) throws ProdutoNaoCadastradoException {
		return loja.addProduto(prod);
	}
	public boolean deleteProduto(DtoProduto prod) throws ProdutoNaoExisteException {
		return loja.removerProduto(prod);
	}
	/**
	 * @throws ProdutoNaoEncontradoException */
	public Produto readProduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		return loja.lerproduto(prod);
	}
	/**
	 * @throws ProdutoNaoAtualizadoExeption */
	public boolean updateProduto(Produto prod) throws ProdutoNaoAtualizadoExeption {
		return loja.atualizarProduto(prod);
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	
	
	
	
	
}
