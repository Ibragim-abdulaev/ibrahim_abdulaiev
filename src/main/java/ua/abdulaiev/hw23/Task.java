package ua.abdulaiev.hw23;

import ua.abdulaiev.hw23.service.AddObjects;
import ua.abdulaiev.hw23.service.ConnectionRepository;
import ua.abdulaiev.hw23.service.CreateTable;
import ua.abdulaiev.hw23.service.ServiceRepository;

public class Task {
    public static void main(String[] args) {
        //CreateTable.createTables();
        //AddObjects.fillTableDevice();
        //AddObjects.fillTableFactory();
        ServiceRepository.getDeviceAndFactory(7);
        ServiceRepository.changeDeviceForPrice(2);
        ServiceRepository.deleteObjectDeviceTable(4);
        ServiceRepository.getDevicesListByFactoryId(1);
        ServiceRepository.getSumAndCountObject();
        ConnectionRepository.closeConnection();
    }
}
