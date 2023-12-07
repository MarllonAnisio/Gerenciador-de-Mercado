package Model;

import DTO.DtoUser;

public class FabricaCliente implements Fabrica{
	Pessoa cliente;
	
	public void criar(DtoUser user) {
		cliente = new Cliente(user);
		cliente.criarUser(cliente);
	}


}
