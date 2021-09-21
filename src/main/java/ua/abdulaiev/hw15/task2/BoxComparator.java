package ua.abdulaiev.hw15.task2;

import java.util.Comparator;

public class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x1, Box x2) {
        if (x1.value == 0 || x2.value == 0) {
            if (x1.value == 0) {
                return -1;
            }
            return 1;
        }
        return Integer.compare(x2.value, x1.value);
    }
}
