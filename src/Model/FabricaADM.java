package Model;

import DTO.DtoUser;

public class FabricaADM extends Fabrica{
	/**
	 * cria especificamente um ADM que o mesmo carrega um DTO com valores exclusivos e necessarios para criação do mesmo.
	 * */
	public boolean criar(DtoUser user) {
		pessoa = new ADM(user);
		return pessoa.criarUser(pessoa);
	}

}
