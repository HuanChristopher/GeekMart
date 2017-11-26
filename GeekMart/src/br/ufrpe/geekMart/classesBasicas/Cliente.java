package br.ufrpe.geekMart.classesBasicas;

import java.util.ArrayList;

public class Cliente extends Usuario{
	
	private boolean ativo = true;
	private String telefone;
	private Endereco endereco = new Endereco();
	private ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
	private int tamanho = anuncios.size();
	private Loja loja;
	
	public Cliente(){
		
	}
	
	public Cliente (String nome, String cpf, String email, String telefone, Endereco endereco, String senha){
		super(nome,cpf,email,senha);
		
		this.telefone = telefone;
		this.endereco = new Endereco(endereco.getLogradouro(), endereco.getNumero(), endereco.getBairro(), endereco.getCidade(), endereco.getEstado(), endereco.getCep(),
				endereco.getComplemento());
	
	}
	
	public String getTelefone(){
		return telefone;
	}
	public void setTelefone(String telefone){
		this.telefone=telefone;
	}

	public String getEndereco() {
		String temp = endereco.toString();
		return temp;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public ArrayList<Anuncio> getAnuncios() {
		return anuncios;
	}

	public void setAnuncios(Anuncio anuncios) {
		this.anuncios.add(anuncios);
	}
	
	
	
}
