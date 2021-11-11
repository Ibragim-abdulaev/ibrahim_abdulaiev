package ua.abdulaiev.hw26.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import ua.abdulaiev.hw24.models.Device;
import ua.abdulaiev.hw24.models.Factory;
import ua.abdulaiev.hw26.models.*;

import javax.persistence.Entity;
import java.util.Set;

public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Album.class);
                configuration.addAnnotatedClass(Artist.class);
                configuration.addAnnotatedClass(Customer.class);
                configuration.addAnnotatedClass(CustomerBuying.class);
                configuration.addAnnotatedClass(Order.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
