package DAO;



import DTO.DtoProduto;
import DTO.DtoUser;
import Model.Fornecedor;
import Model.Produto;

public class ProdutoDAO implements ContratoProduto{

	
	
	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();
	Fornecedor f;
	
	public boolean criarProduto(Produto prod, DtoUser forn) {
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			if(f.adicionarProduto(prod)) {
				if(CDI.atualizar(f)) {
					 CDI.salvarCentral(CDI, "Central");
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean deleteProduto(DtoProduto prod, DtoUser forn) {
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			if(f.removerProduto(prod)) {
				if(CDI.atualizar(f)) {
					 CDI.salvarCentral(CDI, "Central");
				}
			}
		}
		return false;
	}
	
	public Produto readProduto(DtoProduto prod, DtoUser forn) {
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			return f.lerProduto(prod);	
		}
		return null;
	}
	public boolean updateProduto(Produto prod, DtoUser forn) {
		f = CDI.lerFornecedor(forn);
		if(f != null) {
			if(f.AtualizarProduto(prod)) {
				if(CDI.atualizar(f)) {
					 CDI.salvarCentral(CDI, "Central");
				}
			}
		}
		return false;
	}

}
