package Model;

import DAO.PessoaDAO;
import DAO.UsuarioNaoCadastradoException;
import DTO.DtoUser;

public class FabricaCliente extends Fabrica{

	@Override
	public boolean criarTipoPessoa(DtoUser user) throws UsuarioNaoCadastradoException {
		pessoa = new Cliente(user);
		banco = new PessoaDAO();
		return banco.adicionarCliente(pessoa);
		
	}

	
}
