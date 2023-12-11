package DAO;

import java.util.ArrayList;

import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;

public class PessoaDAO {
	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();
	Fornecedor f;
	Cliente c;
	ADM a;
	public PessoaDAO() {

	}
//	throws UsuarioNaoCadastradoException
//	throws UsuarioNaoExistenteException
//	throws UsuarioNaoEncontradaExeption
//	 throws UsuarioNaoAtualizadoException

	public boolean criarUser(Pessoa pessoa) throws UsuarioNaoCadastradoException{

		if (pessoa instanceof Cliente) {
			if (CDI.adicionarCliente(pessoa)) {
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		} else if (pessoa instanceof ADM) {
			if (CDI.adicionarADM(pessoa)) {
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		} else if (pessoa instanceof Fornecedor) {
			if (CDI.adicionarFornecedor(pessoa)) {
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		}
		throw new  UsuarioNaoCadastradoException();
	}

	public boolean deleteUserADM(DtoUser person) throws UsuarioNaoExistenteException{
		if (CDI.removerADM(person)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new UsuarioNaoExistenteException();
	}

	public boolean deleteUserFornecedor(DtoUser person) throws UsuarioNaoExistenteException{
		if (CDI.removerFornecedor(person)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new  UsuarioNaoExistenteException();	}

	public boolean deleteUserCliente(DtoUser person) throws UsuarioNaoExistenteException {
		if (CDI.removerCliente(person)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new  UsuarioNaoExistenteException();
	}

	public Fornecedor readFornecedor(DtoUser user) throws UsuarioNaoEncontradaExeption{
		f = CDI.lerFornecedor(user);
		if(f != null) {
			return f;
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public Cliente readCliente(DtoUser user) throws UsuarioNaoEncontradaExeption{
		c =CDI.lerCliente(user);
		if(c != null) {
			return c;
		}
		throw new UsuarioNaoEncontradaExeption();

	}

	public ADM readADM(DtoUser user) throws UsuarioNaoEncontradaExeption{
		a =  CDI.lerADM(user);
		if(a != null) {
			return a;
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public boolean atualizarFornecedor(Pessoa user) throws UsuarioNaoAtualizadoException {
		if(CDI.atualizarFornecedor(user)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new UsuarioNaoAtualizadoException();
	}
	public boolean atualizarADM(Pessoa user) throws UsuarioNaoAtualizadoException{
		if(CDI.atualizarADM(user)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new UsuarioNaoAtualizadoException();
	}
	public boolean atualizarCliente(Pessoa user) throws UsuarioNaoAtualizadoException {
		if(CDI.atualizarCliente(user)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		throw new UsuarioNaoAtualizadoException();
	}
	public boolean procureADM(DtoUser user) throws UsuarioNaoEncontradaExeption{
		if(CDI.checagemADM(user)) {
			return true;
		}
		throw new UsuarioNaoEncontradaExeption();
		
	}
	public boolean procureFornecedor(DtoUser user)  throws UsuarioNaoEncontradaExeption{
		if(CDI.checagemFornecedores(user)) {
			return true;
		}
		throw new UsuarioNaoEncontradaExeption();
	}
	public boolean procureCliente(DtoUser user) throws UsuarioNaoEncontradaExeption {
		if(CDI.checagemClientes(user)) {
		return true;
		}
		throw new UsuarioNaoEncontradaExeption();
	}
	
	public ArrayList<Fornecedor> retornaArrayFornecedor() {
		return CDI.retornaArrayFornecedor();
	}

	public ArrayList<Cliente> retornarArrayClientes() {
		return CDI.retornarArrayClientes();
	}

	public ArrayList<ADM> retornarArrayADM() {
		return CDI.retornarArrayADM();
	}

}
