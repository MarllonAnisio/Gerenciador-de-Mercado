package DAO;

import java.util.ArrayList;

import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;

/**
 * Central onde todas as nossas informacoes estão 
 * 
 * 
 * */
public class CentralDeInformacoes {
	private ArrayList<ADM> administradores = new ArrayList<ADM>();
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	private ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	public boolean checagemClientes(Pessoa user) {
		for(Cliente x: clientes) {
			if(user.getEmail().equals(x.getEmail())) {
				return true;
			}
		}
		return false; 
	}
	public boolean checagemFornecedores(Pessoa user) {
		for(ADM x: administradores) {
			if(user.getEmail().equals(x.getEmail())) {
				return true;
			}
		}
		return false;
	}
	public boolean checagemADM(Pessoa user) {
		for(ADM x: administradores) {
			if(user.getEmail().equals(x.getEmail())) {
				return false;
			}
		}
		return false;
	}
	
	public boolean adicionarCliente(Pessoa person) {
		if(checagemClientes(person)){
			return false;
		}		
		clientes.add((Cliente) person);
		return true;
	}
	public boolean adicionarADM(Pessoa person) {
		if(checagemADM(person)) {
			return false;
		}
		administradores.add((ADM) person);
		return true;
	}
	public boolean adicionarFornecedor(Pessoa person) {
		if(checagemFornecedores(person)) {
			return false;
		}
		fornecedores.add((Fornecedor) person);
		return true;
	}
	public boolean removerCliente(DtoUser p) {
		
		
		
		return true;
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
		clientes.add(x);	}
	public ArrayList<Fornecedor> getFornecedores() {
		return fornecedores;
	}
	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}
}
