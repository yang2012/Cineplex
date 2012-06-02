package cineplex.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class DataBaseManager {
	private static DataBaseManager instance = null;

	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry = null;

	private DataBaseManager() {
		Configuration configuration = new Configuration();
	    configuration.configure();
	    serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();        
	    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	}

	public static DataBaseManager getInstance() {
		if (null == instance) {
			instance = new DataBaseManager();
		}

		return instance;
	}
	
	public Session openSession() {
		return sessionFactory.openSession();
	}
	
	public void closeSession() {
		sessionFactory.getCurrentSession().close();
	}
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
}
