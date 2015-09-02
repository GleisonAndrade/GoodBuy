package br.ufpi.goodbuy.controller;

import java.io.File;

import javax.inject.Inject;


import br.ufpi.goodbuy.controller.ProdutosController;
import br.ufpi.goodbuy.imagens.Imagens;
import br.ufpi.goodbuy.modelo.*;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.com.caelum.vraptor.validator.Validator;

@Controller
public class ImagensController {
	private final Validator validator;
	private final Imagens imagens;
	private final Result result;

	protected ImagensController() {
		this(null, null, null);
	}

	@Inject
	public ImagensController(Validator validator, Imagens imagens, Result result) {
		this.validator = validator;
		this.imagens = imagens;
		this.result = result;
	}

	@Post("/produtos/{produto.id}/imagem")
	public void upload(Produto produto, final UploadedFile imagem) {

		validator.onErrorRedirectTo(ProdutosController.class).edita(
				produto.getId());
		imagens.salva(imagem, produto);
		result.redirectTo(ProdutosController.class).edita(produto.getId());
	}

	@Get("/produtos/{produto.id}/imagem")
	public File download(Produto produto) {
		return imagens.mostra(produto);
	}
}
