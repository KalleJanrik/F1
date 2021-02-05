package ItteratorList;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLListIterator<E> implements Iterable<E>{



    private static class Node<E> {
        private E data;
        private Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node<E> head;
    private int size;
    public SLListIterator(){
        head = null;
        size = 0;
    }
    public void add(int index, E item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if (index == 0) {
            addFirst(item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    private void addFirst(E item) {
        head =
                new Node<E>(item, head);
        size++;
    }

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }

    private void addAfter(Node<E> node, E item) {
        node.next =
                new Node<E>(item, node.next);
        size++;
    }
    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }

    public Iterator<E> iterator() {
        return new Itr(head);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<E> p = head;
        if (p != null) {
            while (p.next != null) {
                sb.append(p.data.toString());
                sb.append(" ==> ");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private class Itr implements Iterator<E> {//nested class – ligger i SingleLinkedList

        private Node<E> current;
        private Node<E> beforeCurrent;
        private Node<E> beforeBeforeCurrent;
        public Itr(Node<E> start) {
            current = start;
            beforeCurrent = null;
            beforeBeforeCurrent = null;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }
        @Override
        public E next() {
            if (current == null) {
                throw new NoSuchElementException();
            }
            E returnValue = current.data;
            beforeBeforeCurrent = beforeCurrent;
            beforeCurrent = current;
            current = current.next;
            return returnValue;
        }
        @Override
        public void remove(){

            if(beforeCurrent == null || beforeBeforeCurrent == beforeCurrent){
                throw new IllegalStateException("Call next first");
            }
            if(beforeBeforeCurrent == null){
                head = current;
            }else{
                beforeBeforeCurrent.next = current;
            }
            beforeCurrent = beforeBeforeCurrent;
            size--;
        }
    }

}
