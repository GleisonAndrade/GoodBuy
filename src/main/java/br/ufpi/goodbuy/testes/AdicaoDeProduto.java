//package br.ufpi.goodbuy.testes;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.cfg.AnnotationConfiguration;
//import org.hibernate.cfg.Configuration;
//import org.hibernate.service.ServiceRegistry;
//import org.hibernate.service.ServiceRegistryBuilder;
//
//import br.ufpi.goodbuy.dao.ProdutoDao;
////import br.ufpi.goodbuy.infra.CriadorDeSession;
//import br.ufpi.goodbuy.modelo.Produto;
//
//public class AdicaoDeProduto {
//
//	public static void main(String[] args) {
//		// Configuration configuration = new Configuration();
//		// configuration.configure();
//		// SessionFactory factory;
//		// ServiceRegistry serviceRegistry;
//		// serviceRegistry = new ServiceRegistryBuilder().applySettings(
//		// configuration.getProperties()).buildServiceRegistry();
//		//
//		// factory = configuration.buildSessionFactory(serviceRegistry);
//		// Session session = factory.openSession();
//
//		Produto produto = criaProduto();
//
//	///	ProdutoDao dao = new ProdutoDao();
//	//	dao.salva(produto);
//
//	}
//
//	private static Produto criaProduto() {
//		Produto produto = new Produto();
//		produto.setNome("Prateleira");
//		produto.setDescricao("Uma prateleira para colocar livros");
//		produto.setPreco(35.90);
//		return produto;
//	}
//
//}
