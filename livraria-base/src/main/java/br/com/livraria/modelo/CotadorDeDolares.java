package br.com.livraria.modelo;

import javax.ejb.Remote;

@Remote
public interface CotadorDeDolares {
	double fazCotacao(double quantia);
}
