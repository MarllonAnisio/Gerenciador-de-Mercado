package DAO;

import Model.Produto;

public class LojaDAO {
	
	
	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();
	
	public boolean addProduto(Produto prod) {
		if(CDI.criarProduto(prod)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}
	
}
