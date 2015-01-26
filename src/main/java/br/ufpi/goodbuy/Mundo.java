package br.ufpi.goodbuy;

import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Controller;
import br.ufpi.goodbuy.modelo.Produto;

/**
 * @author Gleison
 *
 */
@Controller
public class Mundo {

	public String boasVindas() {
		return "olá mundo!";
	}

	public List<String> paises() {
		List<String> result = new ArrayList<String>();
		result.add("Brasil");
		result.add("Portugal");
		result.add("Japão");
		result.add("Canadá");
		result.add("Paraguai");
		return result;
	}
	
	public Produto produto(){
		Produto p = new Produto();
		p.setDescricao("Teste");
		p.setNome("Sem nome");
		p.setPreco(100000.00);
		return p;
	}

}