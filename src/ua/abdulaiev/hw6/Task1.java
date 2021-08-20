package ua.abdulaiev.hw6;

import java.util.Arrays;

public class Task1 {
    public static void main(String[] args){
        Phone phone1 = new Phone("80808808", "Apple", 7.6);
        Phone phone2 = new Phone("9677436221", "Samsung");
        Phone phone3 = new Phone();

        phone2.weight = 6.9;
        phone3.number = "3238906885";
        phone3.model = "Huawei";
        phone3.weight = 8.2;

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);
        System.out.print(System.lineSeparator());

        System.out.println("Phone1 number: " + phone1.getNumber());
        System.out.println("Phone2 number: " + phone2.getNumber());
        System.out.println("Phone3 number: " + phone3.getNumber());
        System.out.print(System.lineSeparator());

        phone1.receiveCall("Алексей");
        phone1.receiveCall("Андрей");
    }
}
