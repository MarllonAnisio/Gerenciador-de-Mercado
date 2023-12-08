package DAO;

import DTO.DtoProduto;
import DTO.DtoUser;

import Model.Produto;

public interface ContratoProduto {

	public boolean criarProduto(Produto prod,DtoUser forn);
	public boolean deleteProduto(DtoProduto prod,DtoUser forn);
	public Produto readProduto(DtoProduto prod,DtoUser forn);
	public boolean updateProduto(Produto prod,DtoUser forn);
}
