package ua.abdulaiev.hw15.task1;

public class MyList<E> {

    private MyNode<E> head;
    private MyNode<E> tail;
    private int length = 0;

    public void add(E value) {
        MyNode<E> nodes = new MyNode<>(value);
        if (head == null) {
            head = nodes;
        } else {
            MyNode<E> next = head.next;
            if (next == null) {
                head.next = nodes;
                nodes.prev = head;
            } else {
                while (next.next != null) {
                    next = next.next;
                }
                next.next = nodes;
                nodes.prev = next;
            }
        }
        tail = nodes;
        length++;
    }

    public E getFromLast(E value) {
        if (tail == null) {
            return null;
        }
        if (tail == head) {
            return tail.value;
        }
        MyNode<E> prevElem = tail;
        for (int i = 0; i < length; i++) {
            if (prevElem.value.equals(value)) {
                return prevElem.value;
            }
            prevElem = prevElem.prev;
        }
        return null;
    }
}