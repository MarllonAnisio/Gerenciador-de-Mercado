package Model;

import java.util.ArrayList;

import DAO.PessoaDAO;
import DAO.UsuarioNaoAtualizadoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoUser;

public class ADM  extends Pessoa{
	PessoaDAO banco = new PessoaDAO();
	public ADM(DtoUser adm) {
		super(adm);
	
	}
	
	public ADM() {
		
	}

	/**
	 * parte do trajeto até o banco este fará  a criação do mesmo
	 * @throws UsuarioNaoCadastradoException 
	 * */
	

	public boolean deleteUser(DtoUser pessoa) throws UsuarioNaoExistenteException {
		return banco.removerADM(pessoa);
	}
	public ADM readUser(DtoUser pessoa) throws UsuarioNaoEncontradaExeption {
		return banco.lerADM(pessoa);
	}

	public boolean updateUser(Pessoa Pessoa) throws UsuarioNaoAtualizadoException, UsuarioNaoEncontradaExeption {
		return banco.atualizarADM(Pessoa);
	}

	public  ArrayList<ADM> retornarArrayADM(){
		return banco.retornarArrayADM();
	}
	public boolean procureADM(DtoUser user) throws UsuarioNaoEncontradaExeption {
		return banco.checagemADM(user);
	}
}

