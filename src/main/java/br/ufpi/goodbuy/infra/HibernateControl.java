//package br.ufpi.goodbuy.infra;
//
//import javax.enterprise.context.ApplicationScoped;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.cfg.AnnotationConfiguration;
//
//@ApplicationScoped
//public class HibernateControl {
//
//  private final SessionFactory factory;
//  public HibernateControl() {
//      this.factory = new AnnotationConfiguration().configure().buildSessionFactory();
//  }
//
//  public SessionFactory getSession() {
//      return factory;
//  }
//}