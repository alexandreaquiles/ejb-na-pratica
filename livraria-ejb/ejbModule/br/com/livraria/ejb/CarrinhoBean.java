package br.com.livraria.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.EJB;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Remove;
import javax.ejb.Stateful;

import br.com.livraria.modelo.Carrinho;
import br.com.livraria.modelo.Livro;

@Stateful
//@StatefulTimeout(value = 30, unit = TimeUnit.SECONDS)
public class CarrinhoBean implements Carrinho {
	
	@EJB
	private EstoqueBean estoque;
	
	private List<Livro> livros = new ArrayList<>();
	private double total = 0.0;
	
	public CarrinhoBean() {
		System.out.println("Executando o construtor antes da injeção: " + this);
	}

	@PostConstruct
	public void inicializa() {
		System.out.println("Executando um método de callback após a injeção: "  + this);
	}

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

	@Remove
	@Override
	public void finalizaCompra() {
		System.out.println("Finalizando compra: " + this);
		for (Livro livro : livros) {
			estoque.baixaEstoque(livro);
			System.out.println("Comprou livro " + livro.getNome() );
		}
	}
	
	@PrePassivate
	public void antesDePassivar() {
		System.out.println("Antes de passivar: " + this);
	}

	@PostActivate
	public void depoisDeAtivar() {
		System.out.println("Depois de ativar: " + this);
	}

	@PreDestroy
	public void antesDeDestruir() {
		System.out.println("Antes de destruir: " + this);
	}


}
