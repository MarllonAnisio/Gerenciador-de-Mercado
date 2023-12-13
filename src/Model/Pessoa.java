package Model;

import DAO.UsuarioNaoAtualizadoException;
import DAO.UsuarioNaoCadastradoException;
import DAO.UsuarioNaoEncontradaExeption;
import DAO.UsuarioNaoExistenteException;
import DTO.DtoUser;

public abstract class Pessoa {
	private String nome;
	private long cpf;
	private long cnpj;
	private String senha;
	private String email;
	private long telefone;

	private String descricao;
	private String cidade;

	/**
	 * construtor de pessoa esse construtor tem tudo que necessita para criaçao das
	 * 3 variantes de pessoa.
	 */
	public Pessoa(DtoUser pessoa) {
		this.cpf = pessoa.getCpf();
		this.nome = pessoa.getNome();
		this.cnpj = pessoa.getCnpj();
		this.email = pessoa.getEmail();
		this.senha = pessoa.getSenha();
		this.telefone = pessoa.getTelefone();
		this.cidade = pessoa.getCidade();
		this.descricao = pessoa.getDescricao();
		
	}
	public Pessoa() {
	}
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
