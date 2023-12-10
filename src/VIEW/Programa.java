package VIEW;

import Controler.FacadeLoja;
import DTO.DtoUser;

public class Programa {
	public static void main(String[] args) {
    TelaLogin t =	new TelaLogin();
    t.desenharTela();
    FacadeLoja p = new FacadeLoja();
    DtoUser user = new DtoUser("marllon", "marllon.Anisio@gmail.com","12345");
    p.criarADM(user);
    
    
	}
}
