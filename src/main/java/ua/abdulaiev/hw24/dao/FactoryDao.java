package ua.abdulaiev.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.abdulaiev.hw23.service.ConnectionRepository;
import ua.abdulaiev.hw24.models.Device;
import ua.abdulaiev.hw24.models.Factory;
import ua.abdulaiev.hw24.utils.HibernateUtils;

import javax.persistence.Query;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class FactoryDao {
    public void save(Factory factory) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(factory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Factory getFactoryById(int id) {
        Factory factory = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            factory = session.createQuery("SELECT f FROM Factory f WHERE f.id = :id", Factory.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return factory;
    }


    public List<Factory> findAllFactory() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT f FROM Factory f", Factory.class)
                    .list();
        }
    }

    public void update(Factory factory) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(factory);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteByID(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Query query = session.createQuery(
                    "DELETE FROM Factory f WHERE f.id = :id")
                    .setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void getSumAndCountObject() {
        Connection connection;
        PreparedStatement statement;
        ResultSet resultSet;
        try {
            String hql = "SELECT fc_id , COUNT(*) AS AllCount, SUM(price) " +
                    "AS AllPrice FROM Device d GROUP BY d.fc_id ORDER BY d.fc_id";
            connection = ConnectionRepository.getDBConnection();
            statement = connection.prepareStatement(hql);
            resultSet = statement.executeQuery();
            int columns = resultSet.getMetaData().getColumnCount();
            System.out.println("Amount and the sum of all objects of the Factory");
            if (resultSet.next()) {
                do {
                    for (int i = 1; i <= columns; i++) {
                        System.out.print(resultSet.getString(i) + " ");
                    }
                    System.out.println();
                } while (resultSet.next());
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
