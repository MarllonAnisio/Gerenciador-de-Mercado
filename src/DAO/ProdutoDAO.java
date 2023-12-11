package DAO;



import java.util.ArrayList;

import DTO.DtoProduto;
import DTO.DtoUser;
import Model.Fornecedor;
import Model.Produto;

public class ProdutoDAO implements ContratoProduto{

	
	
	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();
	Fornecedor f;
	Produto p;
	public boolean criarProduto(Produto prod, DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoCadastradoException{
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			if(f.adicionarProduto(prod)) {
				if(CDI.atualizarFornecedor(f)) {
					 CDI.salvarCentral(CDI, "Central");
					return true;
				}
			}
			throw new  ProdutoNaoCadastradoException();
			
		}
		throw new UsuarioNaoEncontradaExeption();
		
	}

	public boolean checarProduto(DtoProduto prod, DtoUser forn) throws ProdutoNaoEncontradoException,  UsuarioNaoEncontradaExeption{
		f = CDI.lerFornecedor(forn);
		if(!f.equals(null)) {
			if(f.checarProdutoFF(prod)) {
				return true;
			}
			throw new ProdutoNaoEncontradoException();
		}
		throw new  UsuarioNaoEncontradaExeption();
		
	}
	
	public boolean deleteProduto(DtoProduto prod, DtoUser forn) throws ProdutoNaoExisteException, UsuarioNaoEncontradaExeption{
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			if(f.removerProduto(prod)) {
				if(CDI.atualizarFornecedor(f)) {
					 CDI.salvarCentral(CDI, "Central");
					 return true;
				}
			}
			throw new ProdutoNaoExisteException();
		}
		throw new  UsuarioNaoEncontradaExeption();
	}
	
	public Produto readProduto(DtoProduto prod, DtoUser forn) throws UsuarioNaoEncontradaExeption{
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			return f.lerProduto(prod);	
		}
		throw new  UsuarioNaoEncontradaExeption();
	}
	
	public boolean updateProduto(Produto prod, DtoUser forn) throws  UsuarioNaoEncontradaExeption,   ProdutoNaoAtualizadoExeption{
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			if(f.AtualizarProduto(prod)) {
				if(CDI.atualizarFornecedor(f)) {
					 CDI.salvarCentral(CDI, "Central");
				}
			}
			 throw new  ProdutoNaoAtualizadoExeption();
		}
		throw new  UsuarioNaoEncontradaExeption();
	}
	public ArrayList<Produto> retornaArrayProduto(Fornecedor user){
		return user.retornaArrayProdutos();
	}
}
