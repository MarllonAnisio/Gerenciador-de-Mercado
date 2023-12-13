package Model;

import DAO.PessoaDAO;
import DAO.UsuarioNaoCadastradoException;
import DTO.DtoUser;

public class FabricaADM extends Fabrica{

	@Override
	public boolean criarTipoPessoa(DtoUser user) throws UsuarioNaoCadastradoException {
		pessoa = new ADM(user);
		banco = new PessoaDAO();
		return banco.adicionarADM(pessoa);
	
	}

	
}
