package Controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoProduto;
import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fabrica;

import Model.Fornecedor;
import Model.Produto;

public class FacadeLoja {
	
	private Fabrica f;
	private Cliente c;
	private ADM adm;
	private Fornecedor fo;
	private Fabrica fabrica;
	private Produto p;
	
	
	public boolean criarADM(DtoUser user) {
		fabrica = new Fabrica();
		try {
			return fabrica.criarTipoPessoa(user, "ADM");
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean criarCliente(DtoUser user) {
		fabrica = new Fabrica();
		try {
			return fabrica.criarTipoPessoa(user, "CLIENTE");
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean criarFornecedor(DtoUser user) {
		fabrica = new Fabrica();
		try {
			return fabrica.criarTipoPessoa(user, "FORNECEDOR");
		} catch (UsuarioNaoCadastradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean procureADM(DtoUser user) {
		adm = new ADM();
		try {
			return adm.procureADM(user);
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public boolean deleteUserADM(DtoUser person) {
		try {
			adm.deleteUser(person);
		} catch (UsuarioNaoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public boolean deleteUserCliente(DtoUser person) {
		try {
			c.deleteUser(person);
		} catch (UsuarioNaoExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Cliente readCliente(DtoUser user) {
		try {
			c =   (Cliente) c.readUser(user);
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(c != null) {
			return c;
		}
		return null;
		
	}
	public ADM readADM(DtoUser user) {
		try {
			adm =  adm.readUser(user);
		} catch (UsuarioNaoEncontradaExeption e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	//	System.out.println(a.getEmail());
		if(adm != null) {
			return adm;
		}
		return null;
	}

	public  ArrayList<Fornecedor> retornaArrayFornecedor(){
		 return fo.retornaArrayFornecedor();
	}
	
	
}
