package Controler;

import java.util.ArrayList;

import DTO.DtoProduto;
import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fabrica;
import Model.FabricaADM;
import Model.FabricaCliente;
import Model.FabricaFornecedor;
import Model.Fornecedor;
import Model.Produto;

public class FacadeProj {
	
	private Fabrica f;
	private Cliente c;
	private ADM a;
	private Fornecedor fo;
	private Fabrica fabrica;
	private Produto p;
	public boolean criarADM(DtoUser user) {
		f = new FabricaADM();
		return f.criar(user);
	}
	public boolean criarCliente(DtoUser user) {
		f = new FabricaCliente();
		return f.criar(user);
	}
	
	public boolean deleteUserADM(DtoUser person) {
		a.deleteUser(person);
		
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
		a =  a.readUser(user);
		if(a != null) {
			return a;
		}
		return null;
	}
	public boolean procureADM(DtoUser user) {
		return a.procureADM(user);
	}
	
	public void criarFornecedor(DtoUser user) {
		fabrica = new FabricaFornecedor();
		fabrica.criar(user);
	}
	public void deleteUserFornecedor(DtoUser person) {
		fo.deleteUser(person);
	}
	public Fornecedor readFornecedor(DtoUser user) {
		fo =  (Fornecedor) fo.readUser(user);
		if(fo != null) {
			return fo;
		}
		return null;
	}
	public void atualizarfornecedor(Fornecedor p) {
		fo.updateUser(p);
		
	}
 	public void criarProduto(Produto prod,DtoUser forn) {
		p.criarProduto(prod, forn);
	}
	public Produto lerProduto(DtoProduto prod,DtoUser forn) {
		return p.readProduto(prod, forn);
	}
	public void deletarProduto(DtoProduto prod,DtoUser forn) {
		p.deleteProduto(prod, forn);	
	}
	public void editarProduto(DtoProduto prod,DtoUser forn) {
		p.updateProduto(p, forn);
	}
	public  ArrayList<Fornecedor> retornaArrayFornecedor(){
		 return fo.retornaArrayFornecedor();
	}
	
	
}
