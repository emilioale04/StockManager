package epn.fis.stockmanager.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Configures and provides access to the Hibernate SessionFactory.
 */
public class HibernateConfig {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    /**
     * Builds the Hibernate SessionFactory using the configuration file.
     *
     * @return The configured SessionFactory instance.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError("Initial SessionFactory creation failed: " + ex);
        }
    }

    /**
     * Provides access to the Hibernate SessionFactory.
     *
     * @return The singleton SessionFactory instance.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     * Closes the SessionFactory to release resources.
     */
    public static void shutdown() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
