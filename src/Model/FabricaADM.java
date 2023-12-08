package Model;

import DTO.DtoUser;

public class FabricaADM implements Fabrica{
	private Pessoa adm;
	
	public boolean criar(DtoUser user) {
		adm = new ADM(user);
		return adm.criarUser(adm);
	}

}
