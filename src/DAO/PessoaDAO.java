package DAO;



import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;

public class PessoaDAO {
	CentralDeInformacoes CDI = CentralDeInformacoes.getInstance();
		
	public PessoaDAO(){
	
	}
	public boolean  criarUser(Pessoa pessoa){
		
		if(pessoa instanceof Cliente) {
			if(CDI.adicionarCliente(pessoa)) {
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		}
		else if(pessoa instanceof ADM) {
			if(CDI.adicionarADM(pessoa)) {
				CDI.salvarCentral(CDI,"Central");
				return true;
			}
		}
		else if(pessoa instanceof Fornecedor) {
			if(CDI.adicionarFornecedor(pessoa)) {
				CDI.salvarCentral(CDI, "Central");
				return true;
			}
		}
		return false;
	}
	public boolean deleteUserADM(DtoUser person) {
		if(CDI.removerADM(person)) {
			CDI.salvarCentral(CDI, "central");
			return true;
		}
		return false;
	}
	public boolean deleteUserFornecedor(DtoUser person) {
		if(CDI.removerFornecedor(person)) {
			CDI.salvarCentral(CDI, "central");
			return true;
		}
		return false;
	}
	public boolean deleteUserCliente(DtoUser person) {
		if(CDI.removerCliente(person)) {
			CDI.salvarCentral(CDI, "central");
			return true;
		}
		return false;
	}

	public Fornecedor readFornecedor(DtoUser user) {
		return CDI.lerFornecedor(user);
		
	}
	public Cliente readCliente(DtoUser user) {
		return CDI.lerCliente(user);
		
	}
	public ADM readADM(DtoUser user) {
		return CDI.lerADM(user);	
	}
	
	public boolean atualizar(Pessoa user) {
		return CDI.atualizar(user);
		}
		/**if(user instanceof Fornecedor){
			if(CDI.atualizar(user)) {
				return true;
			}
		}
		if(user instanceof ADM){
			if(CDI.atualizar(user)) {
				return true;
			}
		}
		if(user instanceof Cliente){
			if(CDI.atualizar(user)) {
				return true;
			}
		}
		return false;
	}*/
	



}
