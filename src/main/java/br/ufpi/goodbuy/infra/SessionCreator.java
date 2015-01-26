//package br.ufpi.goodbuy.infra;
//
//import javax.enterprise.context.RequestScoped;
//import javax.enterprise.inject.Disposes;
//import javax.enterprise.inject.Produces;
//import javax.inject.Inject;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//
//@RequestScoped
//public class SessionCreator {
//
//    @Inject private SessionFactory sessionFactory;
//
//    @Produces @RequestScoped
//    public Session getSession() {
//        return sessionFactory.openSession();
//    }
//
//    public void close(@Disposes Session session) {
//        if (session.isOpen()) {
//            session.close();
//        }
//    }
//}