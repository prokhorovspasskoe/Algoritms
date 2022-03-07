package ru.prokhorov;

public interface Tree<E> {
    enum TraversMode {
        IN_ORDER, PRE_ORDER, POST_ORDER
    }

    boolean contains(E value);

    boolean add(E value);

    boolean remove(E value);

    boolean isEmpty();

    int size();

    void display();

    void traverse(TraversMode mode);
}
