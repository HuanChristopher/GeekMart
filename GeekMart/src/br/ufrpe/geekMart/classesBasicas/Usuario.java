package br.ufrpe.geekMart.classesBasicas;

public class Usuario {

	private boolean ativo = true;
	public String nome, email , cpf, senha;
	
	public Usuario(String nome, String email, String cpf, String senha){
		this.nome = nome;
		this.email=email;
		this.cpf=cpf;
		this.senha=senha;
		this.ativo =true;
	}
	
	public Usuario(){
	
	}

	public boolean getAtivo () {
		return this.ativo;
	}

	public void setAtivo () {
		this.ativo = true;
	}

	public void setBloqueado () {
		this.ativo = false;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome; 
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email=email;
	}
	
	public String getCpf(){
		return cpf;
	}
	
	public void setCpf(String cpf){
		this.cpf = cpf;
	}
	
	public String getSenha(){
		return senha;
	}

	public boolean verificarSenha (String senha) {
		boolean r = false;
		if (this.senha.equals(senha)) {
			r = true;
		}
		return r;
	}
	
	public void setSenha(String senha){
		this.senha=senha;
	}
	
	public boolean equals(Usuario c){
		boolean r;
		if(c != null && this.cpf != null){
			r=(this.cpf.equals(c.getCpf()));
		}else{
			r=false;
		}
		return r;
	}

	public String toString(){
		String c;
		c = "O nome do usario é "+nome;
		return c;
	}
	
	
}
