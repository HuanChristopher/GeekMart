package br.ufrpe.geekMart.classesBasicas;

import java.util.ArrayList;

public class Loja {
	
	private Cliente cliente;
	private String nome, descricao, cep, estado, telefone;
	private ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
	private int tamanho = anuncios.size();
	

	public Loja(){

	}

	public Loja(String nome, String descricao, String cep, String estado, String telefone,Cliente cliente){
		this.nome = nome;
		this.descricao = descricao;
		this.cep = cep;
		this.estado = estado;
		this.telefone = telefone;
		this.cliente = cliente;
		this.anuncios = cliente.getAnuncios();
		this.tamanho = this.anuncios.size();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public ArrayList<Anuncio> getAnuncio(int i) {
		return anuncios;
	}

	public void setAnuncios(ArrayList<Anuncio> anuncios) {
		this.anuncios = anuncios;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}

	public void setCliente(Cliente cliente){
		this.cliente = cliente;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public String toString(){
		String c = "Loja: " + this.getNome() + "\nDono: " + this.getCliente() + "\nDescrição: " + this.getDescricao() +
				"\nLocal: " + this.getEstado() + ", " + this.getCep() + "\nTelefone: " + this.getTelefone();
		if (tamanho > 0) {
            for (int i = 0; i < this.tamanho; i++) {
                c = c + "\n" + this.getAnuncio(i).toString();
            }
        }
        else {
		    c = c + "\nA loja ainda não contem anúncios.";
        }
		return c;
	}
	

}
