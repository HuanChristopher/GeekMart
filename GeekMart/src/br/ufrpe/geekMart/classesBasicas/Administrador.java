package br.ufrpe.geekMart.classesBasicas;



public class Administrador extends Usuario{
	private boolean adm = true;
	
	public Administrador(){
		
	}
	public Administrador(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nCpf: " + cpf + "\nEmail: " + email;
	}

	public boolean getAdm(){
		return adm;
	}

}
