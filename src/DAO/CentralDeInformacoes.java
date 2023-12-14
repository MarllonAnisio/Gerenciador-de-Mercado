package DAO;

import java.util.ArrayList;

import DTO.DtoProduto;
import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;
import Model.Produto;

/**
 * Central onde todas as nossas informacoes estão armazenadas
 * 
 * 
 */
public class CentralDeInformacoes {
	private volatile static CentralDeInformacoes instance;
	private static Persistencia banco = new Persistencia();
	private double saldo;
	/**
	 * Array que armazena todos os nossos Administradores.
	 */
	protected ArrayList<ADM> administradores = new ArrayList<ADM>();
	/**
	 * array que armazena todos os nossos Clientes.
	 */
	protected ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	/**
	 * Array que armazena todos os nossos Fornecedores.
	 */
	protected ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();

	protected ArrayList<Produto> estoque = new ArrayList<Produto>();
	
	/**
	 * Construtor privado pela classe ter adotado o padrao Singleton.
	 */
	
	private CentralDeInformacoes() {

		
	}
	
	
	/**
	 * retorno da instancia, não pode haver diversas centrais circulando esse medoto resolve isso
	 */
	public static CentralDeInformacoes getInstance() {
		/**
		 * ligação com a persistencia para receber nossa central em XMl retornando nossa
		 * Central guardada.
		 */
		//instance = banco.recuperarCentral("Central");
		/**
		 * Primeira checagem para saber se está com nossa central
		 */
		if (instance == null) {
			synchronized (CentralDeInformacoes.class) {
				
				if (instance == null) {
					instance = banco.recuperarCentral("Central");
				}
			}
		}
		return instance;
	}

	
	
	
	public ArrayList<Fornecedor> retornaArrayFornecedor() {
		return fornecedores;
	}

	public ArrayList<Cliente> retornarArrayClientes() {
		return clientes;
	}

	public ArrayList<ADM> retornarArrayADM() {
		return administradores;
	}

	

	public void setAdministradores(ArrayList<ADM> administradores) {
		this.administradores = administradores;
	}
	
	public void setFornecedores(ArrayList<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public void salvarCentral(CentralDeInformacoes cDI, String string) {
		banco.salvarCentral(cDI, null);
	}

	public ArrayList<Produto> retornarProdutos() {
		return estoque;
	}

	public void setProdutos(ArrayList<Produto> produto) {
		estoque = produto;
	}
	
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
