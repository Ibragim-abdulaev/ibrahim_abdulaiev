package ua.abdulaiev.hw12;

public class Task3 {
    public static void main(String[] args) {
        try {
            throwThreeException(-1);
        } catch (OneException | TwoException | ThreeException exception) {
            exception.printStackTrace();
        }
    }

    public static void throwThreeException(int number) throws OneException, TwoException, ThreeException {
        if (number == 0) {
            throw new OneException("Число равно нулю");
        }
        if (number > 0) {
            throw new TwoException("Число больше нуля");
        } else {
            throw new ThreeException("Число меньше нуля");
        }
    }
}

class OneException extends Exception {
    public OneException(String message) {
        super(message);
    }
}

class TwoException extends Exception {
    public TwoException(String message) {
        super(message);
    }
}

class ThreeException extends Exception {
    public ThreeException(String message) {
        super(message);
    }
}
