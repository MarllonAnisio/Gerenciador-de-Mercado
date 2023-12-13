package DAO;

import java.util.ArrayList;

import DTO.DtoProduto;
import Model.Produto;

public class LojaDAO {

	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();
	Produto produto;

	public void setSaldo(double saldo) {

	}

	public boolean AdicionarProduto(Produto prod) throws ProdutoNaoCadastradoException {
		for (Produto x : CDI.estoque) {
			if (prod.getNameProduto().equals(x.getNameProduto())) {
				throw new ProdutoNaoCadastradoException();
			}
		}
		if (CDI.estoque == null) {
			CDI.estoque.add(prod);
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		CDI.estoque.add(prod);
		CDI.salvarCentral(CDI, "Central");
		return true;
	}

	public boolean checarProduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		for (Produto x : CDI.estoque) {
			if (prod.getNameProduto().equals(x.getNameProduto())) {
				return true;

			}
		}
		throw new ProdutoNaoEncontradoException();
	}

	public Produto lerproduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		for (Produto x : CDI.estoque) {
			if (prod.getNameProduto().equals(x.getNameProduto())) {
				return x;
			}
		}
		throw new ProdutoNaoEncontradoException();
	}

	public boolean removerProduto(DtoProduto prod) throws ProdutoNaoExisteException {
		for (Produto x : CDI.estoque) {
			if (prod.getNameProduto().equals(x.getNameProduto())) {
				CDI.estoque.remove(x);
				CDI.salvarCentral(CDI, "Central");
				return true;

			}
		}
		throw new ProdutoNaoExisteException();
	}

	public ArrayList<Produto> retornaProdutos() {
		return CDI.retornarProdutos();
		
	}

	public boolean atualizarProduto(Produto prod) throws ProdutoNaoAtualizadoExeption {
		for (Produto x : CDI.estoque) {
			if (prod.getNameProduto().equals(x.getNameProduto())) {
				CDI.estoque.remove(x);
				CDI.estoque.add(prod);
				CDI.salvarCentral(CDI, "Central");
				return true;

			}
		}
		throw new ProdutoNaoAtualizadoExeption();
	}
	public boolean adicionarSaldo(double valor) throws  ValorInvalidoException{
		if(valor > 0) {
			CDI.setSaldo(valor);
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new ValorInvalidoException();
	
	}
	public double receberValor() {
		return CDI.getSaldo();
				
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
