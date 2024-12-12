package br.com.livraria.ejb;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.livraria.modelo.LivroEntity;
import br.com.livraria.modelo.LivroService;

@Stateless
public class LivroServiceBean implements LivroService {
	
	@PersistenceContext(unitName = "livrariapu")
	private EntityManager em;
	
	public LivroServiceBean() {
		System.out.println("Chamou construtor de LivroServiceBean: " + this);
	}

	@PostConstruct
	public void inicializa() {
		System.out.println("Inicializou LivroServiceBean: " + this);
	}
	
	@Override
	public LivroEntity salvar(LivroEntity livro) {
		em.persist(livro);
		return livro;
	}

	@Override
	public LivroEntity atualizar(LivroEntity livro) {
		return em.merge(livro);
	}

	@Override
	public void deletar(Long id) {
		buscarPorId(id)
			.ifPresent(livro -> em.	remove(livro));
	}

	@Override
	public Optional<LivroEntity> buscarPorId(Long id) {
		LivroEntity livro = em.find(LivroEntity.class, id);
		return Optional.ofNullable(livro);
	}

	@Override
	public List<LivroEntity> listarTodos() {
		return em.createQuery("select l from LivroEntity l", LivroEntity.class).getResultList();
	}

}
