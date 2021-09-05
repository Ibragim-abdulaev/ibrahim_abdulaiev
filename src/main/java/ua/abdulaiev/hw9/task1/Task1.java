package ua.abdulaiev.hw9.task1;

public class Task1 {
    public static void main(String[] args) {
        Mercury mercury = new Mercury();
        Earth earth = new Earth();
        Jupiter jupiter = new Jupiter();
        Mars mars = new Mars();

        System.out.println("Acceleration of gravity Mercury: " + mercury.getGravityAccel() + ", Is Atmosphere: "
                + mercury.isAtmosphere() + ", Is Satellite: " + mercury.isSatellite());
        System.out.println("Acceleration of gravity Earth: " + earth.getGravityAccel() + ", Is Atmosphere: "
                + earth.isAtmosphere() + ", Is Satellite: " + earth.isSatellite());
        System.out.println("Acceleration of gravity Jupiter: " + jupiter.getGravityAccel() + ", Is Atmosphere: "
                + jupiter.isAtmosphere() + ", Is Satellite: " + jupiter.isSatellite());
        System.out.println("Acceleration of gravity Mars: " + mars.getGravityAccel() + ", Is Atmosphere: "
                + mars.isAtmosphere() + ", Is Satellite: " + mars.isSatellite());
    }
}
