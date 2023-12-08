package Model;

import DTO.DtoUser;

public class FabricaADM implements Fabrica{
	private Pessoa adm;
	/**
	 * cria especificamente um ADM que o mesmo carrega um DTO com valores exclusivos e necessarios para criação do mesmo.
	 * */
	public boolean criar(DtoUser user) {
		adm = new ADM(user);
		return adm.criarUser(adm);
	}

}
