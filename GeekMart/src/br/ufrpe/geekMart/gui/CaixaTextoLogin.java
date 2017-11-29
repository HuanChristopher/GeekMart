package br.ufrpe.geekMart.gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import javax.swing.JLabel;

public class CaixaTextoLogin extends JFrame{
    private JTextField usuario;
    private JPasswordField senha;
    private JButton login, limpa;
    private JLabel user, pass;

    public String getUsuario () {
        return usuario.getText();
    }

    public String getSenha () {
        return new String(senha.getPassword());
    }

    public CaixaTextoLogin(){
        super("Login em Java");
        setLayout(new FlowLayout());

        Container c = getContentPane();
        c.setLayout(null);

        user = new JLabel("Usuário: ");
        user.setBounds(10, 10, 90, 30);
        c.add(user);

        usuario = new JTextField(15);
        usuario.setBounds(70, 10, 200, 30);
        c.add(usuario);

        pass = new JLabel("Senha:   ");
        pass.setBounds(10, 50, 90, 30);
        c.add(pass);

        senha = new JPasswordField(15);
        senha.setBounds(70, 50, 200, 30);
        c.add(senha);

        login = new JButton("Entrar");
        login.addActionListener(new ActionListener() {
                                    public void actionPerformed(ActionEvent evento){
                                        if(evento.getSource() == login) {
                                            getUsuario();
                                            getSenha();
                                        }

                                    }
                                }
        );
        login.setBounds(100, 90, 90, 40);
        c.add(login);
    }


}

