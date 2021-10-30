package ua.abdulaiev.hw24.service;

import ua.abdulaiev.hw23.object.Factory;
import ua.abdulaiev.hw24.dao.DeviceDao;
import ua.abdulaiev.hw24.models.Device;

import java.util.List;

public class ServiceDevice {
    private static final DeviceDao DEVICE_DAO = new DeviceDao();

    public ServiceDevice() {
    }

    public void saveDevice(Device device) {
        DEVICE_DAO.save(device);
    }

    public void deleteDevice(int id) {
        DEVICE_DAO.delete(id);
    }

    public Device getById(int id) {
        return DEVICE_DAO.getDeviceById(id);
    }

    public void updateDevice(Device device) {
        DEVICE_DAO.update(device);
    }

    public List<Device> findAllDevice() {
        return DEVICE_DAO.getAllDevice();
    }

    public Factory findFactoryById(int id) {
        return DEVICE_DAO.getFactoryById(id);
    }

    public void getDeviceFromFactoryId(int id){
        DEVICE_DAO.getDevicesAndFactory(id);
    }
}
