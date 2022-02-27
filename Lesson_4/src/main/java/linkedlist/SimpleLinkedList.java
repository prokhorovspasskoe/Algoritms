package linkedlist;

public class SimpleLinkedList<E> implements LinkedList<E>{
    protected int size;
    protected Node<E> first;

    @Override
    public void insertFirst(E value) {
        first = new Node<>(value, first);
        size++;
    }

    @Override
    public E removeFirst() {
        if(isEmpty()){
            return null;
        }
        Node<E> removedNode = first;
        first = removedNode.next;
        removedNode.next = null;
        size--;
        return removedNode.item;
    }

    @Override
    public boolean remove(E value) {
        Node<E> prev = null;
        Node<E> current = first;

        while(current != null){
            if(current.item.equals(value)){
                break;
            }
        }

        if(current == null){
            return false;
        }

        prev = current;
        current = current.next;

        if(current == first){
            removeFirst();
            return true;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    private Node<E> indexOf(E value) {
        Node<E> current = first;

        while(current != null){
            if(current.item.equals(value)){
                return current;
            }
            current = current.next;
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return indexOf(value) != null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> current = first;

        while(current != null){
            sb.append(current.item);
            if(current.next != null){
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.append("]").toString();
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public E getFirst() {
        return null;
    }
}
