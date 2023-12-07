package Model;

import DAO.PessoaDAO;
import DAO.UsuarioJaCadrastradaException;
import DTO.DtoUser;

public class Cliente extends Pessoa {
	PessoaDAO banco;
	public Cliente(DtoUser pessoa) {
		super(pessoa);
		
	}
	public void criarUser(Pessoa cliente){
		banco = new PessoaDAO();
		banco.criarUser(cliente);
	}

	
	public boolean deleteUsuario(Pessoa person) {
		// Deletar um usuario
		return false;
	}


	public Pessoa readUsuario(Pessoa pessoa) {
		//ler um Usuario 
		return null;
	}


	public void updateUsuario() {
		// atualizar um usuario cliente do sistema
		
	}

	


}
