package ua.abdulaiev.hw25.dao;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.abdulaiev.hw25.models.Owner;
import ua.abdulaiev.hw25.models.TyresType;
import ua.abdulaiev.hw25.models.Vehicle;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class VehicleDaoTest {
    private static VehicleDao vehicleDao;
    Vehicle vehicle;
    Vehicle vehicle1;
    Owner owner;
    Owner owner1;

    @BeforeAll
    static void beforeAll() {
        vehicleDao = new VehicleDao();
    }

    @BeforeEach
    void setUp() {
        owner = new Owner("Owner", "hello@gmail.com");
        owner1 = new Owner("Owner1", "world@gmail.com");
        vehicle = new Vehicle("Vehicle",
                LocalDate.of(2021, 8, 1),
                100, TyresType.SUMMER, LocalDate.now());
        vehicle.setOwner(owner);
        vehicle1 = new Vehicle("Vehicle1",
                LocalDate.of(2020, 12, 2),
                500, TyresType.WINTER, LocalDate.now());
        vehicle1.setOwner(owner1);
    }

    @Test
    void saveVehicle() {
        vehicleDao.saveVehicle(vehicle);
        Assertions.assertEquals(vehicle, vehicleDao.getVehicleById(1));
    }

    @Test
    void deleteVehicle() {
        vehicleDao.saveVehicle(vehicle);
        vehicleDao.deleteVehicle(vehicle.getId());
        Assertions.assertEquals(0, vehicleDao.getAllVehicles().size());
    }

    @Test
    void updateVehicle() {
        vehicleDao.saveVehicle(vehicle);
        vehicle.setPrice(1000);
        vehicleDao.updateVehicle(vehicle);
        Assertions.assertEquals(1000, vehicleDao.getVehicleById(1).getPrice());
    }

    @Test
    void getVehicleById() {
        vehicleDao.saveVehicle(vehicle);
        Assertions.assertEquals(vehicle, vehicleDao.getVehicleById(1));
    }

    @Test
    void getAllVehicles() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle);
        vehicleList.add(vehicle1);
        vehicleDao.saveVehicle(vehicle);
        vehicleDao.saveVehicle(vehicle1);
        Assertions.assertEquals(vehicleList, vehicleDao.getAllVehicles());
    }
}