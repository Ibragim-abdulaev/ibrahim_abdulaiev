package ua.abdulaiev.hw26.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.abdulaiev.hw26.models.Album;
import ua.abdulaiev.hw26.models.Customer;

import java.util.ArrayList;
import java.util.List;

class CustomerDaoTest {
    private static CustomerDao CUSTOMER_DAO;
    Customer customer1;
    Customer customer2;

    @BeforeAll
    static void beforeAll() {
        CUSTOMER_DAO = new CustomerDao();
    }

    @BeforeEach
    void setUp() {
        customer1 = new Customer("Customer1");
        customer2 = new Customer("Customer2");
    }

    @Test
    void saveCustomer() {
        CUSTOMER_DAO.saveCustomer(customer1);
        Assertions.assertEquals(customer1, CUSTOMER_DAO.getById(1));
    }

    @Test
    void updateCustomer() {
        CUSTOMER_DAO.saveCustomer(customer1);
        customer1.setName("Mafiosi");
        CUSTOMER_DAO.updateCustomer(customer1);
        Assertions.assertEquals(customer1, CUSTOMER_DAO.getById(1));
    }

    @Test
    void deleteCustomer() {
        CUSTOMER_DAO.saveCustomer(customer1);
        CUSTOMER_DAO.deleteCustomer(1);
        Assertions.assertEquals(0, CUSTOMER_DAO.getAllCustomer().size());
    }

    @Test
    void getCustomer() {
        CUSTOMER_DAO.saveCustomer(customer1);
        Assertions.assertEquals(customer1, CUSTOMER_DAO.getById(1));
    }

    @Test
    void getAllCustomer() {
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer1);
        customerList.add(customer2);
        CUSTOMER_DAO.saveCustomer(customer1);
        CUSTOMER_DAO.saveCustomer(customer2);
        Assertions.assertEquals(customerList, CUSTOMER_DAO.getAllCustomer());
    }

    @Test
    void buyRandomAlbum() {
        AlbumDao albumDao = new AlbumDao();
        albumDao.save(new Album());
        CUSTOMER_DAO.saveCustomer(customer1);
        CUSTOMER_DAO.buyRandomAlbum(customer1);
        Assertions.assertNotNull(CUSTOMER_DAO.getById(1).getCustomerBuying().getAlbum());
    }
}