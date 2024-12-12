package br.com.livraria.ejb;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.com.livraria.modelo.CotadorDeDolares;

@Singleton @Startup
public class NotificadorDeCotacaoDoDolarBean {
	
	@EJB
	private CotadorDeDolares cotadorDolares;

	@Schedule(hour="*", minute="*", second="30")
	public void notificaCotacaoDolar() {
		double cotacao = cotadorDolares.fazCotacao(1.0);
		System.out.println("Notificando que a cotação do dólar está em: R$ " + cotacao);
	}

	
}
