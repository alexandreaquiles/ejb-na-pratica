package br.com.livraria.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import br.com.livraria.modelo.Carrinho;
import br.com.livraria.modelo.Livro;

@Stateful
public class CarrinhoBean implements Carrinho {
	
	private List<Livro> livros = new ArrayList<>();
	private double total = 0.0;
	

	@Override
	public void adicionaLivro(Livro livro) {
		System.out.println("Adicionando livro " + livro.getNome() + " : " + this);
		this.livros.add(livro);
		this.total += livro.getPreco();
	}

	@Override
	public List<Livro> obtemLivros() {
		System.out.println("Retornando livros: " + this);
		return this.livros;
	}

	@Override
	public double obtemTotal() {
		System.out.println("Obtendo total: " + this);
		return this.total;
	}

	@Override
	public void finalizaCompra() {
		System.out.println("Finalizando compra: " + this);
		for (Livro livro : livros) {
			System.out.println("Comprou livro " + livro.getNome() );
		}
	}

}
