package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.classesBasicas.*;

public interface IRepositorioUsuario {

     void cadastrarUsuario(Usuario c);
    void bloquearUsuario (String cpf);
    void desbloquearUsuario (String cpf);
     Usuario procurar(String num);
    void remover(String num);
    boolean autenticarLogin(String senha, String cpf);
    boolean existe(String cpf);
    void duplicaArrayUsuarios();
    void alterarUsuario(Usuario usuario);



}
