package Controler;

import java.util.ArrayList;

import DAO.ProdutoNaoAtualizadoExeption;
import DAO.ProdutoNaoCadastradoException;
import DAO.ProdutoNaoEncontradoException;
import DAO.ProdutoNaoExisteException;
import DAO.UsuarioNaoAtualizadoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoProduto;
import DTO.DtoUser;
import Model.Fabrica;
import Model.Fornecedor;
import Model.Produto;

public class FachadaProdutoAndFornecedores {
	Fornecedor fornecedor = new Fornecedor();
	Produto produto = new Produto();

	public void deleteUserFornecedor(DtoUser person){

		try {
			if(fornecedor.deleteUser(person)) {
				
			}
		} catch (UsuarioNaoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Fornecedor readFornecedor(DtoUser user)  {
		try {
			fornecedor = (Fornecedor) fornecedor.readUser(user);
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(fornecedor != null) {
			return fornecedor;
		}
		return null;
		}

	

	 

	public void atualizarfornecedor(Fornecedor p) {
		try {
			if (fornecedor.updateUser(p)) {
				
			}
		} catch (UsuarioNaoAtualizadoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void criarProdutoFornecedor(Produto prod, DtoUser forn) {

		try {
			if (!produto.criarProduto(prod, forn)) {
				
			}
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProdutoNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Produto lerProdutoFornecedor(DtoProduto prod, DtoUser forn) {
		try {
			return produto.readProduto(prod, forn);
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deletarProdutoFornecedor(DtoProduto prod, DtoUser forn) {
		try {
			produto.deleteProduto(prod, forn);
		} catch (ProdutoNaoExisteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public void editarProdutoFornecedor(Produto prod, DtoUser forn)  {
		try {
			produto.updateProduto(prod, forn);
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProdutoNaoAtualizadoExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		}
	public void checarProdutoFornecedor(DtoProduto prod, DtoUser user) {
		try {
			if(fornecedor.checarProdutoF(prod, user)) {
				
			}
		} catch (ProdutoNaoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ArrayList<Produto> retornaProdutos(Fornecedor user){
		fornecedor = user;
		if (fornecedor != null) {
			
		}
		
		return fornecedor.retornaArrayProdutos();
	}

	public ArrayList<Fornecedor> recuperarFornecedores() {
		return fornecedor.retornaArrayFornecedor();
	}

}
