package br.ufrpe.geekMart.dados;

import java.util.List;

import br.ufrpe.geekMart.classesBasicas.*;

public class RepositorioUsuario {
	
	private Usuario[] usuarios = new Usuario[20];
	private List<Usuario> listaUsuarios = null;
	private Usuario user;
	private int proxima;
	
	private static RepositorioUsuario instancia = new RepositorioUsuario(50);

	public static RepositorioUsuario getInstancia() {
		
		return instancia;
	}
	
	public RepositorioUsuario(){
		
	}
	public RepositorioUsuario(int tamanho){
		this.usuarios = new Usuario[tamanho];
		this.proxima = 0;
	}

	public void cadastrarUsuario(Usuario c){
	    boolean r = this.existe(c.getCpf());
	    if (r == false) {
            this.usuarios[this.proxima] = c;
            this.proxima = this.proxima + 1;
            if (this.proxima == this.usuarios.length) {
                this.duplicaArrayUsuarios();
            }
        }
	}

	public void bloquearUsuario (String cpf) {
		int indice = procurarIndice(cpf);
		if (indice < this.proxima) {
			usuarios[indice].setBloqueado();
		}
	}

	public void desbloquearUsuario (String cpf) {
		int indice = procurarIndice(cpf);
		if (indice < this.proxima) {
			usuarios[indice].setAtivo();
		}
	}

	private int procurarIndice(String num){
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)) {
			if (num.equals(this.usuarios[i].getCpf())) {
				achou = true;
			} else {
				i++;
			}
		}
	 	return i;
	}

	public Usuario procurar(String num){
		int i = this.procurarIndice(num);
		Usuario resultado = null;
		if (i != this.proxima) {
			resultado = this.usuarios[i];
		}
		return resultado;
	}

	public void remover(String num){
		int i = this.procurarIndice(num);
		if (i != this.proxima){
			this.usuarios[i]= this.usuarios[this.proxima -1];
			this.usuarios[this.proxima -1]= null;
			this.proxima = this.proxima -1 ;
		} else{
			
		}
	}

	public boolean autenticarLogin(String senha, String cpf) {
		boolean retorno = false;
		user = this.procurar(cpf);
		boolean tipo = user.getAtivo();
		if (tipo != false) {
			boolean equivale = user.getSenha().equals(senha);
			if (equivale != false) {
				retorno = true;
			}
		}
		return retorno;
	}

	public boolean existe(String cpf){
		boolean existe = false;
		int indice = this.procurarIndice(cpf);
		if(indice != proxima){
			existe = true;
		}
		return existe;
	}
	public void duplicaArrayUsuarios(){
		if(this.usuarios != null && this.usuarios.length>0){
			Usuario[] arrayDuplicado = new Usuario[this.usuarios.length*2];
			for(int i=0 ; i< this.usuarios.length; i++){
				arrayDuplicado[i] = this.usuarios[i];
			}
			this.usuarios = arrayDuplicado;
		}
	}

	public void alterarUsuario(Usuario usuario){
		int indice = this.procurarIndice(usuario.getCpf());
		if (indice != this.proxima) {
			usuarios[indice] = usuario;
		}
	}
	
	
	
	
}

