package Model;

import DTO.DtoUser;

public class FabricaCliente implements Fabrica {
	private Pessoa cliente;

	/**
	 * cria especificamente um Cliente que o mesmo carrega um DTO com valores
	 * exclusivos e necessarios para criação do mesmo.
	 */
	public boolean criar(DtoUser user) {
		cliente = new Cliente(user);
		return cliente.criarUser(cliente);
	}

}
