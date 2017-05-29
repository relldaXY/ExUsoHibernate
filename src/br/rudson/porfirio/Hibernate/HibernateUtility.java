package br.rudson.porfirio.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import br.rudson.porfirio.Entidades.Usuario;




public class HibernateUtility {

	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration();
		configuration.addAnnotatedClass(Usuario.class);
		
		/*MAPEAMENTO DAS CLASS QUE USARAM O HIBERNATE*/
		
		/*
		configuration.addAnnotatedClass(Cliente.class);
		configuration.addAnnotatedClass(Motorista.class);
		configuration.addAnnotatedClass(Funcionario.class);
		*/
		
		configuration.configure();
		ServiceRegistryBuilder serviceRegistryBuilder = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		ServiceRegistry serviceRegistry = serviceRegistryBuilder
				.buildServiceRegistry();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static Session getSession() {
		Session session = sessionFactory.openSession();
		return session;
	}

}