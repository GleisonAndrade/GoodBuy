package br.ufpi.goodbuy.controller;

import java.util.List;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.Validator;
import br.ufpi.goodbuy.dao.ProdutoDao;
import br.ufpi.goodbuy.modelo.Produto;
import static br.com.caelum.vraptor.view.Results.*;

/**
 * @author Gleison
 *
 */

@Controller
public class ProdutosController {

	private final ProdutoDao dao;
	private final Result result;
	private final Validator validator;

	protected ProdutosController() {
		this(null, null, null);
	}

	//
	@Inject
	public ProdutosController(ProdutoDao dao, Result result, Validator validator) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
	}

	@Get("/produtos")
	public List<Produto> lista() {
		return dao.listaTudo();
	}

	// public void adiciona(final Produto produto) {
	// if (produto.getNome() == null || produto.getNome().length() < 3) {
	// validator.add(new SimpleMessage("produto.nome",
	// "Nome é obrigatório e precisa ter mais de 3 letras"));
	// }
	// if (produto.getDescricao() == null
	// || produto.getDescricao().length() > 40) {
	// validator.add(new SimpleMessage("produto.descricao",
	// "Descrição é obrigatória não pode ter mais que 40 letras"));
	// }
	// if (produto.getPreco() <= 0) {
	// validator.add(new SimpleMessage("produto.preco",
	// "Preço precisa ser positivo"));
	// }
	// validator.onErrorUsePageOf(this).formulario();
	// dao.salva(produto);
	// result.redirectTo(this).lista();
	// }

	@Post("/produtos")
	public void adiciona(final Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(this).formulario();
		dao.salva(produto);
		result.redirectTo(this).lista();
	}

	@Get("/produtos/novo")
	public void formulario() {
	}

	@Get("/produtos/{id}")
	public Produto edita(Long id) {
		return dao.carrega(id);
	}

	// public void altera(final Produto produto) {
	// if (produto.getNome() == null || produto.getNome().length() < 3) {
	// validator.add(new SimpleMessage("produto.nome",
	// "Nome é obrigatório e precisa ter mais de 3 letras"));
	// }
	// if (produto.getDescricao() == null
	// || produto.getDescricao().length() > 40) {
	// validator.add(new SimpleMessage("produto.descricao",
	// "Descrição é obrigatória não pode ter mais que 40 letras"));
	// }
	// if (produto.getPreco() <= 0) {
	// validator.add(new SimpleMessage("produto.preco",
	// "Preço precisa ser positivo"));
	// }
	// validator.onErrorUsePageOf(this).formulario();
	// dao.atualiza(produto);
	// result.redirectTo(this).lista();
	// }

	@Put("/produtos/{produto.id}")
	public void altera(final Produto produto) {
		validator.validate(produto);
		validator.onErrorUsePageOf(this).formulario();
		dao.atualiza(produto);
		result.redirectTo(this).lista();
	}

	@Delete("/produtos/{id}")
	public void remove(Long id) {
		Produto produto = dao.carrega(id);
		dao.remove(produto);
		result.redirectTo(this).lista();
	}

	@Get("/produtos/busca")
	public List<Produto> busca(String nome) {
		result.include("nome", nome);
		return dao.busca(nome);
	}

	@Get("/produtos/busca.json")
	public void buscaJson(String q) {
		result.use(json()).withoutRoot().from(dao.busca(q))
				.exclude("id", "descricao").serialize();
	}

//	public void busca(String nome) {
//		result.include("nome", nome);
//		result.use(representation()).from(dao.busca(q), "produtos")
//				.exclude("id", "descricao").serialize();
//	}

}