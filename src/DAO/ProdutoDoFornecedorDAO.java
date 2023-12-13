package DAO;



import java.util.ArrayList;

import DTO.DtoProduto;
import DTO.DtoUser;
import Model.Fornecedor;
import Model.Produto;

public class ProdutoDoFornecedorDAO {

	
	
	PessoaDAO banco = new PessoaDAO();
	Fornecedor fornecedor;
	Produto p;
	public boolean criarProduto(Produto prod, DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoCadastradoException{
		fornecedor = banco.lerFornecedor(forn);
		if(fornecedor != null) {
			if(fornecedor.adicionarProduto(prod)) {
				if(banco.atualizarFornecedor(fornecedor)) {
					return true;
				}
			}
			throw new  ProdutoNaoCadastradoException();
			
		}
		throw new UsuarioNaoEncontradaExeption();
		
	}

	public boolean checarProduto(DtoProduto prod, DtoUser forn) throws ProdutoNaoEncontradoException,  UsuarioNaoEncontradaExeption{
		fornecedor = banco.lerFornecedor(forn);
		if(!fornecedor.equals(null)) {
			if(fornecedor.checarProdutoFF(prod)) {
				return true;
			}
			throw new ProdutoNaoEncontradoException();
		}
		throw new  UsuarioNaoEncontradaExeption();
		
	}
	
	public boolean deleteProduto(DtoProduto prod, DtoUser forn) throws ProdutoNaoExisteException, UsuarioNaoEncontradaExeption{
		fornecedor = banco.lerFornecedor(forn);
		if(fornecedor != null) {
			if(fornecedor.removerProduto(prod)) {
				if(banco.atualizarFornecedor(fornecedor)) {
					 return true;
				}
			}
			throw new ProdutoNaoExisteException();
		}
		throw new  UsuarioNaoEncontradaExeption();
	}
	
	public Produto readProduto(DtoProduto prod, DtoUser forn) throws UsuarioNaoEncontradaExeption{
		fornecedor = banco.lerFornecedor(forn);
		if(fornecedor != null) {
			return fornecedor.lerProduto(prod);	
		}
		throw new  UsuarioNaoEncontradaExeption();
	}
	
	public boolean updateProduto(Produto prod, DtoUser forn) throws  UsuarioNaoEncontradaExeption,   ProdutoNaoAtualizadoExeption{
		fornecedor = banco.lerFornecedor(forn);
		if(fornecedor != null) {
			if(fornecedor.AtualizarProduto(prod)) {
				if(banco.atualizarFornecedor(fornecedor)) {
					return true;
				}
			}
			 throw new  ProdutoNaoAtualizadoExeption();
		}
		throw new  UsuarioNaoEncontradaExeption();
	}
	
	public ArrayList<Produto> retornaArrayProduto(DtoUser user) throws UsuarioNaoEncontradaExeption{
		fornecedor = banco.lerFornecedor(user);
		if(fornecedor != null) {
			return fornecedor.retornaArrayProdutos();
		}
		throw new  UsuarioNaoEncontradaExeption();
		
	}
}
