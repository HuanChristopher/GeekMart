package br.ufrpe.geekMart.negocio;


import br.ufrpe.geekMart.classesBasicas.Loja;
import br.ufrpe.geekMart.classesBasicas.Usuario;
import br.ufrpe.geekMart.dados.RepositorioLoja;

public class ControladorLoja {
	private static ControladorLoja instancia;
	private RepositorioLoja repositorio;
	
	public ControladorLoja() {
		this.repositorio = RepositorioLoja.getInstancia();
	}
	
	public void cadastrarLoja(Usuario user, Loja loja){
		if(user != null){
			boolean  existe = this.repositorio.existe(user.getNome());
			if (existe != true){
				this.repositorio.cadastrar(user, loja);
			}
		}
	}
	public Loja buscarLoja(String titulo){
		Loja retorno = null;
		if(titulo != null){
			retorno = this.repositorio.procurar(titulo);
		}
		return retorno;
	}
	public void removerLoja(String titulo){
		if(titulo != null){
			if(this.repositorio.existe(titulo) != false)
				this.repositorio.remover(titulo);
		}
	}
	public void alterarLoja(Loja loja){
		// Precisa ser implementado
	}

	public static ControladorLoja getInstancia() {
		if (instancia == null) {
			instancia = new ControladorLoja();
		}
		return instancia;
	}
	
	

}
