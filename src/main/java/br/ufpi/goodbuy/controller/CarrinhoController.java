package br.ufpi.goodbuy.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.ufpi.goodbuy.dao.ProdutoDao;
import br.ufpi.goodbuy.modelo.Carrinho;
import br.ufpi.goodbuy.modelo.Item;

@Controller
public class CarrinhoController {

	private final Carrinho carrinho;
	private final ProdutoDao dao;
	private final Result result;

	protected CarrinhoController() {
		this(null, null, null);
	}

	@Inject
	public CarrinhoController(Carrinho carrinho, ProdutoDao dao, Result result) {
		this.carrinho = carrinho;
		this.dao = dao;
		this.result = result;
	}

	// @Post("/carrinho")
	// public void adiciona(Item item) {
	// // System.out.println("Controller");
	// dao.recarrega(item.getProduto());
	// carrinho.adiciona(item);
	// result.redirectTo(this).visualiza();
	// }
	//
	// @Get
	// @Path("/carrinho")
	// public void visualiza() {
	// }
	//
	// @Delete("/carrinho/{indiceItem}")
	// public void remove(int indiceItem) {
	// carrinho.remove(indiceItem);
	// result.redirectTo(this).visualiza();
	// }
	@Post("/carrinho")
	public void adiciona(Item item) {
		dao.recarrega(item.getProduto());
		carrinho.adiciona(item);
		result.redirectTo(this).visualiza();
	}

	@Get
	@Path("/carrinho")
	public void visualiza() {
	}

	@Delete("/carrinho/{indiceItem}")
	public void remove(int indiceItem) {
		carrinho.remove(indiceItem);
		result.redirectTo(this).visualiza();
	}
}
