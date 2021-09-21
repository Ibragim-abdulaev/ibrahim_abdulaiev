package ua.abdulaiev.hw15.task1;

public class Task1 {
    public static void main(String[] args) {
        MyList<Integer> myList = new MyList<>();
        for (int i = 0; i < 5; i++) {
            myList.add(i);
        }
        System.out.println(myList.getFromLast(0));
        System.out.println(myList.getFromLast(4));
    }
}
