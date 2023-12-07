package Model;

import DTO.DtoUser;

public class ADM  extends Pessoa{
	Pessoa P;
	
	public ADM(DtoUser adm) {
		super(adm);
	}
	public void criarUser(Pessoa user) {
		// TODO Auto-generated method stub
		
	}

	
	public boolean deleteUsuario(DtoUser person) {
		// Deletar um usuario ADM
		return false;
	}


	public Pessoa readUsuario(DtoUser person) {
		//ler um Usuario  ADM
		return null;
	}


	public void updateUsuario(DtoUser person) {
		// atualizar um usuario ADM do sistema
		
	}
	
}

