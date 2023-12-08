package VIEW;



import DAO.Persistencia;
import DTO.DtoUser;
import Model.ADM;
import Model.Fabrica;
import Model.FabricaADM;
import Model.Pessoa;
public class MainBackTest {

	public static void main(String[] args) {
		//Fabrica f = new FabricaFornecedor();

		//Fabrica a = new FabricaCliente();
		Fabrica b = new FabricaADM();

		DtoUser b1 = new DtoUser("Jonas", "marllon@gmail.com", "12se45aa");
		Pessoa c = new ADM(b1);
		//c.criarUser(c);
		//p.salvarCentral(h, "Central");
		
		System.out.print(b.criar(b1));
	}
}
