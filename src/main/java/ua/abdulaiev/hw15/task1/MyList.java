package ua.abdulaiev.hw15.task1;

public class MyList<E> {

    private MyNode<E> head;
    private MyNode<E> tail;

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
    }

    public E getFromLast(E value) {
        if (tail == null) {
            return null;
        }
        if (tail == head) {
            return tail.value;
        }

        MyNode<E> prevElem = tail;
        if (prevElem.value.equals(value)) {
            return prevElem.value;
        } else {
            while (prevElem.value != null) {
                if (prevElem.value.equals(value)) {
                    return prevElem.value;
                }
                prevElem = prevElem.prev;
            }
        }
        return null;
    }
}

class MyNode<E> {
    protected E value;
    protected MyNode<E> next;
    protected MyNode<E> prev;

    public MyNode(E value) {
        this.value = value;
    }
}