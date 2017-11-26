package br.ufrpe.geekMart.dados;



import br.ufrpe.geekMart.classesBasicas.Anuncio;
import br.ufrpe.geekMart.classesBasicas.Usuario;

public class RepositorioUsuario {
	
	private Usuario[] usuarios = new Usuario[20];;
	private Usuario user;
	private int proxima;
	
	private static RepositorioUsuario instancia;

	public static RepositorioUsuario getInstancia() {
		
		return instancia;
	}
	
	public RepositorioUsuario(){
		
	}
	public RepositorioUsuario(int tamanho){
		this.usuarios = new Usuario[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar(Usuario c){
		this.usuarios[this.proxima] = c;
		this.proxima = this.proxima +1;
	}
	private int procurarIndice(String num){
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)){
			if(num.equals(this.usuarios[i].getCpf())){
				achou = true;
			} else {
				i = i+1;
		}
		
	}
	return 1;
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
		boolean equivale;
		user = this.procurar(cpf);
		equivale = user.getSenha().equals(senha);
		if (equivale != false) {
			retorno = true;
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
	private void duplicaArrayUsuarios(){
		if(this.usuarios != null && this.usuarios.length>0){
			Usuario[] arrayDuplicado = new Usuario[this.usuarios.length*2];
			for(int i=0 ; i< this.usuarios.length; i++){
				arrayDuplicado[i] = this.usuarios[i];
			}
			this.usuarios = arrayDuplicado;
		}
	}
	public void alterarUsuario(Usuario Usuario){
		
	}
	
	
	
	
}

