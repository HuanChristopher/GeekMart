package br.ufrpe.geekMart.negocio;

public class ControleDeLogin {

		private ControladorUsuario cadastroUser;

		public ControleDeLogin() {
			this.cadastroUser = new ControladorUsuario();
		}

		public boolean autenticarLogin (String senha, String cpf) {
			return this.cadastroUser.autenticarLogin(senha, cpf);
		}

	}


