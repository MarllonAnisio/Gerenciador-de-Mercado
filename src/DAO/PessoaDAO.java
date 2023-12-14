package DAO;

import java.util.ArrayList;

import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;

public class PessoaDAO {
	CentralDeInformacoes CDI;
	
	public PessoaDAO() {
		CDI = CentralDeInformacoes.getInstance();
	}
	

	public boolean adicionarADM(Pessoa user) throws UsuarioNaoCadastradoException{
		for (ADM x : CDI.administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				throw new  UsuarioNaoCadastradoException();
			}
		}
		if(CDI.administradores == null) {
			CDI.administradores.add((ADM) user);
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		CDI.administradores.add((ADM) user);
		CDI.salvarCentral(CDI, "Central");
		return true;
	}
	
	public boolean adicionarFornecedor(Pessoa user) throws UsuarioNaoCadastradoException{
		for (Fornecedor fornecedor : CDI.fornecedores) {
			if (fornecedor.getCnpj() == user.getCnpj()) {
				throw new  UsuarioNaoCadastradoException();
			}
			
			CDI.fornecedores.add((Fornecedor) user);
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		if(CDI.fornecedores == null) {
			CDI.fornecedores.add((Fornecedor) user);
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		CDI.fornecedores.add((Fornecedor) user);
		CDI.salvarCentral(CDI, "Central");
		return true;
	}
	
	public boolean adicionarCliente(Pessoa user) throws UsuarioNaoCadastradoException{
		if(CDI.clientes == null) {
			CDI.clientes.add((Cliente) user);
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		
		for (Cliente x : CDI.clientes) {
			if (user.getCpf() == x.getCpf()) {
				throw new  UsuarioNaoCadastradoException();
			}
		}
		CDI.clientes.add((Cliente) user);
		CDI.salvarCentral(CDI, "Central");
		return true;
	}
	
	

	public boolean removerCliente(DtoUser user) throws  UsuarioNaoExistenteException{
		for (Cliente x : CDI.clientes) {
			if (user.getCpf() == x.getCpf()) {
				CDI.clientes.remove(x);
				return true;
			}
		}
		throw new  UsuarioNaoExistenteException();
	}

	public boolean removerADM(DtoUser user)  throws  UsuarioNaoExistenteException{
		for (ADM x : CDI.administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				CDI.administradores.remove(x);
				return true;
			}
		}
		throw new  UsuarioNaoExistenteException();
	}

	public boolean removerFornecedor(DtoUser user) throws  UsuarioNaoExistenteException {
		for (Fornecedor x : CDI.fornecedores) {
			if (user.getCnpj() == x.getCnpj()) {
				CDI.fornecedores.remove(x);
				return true;
			}
		}
		throw new  UsuarioNaoExistenteException();
	}
	
	public Cliente lerCliente(DtoUser user) throws UsuarioNaoEncontradaExeption{
		for (Cliente x : CDI.clientes) {
			if (user.getCpf() == x.getCpf()) {
				return x;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public Fornecedor lerFornecedor(DtoUser user) throws UsuarioNaoEncontradaExeption {
		for (Fornecedor x : CDI.fornecedores) {
			if (user.getCnpj() == x.getCnpj()) {
				return x;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
		
	}

	public ADM lerADM(DtoUser user) throws UsuarioNaoEncontradaExeption {
		for (ADM x : CDI.administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				return x;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public boolean atualizarFornecedor(Pessoa user)  throws  UsuarioNaoEncontradaExeption{
		for (Fornecedor x : CDI.fornecedores) {
			if (user.getCnpj() == x.getCnpj()) {
				CDI.fornecedores.remove(x);
				x = (Fornecedor) user;
				CDI.fornecedores.add(x);
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public boolean atualizarADM(Pessoa user) throws  UsuarioNaoEncontradaExeption {
		for (ADM x : CDI.administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				CDI.administradores.remove(x);
				x = (ADM) user;
				CDI.administradores.add(x);
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public boolean atualizarCliente(Pessoa user) throws  UsuarioNaoEncontradaExeption{
		for (Cliente x : CDI.clientes) {
			if (user.getCpf() == x.getCpf()) {
				CDI.clientes.remove(x);
				x = (Cliente) user;
				CDI.clientes.add(x);
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
	}
	
	public boolean checagemClientes(DtoUser user)  throws UsuarioNaoEncontradaExeption {
		for (Cliente x : CDI.clientes) {
			if (x.getCpf() == user.getCpf()) {
				return true;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public boolean checagemFornecedores(DtoUser user) throws UsuarioNaoEncontradaExeption  {
		for (Fornecedor fornecedor : CDI.fornecedores) {
			if (user.getCnpj() == fornecedor.getCnpj()) {
				return true;
			}
		}
		throw new UsuarioNaoEncontradaExeption();
	}

	public boolean checagemADM(DtoUser user) throws UsuarioNaoEncontradaExeption {
		for (ADM adm : CDI.administradores) {
			if (user.getEmail().equals(adm.getEmail()) && adm.getSenha().equals(user.getSenha())) {
				return true;
			}
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
