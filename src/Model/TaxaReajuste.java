package Model;

import DTO.DtoProduto;

public class TaxaReajuste {

	/**
	 * requisito funcional nosso que nos ajuda na hora de reestabelecer os precos na
	 * hora da criação
	 */
	public TaxaReajuste() {
		
	}

	/**
	 * metodo que faz o reajuste nos valoes do produto.
	 */
	public DtoProduto taxReajuste(DtoProduto produto) {
		if (produto.getTipoDoProduto() == TipoProduto.ALIMENTOS) {
			produto.setValorProduto(produto.getValorProduto() * 1.20);
		} else if (produto.getTipoDoProduto() == TipoProduto.BEBIDAS) {
			produto.setValorProduto(produto.getValorProduto() * 1.25);
		} else if (produto.getTipoDoProduto() == TipoProduto.BEBIDAS_ALCOOLICAS) {
			produto.setValorProduto(produto.getValorProduto() * 1.55);
		} else if (produto.getTipoDoProduto() == TipoProduto.MATERIAL_ESCOLAR) {
			produto.setValorProduto(produto.getValorProduto() * 1.45);
		} else if (produto.getTipoDoProduto() == TipoProduto.HIGIENE) {
			produto.setValorProduto(produto.getValorProduto() * 1.20);
		}

		return produto;
	}


}
