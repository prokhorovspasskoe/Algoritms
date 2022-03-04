package linkedlist;

public class TwoSideLinkedListImpl<E> extends SimpleLinkedList<E> implements TwoSideLinkedList<E>{

    protected Node<E> last;

    @Override
    public void insertFirst(E value) {
        super.insertFirst(value);
        if(size == 1){
            last = first;
        }
    }

    @Override
    public E removeFirst() {
        E removedValue = super.removeFirst();
        if(isEmpty()){
            last = null;
        }
        return removedValue;
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

        if(current == last){
            last = prev;
            last.next = null;
        }

        prev.next = current.next;
        current.next = null;
        size--;

        return true;
    }

    @Override
    public void insertLast(E value) {
        if(isEmpty()){
            insertLast(value);
            return;
        }
        Node<E> newNode = new Node<>(value, null, null);
        last.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E getLast() {
        return null;
    }
}
