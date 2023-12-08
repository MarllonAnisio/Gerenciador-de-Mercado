package Model;

import DTO.DtoUser;

public class FabricaCliente implements Fabrica{
	private Pessoa cliente;
	
	public boolean criar(DtoUser user) {
		cliente = new Cliente(user);
		return cliente.criarUser(cliente);
	}


}
