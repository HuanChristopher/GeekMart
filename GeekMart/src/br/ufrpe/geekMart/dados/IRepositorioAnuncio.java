package br.ufrpe.geekMart.dados;

import br.ufrpe.geekMart.classesBasicas.Anuncio;

public interface IRepositorioAnuncio {

    void cadastrar(Anuncio c);
    Anuncio procurar(String num);
    void remover(String num);
    boolean existe(String titulo);
    void duplicaArrayAnuncios();
    void alterarAnuncio(Anuncio anuncio);


}
