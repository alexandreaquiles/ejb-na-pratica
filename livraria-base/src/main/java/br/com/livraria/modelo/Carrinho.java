package br.com.livraria.modelo;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface Carrinho {

	void adicionaLivro(Livro livro);

	List<Livro> obtemLivros();

	double obtemTotal();

	void finalizaCompra();

}
