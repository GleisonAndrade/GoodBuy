//package br.ufpi.goodbuy.infra;
//
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.inject.Produces;
//import javax.enterprise.inject.Specializes;
//import javax.inject.Inject;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//import br.com.caelum.vraptor.hibernate.SessionFactoryCreator;
//
//@Specializes
//public class CustomSessionFactory extends SessionFactoryCreator {  
//
//    private Session session;  
//    private SessionFactory factory;
//
//     /**
//     * @deprecated CDI eyes only
//     */
//    public CustomSessionFactory() {
//    }
//
//    @Inject
//    public CustomSessionFactory() {
//    	
//    }
//
//    @Produces @RequestScoped
//    public Session getInstance() {
//        session = factory.openSession();
//        return session;
//    }
//}