package ua.abdulaiev.hw15.task1;

public class MyNode<E> {
        protected E value;
        protected ua.abdulaiev.hw15.task1.MyNode<E> next;
        protected ua.abdulaiev.hw15.task1.MyNode<E> prev;

        public MyNode(E value) {
            this.value = value;
        }

}
