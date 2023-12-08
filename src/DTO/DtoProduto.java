package DTO;

import Model.TipoProduto;

public class DtoProduto {

	private String nameProduto;
	private int validade;
	private TipoProduto tipoDoProduto;
	private String Descricao;
	private double valorProduto;
	private String nomeMarca;
	private double peso;
	private double valorGeral;
	private int qtdProdutos;
	public DtoProduto() {
		
	}
	/**
	 * Construtor cheio terá que ser assim para adicionarmos nosso produto
	 * */
	public DtoProduto(String nomeProd,double valorGeral,
			double valor,String marca,TipoProduto tipo,
			String descricao,int quantidade,double peso) {
		
		setTipoDoProduto(tipo);
		setName(nomeProd);
		setQtdProdutos(quantidade);
		setPeso(peso);
		setDescricao(descricao);
		setValorGeral(valorGeral);
		setValorProduto(valor);
		setNomeMarca(marca);
		
	}
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
	public String getNameProduto() {
		return nameProduto;
	}
	public void setName(String name) {
		this.nameProduto = name;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public double getValorGeral() {
		return valorGeral;
	}
	public void setValorGeral(double valorGeral) {
		this.valorGeral = valorGeral;
	}
	public int getQtdProdutos() {
		return qtdProdutos;
	}
	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}
}
