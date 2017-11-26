package br.ufrpe.geekMart.classesBasicas;




import java.time.LocalDateTime;

public class Anuncio {
	
	private Cliente cliente;
	private double preco;
	private String titulo;
	private String descricao;
	private Categoria categoria;
	private String cep, estado;
	//imagens
	private LocalDateTime data = LocalDateTime.now();
	
	public Anuncio(){
		
	}
	public Anuncio(Cliente cliente, double preco, String titulo, String descricao, Categoria categoria, String cep,
			String estado, LocalDateTime data) {
		this.cliente = cliente;
		this.preco = preco;
		this.titulo = titulo;
		this.descricao = descricao;
		this.categoria = categoria;
		this.cep = cep;
		this.estado = estado;
		this.data = data;
	}
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
	public Cliente getCliente() {
		return cliente;
	}
	public LocalDateTime getData() {
		return data;
	}
	
	public boolean equals(Anuncio c){
		boolean r;
		if(c != null && this.titulo != null && this.categoria != null){
			r = (this.titulo.equals(c.getTitulo()) && this.categoria.equals(c.getCategoria()));
		}else{
			r = false;
		}
		return r;
		
	}

}
