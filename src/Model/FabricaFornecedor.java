package Model;

import DTO.DtoUser;

public class FabricaFornecedor implements Fabrica {

	private Pessoa fornecedor;
	/**
	 * cria especificamente um fornecedor que o mesmo carrega um DTO com valores exclusivos e necessarios para criação do mesmo.
	 * */
	public boolean criar(DtoUser user) {
		fornecedor = new Fornecedor(user);
		return fornecedor.criarUser(fornecedor);
	}
}
