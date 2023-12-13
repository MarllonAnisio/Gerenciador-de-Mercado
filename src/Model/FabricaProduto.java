package Model;

import DAO.LojaDAO;
import DAO.ProdutoDoFornecedorDAO;
import DAO.ProdutoNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DTO.DtoProduto;
import DTO.DtoUser;

public class FabricaProduto {
	private LojaDAO loja;
	private ProdutoDoFornecedorDAO produtoFornecedor;
	private Produto produto;
	private TaxaReajuste taxa;
	
	
	public boolean ProdutoFornecedor(DtoProduto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoCadastradoException {
		produto = new Produto();
		return produtoFornecedor.criarProduto(produto, forn);
	}
	
	public boolean produtoLoja(DtoProduto prod) throws ProdutoNaoCadastradoException {
		loja = new LojaDAO();
		taxa = new TaxaReajuste();
		prod = taxa.taxReajuste(prod);
		produto = new Produto(prod);
		return loja.AdicionarProduto(produto);
		
	}
}
