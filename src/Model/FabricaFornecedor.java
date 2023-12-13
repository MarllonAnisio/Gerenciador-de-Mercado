package Model;

import DAO.PessoaDAO;
import DAO.UsuarioNaoCadastradoException;
import DTO.DtoUser;

public class FabricaFornecedor extends Fabrica{

	@Override
	public boolean criarTipoPessoa(DtoUser user) throws UsuarioNaoCadastradoException {
		pessoa = new Fornecedor(user);
		banco = new PessoaDAO();
		return banco.adicionarFornecedor(pessoa);
	}

}
