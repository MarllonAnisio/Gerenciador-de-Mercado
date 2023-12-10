package Controler;

import java.util.ArrayList;

import javax.swing.JOptionPane;

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
		return fabrica.criarTipoPessoa(user, "ADM");
		}
	public boolean criarCliente(DtoUser user) {
		fabrica = new Fabrica();
		return fabrica.criarTipoPessoa(user, "CLIENTE");
	}
	public boolean criarFornecedor(DtoUser user) {
		fabrica = new Fabrica();
		return fabrica.criarTipoPessoa(user, "FORNECEDOR");
	}
	public boolean procureADM(DtoUser user) {
		adm = new ADM();
		return adm.procureADM(user);
	}
	
	
	
	public boolean deleteUserADM(DtoUser person) {
		adm.deleteUser(person);
		
		return false;
	}

	public boolean deleteUserCliente(DtoUser person) {
		c.deleteUser(person);
		return false;
	}
	
	public Cliente readCliente(DtoUser user) {
		c =   (Cliente) c.readUser(user);
		if(c != null) {
			return c;
		}
		return null;
		
	}
	public ADM readADM(DtoUser user) {
		adm =  adm.readUser(user);
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
