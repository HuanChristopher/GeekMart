package br.ufrpe.geekMart.negocio;
import br.ufrpe.geekMart.gui.*;

import javax.swing.*;

public class ControleDeLogin {

		private ControladorUsuario cadastroUser;
		private static ControleDeLogin instancia;

		private static ControleDeLogin getInstancia() {
			if (instancia == null) {
				instancia = new ControleDeLogin();
			}
			return instancia;
		}

		private ControleDeLogin() {

			this.cadastroUser = ControladorUsuario.getInstancia();

		}

		public boolean autenticarLogin(String senha, String cpf) {
			/*CaixaTextoLogin texfield = new CaixaTextoLogin();

			texfield.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			texfield.setSize(310,180);
			texfield.setVisible(true);*/
			return this.cadastroUser.autenticarLogin(/*texfield.getUsuario(), texfield.getSenha()*/senha, cpf);
		}

	}


