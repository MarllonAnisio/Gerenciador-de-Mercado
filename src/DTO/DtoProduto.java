package DTO;

import Model.TipoProduto;

public class DtoProduto {

	private String name;
	private int validade;
	private TipoProduto tipoDoProduto;
	
	public TipoProduto getTipoDoProduto() {
		return tipoDoProduto;
	}
	public void setTipoDoProduto(TipoProduto tipoDoProduto) {
		this.tipoDoProduto = tipoDoProduto;
	}
	public int getValidade() {
		return validade;
	}
	public void setValidade(int validade) {
		this.validade = validade;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
