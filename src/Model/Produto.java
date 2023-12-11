package Model;

import DAO.ContratoProduto;
import DAO.ProdutoDAO;
import DAO.ProdutoNaoAtualizadoExeption;
import DAO.ProdutoNaoCadastradoException;
import DAO.ProdutoNaoExisteException;
import DAO.UsuarioNaoEncontradaExeption;
import DTO.DtoProduto;
import DTO.DtoUser;

public class Produto implements ContratoProduto {

	private String nameProduto;
	private int validade;
	private TipoProduto tipoDoProduto;
	private String descricao;
	private double valorProduto;
	private String nomeMarca;
	private double peso;
	private double valorGeral;
	private int qtdProdutos;
	private ProdutoDAO banco = new ProdutoDAO();
	Produto produto;
	/**
	 * Construtor geral de Produto, produto tem que ter todos os campos com valores pois partirá para o banco
	 * */
	public Produto() {
		
	}
	public Produto(DtoProduto prod) {
		nameProduto = prod.getNameProduto();
		qtdProdutos = prod.getQtdProdutos();
		valorGeral = prod.getValorGeral();
		peso = prod.getPeso();
		valorProduto = prod.getValorProduto();
		tipoDoProduto = prod.getTipoDoProduto();
		descricao = prod.getDescricao();
	}
	
	
	/**
	 *  parte do trajeto até o banco este fará  a criação do mesmo
	 * @throws ProdutoNaoCadastradoException 
	 * @throws UsuarioNaoEncontradaExeption 
	 * */
	public boolean criarProduto(Produto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoCadastradoException {
		return banco.criarProduto(prod,forn);
	}
	/**
	 * @throws UsuarioNaoEncontradaExeption 
	 * @throws ProdutoNaoExisteException */
	public boolean deleteProduto(DtoProduto prod,DtoUser forn) throws ProdutoNaoExisteException, UsuarioNaoEncontradaExeption {
		return banco.deleteProduto(prod,forn);
	}
	/**
	 * @throws UsuarioNaoEncontradaExeption */
	public Produto readProduto(DtoProduto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption {
		return banco.readProduto(prod,forn);
	}
	/**
	 * @throws ProdutoNaoAtualizadoExeption 
	 * @throws UsuarioNaoEncontradaExeption */
	public boolean updateProduto(Produto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoAtualizadoExeption {
		return banco.updateProduto(produto, forn);
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
	public void setNameProduto(String name) {
		this.nameProduto = name;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String desc) {
		descricao = desc;
	}
	public double getValorProduto() {
		return valorProduto;
	}
	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	public int getQtdProdutos() {
		return qtdProdutos;
	}
	public void setQtdProdutos(int qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}
	public double getValorGeral() {
		return valorGeral;
	}
	public void setValorGeral(double valorGeral) {
		this.valorGeral = valorGeral;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getNomeMarca() {
		return nomeMarca;
	}
	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}
}
