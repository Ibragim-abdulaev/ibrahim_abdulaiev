package ua.abdulaiev.hw9.task1;

public class Jupiter implements Planet{
    double gravityAccel = 24.79;
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
