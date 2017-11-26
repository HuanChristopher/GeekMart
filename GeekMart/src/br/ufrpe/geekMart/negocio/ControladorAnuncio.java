package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Anuncio;

import br.ufrpe.geekMart.dados.RepositorioAnuncio;



public class ControladorAnuncio {
	
	private static ControladorAnuncio instancia;
	private RepositorioAnuncio repositorio;
	
	ControladorAnuncio() {
		this.repositorio = RepositorioAnuncio.getInstancia();
	}

	public static ControladorAnuncio getInstancia() {
		if (instancia == null) {
			instancia = new ControladorAnuncio();
		}
		return instancia;
	}
	public void cadastrarAnuncio(Anuncio user){
		if(user != null){
			boolean  existe = this.repositorio.existe(user.getTitulo());
			if (existe != true){
				this.repositorio.cadastrar(user);
			}
		}
	}
	public Anuncio buscarAnuncio(String titulo){
		Anuncio retorno = null;
		if(titulo != null){
			retorno = this.repositorio.procurar(titulo);
		}
		return retorno;
	}
	public void removerAnuncio(String titulo){
		if(titulo != null){
			if(this.repositorio.existe(titulo) != false)
				this.repositorio.remover(titulo);
		}
	}
	public void alterarAnuncio(Anuncio anuncio){
		// Precisa ser implementado
	}
	
	
	

}
