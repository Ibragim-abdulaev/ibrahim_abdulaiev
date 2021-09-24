package ua.abdulaiev.hw16.task3;

public class Task3 {
    public static void main(String[] args) {
        Integer[] integers = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        IteratorArray<Integer> numbers = new IteratorArray<>(integers);
        while (numbers.hasNext()) {
            System.out.println(numbers.next());
            numbers.remove();
        }
    }
}
