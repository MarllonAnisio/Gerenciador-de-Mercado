package DAO;

import java.util.ArrayList;

import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;

public class PessoaDAO {
	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();

	public PessoaDAO() {

	}

	public boolean criarUser(Pessoa pessoa) {

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
		return false;
	}

	public boolean deleteUserADM(DtoUser person) {
		if (CDI.removerADM(person)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}

	public boolean deleteUserFornecedor(DtoUser person) {
		if (CDI.removerFornecedor(person)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}

	public boolean deleteUserCliente(DtoUser person) {
		if (CDI.removerCliente(person)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}

	public Fornecedor readFornecedor(DtoUser user) {
		return CDI.lerFornecedor(user);

	}

	public Cliente readCliente(DtoUser user) {
		return CDI.lerCliente(user);

	}

	public ADM readADM(DtoUser user) {
		return CDI.lerADM(user);
	}

	public boolean atualizarFornecedor(Pessoa user) {
		if(CDI.atualizarFornecedor(user)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}
	public boolean atualizarADM(Pessoa user) {
		if(CDI.atualizarADM(user)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}
	public boolean atualizarCliente(Pessoa user) {
		if(CDI.atualizarCliente(user)) {
			CDI.salvarCentral(CDI, "Central");
			return true;
		}
		return false;
	}
	public boolean procureADM(DtoUser user) {
		return CDI.checagemADM(user);
	}
	public boolean procureFornecedor(DtoUser user) {
		return CDI.checagemFornecedores(user);
	}
	public boolean procureCliente(DtoUser user) {
		return CDI.checagemClientes(user);
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
