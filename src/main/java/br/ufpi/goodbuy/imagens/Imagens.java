package br.ufpi.goodbuy.imagens;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.IOUtils;
import br.com.caelum.vraptor.observer.upload.UploadedFile;
import br.ufpi.goodbuy.modelo.Produto;

public class Imagens {
	private File pastaImagens;

	public Imagens() {
		String caminhoImagens = "C:/img";// context.getRealPath("/resources/imagens");
		pastaImagens = new File(caminhoImagens);
		pastaImagens.mkdir();
	}

	public void salva(UploadedFile imagem, Produto produto) {
		File destino = new File(pastaImagens, produto.getId() + ".imagem");
//		boolean teste = true;
//		if(imagem.equals(is(notNullValue()))) teste = false;
//		validator.check(teste, new SimpleMessage("imagem.nula","imagem nula"));
//		boolean teste2 = true;
//		if (imagem.getContentType().startsWith("imagem")) teste2 = false;
//		validator.check(imagem.getContentType().startsWith("imagem"), new SimpleMessage("nao.eh.imagem","imagem invalida"));
		// validator.checking(new Validations() {
		// {
		// if (that(imagem, is(notNullValue()), "imagem", "imagem.nula")) {
		// that(imagem.getContentType(), startsWith("image"),
		// "imagem", "nao.eh.imagem");
		// }
		// }
		// });
		try {
			IOUtils.copy(imagem.getFile(), new FileOutputStream(destino));
			imagem.getFile().close();
		} catch (IOException e) {
			throw new RuntimeException("Erro ao copiar imagem", e);
		}
	}

	public File mostra(Produto produto) {
		File teste = new File(pastaImagens, produto.getId() + ".imagem");
		if (!teste.exists()) {
			teste = new File(new File("C:/img"), "default.imagem");
		}
		return teste;
	}
}