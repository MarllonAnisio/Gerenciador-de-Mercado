package Model;

import DTO.DtoUser;

public class FabricaFornecedor extends Fabrica {
	/**
	 * cria especificamente um fornecedor que o mesmo carrega um DTO com valores exclusivos e necessarios para criação do mesmo.
	 * */
	public boolean criar(DtoUser user) {
		pessoa = new Fornecedor(user);
		return pessoa.criarUser(pessoa);
	}
}
