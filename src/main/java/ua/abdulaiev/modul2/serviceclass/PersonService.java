package ua.abdulaiev.modul2.serviceclass;

import ua.abdulaiev.modul2.modelclass.Customer;

public class PersonService {
    public static Customer generateCustomer() {
        return new Customer(Util.randomInt(10000),
                Util.randomString(20) + "@gmail.com",
                Util.randomInt(100));
    }
}
