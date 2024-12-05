package br.com.livraria.cliente;

import javax.naming.InitialContext;

import com.ibm.CORBA.iiop.PortableRemoteObject;

import br.com.livraria.modelo.Carrinho;
import br.com.livraria.modelo.Livro;

public class ClienteCarrinhoLivraria {

	public static void main(String[] args) throws Exception {
		
		for (int i = 0; i < 3; i++) {
			InitialContext ic = new InitialContext();
			Object stub = ic.lookup("ejb/livraria-ear/livraria-ejb.jar/CarrinhoBean#br.com.livraria.modelo.Carrinho");
			Carrinho carrinho = (Carrinho) new PortableRemoteObject().narrow(stub, Carrinho.class);

			Livro alice = new Livro();
			alice.setNome("Alice no País das Maravilhas " + i );
			alice.setPreco(15.0);
			carrinho.adicionaLivro(alice );

			Livro principe = new Livro();
			principe.setNome("Pequeno Príncipe " + i);
			principe.setPreco(15.0);
			carrinho.adicionaLivro(principe );

			double total = carrinho.obtemTotal();
			System.out.println(total);
			
			carrinho.finalizaCompra();
		}
		

		
	}
	
}
