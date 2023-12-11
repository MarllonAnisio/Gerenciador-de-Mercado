package Model;

import DAO.ProdutoNaoCadastradoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DTO.DtoProduto;
import DTO.DtoUser;
/**
 * padrao Factory method utlizado para suprir as diferentes formas de criaçao
 * 
 * 
 * */
public  class Fabrica {
	Pessoa pessoa;
	Produto p;
	Loja loja;
	TaxaReajuste taxa;
	DtoProduto produto;
	
	
	public  boolean criarTipoPessoa(DtoUser user, String tipo) throws UsuarioNaoCadastradoException {
		switch (tipo) {
		
		case "FORNECEDOR":
			pessoa = new Fornecedor(user);
			break;
		case "CLIENTE":
			pessoa = new Cliente(user);
			break;
		case "ADM":
			pessoa = new ADM(user);
			break;	
		}
		return pessoa.criarUser(pessoa);	
	}
	public boolean ProdutoFornecedor(DtoProduto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoCadastradoException {
		p = new Produto();
		return p.criarProduto(p, forn);
	}
	public boolean produtoLoja(DtoProduto prod) throws ProdutoNaoCadastradoException {
		loja = new Loja();
		taxa = new TaxaReajuste(prod);
		produto = taxa.taxReajuste();
		p = new Produto(produto);
		return loja.adicionarProduto(p);
	}
	
}
