package ba.unsa.etf.si2013.tim9.Klijenti;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;



public class HibernateUtil {

	private static final SessionFactory sessionFactory;
	private static final ServiceRegistry serviceRegistry;

	static {

		try {
		    Configuration cfg = new Configuration();
		    cfg.configure();

		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            cfg.getProperties()).build();
		    sessionFactory = cfg.buildSessionFactory(serviceRegistry);

		} catch (Throwable ex) {

			System.err.println("PROBLEEEm." + ex);

			throw new ExceptionInInitializerError(ex);

		}

	}

	public static SessionFactory getSessionFactory() {

		return sessionFactory;

	}

}