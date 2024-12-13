package br.com.livraria.modelo;

import java.util.List;
import java.util.Optional;

import javax.ejb.Local;

@Local
public interface LivroService {

	LivroEntity salvar(LivroEntity livro);

	LivroEntity atualizar(LivroEntity livro);

	void deletar(Long id);

	Optional<LivroEntity> buscarPorId(Long id);

	List<LivroEntity> listarTodos();

	Optional<LivroEntity> aplicarDesconto(Long id, double desconto);
}
