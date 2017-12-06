package br.ufrpe.geekMart.negocio;
import java.util.List;
import br.ufrpe.geekMart.dados.*;
import br.ufrpe.geekMart.classesBasicas.Administrador;
import br.ufrpe.geekMart.dados.RepositorioAdministrador;

public class ControladorAdministrador {
    private static ControladorAdministrador instancia;
    private RepositorioAdministrador repositorio;

    private ControladorAdministrador(){
        this.repositorio = RepositorioAdministrador.getInstancia();
    }

    public void cadastrarAdministrador(Administrador adm){
        if(adm!=null){
            boolean existe = this.repositorio.existe(adm.getCpf());
            if(existe!=true){
                this.repositorio.cadastrarAdministrador(adm);
            }
        }
    }

    public Administrador buscarAdministrador(String cpf){
        Administrador retorno = null;
        if(cpf!= null){
            retorno = this.repositorio.buscarAdministrador(cpf);
        }
        return retorno;
    }

    public void removerAdministrador(Administrador adm){
        if(adm!=null){
            if(this.repositorio.existe(adm.getCpf())!=false)
                this.repositorio.removerAdministrador(adm.getCpf());
        }
    }

    public void alterarAdministrador(Administrador adm){
        if(adm!=null){
            if(this.repositorio.existe(adm.getCpf())!= false)
                this.repositorio.alterarAdministrador(adm);
        }
    }

    public List<Administrador> mostrarAdms(){
        return this.repositorio.mostrarAdms();
    }

    public static ControladorAdministrador getInstancia(){
        if(instancia == null){
            instancia = new ControladorAdministrador();
        }
        return instancia;

    }

    public boolean autenticarLoginAdm(String senha, String cpf){
        boolean retorno = false;
        if(cpf!=null&&senha!=null){
            boolean existe = this.repositorio.existe(cpf);
            if(existe!=false){
                retorno = this.repositorio.autenticarLoginAdm(senha, cpf);
                }
            }
            return retorno;
        }
    }



