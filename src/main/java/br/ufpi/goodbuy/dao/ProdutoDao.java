package br.ufpi.goodbuy.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import br.ufpi.goodbuy.modelo.Produto;

@RequestScoped
public class ProdutoDao {

	private final Session session;

	protected ProdutoDao() {
		this(null);
	}

	@Inject
	public ProdutoDao(Session session) {
		this.session = session;
	}

	public void salva(final Produto produto) {
		session.saveOrUpdate(produto);
		session.flush();
	}

	public Produto carrega(Long id) {
		return (Produto) this.session.load(Produto.class, id);
	}

	public void remove(Produto produto) {
		session.delete(produto);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> listaTudo() {
		return this.session.createCriteria(Produto.class).list();
	}

	public void atualiza(Produto produto) {
		session.saveOrUpdate(produto);
		session.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Produto> busca(String nome) {
//		System.out.println("Entrei no DAO");
		return session.createCriteria(Produto.class)
				.add(Restrictions.ilike("nome", nome, MatchMode.ANYWHERE))
				.list();
	}

	public void recarrega(Produto produto) {
		System.out.println("recarrega");
		session.refresh(produto);
	}

}
