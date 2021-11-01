package ua.abdulaiev.hw25.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.abdulaiev.hw25.utils.HibernateUtils;
import ua.abdulaiev.hw25.models.Vehicle;

import java.util.List;

public class VehicleDao {
    public void saveVehicle(Vehicle vehicle) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(vehicle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateVehicle(Vehicle vehicle) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(vehicle);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void deleteVehicle(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Vehicle vehicle = session.get(Vehicle.class, id);
            if (vehicle != null) {
                session.delete(vehicle);
                System.out.println("Vehicle is deleted id: " + id);
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Vehicle getVehicleById(int id) {
        Vehicle vehicle = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            vehicle = session.createQuery("SELECT v FROM Vehicle v WHERE v.id = :id", Vehicle.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return vehicle;
    }

    public List<Vehicle> getAllVehicles() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT v FROM Vehicle v", Vehicle.class)
                    .list();
        }
    }
}
