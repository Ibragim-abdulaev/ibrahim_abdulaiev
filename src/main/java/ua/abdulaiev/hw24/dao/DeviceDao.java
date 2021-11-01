package ua.abdulaiev.hw24.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.abdulaiev.hw23.object.Factory;
import ua.abdulaiev.hw24.models.Device;
import ua.abdulaiev.hw24.utils.HibernateUtils;

import javax.persistence.Query;
import java.util.List;

public class DeviceDao {
    public void save(Device device) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.saveOrUpdate(device);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public Device getDeviceById(int id) {
        Device device = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            device = session.createQuery("SELECT d FROM Device d WHERE d.id = :id", Device.class)
                    .setParameter("id", id)
                    .stream().findFirst().orElse(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return device;
    }

    public void update(Device device) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(device);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Device> getAllDevice() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT d FROM Device d", Device.class)
                    .list();
        }
    }

    public Factory getFactoryById(int id) {
        return HibernateUtils.getSessionFactory().openSession().get(Factory.class, id);
    }

    public List<Device> getDevicesAndFactory(int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(
                    "SELECT d FROM Device d " +
                            "INNER JOIN Factory f " +
                            "ON d.factoryId.id = f.id AND f.id = :id", Device.class)
                    .setParameter("id", id)
                    .list();
        }
    }

    public void delete(int id) {
        Transaction transaction = null;

        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Device device = session.get(Device.class, id);
            if (device != null) {
                session.delete(device);
                System.out.println("Device is deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
