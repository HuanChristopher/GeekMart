package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Loja;
import br.ufrpe.geekMart.dados.RepositorioLoja;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;

public class ControladorLoja {
	private RepositorioLoja repositorio;
	private static ControladorLoja instancia;

	public static ControladorLoja getInstancia () {
	    if (instancia == null) {
	        instancia = new ControladorLoja();
        }
        return instancia;
    }
	
	private ControladorLoja() {
		this.repositorio = RepositorioLoja.getInstancia();
	}
	
	public void cadastrarLoja (Loja loja) throws ParametroNullException, JaExisteException {
		if(loja != null){
			boolean existe = this.repositorio.existe(loja.getNome());
			if (!existe){
				this.repositorio.cadastrar(loja);
			} else {
			    throw new JaExisteException("loja", "nome " + loja.getNome());
            }
		} else {
			throw new ParametroNullException("loja");
		}
	}

	public Loja buscarLoja(String titulo) throws ParametroNullException, NaoExisteException {
		Loja retorno = null;
		if(titulo != null){
			retorno = this.repositorio.procurar(titulo);
		} else {
		    throw new ParametroNullException("título da loja");
        }
		return retorno;
	}

	public void removerLoja(Loja loja) throws ParametroNullException, NaoExisteException {
		if(loja != null){
			if(this.repositorio.existe(loja.getNome())) {
                this.repositorio.remover(loja);
            } else {
			    throw new NaoExisteException("loja", "nome " + loja.getNome());
            }
		} else {
		    throw new ParametroNullException("loja");
        }
	}

	public void alterarLoja (String nomeAntigo, Loja loja) throws ParametroNullException, NaoExisteException {
		if (nomeAntigo != null && loja != null) {
			if (this.repositorio.existe(nomeAntigo)) {
				this.repositorio.alterarLoja(nomeAntigo, loja);
			} else {
			    throw new NaoExisteException("loja", "nome " + nomeAntigo);
            }
		} else {
		    throw new ParametroNullException("antigo nome da loja ou novas definições da loja");
        }
	}
}
