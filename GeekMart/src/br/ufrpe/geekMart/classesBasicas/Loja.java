package br.ufrpe.geekMart.classesBasicas;

import java.util.ArrayList;

public class Loja {
	
	private Cliente cliente;
	private String nome, descricao, cep, estado, telefone;
	private ArrayList<Anuncio> anuncios = new ArrayList<Anuncio>();
	private int tamanho = anuncios.size();
	
	public Loja(){
		
	}

	public Loja(String nome, String descricao, String cep, String estado, String telefone){
		this.nome = nome;
		this.descricao = descricao;
		this.cep = cep;
		this.estado = estado;
		this.telefone = telefone;
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

	public ArrayList<Anuncio> getAnuncios() {
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
		String c = "A loja "+nome+" possui a descrição: "+descricao;
		return c;
	}
	

}
