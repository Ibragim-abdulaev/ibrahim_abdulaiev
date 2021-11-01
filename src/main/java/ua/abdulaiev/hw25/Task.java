package ua.abdulaiev.hw25;

import ua.abdulaiev.hw25.dao.VehicleDao;
import ua.abdulaiev.hw25.models.Owner;
import ua.abdulaiev.hw25.models.TyresType;
import ua.abdulaiev.hw25.models.Vehicle;

import java.time.LocalDate;

public class Task {
    private static final VehicleDao VEHICLE_DAO = new VehicleDao();
    public static void main(String[] args) {
        Owner owner = new Owner("Owner");
        Owner owner1 = new Owner("Owner1");
        Vehicle vehicle = new Vehicle("Vehicle", owner, LocalDate.of(2021, 8, 1),
                100, TyresType.SUMMER, LocalDate.now());
        vehicle.setOwner(owner);
        Vehicle vehicle1 = new Vehicle("Vehicle1", owner1, LocalDate.of(2020, 12, 2),
                500, TyresType.WINTER, LocalDate.now());
        vehicle1.setOwner(owner1);
        VEHICLE_DAO.saveVehicle(vehicle);
        VEHICLE_DAO.saveVehicle(vehicle1);
        System.out.println("All Vehicle");
        VEHICLE_DAO.getAllVehicles().forEach(System.out::println);
        System.out.println(System.lineSeparator() + "Update price Vehicle");
        vehicle.setPrice(3000);
        vehicle1.setPrice(1000);
        VEHICLE_DAO.updateVehicle(vehicle);
        VEHICLE_DAO.updateVehicle(vehicle1);
        VEHICLE_DAO.getAllVehicles().forEach(System.out::println);
        System.out.println(System.lineSeparator() +"Delete Vehicle #1");
        VEHICLE_DAO.deleteVehicle(1);
        VEHICLE_DAO.getAllVehicles().forEach(System.out::println);
        System.out.println(System.lineSeparator() + "Get Vehicle id: #1");
        System.out.println(VEHICLE_DAO.getVehicleById(1));
    }
}
