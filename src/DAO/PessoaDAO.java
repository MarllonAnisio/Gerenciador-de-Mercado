package DAO;

import DTO.DtoUser;
import Model.ADM;
import Model.Cliente;
import Model.Fornecedor;
import Model.Pessoa;

public class PessoaDAO {
	Persistencia banco ;
	CentralDeInformacoes CDI;
	public boolean  criarUser(Pessoa pessoa){
		banco = banco.getInstance();
		CDI = banco.recuperarCentral("Central");
		/**
		 * modelo que sera utilizado para salvar pessoas no banco, remover,ler e editar
		 * 
		 * 
		 * */
		if(pessoa instanceof Cliente) {
			if(CDI.adicionarCliente(pessoa)) {
				return true;
			}
			
		}
		else if(pessoa instanceof ADM) {
			return CDI.adicionarADM(pessoa);
			}
		else if(pessoa instanceof Fornecedor) {
			return CDI.adicionarFornecedor(pessoa);
		}
		return false;
	}

	public boolean deleteUsuario(DtoUser person) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public Pessoa readUsuario(DtoUser person) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public void updateUsuario(DtoUser person) {
		
		
	}




}
