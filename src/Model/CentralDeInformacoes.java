package Model;

import java.util.ArrayList;


public class CentralDeInformacoes {
	private ArrayList<ADM> administradores = new ArrayList<ADM>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
	/**
	public boolean adicionarCliente(Pessoa person) {
		for(Pessoa x: clientes) {
			if(person.getEmail().equals(x.getEmail())) {
				return false;
			}
			
		}
		clientes.add((Cliente) person);
		return true;
	}
	*/
	/**
	 * primeiro ponto da central que ira guardar nossos usuarios, Fornecedores etc...
	 * 
	 * */
	
	public ArrayList<ADM> getAdministradores() {
		return administradores;
	}
	public void setAdministradores(ArrayList<ADM> administradores) {
		this.administradores = administradores;
	}
	public ArrayList<Cliente> getClientes() {
		return clientes;
	}
	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
	}
	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		
		
		this.fornecedores = fornecedores;
	}

}
