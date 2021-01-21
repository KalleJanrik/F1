package NB2;

import java.util.Arrays;

public class IntList {
    private int[] data;
    private int nrElements;
    //private int capacity;

    public IntList(int initialCapacity) {
        //this.capacity = initialCapacity;
        this.nrElements = 0;
        data = new int[initialCapacity];
    }

    public Boolean add(int element) {
        if (nrElements == data.length)
            reallocate();
        data[nrElements++] = element;
        return true;
    }

    public void add(int index, int element) {
        if (0 <= index && index < data.length) {
            if (nrElements == data.length)
                reallocate();
            shuffleRight(index);
            data[index] = element;
            nrElements++;
            return;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public int get(int index) {
        if (0 <= index && index < data.length) {
            return data[index];
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public int indexOf(int element) {
        for (int i = 0; i < nrElements; i++) {
            if (data[i] == element) {
                return i;
            }
        }
        return -1;
    }

    public int remove(int index) {
        if (0 <= index && index < data.length) {
            int element = data[index];
            shuffleLeft(index);
            nrElements--;
            return element;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public int set(int index, int element) {
        if (0 <= index && index < data.length) {

            int oldValue = data[index];
            data[index] = element;
            return oldValue;
        }
        throw new ArrayIndexOutOfBoundsException(index);
    }

    public int size() {
        return nrElements;
    }

    private void reallocate() {
        //data = Arrays.copyOf(data,data.length*2);
        int[] copy = data;
        data = new int[data.length * 2];
        for (int i = 0; i < nrElements; i++) {
            data[i] = copy[i];
        }
    }

    private void shuffleRight(int index) {
        for (int i = nrElements; i > index; i--) {
            data[i] = data[i - 1];
        }
    }

    private void shuffleLeft(int index) {
        for (int i = index; i < nrElements; i++) {
            data[i] = data[i + 1];
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("[");
        for (int i = 0; i < nrElements; i++) {
            string.append(data[i]);
            if(i<nrElements -1)
                string.append(", ");
        }
        string.append("]");

        return string.toString();
    }
}
