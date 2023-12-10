package DAO;

import java.util.ArrayList;

import DTO.DtoProduto;
import Model.Produto;

public class LojaDAO {

	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();

	public boolean addProduto(Produto prod) {
		
		if (CDI.criarProduto(prod)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}

	public boolean checarProduto(DtoProduto prod) {
		if(CDI.checarProduto(prod)) {
			return true;
		}
		return false;
	}
	public Produto lerproduto(DtoProduto prod) {
		return CDI.lerProduto(prod);
	}
	public boolean removerProduto(DtoProduto prod) {
		if (CDI.deletarProduto(prod)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}
	public ArrayList<Produto> retornaProdutos() {
		return CDI.retornarProdutos();
	}

	public boolean atualizarProduto(Produto prod) {
		if (CDI.atualizarProduto(prod)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}

}
