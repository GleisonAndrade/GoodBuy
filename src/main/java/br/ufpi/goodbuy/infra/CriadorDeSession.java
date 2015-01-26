//package br.ufpi.goodbuy.infra;
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.inject.Disposes;
//import javax.enterprise.inject.Produces;
//import javax.inject.Inject;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//
//@SuppressWarnings("deprecation")
//
//public class CriadorDeSession{
//	private SessionFactory factory;
//
//	public Session getSession() {
//		AnnotationConfiguration configuration = new AnnotationConfiguration();
//		factory = configuration.configure().buildSessionFactory();
//		return factory.openSession();
//	}
//	
//	
//}