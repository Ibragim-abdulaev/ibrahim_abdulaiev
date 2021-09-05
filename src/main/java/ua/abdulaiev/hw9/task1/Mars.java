package ua.abdulaiev.hw9.task1;

public class Mars implements Planet {
    double gravityAccel = 3.72;
    boolean atmosphere = true;
    boolean satellite = true;

    public boolean isAtmosphere() {
        return atmosphere;
    }

    public boolean isSatellite() {
        return satellite;
    }

    @Override
    public double getGravityAccel() {
        return gravityAccel;
    }
}
