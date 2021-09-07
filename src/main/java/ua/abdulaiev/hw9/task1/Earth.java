package ua.abdulaiev.hw9.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Earth earth = (Earth) o;
        return Double.compare(earth.gravityAccel, gravityAccel) == 0 && atmosphere == earth.atmosphere
                && satellite == earth.satellite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gravityAccel, atmosphere, satellite);
    }
}
