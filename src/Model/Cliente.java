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
	/**
	 * parte do trajeto até o banco este fará  a criação do mesmo
	 * @throws UsuarioNaoCadastradoException 
	 * */
	public boolean criarUser(Pessoa cliente) throws UsuarioNaoCadastradoException{
		return banco.criarUser(cliente);
	}
	public boolean deleteUser(DtoUser pessoa) throws UsuarioNaoExistenteException {
		return banco.deleteUserCliente(pessoa);
	}
	
	public Pessoa readUser(DtoUser pessoa) throws UsuarioNaoEncontradaExeption {
		return banco.readCliente(pessoa);
	}
	
	public boolean updateUser(Pessoa Pessoa) throws UsuarioNaoAtualizadoException {
		return banco.atualizarCliente(Pessoa);
		
	}
	public ArrayList<Cliente> retornarArrayClientes(){
		return banco.retornarArrayClientes();
	}
	public boolean procuraCliente(DtoUser user) throws UsuarioNaoEncontradaExeption {
		return banco.procureCliente(user);
	}

	
	

	


}
