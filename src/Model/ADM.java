package Model;

import java.util.ArrayList;

import DAO.PessoaDAO;
import DTO.DtoUser;

public class ADM  extends Pessoa{
	PessoaDAO banco;
	public ADM(DtoUser adm) {
		super(adm);
		banco = new PessoaDAO();
	}

	/**
	 * parte do trajeto até o banco este fará  a criação do mesmo
	 * */
	public boolean criarUser(Pessoa user) {
		return banco.criarUser(user);
	}


	public boolean deleteUser(DtoUser pessoa) {
		return banco.deleteUserADM(pessoa);
	}


	public ADM readUser(DtoUser pessoa) {
		return banco.readADM(pessoa);
	}

	public boolean updateUser(Pessoa Pessoa) {
		return banco.atualizar(Pessoa);
	}

	public  ArrayList<ADM> retornarArrayADM(){
		return banco.retornarArrayADM();
	}
}

