package br.ufrpe.geekMart.dados;
import br.ufrpe.geekMart.classesBasicas.Administrador;
import br.ufrpe.geekMart.classesBasicas.Usuario;
import java.util.ArrayList;
import java.util.List;


public class RepositorioAdministrador {

    private ArrayList<Administrador> administrador = new ArrayList<Administrador>();
    Administrador adm = new Administrador();
    private static RepositorioAdministrador instancia;

    public static RepositorioAdministrador getInstancia(){
        if(instancia == null){
            instancia = new RepositorioAdministrador();
        }
        return instancia;
    }
    private RepositorioAdministrador(){

    }

    public void cadastrarAdministrador(Administrador adm){
        this.administrador.add(adm);
    }

    public Administrador buscarAdministrador(String cpf){
        Administrador retorno = null;
        int indice = this.obterIndice(cpf);
        if(indice!=-1){
            retorno = this.administrador.get(indice);
        }
        return retorno;
    }
    private int obterIndice(String cpf){
        int indice = -1;
        for(int i=0;i<this.administrador.size();i++){
            if(this.administrador.get(i).getCpf().equals(cpf)){
                indice = i;
            }
        }
        return indice;
    }

    public boolean existe(String cpf){
        boolean existe = false;
        int indice = this.obterIndice(cpf);
        if(indice!=-1){
            existe = true;
        }
        return existe;
    }

    public void removerAdministrador(String cpf){
        int indice = this.obterIndice(cpf);
        if(indice!=-1){
            this.administrador.remove(indice);
        }
    }

    public void alterarAdministrador(Administrador adm){
        int indice = this.obterIndice(adm.getCpf());
        if(indice!=-1){
            this.administrador.set(indice, adm);
        }
    }

    public List<Administrador> mostrarAdms(){
        return this.administrador;
    }

    public boolean autenticarLoginAdm(String senha, String cpf){
        boolean retorno = false;
        adm = this.buscarAdministrador(cpf);
        boolean tipo = adm.getAdm();
        if(tipo!=false){
            boolean equivale = adm.getSenha().equals(senha);
            if(equivale!= false){
                    retorno = true;
                }

            }
            return retorno;
        }



    }




