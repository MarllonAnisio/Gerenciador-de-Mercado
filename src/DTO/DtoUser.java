package DTO;

import Model.Fornecedor;

public class DtoUser {
 
	private String nome;
	private long cpf;
	private long cnpj;
	private String senha;
	private String email;
	private long telefone;
	private String cidade;
	private String descricao;
	
	/**
	 *  construtor para receber dados futuros de ADM
	 * */
	public DtoUser( String nome, String email, String senha) {
		this.senha = senha;
		this.email = email;
		this.nome = nome;
	}
	
	/**
	 * 
	 * construtor para receber dados futuros de um fornecedor
	 * */
	public DtoUser(String nome,long cnpj,long telefone,String descricao,String cidade) {
		
		
		this.cidade = cidade;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.descricao = descricao;
		this.nome = nome;
	}
	
	
	
	/**
	 * caso necessario repassar valores de um fornecedor sem passar uma copia do mesmo para camadas superiores
	 * */
	public DtoUser(Fornecedor forn) {
		nome = forn.getNome();
		cnpj = forn.getCnpj();
		telefone = forn.getTelefone();
		cidade= forn.getCidade();
		setDescricao(forn.getDescricao());
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


	public long getCpf() {
		return cpf;
	}


	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
