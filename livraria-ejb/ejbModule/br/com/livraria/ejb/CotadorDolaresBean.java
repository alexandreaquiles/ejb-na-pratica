package br.com.livraria.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;

import br.com.livraria.modelo.CotadorDeDolares;

@Stateless
public class CotadorDolaresBean implements CotadorDeDolares {

	public CotadorDolaresBean() {
		System.out.println("Executando o construtor antes da injeção: " + this);
	}


	@PostConstruct
	public void inicializa() {
		System.out.println("Executando um método de callback após a injeção: "  + this);
	}

	
	@Override
	public double fazCotacao(double quantia) {
		System.out.println("Fazendo cotação: " + this);
		return quantia * 6;
	}
	
	@PreDestroy
	public void antesDeDestruir() {
		System.out.println("Antes de destruir: " + this);
	}


}
