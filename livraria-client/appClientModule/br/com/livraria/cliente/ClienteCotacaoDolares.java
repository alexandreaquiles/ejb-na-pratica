package br.com.livraria.cliente;

import javax.naming.InitialContext;

import com.ibm.CORBA.iiop.PortableRemoteObject;

import br.com.livraria.modelo.CotadorDeDolares;

public class ClienteCotacaoDolares {

	public static void main(String[] args) throws Exception {

		for (int i = 0; i < 10; i++) {

			new Thread(() -> {
				
				try {

				InitialContext ic = new InitialContext();
				Object stub = ic.lookup(
						"ejb/livraria-ear/livraria-ejb.jar/CotadorDolaresBean#br.com.livraria.modelo.CotadorDeDolares");
				CotadorDeDolares cotador = (CotadorDeDolares) new PortableRemoteObject().narrow(stub,
						CotadorDeDolares.class);
				double cotacao = cotador.fazCotacao(1);
				System.out.println(cotacao);
				
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}

			}).start();

		}
	}

}
