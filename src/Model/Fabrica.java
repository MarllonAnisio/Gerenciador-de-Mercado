package Model;

import DTO.DtoUser;
/**
 * padrao Factory method utlizado para suprir as diferentes formas de criaçao
 * 
 * 
 * */
public abstract class Fabrica {
	Pessoa pessoa;
	public abstract boolean criar(DtoUser user);
	
}
