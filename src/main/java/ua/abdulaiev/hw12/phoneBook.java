package ua.abdulaiev.hw12;

import java.util.Optional;

public class phoneBook {
    private static String[] phoneBook = new String[3];

    public static void main(String[] args) {
        phoneBook[0] = "016/161616";
        phoneBook[1] = "016/161617";
        phoneBook[2] = "016/161618";
        System.out.println("Index of number 016/161617 = "
                + findIndexByPhoneNumber(phoneBook, "016/161617"));
        System.out.println("Search with null " + findIndexByPhoneNumber(phoneBook, null));
    }

    public static Optional<Integer> findIndexByPhoneNumber(String[] array, String phoneNumber) {
        for (int i = 0; i < phoneBook.length; i++) {
            if (phoneNumber.equals(phoneBook[i])) {
                return Optional.of(i);
            }
        }
        return Optional.empty();
    }
}
