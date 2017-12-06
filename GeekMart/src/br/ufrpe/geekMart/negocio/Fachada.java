package br.ufrpe.geekMart.negocio;

import br.ufrpe.geekMart.classesBasicas.Anuncio;
import br.ufrpe.geekMart.classesBasicas.Loja;
import br.ufrpe.geekMart.classesBasicas.Usuario;
import br.ufrpe.geekMart.negocio.*;

public class Fachada {
	
	private ControladorAnuncio cadastroAnuncio;
	private static Fachada instancia;
	private ControleDeLogin controleLogin;
	private ControladorUsuario cadastroUsuario;
	private ControladorLoja cadastroLoja;

	private Fachada() {
		this.cadastroAnuncio = new ControladorAnuncio();
		this.cadastroLoja = new ControladorLoja();
		this.controleLogin = new ControleDeLogin();
		this.cadastroUsuario = new ControladorUsuario();
	}

	public static Fachada getInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
}
	
	// USUARIO
		public void cadastrarUsuario(Usuario user) {
			this.cadastroUsuario.cadastrarUsuario(user);
		}

		public Usuario buscaUsuario(String cpf) {
			return this.cadastroUsuario.buscarUsuario(cpf);
		}

		public void removerUsuario(String cpf){
			this.cadastroUsuario.removerUsuario(cpf);
		}

		public void alterarUsuario (Usuario usuario) {
			this.cadastroUsuario.alterarUsuario(usuario);
		}

		

		public void adicionarAnuncio(Anuncio anuncio) {
			this.cadastroAnuncio.cadastrarAnuncio(anuncio);
		}

		public Anuncio buscarAnuncio(String nome) {
			return this.cadastroAnuncio.buscarAnuncio(nome);
		}

	
		public void removerAnuncio(String titulo) {
			this.cadastroAnuncio.removerAnuncio(titulo);
		}

		
		public void alterarAnuncio (Anuncio anuncio) {
			this.cadastroAnuncio.alterarAnuncio(anuncio);
		}

		

		// LOJA

		

		public void novaLoja(String cpf, Loja loja) {
			this.cadastroLoja.cadastrarLoja(cpf, loja);
		}

		public Loja buscarLoja(String nome) {
			return this.cadastroLoja.buscarLoja(nome);
		}

		public void removerLoja(String cpf) {
			this.cadastroLoja.removerLoja(cpf);
		}

		public void alterarLoja(String cpf, Loja loja) {
			this.cadastroLoja.alterarLoja(cpf, loja);
		}

		

		// LOGIN

		public boolean autenticarLogin(String senha, String cpf) {
			return this.controleLogin.autenticarLogin(senha, cpf);
		}

		//ADM

		public void bloquearUsuario(String cpf){
			 this.cadastroUsuario.bloquearUsuario(cpf);
		}

		public void desbloquearUsuario(String cpf){
			this.cadastroUsuario.desbloquearUsuario(cpf);
		}
	
}
