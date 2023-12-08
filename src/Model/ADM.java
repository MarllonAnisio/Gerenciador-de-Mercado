package Model;

import DAO.PessoaDAO;
import DTO.DtoUser;

public class ADM  extends Pessoa{
	PessoaDAO banco;
	public ADM(DtoUser adm) {
		super(adm);
		banco = new PessoaDAO();
	}

	@Override
	public boolean criarUser(Pessoa user) {
		return banco.criarUser(user);
	}

	@Override
	public boolean deleteUser(DtoUser pessoa) {
		return banco.deleteUserADM(pessoa);
	}

	@Override
	public ADM readUser(DtoUser pessoa) {
		return banco.readADM(pessoa);
	}
	@Override
	public boolean updateUser(Pessoa Pessoa) {
		return banco.atualizar(Pessoa);
	}

	
}

