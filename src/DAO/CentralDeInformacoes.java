package DAO;

import java.util.ArrayList;

import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;

/**
 * Central onde todas as nossas informacoes estão armazenadas
 * 
 * 
 */
public class CentralDeInformacoes {
	private volatile static CentralDeInformacoes instance;
	private static Persistencia banco = new Persistencia();
	/**
	 * Array que armazena todos os nossos Administradores.
	 */
	private ArrayList<ADM> administradores = new ArrayList<ADM>();
	/**
	 * array que armazena todos os nossos Clientes.
	 */
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	/**
	 * Array que armazena todos os nossos Fornecedores.
	 */
	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	/**
	 * Construtor privado pela classe ter adotado o padrao Singleton.
	 */
	private CentralDeInformacoes() {

	}

	/**
	 * retorno da instancia, so pode haver simultaniamente 1(uma) unica central.
	 */
	public static CentralDeInformacoes getInstance() {
		/**
		 * ligação com a persistencia para receber nossa central em XMl retornando nossa
		 * Central guardada.
		 */
		instance = banco.recuperarCentral("Central");
		/**
		 * Primeira checagem para saber se está com nossa central
		 */
		if (instance == null) {
			synchronized (Persistencia.class) {

				if (instance == null) {
					instance = new CentralDeInformacoes();
				}
			}
		}
		return instance;
	}

	public boolean checagemClientes(DtoUser user) {
		for (Cliente x : clientes) {
			if (x.getCpf() == user.getCpf()) {
				return true;
			}
		}
		return false;
	}

	public boolean checagemFornecedores(DtoUser user) {
		for (Fornecedor fornecedor : fornecedores) {
			if (user.getEmail().equals(fornecedor.getEmail()) || user.getCnpj() == fornecedor.getCnpj()) {
				return true;
			}
		}
		return false;
	}

	public boolean checagemADM(DtoUser user) {
		for (ADM adm : administradores) {
			if (user.getEmail().equals(adm.getEmail()) && adm.getSenha().equals(user.getSenha())) {
				return true;
			}
		}
		return false;
	}

	public boolean adicionarCliente(Pessoa user) {
		for (Cliente x : clientes) {
			if (user.getEmail().equals(x.getEmail())) {
				return false;
			}
		}
		clientes.add((Cliente) user);
		return true;
	}

	public boolean adicionarADM(Pessoa user) {
		for (ADM x : administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				return false;
			}
		}
		administradores.add((ADM) user);
		return true;
	}

	public boolean adicionarFornecedor(Pessoa user) {
		for (Fornecedor fornecedor : fornecedores) {
			if (user.getEmail().equals(fornecedor.getEmail()) && fornecedor.getSenha().equals(user.getSenha())) {
				return false;
			}
		}
		fornecedores.add((Fornecedor) user);
		return true;
	}

	public boolean removerCliente(DtoUser user) {
		for (Cliente x : clientes) {
			if (user.getEmail().equals(x.getEmail())) {
				clientes.remove(x);
				return true;
			}
		}
		return false;
	}

	public boolean removerADM(DtoUser user) {
		for (ADM x : administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				administradores.remove(x);
				return true;
			}
		}
		return false;
	}

	public boolean removerFornecedor(DtoUser user) {
		for (Fornecedor x : fornecedores) {
			if (user.getEmail().equals(x.getEmail())) {
				fornecedores.remove(x);
				return true;
			}
		}
		return false;
	}

	public Cliente lerCliente(DtoUser user) {
		for (Cliente x : clientes) {
			if (user.getEmail().equals(x.getEmail())) {
				return x;
			}
		}
		return null;
	}

	public Fornecedor lerFornecedor(DtoUser user) {
		for (Fornecedor x : fornecedores) {
			if (user.getEmail().equals(x.getEmail())) {
				return x;
			}
		}
		return null;
	}

	public ADM lerADM(DtoUser user) {
		for (ADM x : administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				return x;
			}
		}
		return null;
	}

	public boolean atualizar(Pessoa user) {
		if (user instanceof Cliente) {
			for (Cliente x : clientes) {
				if (user.getEmail().equals(x.getEmail())) {
					clientes.remove(x);
					x = (Cliente) user;
					clientes.add(x);
					return true;
				}
			}
		} else if (user instanceof ADM) {
			for (ADM x : administradores) {
				if (user.getEmail().equals(x.getEmail())) {
					administradores.remove(x);
					x = (ADM) user;
					administradores.add(x);
					return true;
				}
			}
		} else if (user instanceof Fornecedor) {
			for (Fornecedor x : fornecedores) {
				if (user.getEmail().equals(x.getEmail())) {
					fornecedores.remove(x);
					x = (Fornecedor) user;
					fornecedores.add(x);
					return true;
				}
			}
		}
		return false;
	}
	public boolean atualizarFornecedor(Fornecedor user) {
		for (Fornecedor x : fornecedores) {
			if (user.getEmail().equals(x.getEmail())) {
				fornecedores.remove(x);
				x = (Fornecedor) user;
				fornecedores.add(x);
				return true;
		}
	}
	return false;
	}
	public boolean atualizarADM(ADM user) {
		for (ADM x : administradores) {
			if (user.getEmail().equals(x.getEmail())) {
				administradores.remove(x);
				x = (ADM) user;
				administradores.add(x);
				return true;
			}
		}
		return false;
	}
	public boolean atualizarCliente(Cliente user) {
		for (Cliente x : clientes) {
			if (user.getEmail().equals(x.getEmail())) {
				clientes.remove(x);
				x = (Cliente) user;
				clientes.add(x);
				return true;
			}
		}
		return false;
	}

	
	public  ArrayList<Fornecedor> retornaArrayFornecedor(){
		return getFornecedores();
	}
	public ArrayList<Cliente> retornarArrayClientes(){
		return getClientes();
	}
	public  ArrayList<ADM> retornarArrayADM(){
		return getAdministradores();
	}

	public String toString() {
		return "CentralDeInformacoes [administradores=" + administradores + ", clientes=" + clientes + ", fornecedores="
				+ fornecedores + "]";
	}

	public ArrayList<ADM> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(ArrayList<ADM> administradores) {
		this.administradores = administradores;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Cliente x) {
		clientes.add(x);
	}

	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void salvarCentral(CentralDeInformacoes cDI, String string) {
		banco.salvarCentral(cDI, null);
	}
}
