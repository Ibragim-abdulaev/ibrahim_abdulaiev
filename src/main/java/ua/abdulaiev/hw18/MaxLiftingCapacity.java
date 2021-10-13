package ua.abdulaiev.hw18;

public class MaxLiftingCapacity {
    protected String unit;
    protected int value;

    public MaxLiftingCapacity(String unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public MaxLiftingCapacity() {
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "MaxLiftingCapacity{" +
                "unit='" + unit + '\'' +
                ", value=" + value +
                '}';
    }
}
