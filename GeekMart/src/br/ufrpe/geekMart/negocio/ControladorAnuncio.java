package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Anuncio;
import br.ufrpe.geekMart.dados.RepositorioAnuncio;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;

public class ControladorAnuncio {
	private static ControladorAnuncio instancia;
	private RepositorioAnuncio repositorio;
	
	private ControladorAnuncio() {
		this.repositorio = RepositorioAnuncio.getInstancia();
	}
	public static ControladorAnuncio getInstancia() {
		if (instancia == null) {
			instancia = new ControladorAnuncio();
		}
		return instancia;
	}

	public void cadastrarAnuncio (Anuncio anuncio) throws ParametroNullException, JaExisteException {
		if (anuncio != null) {
			boolean existe = this.repositorio.existe(anuncio.getTitulo());
			if (!existe) {
				this.repositorio.cadastrar(anuncio);
			} else {
			    throw new JaExisteException("anuncio", "título " + anuncio.getTitulo());
            }
		} else {
            throw new ParametroNullException("anúncio");
        }
	}
	public Anuncio buscarAnuncio (String titulo) throws ParametroNullException {
		Anuncio retorno = null;
		if (titulo != null) {
			retorno = this.repositorio.procurar(titulo);
		} else {
		    throw new ParametroNullException("título de anúncio");
        }
		return retorno;
	}

	public void removerAnuncio (String titulo) throws ParametroNullException, NaoExisteException {
		if (titulo != null) {
			if (this.repositorio.existe(titulo)) {
                this.repositorio.remover(titulo);
            } else {
			    throw new NaoExisteException("anúncio", "título " + titulo);
            }
		} else {
		    throw new ParametroNullException("título de anúncio");
        }
	}
	public void alterarAnuncio (Anuncio anuncio) throws ParametroNullException, NaoExisteException {
		if (anuncio != null) {
		    if (this.repositorio.existe(anuncio.getTitulo())) {
		        this.repositorio.alterarAnuncio(anuncio);
            } else {
		        throw new NaoExisteException("anúncio", "título " + anuncio.getTitulo());
            }
        } else {
		    throw new ParametroNullException("anúncio");
        }
	}

	public Anuncio[] getAnunciosCategoria (int categoria) {
		return this.repositorio.getAnunciosCategoria(categoria);
	}

	public Anuncio[] getAnunciosCategoria (String categoria) {
		return this.repositorio.getAnunciosCategoria(categoria);
	}
}
