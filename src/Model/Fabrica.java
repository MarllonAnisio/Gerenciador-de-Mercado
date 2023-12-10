package Model;

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
	public  boolean criarTipoPessoa(DtoUser user, String tipo) {
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
	public boolean ProdutoFornecedor(DtoProduto prod,DtoUser forn) {
		p = new Produto();
		return p.criarProduto(p, forn);
	}
	public boolean produtoLoja(DtoProduto prod) {
		loja = new Loja();
		taxa = new TaxaReajuste(prod);
		produto = taxa.taxReajuste();
		p = new Produto(produto);
		return loja.adicionarProduto(p);
	}
	
}
