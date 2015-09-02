package br.ufpi.goodbuy.controller;

import javax.enterprise.context.RequestScoped;

import br.com.caelum.vraptor.Accepts;
import br.com.caelum.vraptor.AroundCall;
import br.com.caelum.vraptor.Intercepts;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.controller.ControllerMethod;
import br.com.caelum.vraptor.interceptor.SimpleInterceptorStack;
import br.ufpi.goodbuy.modelo.UsuarioWeb;

@Intercepts
@RequestScoped
public class AutorizacaoInterceptor {
	private final UsuarioWeb usuario;
	private final Result result;

	public AutorizacaoInterceptor(UsuarioWeb usuario, Result result) {
		this.usuario = usuario;
		this.result = result;
	}

	@Accepts
	public boolean accepts(ControllerMethod method) {
		return !usuario.isLogado() && method.containsAnnotation(Restrito.class);
	}

	@AroundCall
	public void intercept(SimpleInterceptorStack stack,
			ControllerMethod method, Object resourceInstance) {
		result.redirectTo(UsuariosController.class).loginForm();
	}
}
