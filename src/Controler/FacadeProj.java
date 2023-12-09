package Controler;

import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fabrica;
import Model.FabricaADM;
import Model.FabricaCliente;

public class FacadeProj {
	
	private Fabrica f;
	private Cliente c;
	private ADM a;
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
		System.out.println(a.getEmail());
		if(a != null) {
			return a;
		}
		return null;
	}
	public boolean procureADM(DtoUser user) {
		return a.procureADM(user);
	}
}
