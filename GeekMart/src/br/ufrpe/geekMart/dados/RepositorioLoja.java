package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.classesBasicas.Loja;
import br.ufrpe.geekMart.exceptions.NaoExisteException;

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
	
	public void cadastrar (Loja c) {
		this.lojas[this.proxima] = c;
		this.proxima = this.proxima +1;
		if (this.proxima == lojas.length) {
			this.duplicaArrayLojas();
		}
	}

	public Loja procurar (String nomeLoja) throws NaoExisteException {
		int i = this.procurarIndice(nomeLoja);
		Loja resultado = null;
		if (i < this.proxima) {
			resultado = this.lojas[i];
			return resultado;
		} else {
			throw new NaoExisteException("loja", "nome " + nomeLoja);
		}
	}

	public void remover (Loja loja){
		int i = this.procurarIndice(loja.getNome());
		this.lojas[i]= this.lojas[this.proxima -1];
		this.lojas[this.proxima -1] = null;
		this.proxima = this.proxima -1;
	}

	private int procurarIndice (String titulo) {
		int i = 0;
		boolean achou = false;
		while ((!achou) && (i < this.proxima)){
			if (titulo.equals(this.lojas[i].getNome())) {
				achou = true;
			} else {
				i = i+1;
			}
		}
		return i;
	}

    public boolean existe (String titulo) {
        boolean existe = false;
        int indice = this.procurarIndice(titulo);
        if (indice < this.proxima) {
            existe = true;
        }
        return existe;
    }

    private int procurarIndiceCpf (String titulo) {
        int i = 0;
        boolean achou = false;
        while ((!achou) && (i < this.proxima)){
            if (titulo.equals(this.lojas[i].getCliente().getCpf())) {
                achou = true;
            } else {
                i = i+1;
            }
        }
        return i;
    }

	private void duplicaArrayLojas(){
		if (this.lojas != null && this.lojas.length>0) {
			Loja[] arrayDuplicado = new Loja[this.lojas.length*2];
			for(int i=0; i< this.lojas.length; i++) {
				arrayDuplicado[i] = this.lojas[i];
			}
			this.lojas = arrayDuplicado;
		}
	}
	
    public void alterarLoja (String nomeAntigo, Loja loja) {
		int indice = this.procurarIndice(nomeAntigo);
		lojas[indice] = loja;
	}
}


