package ua.abdulaiev.hw24.service;

import ua.abdulaiev.hw24.models.Device;
import ua.abdulaiev.hw24.models.Factory;

public class CreateDeviceAndFactory {
    private static final ServiceFactory serviceFactory = new ServiceFactory();
    private static final ServiceDevice serviceDevice = new ServiceDevice();
    public static void createDevice() {
        Factory factory1 = new Factory("Shoe", "China");
        serviceFactory.saveFactory(factory1);
        Factory factory2 = new Factory("Machine", "Ukraine");
        serviceFactory.saveFactory(factory2);
        Factory factory3 = new Factory("Door", "France");
        serviceFactory.saveFactory(factory3);
        Factory factory4 = new Factory("Clothing", "Italia");
        serviceFactory.saveFactory(factory4);

        Device device1 = new Device("Television", "Xiaomi", 5555.0, "2002-06-14", "text1", factory3);
        serviceDevice.saveDevice(device1);
        Device device2 = new Device("Television", "Samsung", 4322.0, "2008-01-31", "text2", factory1);
        serviceDevice.saveDevice(device2);
        Device device3 = new Device("Telephone", "Xiaomi", 3845.0, "2010-12-23", "text3", factory2);
        serviceDevice.saveDevice(device3);
        Device device4 = new Device("Telephone", "Huawei", 3134.0, "2001-10-13", "text4", factory4);
        serviceDevice.saveDevice(device4);
        Device device5 = new Device("Television", "Samsung", 9350.0, "2018-11-21", "text5", factory1);
        serviceDevice.saveDevice(device5);
        Device device6 = new Device("Telephone", "OnePlus", 9400.0, "2015-12-23", "text6", factory3);
        serviceDevice.saveDevice(device6);
        Device device7 = new Device("Television", "D600", 2100.0, "2006-09-27", "text7", factory2);
        serviceDevice.saveDevice(device7);
        Device device8 = new Device("Telephone", "Apple", 12200.0, "2005-07-25", "text8", factory4);
        serviceDevice.saveDevice(device8);
        Device device9 = new Device("Telephone", "Motorola", 5700.0, "2000-04-05", "text9", factory2);
        serviceDevice.saveDevice(device9);
        Device device10 = new Device("Television", "Smart", 5460.0, "2012-02-12", "text10", factory4);
        serviceDevice.saveDevice(device10);
    }
}
