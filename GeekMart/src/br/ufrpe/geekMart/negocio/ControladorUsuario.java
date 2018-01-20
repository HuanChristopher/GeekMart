package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Usuario;
import br.ufrpe.geekMart.dados.RepositorioUsuario;
import br.ufrpe.geekMart.exceptions.JaExisteException;
import br.ufrpe.geekMart.exceptions.NaoExisteException;
import br.ufrpe.geekMart.exceptions.ParametroNullException;

public class ControladorUsuario {
	private static ControladorUsuario instancia;
	private RepositorioUsuario repositorio;
	
	ControladorUsuario() {
		this.repositorio = RepositorioUsuario.getInstancia();
	}

	public static ControladorUsuario getInstancia() {
		if (instancia == null) {
			instancia = new ControladorUsuario();
		}
		return instancia;
}

	public void cadastrarUsuario(Usuario user) throws ParametroNullException, JaExisteException {
		if (user != null) {
			boolean existe = this.repositorio.existe(user.getCpf());
			if (!existe) {
				this.repositorio.cadastrarUsuario(user);
			} else {
			    throw new JaExisteException("usuário", "CPF " + user.getCpf());
            }
		} else {
		    throw new ParametroNullException("usuário");
        }
	}

	public Usuario buscarUsuario(String cpf) throws ParametroNullException, NaoExisteException {
		Usuario retorno = null;
		if(cpf != null){
		    boolean existe = this.repositorio.existe(cpf);
		    if (existe) {
                retorno = this.repositorio.procurar(cpf);
                return retorno;
            } else {
		        throw new NaoExisteException("usuário", "CPF " + cpf);
            }
		} else {
		    throw new ParametroNullException("CPF");
        }
	}
	public void removerUsuario(String cpf){
		if(cpf != null){
			if(this.repositorio.existe(cpf) != false)
				this.repositorio.remover(cpf);
		}
	}
	public boolean autenticarLogin(String senha, String cpf) {
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
            repositorio.bloquearUsuario(cpf);
        }
	}

	public void desbloquearUsuario (String cpf) {
	    if (cpf != null) {
            repositorio.desbloquearUsuario(cpf);
        }
	}

	public void alterarUsuario(Usuario usuario){
	    if (usuario != null) {
            repositorio.alterarUsuario(usuario);
        }
	}
	
	
	
}
