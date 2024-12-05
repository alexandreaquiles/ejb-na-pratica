package br.com.livraria.modelo;

import java.io.Serializable;

public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private double preco;

	@Override
	public String toString() {
		return "Livro [nome=" + nome + ", preco=" + preco + "]";
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

}
