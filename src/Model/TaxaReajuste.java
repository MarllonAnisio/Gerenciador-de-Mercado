package Model;

import DTO.DtoProduto;

public class TaxaReajuste {

	private DtoProduto produto;
	/**
	 * requisito funcional nosso que nos ajuda na hora de reestabelecer os precos na 
	 * hora da criação
	 * */
	public TaxaReajuste(DtoProduto prod) {
		setProduto(prod);
	}
	public DtoProduto taxReajuste() {
		if(produto.getTipoDoProduto() == TipoProduto.ALIMENTOS) {
			produto.setValorProduto(produto.getValorProduto() * 1.20);
		}
		else if(produto.getTipoDoProduto() == TipoProduto.BEBIDAS) {
			produto.setValorProduto(produto.getValorProduto() * 1.25);
		}
		else if(produto.getTipoDoProduto() == TipoProduto.BEBIDAS_ALCOOLICAS) {
			produto.setValorProduto(produto.getValorProduto() * 1.55);
		}
		else if(produto.getTipoDoProduto() == TipoProduto.MATERIAL_ESCOLAR) {
			produto.setValorProduto(produto.getValorProduto() * 1.45);
		}
		else if(produto.getTipoDoProduto() == TipoProduto.HIGIENE) {
			produto.setValorProduto(produto.getValorProduto() * 1.20);
		}
		
		return produto;
	}
	
	
	public DtoProduto getProduto() {
		return produto;
	}

	public void setProduto(DtoProduto produto) {
		this.produto = produto;
	}
	
}
