package Controler;

import DTO.DtoProduto;
import DTO.DtoUser;
import Model.Fabrica;
import Model.FabricaFornecedor;
import Model.Fornecedor;
import Model.Pessoa;
import Model.Produto;
public class FacadeFornAndProd {
	private Fornecedor fo;
	private Fabrica fabrica;
	private Produto p;
	public void criarFornecedor(DtoUser user) {
		fabrica = new FabricaFornecedor();
		fabrica.criar(user);
	}
	public void deleteUserFornecedor(DtoUser person) {
		fo.deleteUser(person);
	}
	public Fornecedor readFornecedor(DtoUser user) {
		fo =  (Fornecedor) fo.readUser(user);
		if(fo != null) {
			return fo;
		}
		return null;
	}
	public void atualizarfornecedor(Fornecedor p) {
		fo.updateUser(p);
		
	}
	
	
	

 	public void criarProduto(Produto prod,DtoUser forn) {
		p.criarProduto(prod, forn);
	}
	public Produto lerProduto(DtoProduto prod,DtoUser forn) {
		return p.readProduto(prod, forn);
	}
	public void deletarProduto(DtoProduto prod,DtoUser forn) {
		p.deleteProduto(prod, forn);	
	}
	public void editarProduto(DtoProduto prod,DtoUser forn) {
		p.updateProduto(p, forn);
		
	}




}
