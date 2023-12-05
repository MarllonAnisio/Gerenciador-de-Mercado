package DAO;

import Model.Pessoa;

public interface UserCrud {
	
	/**
	 *  interface para criar tipos de pessoa para nosso projeto
	 *  
	 *  
	 *  versão não final!!!
	 * 
	 * */
	public void createUsuario(Pessoa person);
	public boolean deleteUsuario(Pessoa person);
	public Pessoa readUsuario(Pessoa pessoa);
	public void updateUsuario();
	

}
