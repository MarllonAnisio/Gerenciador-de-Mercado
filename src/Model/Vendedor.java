package Model;

import DTO.DtoUser;
/**
 *  classe nao oficial.
 * 
 * 
 * 
*/
public class Vendedor extends Pessoa{
	
	
	
	
	/**
	 * transmitindo dados para classe pai para 
	 * */
	public Vendedor(DtoUser vendedor) {
		super(vendedor);
	}
	
	public void createUsuario(Pessoa person) {
		// criar um usuario vendedor 
	}

	
	public boolean deleteUsuario(Pessoa person) {
		// Deletar um usuario vendedor
		return false;
	}


	public Pessoa readUsuario(Pessoa pessoa) {
		//ler um Usuario vendedor
		return null;
	}


	public void updateUsuario() {
		// atualizar um usuario vendedor do sistema
		
	}
	

	

	

}
