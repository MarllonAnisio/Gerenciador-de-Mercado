package Model;

import DTO.DtoUser;

public class FabricaFornecedor implements Fabrica {

	private Pessoa fornecedor;
	
	public boolean criar(DtoUser user) {
		fornecedor = new Fornecedor(user);
		return fornecedor.criarUser(fornecedor);
	}

}
