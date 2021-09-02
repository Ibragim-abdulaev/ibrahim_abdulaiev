package ua.abdulaiev.hw9.task1;

public class Mercury implements Planet{
    double gravityAccel = 3.7;
    boolean atmosphere = false;
    boolean satellite = false;

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
