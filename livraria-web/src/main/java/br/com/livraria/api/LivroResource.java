package br.com.livraria.api;

import java.net.URI;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import br.com.livraria.modelo.LivroEntity;
import br.com.livraria.modelo.LivroService;

@Path("/livros")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LivroResource {

	@Inject
	private LivroService livroService;

	@GET
	public Response listarTodos() {
		List<LivroEntity> livros = livroService.listarTodos();
		return Response.ok(livros).build();
	}

	@GET
	@Path("/{id}")
	public Response buscarPorId(@PathParam("id") Long id) {
		return livroService.buscarPorId(id).map(livro -> Response.ok(livro).build())
				.orElse(Response.status(Response.Status.NOT_FOUND).build());
	}

	@POST
	public Response criar(LivroEntity livro, @Context UriInfo uriInfo) {
		LivroEntity novo = livroService.salvar(livro);
		URI location = uriInfo.getAbsolutePathBuilder().path(String.valueOf(novo.getId())).build();
		return Response.created(location).entity(novo).build();
	}

	@PUT
	@Path("/{id}")
	public Response atualizar(@PathParam("id") Long id, LivroEntity livro) {
		livro.setId(id);
		try {
			LivroEntity atualizado = livroService.atualizar(livro);
			return Response.ok(atualizado).build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

	@DELETE
	@Path("/{id}")
	public Response remover(@PathParam("id") Long id) {
		try {
			livroService.deletar(id);
			return Response.noContent().build();
		} catch (IllegalArgumentException e) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	@Path("/{id}/promo")
	@PUT
	public Response megaPromocao(@PathParam("id") Long id) {
		return livroService.aplicarDesconto(id, 0.5)
			.map(livro -> Response.ok(livro))
			.orElse(Response.status(Response.Status.NOT_FOUND))
			.build();
	}

}
