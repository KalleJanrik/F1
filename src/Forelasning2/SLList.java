package Forelasning2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SLList<E> implements Iterable<E> {

    public static void main(String[] args) {

        SLList<String> list = new SLList<>();
        //Test a basic list and see if the tail is following
        for (int i = 0; i <= 10; i++) {//O(n^2)
            list.add("Sträng" + i);
            for (String s : list) { //O(n)
                System.out.println(s);
            }
        }
        System.out.println("Tail: " + list.tail.data + "\n" + "Size: " + list.size);

        System.out.println(list.get(2));


        list.remove(10);
        list.printDataHeadTailSize("Testing to remove last item");

        list.remove(3);
        list.printDataHeadTailSize("Testing to remove in the middle");


        list.add(5, "Mellan 5 och 6");
        list.printDataHeadTailSize("Testing to add in the middle");

        list.remove(0);
        list.printDataHeadTailSize("Testing to remove the head");

        list.add(0, "First");
        list.printDataHeadTailSize("Testing to add a new item to the head");


        SLList<String> smallL = new SLList<>();

        smallL.add("One item");
        smallL.printDataHeadTailSize("Check head and tail");

        smallL.add(0, "Zero item");
        smallL.printDataHeadTailSize("Try to add to head");

        smallL.remove(0);
        smallL.printDataHeadTailSize("Remove head");

        smallL.remove(0);
        smallL.printDataHeadTailSize("Test to clear list");

        smallL.add("New Item");
        smallL.add("Second item");
        smallL.printDataHeadTailSize("Test to add item again");


    }

    public void printDataHeadTailSize() {
        printDataHeadTailSize("Blank test");
    }

    public void printDataHeadTailSize(String test) {
        System.out.println("\n\n");
        System.out.println(test);
        if (head == null) {
            System.out.println("Head: null");
        } else {
            System.out.println("Head: " + head.data);

            for (E string :
                    this) {
                System.out.println(string.toString());
            }
        }
        if(tail == null){
            System.out.println("Tail: null");
        }else{
            System.out.println("Tail: " + tail.data);
        }
        System.out.println("Size: " + size);

    }

    private Node<E> head;
    private int size;
    private Node<E> tail;

    public SLList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean add(E item) {
        add(size, item);
        return true;
    }

    public void add(int index, E item) {
        checkIndex(index);
        if (index == 0) {
            addFirst(item);
        } else if (index == size ) {
            addAfter(tail, item);
        } else {
            Node<E> node = getNode(index - 1);
            addAfter(node, item);
        }
    }

    public E get(int index) {
        checkIndex(index);
        Node<E> node = getNode(index);
        return node.data;
    }


    public E remove(int index) {
        checkIndex(index);
        E returnValue;
        if (index == 0) {
            returnValue = head.data;
            head = head.next;
            if (size == 1)
                tail = null;
        } else if (index == (size - 1)) {
            returnValue = tail.data;
            tail = getNode(index - 1);
            tail.next = null; // Kill link
        } else {
            Node<E> before = getNode(index - 1);
            returnValue = before.next.data;
            before.next = before.next.next;
        }
        size--;
        return returnValue;
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
                sb.append("==>");
                p = p.next;
            }
            sb.append(p.data.toString());
        }
        sb.append("]");
        return sb.toString();
    }

    private void addAfter(Node<E> node, E item) {
        if (node.next == null) {
            node.next = new Node<>(item, null);
            tail = node.next;
        } else {
            node.next = new Node<>(item, node.next);
        }
        size++;
    }

    private void addFirst(E item) {
        head = new Node<>(item, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    private Node<E> getNode(int index) {
        if(index == (size - 1))
            return tail;
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }


    // TODO: beror index på olika variabler?
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
    }

    private static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    private class Itr implements Iterator<E> {

        private Node<E> current;

        public Itr(Node<E> start) {
            this.current = start;
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
            current = current.next;
            return returnValue;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
            //
        }
    }
}
