package br.ufrpe.geekMart.classesBasicas;

public class Administrador extends Usuario{
	
	public Administrador(){
		
	}
	public Administrador(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
	}

	@Override
	public String toString() {
		return "Nome: " + this.getNome() + "\nCpf: " + this.getCpf() + "\nEmail: " + this.getEmail();
	}
	
	
}
