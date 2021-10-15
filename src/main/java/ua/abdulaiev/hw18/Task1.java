package ua.abdulaiev.hw18;

public class Task1 {
    public static void main(String[] args) {
        System.out.println(ServiceBoxFile.fillFromFile("Task18_Box.xml"));
        System.out.println();
        System.out.println(ServiceBoxFile.fillFromFile("Task18_Box.json"));
    }
}
