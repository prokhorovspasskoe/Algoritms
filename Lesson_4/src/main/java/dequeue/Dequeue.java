package dequeue;

import linkedlist.TwoSideLinkedListImpl;

import java.util.ArrayList;

public class Dequeue<E> extends TwoSideLinkedListImpl<E> implements IDequeue<E>{


    private int i;
    private final ArrayList<Node<E>> nodeArrayList;

    public Dequeue() {
        this.nodeArrayList = new ArrayList<>();
    }

    @Override
    public E removeLast() {
        nodeArrayList.remove(i);
        if(i > 0) i--;
        E returnDelete = super.getLast();
        super.remove(super.getLast());
        return returnDelete;
    }

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        nodeArrayList.add(0, first);
    }

    @Override
    public void insertLast(E value) {
        i++;
        nodeArrayList.add(i, last);
        super.insertLast(value);
    }

    @Override
    public E removeFirst() {
        nodeArrayList.remove(0);
        return super.removeFirst();
    }

    @Override
    public boolean remove(E value) {
        for (int j = 0; j < nodeArrayList.size(); j++) {
            Node<E> buf = nodeArrayList.get(j);
            if(buf.equals(value)){
                nodeArrayList.remove(j);
                break;
            }
        }
        return super.remove(value);
    }
}
