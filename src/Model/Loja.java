package Model;

import java.util.ArrayList;

import DAO.LojaDAO;
import DAO.ProdutoNaoAtualizadoExeption;
import DAO.ProdutoNaoCadastradoException;
import DAO.ProdutoNaoEncontradoException;
import DAO.ProdutoNaoExisteException;
import DAO.ValorInvalidoException;
import DTO.DtoProduto;
import DTO.DtoUser;

public class Loja {

	private double saldo;
	private LojaDAO loja = new LojaDAO();	
	
	public boolean deleteProduto(DtoProduto prod) throws ProdutoNaoExisteException {
	
		return loja.removerProduto(prod);
	}
	/**
	 * @throws ProdutoNaoEncontradoException */
	public Produto readProduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		
		return loja.lerproduto(prod);
	}
	public boolean checarProduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		 
		return loja.checarProduto(prod);
	}
	/**
	 * @throws ProdutoNaoAtualizadoExeption */
	public boolean updateProduto(Produto prod) throws ProdutoNaoAtualizadoExeption {
		 
		return loja.atualizarProduto(prod);
	}
	public ArrayList<Produto> retornaProdutos(){
		
		return loja.retornaProdutos();
	}
	public double getSaldo() {
		
		return loja.receberValor();
			
	}
	public boolean setSaldo(double saldo) throws ValorInvalidoException {
		return loja.adicionarSaldo(saldo);
		
	}
	
	
	
	
	
	
}
