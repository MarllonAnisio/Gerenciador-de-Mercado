package Model;

import java.util.ArrayList;

import DAO.PessoaDAO;
import DAO.UsuarioNaoAtualizadoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoUser;

public class Cliente extends Pessoa {
	PessoaDAO banco = new PessoaDAO();;
	public Cliente(DtoUser pessoa) {
		super(pessoa);
	}
	public Cliente() {
		
	}
	
	public boolean deleteUser(DtoUser pessoa) throws UsuarioNaoExistenteException {
		return banco.removerCliente(pessoa);
	}
	
	public Pessoa readUser(DtoUser pessoa) throws UsuarioNaoEncontradaExeption {
		return banco.lerCliente(pessoa);
	}
	
	public boolean updateUser(Pessoa Pessoa) throws UsuarioNaoAtualizadoException, UsuarioNaoEncontradaExeption {
		return banco.atualizarCliente(Pessoa);
		
	}
	public ArrayList<Cliente> retornarArrayClientes(){
		return banco.retornarArrayClientes();
	}
	public boolean procuraCliente(DtoUser user) throws UsuarioNaoEncontradaExeption {
		return banco.checagemClientes(user);
	}

	
	

	


}
