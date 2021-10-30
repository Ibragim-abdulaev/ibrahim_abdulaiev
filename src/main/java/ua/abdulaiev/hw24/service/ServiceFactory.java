package ua.abdulaiev.hw24.service;

import ua.abdulaiev.hw24.models.Factory;
import ua.abdulaiev.hw24.dao.FactoryDao;

import java.util.List;

public class ServiceFactory {
    private FactoryDao factoryDao = new FactoryDao();

    public ServiceFactory() {
    }

    public Factory findFactoryById(int id) {
        return factoryDao.getFactoryById(id);
    }

    public void saveFactory(Factory factory) {
        factoryDao.save(factory);
    }

    public void deleteFactory(int id) {
        factoryDao.deleteByID(id);
    }

    public void updateFactory(Factory factory) {
        factoryDao.update(factory);
    }

    public List<Factory> findAllFactories() {
        return factoryDao.findAllFactory();
    }

    public void getCountAndSumFromAllFactories() {
        factoryDao.getSumAndCountObject();
    }
}
