package br.ufpi.goodbuy.controller;

import javax.inject.Inject;

import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.validator.SimpleMessage;
import br.com.caelum.vraptor.validator.Validator;
import br.ufpi.goodbuy.dao.UsuarioDao;
import br.ufpi.goodbuy.modelo.Usuario;
import br.ufpi.goodbuy.modelo.UsuarioWeb;

@Controller
public class UsuariosController {
	private final UsuarioDao dao;
	private final Result result;
	private final Validator validator;
	private final UsuarioWeb usuarioWeb;

	protected UsuariosController() {
		this(null, null, null, null);
	}

	@Inject
	public UsuariosController(UsuarioDao dao, Result result,
			Validator validator, UsuarioWeb usuarioWeb) {
		this.dao = dao;
		this.result = result;
		this.validator = validator;
		this.usuarioWeb = usuarioWeb;
	}

	@Post("/usuarios")
	public void adiciona(final Usuario usuario) {
		if (dao.existeUsuario(usuario)) {
			validator.add(new SimpleMessage("usuario.login", "Login já existe"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).novo();
		dao.adiciona(usuario);
		result.redirectTo(ProdutosController.class).lista();
	}

	@Get("/login")
	public void loginForm() {
	}

	@Post("/login")
	public void login(Usuario usuario) {
		Usuario carregado = dao.carrega(usuario);
		if (carregado == null) {
			validator.add(new SimpleMessage("usuario.login",
					"Login e/ou senha inválidos"));
		}
		validator.onErrorUsePageOf(UsuariosController.class).loginForm();
		usuarioWeb.login(carregado);
		result.redirectTo(ProdutosController.class).lista();
	}

	@Path("/logout")
	public void logout() {
		usuarioWeb.logout();
		result.redirectTo(ProdutosController.class).lista();
	}

	public void novo() {
	}
}
