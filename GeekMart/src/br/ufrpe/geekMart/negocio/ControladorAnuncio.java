package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Anuncio;
import br.ufrpe.geekMart.dados.RepositorioAnuncio;

public class ControladorAnuncio {

	private RepositorioAnuncio repositorio;
	
	public ControladorAnuncio() {
		this.repositorio = RepositorioAnuncio.getInstancia();
	}

	public void cadastrarAnuncio (Anuncio anuncio) {
		if (anuncio != null) {
			boolean existe = this.repositorio.existe(anuncio.getTitulo());
			if (!existe) {
				this.repositorio.cadastrar(anuncio);
			}
		}
	}
	public Anuncio buscarAnuncio (String titulo) {
		Anuncio retorno = null;
		if (titulo != null) {
			retorno = this.repositorio.procurar(titulo);
		}
		return retorno;
	}

	public void removerAnuncio (String titulo) {
		if (titulo != null) {
			if (this.repositorio.existe(titulo)) {
                this.repositorio.remover(titulo);
            }
		}
	}
	public void alterarAnuncio (Anuncio anuncio) {
		if (anuncio != null) {
		    if (this.repositorio.existe(anuncio.getTitulo())) {
		        this.repositorio.alterarAnuncio(anuncio);
            }
        }
	}
}
