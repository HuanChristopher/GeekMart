package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Administrador;
import br.ufrpe.geekMart.classesBasicas.Anuncio;
import br.ufrpe.geekMart.classesBasicas.Loja;
import br.ufrpe.geekMart.classesBasicas.Usuario;
import br.ufrpe.geekMart.negocio.*;

import java.util.List;

public class Fachada {
	
	private ControladorAnuncio cadastroAnuncio;
	private static Fachada instancia;
	private ControleDeLogin controleLogin;
	private ControladorUsuario cadastroUsuario;
	private ControladorLoja cadastroLoja;
	private ControladorAdministrador cadastroAdm;

	private Fachada() {
		this.cadastroAnuncio = ControladorAnuncio.getInstancia();
		this.cadastroLoja = ControladorLoja.getInstancia();
		this.controleLogin = ControleDeLogin.getInstancia();
		this.cadastroUsuario = ControladorUsuario.getInstancia();
		this.cadastroAdm = ControladorAdministrador.getInstancia();
	}

	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
    }


	    // USUARIO

		public void cadastrarUsuario  (Usuario user) {
			this.cadastroUsuario.cadastrarUsuario(user);
		}

		public Usuario buscaUsuario (String cpf) {
			return this.cadastroUsuario.buscarUsuario(cpf);
		}

		public void removerUsuario (String cpf){
			this.cadastroUsuario.removerUsuario(cpf);
		}


        // ANUNCIO

		public void adicionarAnuncio (Anuncio anuncio) {
			this.cadastroAnuncio.cadastrarAnuncio(anuncio);
		}

		public Anuncio buscarAnuncio (String nome) {
			return this.cadastroAnuncio.buscarAnuncio(nome);
		}


		public void removerAnuncio (String titulo) {
			this.cadastroAnuncio.removerAnuncio(titulo);
		}


		public void alterarAnuncio (Anuncio anuncio) {
			this.cadastroAnuncio.alterarAnuncio(anuncio);
		}

		public Anuncio[] getAnunciosCategoria (String categoria) {
			return this.cadastroAnuncio.getAnunciosCategoria(categoria);
		}


		// LOJA

		public void novaLoja (String cpf, Loja loja) {
			this.cadastroLoja.cadastrarLoja(cpf, loja);
		}

		public Loja buscarLoja (String nome) {
			return this.cadastroLoja.buscarLoja(nome);
		}

		public void removerLoja (String cpf) {
			this.cadastroLoja.removerLoja(cpf);
		}

		public void alterarLoja (String cpf, Loja loja) {
			this.cadastroLoja.alterarLoja(cpf, loja);
		}


		// LOGIN

		public boolean autenticarLogin (String senha, String cpf) {
			return this.controleLogin.autenticarLogin(senha, cpf);
		}

		public boolean autenticarLoginAdm (String senha, String cpf) {return this.controleLogin.autenticarLoginAdm(senha, cpf);}


		//ADM

		public void bloquearUsuario (String cpf){
			 this.cadastroUsuario.bloquearUsuario(cpf);
		}

		public void desbloquearUsuario (String cpf){
			this.cadastroUsuario.desbloquearUsuario(cpf);
		}

	    public void cadastrarAdministrador (Administrador adm) {this.cadastroAdm.cadastrarAdministrador(adm);}

	    public void removerAdministrador (Administrador adm) {this.cadastroAdm.removerAdministrador(adm);}

	    public void alterarAdministrador (Administrador adm) {this.cadastroAdm.alterarAdministrador(adm);}

	    public List<Administrador> mostrarAdms () {return this.cadastroAdm.mostrarAdms();}

	    public Administrador buscarAdministrador (String cpf) { return this.cadastroAdm.buscarAdministrador(cpf);}











	}
