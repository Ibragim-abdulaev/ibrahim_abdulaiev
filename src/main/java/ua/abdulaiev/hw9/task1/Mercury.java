package ua.abdulaiev.hw9.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mercury mercury = (Mercury) o;
        return Double.compare(mercury.gravityAccel, gravityAccel) == 0 && atmosphere == mercury.atmosphere
                && satellite == mercury.satellite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gravityAccel, atmosphere, satellite);
    }
}
