package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.classesBasicas.Anuncio;
import br.ufrpe.geekMart.classesBasicas.Categoria;



public class RepositorioAnuncio {
	
	private Anuncio[] anuncios;
	private int proxima;
	private Categoria categoria;
	private static RepositorioAnuncio instancia;

	public static RepositorioAnuncio getInstancia () {
		if (instancia == null) {
			instancia = new RepositorioAnuncio(100);
		}
		return instancia;
	}

	private RepositorioAnuncio (int tamanho){
		this.anuncios = new Anuncio[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar (Anuncio c) {
        this.anuncios[this.proxima] = c;
		this.proxima = this.proxima + 1;
		if (this.proxima == this.anuncios.length) {
			this.duplicaArrayAnuncios();
		}
	}

	private int procurarIndice (String num){
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)){
			if (num.equals(this.anuncios[i].getTitulo())){
				achou = true;
			} else {
				i = i + 1;
		    }
	    }
	    return i;
	}

	public Anuncio procurar (String num){
		int i = this.procurarIndice(num);
		Anuncio resultado = null;
		if (i < this.proxima) {
			resultado = this.anuncios[i];
		}
		return resultado;
	}

	public void remover (String num){
		int i = this.procurarIndice(num);
		if (i < this.proxima){
			this.anuncios[i]= this.anuncios[this.proxima -1];
			this.anuncios[this.proxima -1]= null;
			this.proxima = this.proxima -1 ;
		} else {
			
		}
	}
	
	public boolean existe (String titulo) {
		boolean existe = false;
		int indice = this.procurarIndice(titulo);
		if (indice < this.proxima) {
			existe = true;
		}
		return existe;
	}

	private void duplicaArrayAnuncios () {
		if (this.anuncios != null && this.anuncios.length>0) {
			Anuncio[] arrayDuplicado = new Anuncio[this.anuncios.length*2];
			for (int i=0; i< this.anuncios.length; i++){
				arrayDuplicado[i] = this.anuncios[i];
			}
			this.anuncios = arrayDuplicado;
		}
	}
	
	
	public void alterarAnuncio (Anuncio anuncio){
		int i = this.procurarIndice(anuncio.getTitulo());
		if (i < this.proxima) {
		    this.anuncios[i] = anuncio;
        }
	}

	
}
