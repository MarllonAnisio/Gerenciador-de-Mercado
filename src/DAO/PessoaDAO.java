package DAO;

import Model.Cliente;
import Model.Pessoa;

public class PessoaDAO implements UserCrud {

	@Override
	public void createUsuario(Pessoa person) {
		// TODO Auto-generated method stub
		if(person instanceof Cliente) {
			
		}
	}

	@Override
	public boolean deleteUsuario(Pessoa person) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Pessoa readUsuario(Pessoa pessoa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUsuario() {
		// TODO Auto-generated method stub
		
	}




}
