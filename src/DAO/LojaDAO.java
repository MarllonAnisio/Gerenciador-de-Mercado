package DAO;

import java.util.ArrayList;

import DTO.DtoProduto;
import Model.Produto;

public class LojaDAO {

	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();
	Produto produto;
//	ProdutoNaoExisteException
//	ProdutoNaoEncontradoException
//	ProdutoNaoAtualizadoExeption
//	throws ProdutoNaoCadastradoException
	
	public void setSaldo(double saldo) {
		
	}
	public boolean addProduto(Produto prod) throws ProdutoNaoCadastradoException{
		if (CDI.criarProduto(prod)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
	
		throw new  ProdutoNaoCadastradoException();
	}

	public boolean checarProduto(DtoProduto prod) throws ProdutoNaoEncontradoException {
		if(CDI.checarProduto(prod)) {
			return true;
		}
		throw new ProdutoNaoEncontradoException();
	}
	
	public Produto lerproduto(DtoProduto prod) throws ProdutoNaoEncontradoException{
		produto = CDI.lerProduto(prod);
		if(produto != null) {
			return produto;
		}
		throw new ProdutoNaoEncontradoException();
	}
	
	public boolean removerProduto(DtoProduto prod) throws ProdutoNaoExisteException {
		if (CDI.deletarProduto(prod)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new ProdutoNaoExisteException();
	}
	public ArrayList<Produto> retornaProdutos() {
		return CDI.retornarProdutos();
	}

	public boolean atualizarProduto(Produto prod) throws ProdutoNaoAtualizadoExeption {
		if (CDI.atualizarProduto(prod)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new ProdutoNaoAtualizadoExeption();
	}

}
