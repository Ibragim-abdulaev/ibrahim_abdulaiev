package ua.abdulaiev.hw9.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Mars mars = (Mars) o;
        return Double.compare(mars.gravityAccel, gravityAccel) == 0 && atmosphere == mars.atmosphere
                && satellite == mars.satellite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gravityAccel, atmosphere, satellite);
    }
}
