package Model;


import java.util.ArrayList;

import DAO.ProdutoDoFornecedorDAO;
import DAO.ProdutoNaoAtualizadoExeption;
import DAO.ProdutoNaoEncontradoException;
import DAO.ProdutoNaoExisteException;
import DAO.UsuarioNaoEncontradaExeption;
import DTO.DtoProduto;
import DTO.DtoUser;

public class Produto  {

	private String nameProduto;
	private TipoProduto tipoDoProduto;
	private String descricao;
	private double valorProduto;
	private String nomeMarca;
	private int qtdProdutos;
	
	ProdutoDoFornecedorDAO banco;
	/**
	 * Construtor geral de Produto, produto tem que ter todos os campos com valores pois partirá para o banco
	 * */
	public Produto() {
		
	}
	public Produto(DtoProduto prod) {
		setNameProduto(prod.getNameProduto());
		setQtdProdutos(prod.getQtdProdutos());
		setValorProduto(prod.getValorProduto());
		setTipoDoProduto(prod.getTipoDoProduto());
		setDescricao(prod.getDescricao());
		setNomeMarca(prod.getNomeMarca());
	}
	/**
	 * @throws UsuarioNaoEncontradaExeption 
	 * @throws ProdutoNaoExisteException */
	public boolean deleteProduto(DtoProduto prod,DtoUser forn) throws ProdutoNaoExisteException, UsuarioNaoEncontradaExeption {
		banco = new ProdutoDoFornecedorDAO();
		return banco.deleteProduto(prod,forn);
	}
	/**
	 * @throws UsuarioNaoEncontradaExeption */
	public Produto readProduto(DtoProduto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption {
		banco = new ProdutoDoFornecedorDAO();
		return banco.readProduto(prod,forn);
	}
	/**
	 * @throws ProdutoNaoAtualizadoExeption 
	 * @throws UsuarioNaoEncontradaExeption */
	public boolean updateProduto(Produto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoAtualizadoExeption {
		banco = new ProdutoDoFornecedorDAO();
		return banco.updateProduto(prod, forn);
	}
	public ArrayList<Produto> produtosFornecedor(DtoUser user) throws UsuarioNaoEncontradaExeption{
		banco = new ProdutoDoFornecedorDAO();
		return banco.retornaArrayProduto(user);
	}
	public boolean checagemProduto(DtoProduto prod, DtoUser user) throws ProdutoNaoEncontradoException, UsuarioNaoEncontradaExeption {
		banco = new ProdutoDoFornecedorDAO();
		return banco.checarProduto(prod, user);
	
	}
	public String getNameProduto() {
		return nameProduto;
	}
	public void setNameProduto(String nameProduto) {
		this.nameProduto = nameProduto;
	}
	public TipoProduto getTipoDoProduto() {
		return tipoDoProduto;
	}
	public void setTipoDoProduto(TipoProduto tipoDoProduto) {
		this.tipoDoProduto = tipoDoProduto;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
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
	public int getQtdProdutos() {
		return qtdProdutos;
	}
	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}
}
