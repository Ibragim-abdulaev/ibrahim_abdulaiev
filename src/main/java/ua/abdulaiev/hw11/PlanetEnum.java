package ua.abdulaiev.hw11;

public enum PlanetEnum {
    MERCURY(0), VENUS(0), EARTH(1), MARS(2), JUPITER(67),
    SATURN(62), URANUS(27), NEPTUNE(17);

    private final int satellite;

    PlanetEnum(int satellite) {
        this.satellite = satellite;
    }

    public int getSatellite() {
        return satellite;
    }
}