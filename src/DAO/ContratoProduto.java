package DAO;

import DTO.DtoProduto;
import DTO.DtoUser;

import Model.Produto;

public interface ContratoProduto {

	public boolean criarProduto(Produto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoCadastradoException;
	public boolean deleteProduto(DtoProduto prod,DtoUser forn) throws ProdutoNaoExisteException, UsuarioNaoEncontradaExeption;
	public Produto readProduto(DtoProduto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption;
	public boolean updateProduto(Produto prod,DtoUser forn) throws UsuarioNaoEncontradaExeption, ProdutoNaoAtualizadoExeption;
}
