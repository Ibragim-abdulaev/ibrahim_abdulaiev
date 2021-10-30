package ua.abdulaiev.hw24;

import ua.abdulaiev.hw24.dao.DeviceDao;
import ua.abdulaiev.hw24.dao.FactoryDao;
import ua.abdulaiev.hw24.models.Device;
import ua.abdulaiev.hw24.models.Factory;
import ua.abdulaiev.hw24.service.CreateDeviceAndFactory;
import ua.abdulaiev.hw24.service.ServiceDevice;
import ua.abdulaiev.hw24.service.ServiceFactory;

public class Task {
    private static final ServiceDevice SERVICE_DEVICE = new ServiceDevice();
    private static final ServiceFactory SERVICE_FACTORY = new ServiceFactory();
    private static final DeviceDao DEVICE_DAO = new DeviceDao();

    public static void main(String[] args) {
        CreateDeviceAndFactory.createDevice();
        System.out.println(SERVICE_DEVICE.findAllDevice());
        System.out.println(SERVICE_FACTORY.findAllFactories() + System.lineSeparator());
        System.out.println(SERVICE_DEVICE.getById(3));
        Device device = SERVICE_DEVICE.getById(3);
        device.setPrice(6000.0);
        SERVICE_DEVICE.updateDevice(device);
        System.out.println(SERVICE_DEVICE.getById(3) + System.lineSeparator());
        System.out.println(SERVICE_DEVICE.getById(1));
        SERVICE_DEVICE.deleteDevice(1);
        System.out.println(SERVICE_DEVICE.getById(1) + System.lineSeparator());
        System.out.println(SERVICE_FACTORY.findFactoryById(2));
        Factory factory = SERVICE_FACTORY.findFactoryById(2);
        factory.setNames("Vehicle");
        SERVICE_FACTORY.updateFactory(factory);
        System.out.println(SERVICE_FACTORY.findFactoryById(2) + System.lineSeparator());
        SERVICE_DEVICE.getDeviceFromFactoryId(2);
        for (Device dev : DEVICE_DAO.getDevicesAndFactory(DEVICE_DAO.getAllDevice().get(0).getFactoryId().getId())) {
            System.out.println(dev);
        }
        System.out.println();
        SERVICE_FACTORY.getCountAndSumFromAllFactories();
    }
}
