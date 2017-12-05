package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Usuario;
import br.ufrpe.geekMart.dados.RepositorioUsuario;

public class ControladorUsuario {

	private RepositorioUsuario repositorio;
	
	public ControladorUsuario() {
		this.repositorio = RepositorioUsuario.getInstancia();
	}

	public void cadastrarUsuario (Usuario user) {
		if (user != null) {
			boolean existe = this.repositorio.existe(user.getCpf());
			if (existe != true) {
				this.repositorio.cadastrarUsuario(user);
			}
		}
	}

	public Usuario buscarUsuario (String cpf){
		Usuario retorno = null;
		if (cpf != null){
			retorno = this.repositorio.procurar(cpf);
		}
		return retorno;
	}

	public void removerUsuario (String cpf){
		if (cpf != null){
			if (this.repositorio.existe(cpf) != false)
				this.repositorio.remover(cpf);
		}
	}

	public boolean autenticarLogin (String senha, String cpf) {
		boolean retorno = false;
		if (cpf != null && senha != null) {
			boolean existe = this.repositorio.existe(cpf);
			if (existe != false) {
				retorno = this.repositorio.autenticarLogin(senha, cpf);
			}
		}
		return retorno;
	}

	public void bloquearUsuario (String cpf) {
	    if (cpf != null) {
	        if (this.repositorio.existe(cpf)) {
                repositorio.bloquearUsuario(cpf);
            }
        }
	}

	public void desbloquearUsuario (String cpf) {
	    if (cpf != null) {
	        if (this.repositorio.existe(cpf)) {
                repositorio.desbloquearUsuario(cpf);
            }
        }
	}

	public void alterarUsuario (Usuario usuario){
	    if (usuario != null) {
	        if (this.repositorio.existe(usuario.getCpf())) {
                repositorio.alterarUsuario(usuario);
            }
        }
	}
}
