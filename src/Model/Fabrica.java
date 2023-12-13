package Model;

import DAO.PessoaDAO;
import DAO.UsuarioNaoCadastradoException;
import DTO.DtoUser;

/**
 * padrao Factory method utlizado para suprir as diferentes formas de criaçao
 * 
 * 
 * */
public abstract class Fabrica {
	Pessoa pessoa;
	PessoaDAO banco;

	public  abstract boolean criarTipoPessoa(DtoUser user) throws UsuarioNaoCadastradoException;

	
	
}
