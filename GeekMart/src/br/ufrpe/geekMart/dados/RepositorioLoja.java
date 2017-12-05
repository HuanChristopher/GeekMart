package br.ufrpe.geekMart.dados;



import br.ufrpe.geekMart.classesBasicas.Cliente;
import br.ufrpe.geekMart.classesBasicas.Loja;
import br.ufrpe.geekMart.classesBasicas.Usuario;

public class RepositorioLoja {
	
	private Loja[] lojas;
	private int proxima;	
	private static RepositorioLoja instancia;

	public static RepositorioLoja getInstancia() {
		if (instancia == null) {
			instancia = new RepositorioLoja(100);
		}
		return instancia;
	}

	private RepositorioLoja (int tamanho){
		this.lojas = new Loja[tamanho];
		this.proxima = 0;
	}
	
	public void cadastrar(Usuario user, Loja c){
	    boolean r = this.existe(c.getNome());
		boolean s = this.existe(user.getCpf());
	    if (r == false && s == true) {
            this.lojas[this.proxima] = c;
            this.proxima = this.proxima +1;
            if (this.proxima == lojas.length) {
                this.duplicaArrayLojas();
            }
        }
	}

	private int procurarIndice(String num){
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)){
			if(num.equals(this.lojas[i].getNome())){
				achou = true;
			} else {
				i = i+1;
			}
		}
		return i;
	}
	public Loja procurar (String num){
		int i = this.procurarIndice(num);
		Loja resultado = null;
		if (i < this.proxima) {
			resultado = this.lojas[i];
		}
		return resultado;
	}
	public void remover(String num){
		int i = this.procurarIndice(num);
		if (i < this.proxima){
			this.lojas[i]= this.lojas[this.proxima -1];
			this.lojas[this.proxima -1]= null;
			this.proxima = this.proxima -1 ;
		} else{
			
		}
	}
	
	public boolean existe(String titulo){
		boolean existe = false;
		int indice = this.procurarIndice(titulo);
		if(indice != this.proxima){
			existe = true;
		}
		return existe;
	}
	private void duplicaArrayLojas(){
		if (this.lojas != null && this.lojas.length>0) {
			Loja[] arrayDuplicado = new Loja[this.lojas.length*2];
			for(int i=0 ; i< this.lojas.length; i++){
				arrayDuplicado[i] = this.lojas[i];
			}
			this.lojas = arrayDuplicado;
		}
	}
	
    public void alterarLoja (Loja loja) {
		int indice = this.procurarIndice(loja.getNome());
		if (indice != this.proxima) {
		    lojas[indice] = loja;
        }
	}
}


