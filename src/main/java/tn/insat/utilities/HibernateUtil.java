package tn.insat.utilities;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author M. Romdhani
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final ServiceRegistry serviceRegistry;
    
    // The code below guaranties that our SessionFactory is a SINGLETON !
    // Reminder : Static initilization blocs are executed once when the classloader
    //            loads the class !
    static {      
        try {
            // Initialize the hibernate configuration.
             Configuration configuration = new Configuration().configure();
             
            // Build a service registry fron the properties of the configuration – 
            // This is new in Hibernate 4 ! 
            serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                                                        configuration.getProperties()).build();            
             
            // Build the SessionFactory !
             sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
