package br.com.livraria.ejb;

import javax.ejb.Stateless;

import br.com.livraria.modelo.Livro;

@Stateless
public class EstoqueBean {
	public void baixaEstoque(Livro livro) {
		System.out.println("Baixando estoque para o livro: " + livro.getNome());
	}

}
