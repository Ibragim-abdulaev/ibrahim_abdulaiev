package ua.abdulaiev.hw24.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.reflections.Reflections;
import ua.abdulaiev.hw24.models.Device;
import ua.abdulaiev.hw24.models.Factory;

import javax.persistence.Entity;
import java.util.Set;


public class HibernateUtils {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                Reflections reflections = new Reflections("models");
                Set<Class<?>> entities = reflections.getTypesAnnotatedWith(Entity.class);
                for (Class<?> entity : entities) {
                    configuration.addAnnotatedClass(entity);
                }
                configuration.addAnnotatedClass(Factory.class);
                configuration.addAnnotatedClass(Device.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}