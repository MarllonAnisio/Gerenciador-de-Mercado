package VIEW;

import Controler.FacadeLoja;
import Controler.FachadaProdutoAndFornecedores;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoUser;

public class Programa {
	public static void main(String[] args) {
    TelaLogin t =	new TelaLogin();
    t.desenharTela();
    FacadeLoja p = new FacadeLoja();
    FachadaProdutoAndFornecedores lo = new FachadaProdutoAndFornecedores();
    DtoUser user = new DtoUser("Laercio ", 12236555, 40028922, "mangabeira", "loucuras acontecem");
    p.criarFornecedor(user);
    
//    try {
//		lo.deleteUserFornecedor(user);
//	} catch (UsuarioNaoExistenteException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
 
    
    
	}
}
