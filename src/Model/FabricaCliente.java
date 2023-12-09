package Model;

import DTO.DtoUser;

public class FabricaCliente extends Fabrica {
	/**
	 * cria especificamente um Cliente que o mesmo carrega um DTO com valores
	 * exclusivos e necessarios para criação do mesmo.
	 */
	public boolean criar(DtoUser user) {
		pessoa = new Cliente(user);
		return pessoa.criarUser(pessoa);
	}
}
