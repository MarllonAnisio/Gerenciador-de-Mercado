package DAO;


import DTO.DtoProduto;
import Model.Produto;
/**
 * interface para gerar crud de produtos
 * 
 * versão não final!!
 * 
 * 
 * 
 * */
public interface ContratoProdutoDAO {

	public void createProduto(Produto p);
	public boolean deleteProduto(DtoProduto p);
	public Produto readProduto(DtoProduto p);
	public void updateProduto(DtoProduto p);
	
}
