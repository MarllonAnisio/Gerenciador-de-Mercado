package Controler;


import java.util.ArrayList;

import DTO.DtoProduto;
import DTO.DtoUser;
import Model.Fabrica;
import Model.Fornecedor;
import Model.Produto;

public class FachadaProdutoAndFornecedores {
	Fabrica fabrica = null;
	Fornecedor fo = null;
	Produto p = null;

	         
	public void deleteUserFornecedor(DtoUser person) throws UsuarioNaoExistenteException {
		fo = new Fornecedor(person);
		if (!fo.deleteUser(person)) {
			throw new UsuarioNaoExistenteException();
		}
	}

	public Fornecedor readFornecedor(DtoUser user) throws UsuarioNaoEncontradaExeption {
		fo = (Fornecedor) fo.readUser(user);
		if (fo.equals(null)) {
			throw new UsuarioNaoEncontradaExeption();
		}
		return fo;

	}

	public void atualizarfornecedor(Fornecedor p) throws UsuarioNaoAtualizadoException {
		if (!fo.updateUser(p)) {
			throw new UsuarioNaoAtualizadoException();
		}

	}

	public void criarProdutoFornecedor(Produto prod, DtoUser forn) throws ProdutoNaoCadastradoException {
		if (!p.criarProduto(prod, forn)) {
			throw new ProdutoNaoCadastradoException();
		}

	}

	public Produto lerProdutoFornecedor(DtoProduto prod, DtoUser forn) {
		return p.readProduto(prod, forn);
	}

	public void deletarProdutoFornecedor(DtoProduto prod, DtoUser forn) throws UsuarioNaoEncontradaExeption {
		if (!p.deleteProduto(prod, forn)) {
			throw new UsuarioNaoEncontradaExeption();
		}
	}

	public void editarProdutoFornecedor(DtoProduto prod, DtoUser forn) throws ProdutoNaoAtualizadoExeption{
		if(!p.updateProduto(p, forn)) {
			
		}
	}
	public ArrayList<Produto> retornaProdutos(Fornecedor user)throws UsuarioNaoEncontradaExeption{
		fo = user;
		if(fo.equals(null)) {
			throw new UsuarioNaoEncontradaExeption();
		}
		return fo.retornaArrayProdutos();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}






















