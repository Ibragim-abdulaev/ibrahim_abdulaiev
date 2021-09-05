package ua.abdulaiev.hw9.task1;

public class Earth implements Planet {
    double gravityAccel = 9.8;
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
