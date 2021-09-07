package ua.abdulaiev.hw9.task1;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Jupiter jupiter = (Jupiter) o;
        return Double.compare(jupiter.gravityAccel, gravityAccel) == 0 && atmosphere == jupiter.atmosphere
                && satellite == jupiter.satellite;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gravityAccel, atmosphere, satellite);
    }
}
