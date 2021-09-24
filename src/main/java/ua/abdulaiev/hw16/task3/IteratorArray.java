package ua.abdulaiev.hw16.task3;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IteratorArray<E> implements Iterator<E> {
    private final E[] array;
    private int pos = 0;

    public IteratorArray(E[] array) {
        this.array = array;
    }


    public boolean hasNext() {
        return pos < array.length;
    }

    public E next() {
        if(!hasNext()){
            throw new NoSuchElementException();
        }
        return array[pos++];
    }
}
