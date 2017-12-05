package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.classesBasicas.Loja;
import br.ufrpe.geekMart.classesBasicas.Usuario;

public interface IRepositorioLoja {

    void cadastrar(Usuario user, Loja c);
    Loja procurar(String num);
    void remover(String num);
    boolean existe(String titulo);
    void duplicaArrayLojas();
    void alterarLoja(Loja loja);
}

