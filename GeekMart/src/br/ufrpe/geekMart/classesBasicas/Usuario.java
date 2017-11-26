package br.ufrpe.geekMart.classesBasicas;

public class Usuario {
	
	private String nome, email , cpf, senha;
	
	public Usuario(String nome, String email, String cpf, String senha){
		this.nome = nome;
		this.email=email;
		this.cpf=cpf;
		this.senha=senha;
	}
	
	public Usuario(){
	
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
		this.cpf=cpf;
	}
	
	public String getSenha(){
		return senha;
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
	
	
	
}
