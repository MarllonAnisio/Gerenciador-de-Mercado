package Model;

import java.util.ArrayList;

import DAO.PessoaDAO;
import DAO.UsuarioJaCadrastradaException;
import DTO.DtoUser;

public class Cliente extends Pessoa {
	PessoaDAO banco;
	public Cliente(DtoUser pessoa) {
		super(pessoa);
		banco = new PessoaDAO();
	}
	/**
	 * parte do trajeto até o banco este fará  a criação do mesmo
	 * */
	public boolean criarUser(Pessoa cliente){
		return banco.criarUser(cliente);
	}
	public boolean deleteUser(DtoUser pessoa) {
		return banco.deleteUserCliente(pessoa);
	}
	
	public Pessoa readUser(DtoUser pessoa) {
		return banco.readCliente(pessoa);
	}
	
	public boolean updateUser(Pessoa Pessoa) {
		return banco.atualizar(Pessoa);
		
	}
	public ArrayList<Cliente> retornarArrayClientes(){
		return banco.retornarArrayClientes();
	}

	
	

	


}
